// GrowingIO  20160309
var _vds = _vds || [];
(function() {
    _vds.push(['setAccountId', '8f6e3e7f89d647cab9784afa81ea87bd']);
    (function() {
    var vds = document.createElement('script'); vds.type = 'text/javascript'; vds.async = !0;
         vds.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'dn-growing.qbox.me/vds.js';
         var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(vds, s);
     })();
 })();

 //GA piwik

var _gaq = _gaq || [];
var _paq = _paq || [];

_gaq.push(['_setAccount', 'UA-40875043-1']);

if (location.hostname.indexOf(".huazhu.com") != -1) {
	_gaq.push(['_setDomainName', '.huazhu.com']);
}

_gaq.push(['_addOrganic', 'soso', 'w']);
_gaq.push(['_addOrganic', 'sogou', 'query']);
_gaq.push(['_addOrganic', 'youdao', 'q']);
_gaq.push(['_addOrganic', 'baidu', 'word']);
_gaq.push(['_addOrganic', '360', 'q']);
_gaq.push(['_addOrganic', '.so.com', 'q']);
_gaq.push(['_addOrganic', 'haosou.com', 'q']);

if (location.hostname.indexOf("checkin.huazhu.com") != -1) {
	_gaq.push(['_setSiteSpeedSampleRate', 100]);
} else {
	_gaq.push(['_setSiteSpeedSampleRate', 10]);
}

function wa_track_event(cate, action, label, value) {
	var cate = cate || "";
	var action = action || "";
	var label = label || "";
	var value = value || 0;

	value = parseInt(value);

	if (cate == "" || action == "") {
		return;
	}

	_gaq.push(['_trackEvent', cate, action, label, value]);
	_paq.push(['trackEvent',  cate, action, label, value]);
}

var wa_filehost_80 = 'http://ws-www.hantinghotels.com';
var wa_filehost_443 = 'https://wshantinghotels.huazhu.com';

function wa_is_http() {
	return location.protocol == 'http:';
}

// 有的页面没有jQuery
try {
	$(document).ready(function() {
		if (location.pathname.toLowerCase() == "/hotel/list") {
			setTimeout(function() {
				$("#divBrandFilter input").change(function() {
				    if(this.checked) {
				       var brand_name = $(this).attr("name");
				       wa_track_event("列表页筛选", "按品牌", brand_name);
				    }
				});

				$("#wbox_f input").change(function() {
				    if(this.checked) {
						var service_name = $(this).attr("name");
				       	wa_track_event("列表页筛选", "按服务设施", service_name);
				    }
				});
			}, 2000);
		}
	});
} catch(e) {

}

var wa_is_site_search = false;
var wa_site_search_find = false;

(function() {
	// 记录订单创建页是否登录
	if (location.pathname == "/Order/Create") {

		var is_login = "1";
		var mid = window.wa_member_id || "";
	  	if (mid == "" || mid == "0") {
	    	is_login = "0";
	  	}
	  	_gaq.push(['_setCustomVar', 1, 'is_login', is_login, 3]);
	}
})();

(function () {
	var wa_custom_url = location.pathname + location.search;

	// 处理中文搜索关键字被escape的问题
	if (location.pathname == "/hotelinfo/hotel_select.aspx") {
		wa_custom_url = location.pathname + unescape(location.search);
	}

	// 列表搜索的关键字
	if (location.pathname.toLowerCase() == '/hotel/list'
		&& location.search != ''
		&& location.search.match(/&Keyword=[^&]+/i) != null) {

	    wa_is_site_search = true;

		try {
			if ($("#noSearchMessage").css("display") == "block") {
				wa_site_search_find = false;
			} else {
				wa_site_search_find = true;
			}
		} catch(e) {

		}
	}

	if (wa_is_site_search) {
	    if (wa_site_search_find) {
	        wa_custom_url += '&search_cate=find';
	    } else {
	        wa_custom_url += '&search_cate=not_find';
	    }

	    // piwik 自定义url，需要使用完整的地址
    	_paq.push(['setCustomUrl', location.protocol + '//' + location.hostname + wa_custom_url]);
	}

	_gaq.push(['_trackPageview', wa_custom_url]);
})();

function wa_set_member_id() {
  var mid = window.wa_member_id || "";
  if (mid == "" || mid == "0") {
    return;
  }
  _paq.push(['setCustomVariable', 1, 'mid', mid, 'visit']);

  if (location.pathname.indexOf("/RegSucceed.aspx") != -1) {
  	  _paq.push(['setCustomVariable', 2, 'reg', mid, 'visit']);
  }
}

(function () {
    var ga = document.createElement('script');
    ga.type = 'text/javascript';
    ga.async = true;

    if (wa_is_http()) {
    	ga.src = wa_filehost_80 + '/wa/ga/ga.js?v=1';
    } else {
    	ga.src = wa_filehost_443 + '/wa/ga/ga.js';
    }

    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(ga, s);
})();

function wa_track_checkin_info() {

}

function wa_on_order_succ() {

	var wa_order_no = window.wa_order_no || "";
	var wa_city = window.wa_city || "";
	var wa_store_name = window.wa_store_name || "";
	var wa_order_total = window.wa_order_total || "";
	var wa_room_type = window.wa_room_type || "";
	var wa_room_price = window.wa_room_price || "";
	var wa_room_day_quantity = window.wa_room_day_quantity || "";

	// 金额，数量转字符串
	wa_order_total = wa_order_total.toString();
	wa_room_price = wa_room_price.toString();
	wa_room_day_quantity = wa_room_day_quantity.toString();

	// 先用支付时的所在页面来区分类型
	var wa_pay_cate = location.pathname;

	wa_room_type = wa_room_type || "(empty)";

	_gaq.push(['_addTrans',
	   wa_order_no,             // transaction ID - required
	   wa_store_name,           // affiliation or store name
	   wa_order_total,          // total - required
	   '0',                     // tax
	   '0',                     // shipping
	   wa_city,                 // city
	   '',                      // state or province
	   ''                       // country
	]);
	_gaq.push(['_addItem',
	   wa_order_no,             // transaction ID - necessary to associate item with transaction
	   wa_room_type,            // SKU/code - required
	   wa_room_type,         	// product name
	   wa_pay_cate,   			// category or variation
	   wa_room_price,          	// unit price - required
	   wa_room_day_quantity     // quantity - required
	]);
	_gaq.push(['_trackTrans']);

	_paq.push([
		"addEcommerceItem",
		wa_room_type,                	// sku
		wa_room_type,                	// 商品名称
		wa_pay_cate, 					// 商品类别
		wa_room_price,      		 	// 商品价格
		wa_room_day_quantity         	// 商品数量(默认为 1)
	]);

	_paq.push([
		"trackEcommerceOrder",
		wa_order_no + "|" + wa_city + "|" + wa_store_name,  // 订单ID
		wa_order_total,       	// 订单金额
		false,    				// 排除运费后的收入
		false,    				// 税
		false,    				// 运费
		false     				// 折扣金额，设置：false，忽略该金额
	]);

}

// piwik config

_paq.push(["setSiteId", "1"]);

if (location.hostname.indexOf(".huazhu.com") != -1) {
	_paq.push(["setCookieDomain", "*.huazhu.com"]);
}

wa_set_member_id();
_paq.push(["trackPageView"]);
//_paq.push(["enableLinkTracking"]);

// (function () {
// 	if (wa_is_http()) {
// 		_paq.push(["setTrackerUrl", "http://track.htinns.com/piwik/piwik.php"]);
// 	} else {
// 		_paq.push(["setTrackerUrl", "https://track.huazhu.com:8092/piwik/piwik.php"]);
// 	}

//     var wa = document.createElement("script");
//     wa.type = "text/javascript";
//     wa.async = true;
//     if (wa_is_http()) {
// 		wa.src = wa_filehost_80 + "/wa/piwik/piwik.js?v=1";
//     } else {
// 		wa.src = wa_filehost_443 +"/wa/piwik/piwik.js?v=1";
//     }

//     var s = document.getElementsByTagName("script")[0];
//     s.parentNode.insertBefore(wa, s);
// })();

// baidu tongji

// checkin站点不加载百度统计
if (location.hostname.indexOf("checkin.huazhu.com") == -1) {
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "//hm.baidu.com/hm.js?e5770a47472445b3f839a58a32b8abe5";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
}

