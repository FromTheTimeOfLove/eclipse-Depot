/*
 * contabs.js
 * 原文件备份为bak_contabs.js
 * 
 * 描述：将菜单新增Tab功能剥离出来，方便其他页面上调用
 * 
 * */

var ConTab=function(){
    function f(l) {
        var k = 0;
        $(l).each(function() {
            k += $(this).outerWidth(true);
        });
        return k;
    }
    function g(n) {
        var o = f($(n).prevAll()), q = f($(n).nextAll());
        var l = f($(".content-tabs").children().not(".J_menuTabs"));
        var k = $(".content-tabs").outerWidth(true) - l;
        var p = 0;
        if ($(".page-tabs-content").outerWidth() < k) {
            p = 0;
        } else {
            if (q <= (k - $(n).outerWidth(true) - $(n).next().outerWidth(true))) {
                if ((k - $(n).next().outerWidth(true)) > q) {
                    p = o;
                    var m = n;
                    while ((p - $(m).outerWidth()) > ($(".page-tabs-content").outerWidth() - k)) {
                        p -= $(m).prev().outerWidth();
                        m = $(m).prev();
                    }
                }
            } else {
                if (o > (k - $(n).outerWidth(true) - $(n).prev().outerWidth(true))) {
                    p = o - $(n).prev().outerWidth(true);
                }
            }
        }
        $(".page-tabs-content").animate({
            marginLeft : 0 - p + "px"
        }, "fast");
    }
    
    function a() {
        $(".J_menuTab.active").prev().click();
    }
    function b() {
        $(".J_menuTab.active").next().click();
    }
    function c(o,m,l) {
        var resBreakpointMd = App.getResponsiveBreakpoint('md');
        if (App.getViewPort().width < resBreakpointMd && $('.page-sidebar').hasClass("in")) {
            $('.page-header .responsive-toggler').click();
        }
//      var $obj=$(this);
//      var o = $obj.attr("href"), m = $obj.data("index"), l = $.trim($obj.text()), k = true;
        
        var k = true;
        if (o == undefined || $.trim(o).length == 0) {
            return false;
        }
        // 首页特殊处理
        if (m == '0') {
            var menu = $('#page-sidebar-menu');
            // menu.find('li.open').children("a").get(0).click();
            menu.find('li.active').removeClass('active');
            // 添加选中 打开的样式
            menu.children("li").eq(0).addClass('active');
            //TODO:
        } else if (parseInt(m) > 0) {
            var menu = $('#page-sidebar-menu');
            menu.find('li.active').removeClass('active');
            // 添加选中 打开的样式
            $('#page-sidebar-menu').find('a').each(function () {
                var dataIndex = $(this).attr('data-index');
                if (dataIndex == m) {
                    $(this).closest("li").addClass('active');
                    var $parentLi = $(this).parents("li");
                	$parentLi.each(function(i, obj){
                        $(obj).prevAll().removeClass('active');
                        $(obj).nextAll().removeClass('active');
                		$(this).addClass('active');
                    });
                    return;
                }
            });
        }
        $(".J_menuTab").each(function() {
            if ($(this).data("id") == o) {
                if (!$(this).hasClass("active")) {
                    $(this).addClass("active").siblings(".J_menuTab").removeClass("active");
                    g(this);
                    $(".J_mainContent .J_iframe").each(function() {
                        if ($(this).data("id") == o) {
                            $(this).show().siblings(".J_iframe").hide();
                            return false;
                        }
                    });
                }
                k = false;
                return false;
            }
        });
        if (k) {
            var p = '<a href="javascript:;" class="active J_menuTab" data-index="' + m + '" data-id="' + o + '">' + l + ' <i class="fa fa-times-circle"></i></a>';
            $(".J_menuTab").removeClass("active");
            var rMath=Math.random();
            var oSrc=o;
            if (oSrc.indexOf("?") != -1) {
                oSrc=oSrc+"&ra="+rMath;
            }else{
                oSrc=oSrc+"?ra="+rMath;
            }

            var n = '<iframe class="J_iframe" name="iframe' + m + '" width="100%" height="100%" src="' + oSrc + '" frameborder="0" data-id="' + o
            + '" seamless></iframe>';
		    $(".J_mainContent").find("iframe.J_iframe").each(function(e) {
		        // $(this).attr("style", "display:none");
		        $(this).hide();
		    });
		    $(".J_mainContent").find("iframe.J_iframe").parents(".J_mainContent").append(n);
		    $(".J_menuTabs .page-tabs-content").append(p);
		    g($(".J_menuTab.active"));
		    Layout.fixContentHeight();
            var is = $("iframe[name='iframe" + m + "']");
            
            /*if(is.length <= 0) {
	            
            } else {
            	$(is).show().siblings(".J_iframe").hide();
            	$(".page-tabs-content a").each(function(i){
            		if(i == 0) return true;
            		if($(this).data("index") == m)
            			$(this).show();
            	})
            }*/
        }
        return false;
    }
    function h(obj) {
        var $obj=$(obj);

        var m = $obj.parents(".J_menuTab").data("id");
        var l = $obj.parents(".J_menuTab").width();
        if ($obj.parents(".J_menuTab").hasClass("active")) {
            if ($obj.parents(".J_menuTab").next(".J_menuTab").size()) {
                var k = $obj.parents(".J_menuTab").next(".J_menuTab:eq(0)").data("id");
                $obj.parents(".J_menuTab").next(".J_menuTab:eq(0)").addClass("active");
                $(".J_mainContent .J_iframe").each(function() {
                    if ($(this).data("id") == k) {
                        $(this).show().siblings(".J_iframe").hide();
                        return false;
                    }
                });
                var n = parseInt($(".page-tabs-content").css("margin-left"));
                if (n < 0) {
                    $(".page-tabs-content").animate({
                        marginLeft : (n + l) + "px"
                    }, "fast");
                }
                $obj.parents(".J_menuTab").remove();
                $(".J_mainContent .J_iframe").each(function() {
                    if ($(this).data("id") == m) {
                        $(this).remove();
                        return false;
                    }
                });
            }
            if ($obj.parents(".J_menuTab").prev(".J_menuTab").size()) {
                var k = $obj.parents(".J_menuTab").prev(".J_menuTab:last").data("id");
                $obj.parents(".J_menuTab").prev(".J_menuTab:last").addClass("active");
                $(".J_mainContent .J_iframe").each(function() {
                    if ($(this).data("id") == k) {
                        $(this).show().siblings(".J_iframe").hide();
                        return false;
                    }
                });
                $obj.parents(".J_menuTab").remove();
                $(".J_mainContent .J_iframe").each(function() {
                    if ($(this).data("id") == m) {
                        $(this).remove();
                        return false;
                    }
                });
            }
        } else {
            $obj.parents(".J_menuTab").remove();
            $(".J_mainContent .J_iframe").each(function() {
                if ($(this).data("id") == m) {
                    $(this).remove();
                    return false;
                }
            });
            g($(".J_menuTab.active"));
        }
        return false;
    }
    function i() {
//      var $obj=$(obj);
        $(".page-tabs-content").children("[data-id]").not(":first").not(".active").each(function() {
            $('.J_iframe[data-id="' + $(this).data("id") + '"]').remove();
            $(this).remove();
        });
        $(".page-tabs-content").css("margin-left", "0");
    }
    function j() {
        g($(".J_menuTab.active"));
    }
    function e(obj) {
        var $obj=$(obj);
        if (!$obj.hasClass("active")) {
            var k = $obj.data("id");
            $(".J_mainContent .J_iframe").each(function() {
                if ($(this).data("id") == k) {
                    $(this).show().siblings(".J_iframe").hide();
                    return false;
                }
            });
            $obj.addClass("active").siblings(".J_menuTab").removeClass("active");
            g($obj[0]);
        }
    }
    function d(obj) {
        var $obj=$(obj);
        var l = $('.J_iframe[data-id="' + $obj.data("id") + '"]');
        var k = l.attr("src");
    }
    
    
    return {
        a:function(){
            var obj=this;
            a(obj);
        }
        ,b:function(){
            var obj=this;
            b(obj);
        }
        ,c:function(o,m,l){
            return c(o,m,l);   //返回c，阻止浏览器对事件的默认处理
        }
        ,d:function(){
            var obj=this;
            d(obj);
        }
        ,e:function(){
            var obj=this;
            e(obj);
        }
        ,h:function(){
            var obj=this;
            return h(obj);
        }
        ,i:function(){
            var obj=this;
            i(obj);
        }
        ,j:function(){
            var obj=this;
            j(obj);
        }
    };
}();


$(function() {
    var a=ConTab["a"];
    var b=ConTab["b"];
    var c=ConTab["c"];
    var d=ConTab["d"];
    var e=ConTab["e"];
    var h=ConTab["h"];
    var i=ConTab["i"];
    var j=ConTab["j"];
    var g=ConTab["g"];
    
    /*$(".J_menuItem").each(function(k) {
        if (!$(this).attr("data-index")) {
            $(this).attr("data-index", k);
        }
    });*/
    
    $(".J_menuItem").on("click", function(){
        var $obj=$(this);
        var o = $obj.attr("href"), m = $obj.data("index"), l = $.trim($obj.text());
        return c(o,m,l);
    });
    
    $(".J_menuTabs").on("click", ".J_menuTab i", h);
    
    $(".J_tabCloseOther").on("click", i);
    
    $(".J_tabShowActive").on("click", j);
    
    $(".J_menuTabs").on("click", ".J_menuTab", e);
    
    $(".J_menuTabs").on("dblclick", ".J_menuTab", d);
    $(".J_tabLeft").on("click", a);
    $(".J_tabRight").on("click", b);
    $(".J_tabCloseAll").on("click", function() {
        $(".page-tabs-content").children("[data-id]").not(":first").each(function() {
            $('.J_iframe[data-id="' + $(this).data("id") + '"]').remove();
            $(this).remove();
        });
        $(".page-tabs-content").children("[data-id]:first").each(function() {
            $('.J_iframe[data-id="' + $(this).data("id") + '"]').show();
            $(this).addClass("active");
        });
        $(".page-tabs-content").css("margin-left", "0");
    });
});
