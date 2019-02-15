package com.ljj.springcloud.messagelistener;

import com.ljj.springcloud.dao.GameDao;
import com.ljj.springcloud.dto.TestDTO;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.IOException;


/**
 * @param
 * @Author: HJ
 * @Time: 下午11:46 19-1-23
 * @version: v1.0
 */
public class getMessageListener implements MessageListener {
    @Autowired
    private SolrServer solrServer;
    @Autowired
    private GameDao dao;
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                //获得消息
                TextMessage ms = (TextMessage) message;
                String id = ms.getText();
                //数据库查询
                TestDTO gameById = dao.findGameById(Integer.parseInt(id));
                //将查询的数据存入到solr域中
                SolrInputDocument document=new SolrInputDocument();
                document.addField("id",gameById.getId());
                document.addField("test_many",gameById.getMany());
                document.addField("test_category",gameById.getCategory());
                document.addField("test_time",gameById.getTime());
                document.addField("test_name",gameById.getName());
                //添加到文档
                try {
                    solrServer.add(document);
                    solrServer.commit();
                } catch (SolrServerException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (JMSException e) {
            e.getStackTrace();
        }
    }
}
