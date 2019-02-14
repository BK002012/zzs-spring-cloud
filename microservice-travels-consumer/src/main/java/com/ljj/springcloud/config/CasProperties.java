package com.ljj.springcloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@PropertySource(value = "classpath:casServer.properties")
@Component
public class CasProperties {
    @Value("${cas.server.host.url}")
    private String CasServerUrl;
    @Value("${cas.server.host.login_url}")
    private String CasServerLoginUrl;
    @Value("${cas.server.host.logout_url}")
    private String CasServerLogoutUrl;
    @Value("${app.server.host.url}")
    private String AppServerUrl;
    @Value("${app.login.url}")
    private String AppServerLoginUrl;
    @Value("${app.logout.url}")
    private String AppServerLogoutUrl;

    public String getCasServerUrl() {
        return CasServerUrl;
    }

    public void setCasServerUrl(String casServerUrl) {
        CasServerUrl = casServerUrl;
    }

    public String getCasServerLoginUrl() {
        return CasServerLoginUrl;
    }

    public void setCasServerLoginUrl(String casServerLoginUrl) {
        CasServerLoginUrl = casServerLoginUrl;
    }

    public String getCasServerLogoutUrl() {
        return CasServerLogoutUrl;
    }

    public void setCasServerLogoutUrl(String casServerLogoutUrl) {
        CasServerLogoutUrl = casServerLogoutUrl;
    }

    public String getAppServerUrl() {
        return AppServerUrl;
    }

    public void setAppServerUrl(String appServerUrl) {
        AppServerUrl = appServerUrl;
    }

    public String getAppServerLoginUrl() {
        return AppServerLoginUrl;
    }

    public void setAppServerLoginUrl(String appServerLoginUrl) {
        AppServerLoginUrl = appServerLoginUrl;
    }

    public String getAppServerLogoutUrl() {
        return AppServerLogoutUrl;
    }

    public void setAppServerLogoutUrl(String appServerLogoutUrl) {
        AppServerLogoutUrl = appServerLogoutUrl;
    }
}
