var GlobalUtil = function() {
	/**
	 * 需要base64.js,Base64三重加密传输
	 */
	var paramEncryption = function(paramValue) {
		if (paramValue != undefined && paramValue != null && paramValue != '') {
			var base64 = new Base64();
			// 三次加密
			paramValue = base64.encode(paramValue);
			paramValue = base64.encode(paramValue);
			paramValue = base64.encode(paramValue);
		}
		return paramValue;
	};
	/**
	 * 需要base64.js,Base64三重解密
	 */
	var paramDecryption = function(paramValue) {
		if (paramValue != undefined && paramValue != null && paramValue != '') {
			var base64 = new Base64();
			// 三次解密
			paramValue = base64.decode(paramValue);
			paramValue = base64.decode(paramValue);
			paramValue = base64.decode(paramValue);
		}
		return paramValue;
	};
	/**
	 * 处理DataTable传回参数JSON
	 * 
	 * @param d
	 * @returns JSON
	 */
	var dealDataTableAjaxData = function(d) {
		var dd = jQuery.parseJSON(JSON.stringify(d)); // 重新转换一次JSON
		var colums = dd.columns;
		// 删除不必要的参数
		delete dd.columns;
		delete dd.search;
		/*
		// 处理排序参数
		var orderArrary = dd.order;
		// 处理排序中的colum参数，原本是下标数字，转换为colums对应的名称
		$.each(orderArrary, function(n, value) {
			if (colums != null && colums[n] != null) {
				orderArrary[n].column = colums[n].data;
			} else {
				orderArrary[n].column = '';
			}
		});
		*/
        var orderArrary = dd.order;//默认已设置为[],若不设置默认值则默认取第一列排序,
        if(null==orderArrary || orderArrary.length==0){
        	dd.order="";
        	return dd;
        }
        // 处理排序中的colum参数，原本是下标数字，转换为colums对应的名称
        $.each(orderArrary, function(n, value) {
            try{
            	orderArrary[n].column = colums[orderArrary[n].column].data;
            }catch(e){
            	//
            }
        });
		dd.order = JSON.stringify(orderArrary); // 转换为字符串形式传递
		return dd;
	};

	/**
	 * js加法误差解决
	 */
	var addValue = function(value1, value2) {
		if (value1 == "")
			value1 = "0";
		if (value2 == "")
			value2 = "0";
		var temp1 = 0;
		var temp2 = 0;
		if (value1.indexOf(".") != -1)
			temp1 = value1.length - value1.indexOf(".") - 1;
		if (value2.indexOf(".") != -1)
			temp2 = value2.length - value2.indexOf(".") - 1;

		var temp = 0;

		if (temp1 > temp2)
			temp = (parseFloat(value1) + parseFloat(value2)).toFixed(temp1);
		else
			temp = (parseFloat(value1) + parseFloat(value2)).toFixed(temp2);

		return temp;
	};
	/**
	 * js减法误差解决
	 */
	var subValue = function(value1, value2) {
		if (value1 == "")
			value1 = "0";
		if (value2 == "")
			value2 = "0";
		var temp1 = 0;
		var temp2 = 0;
		if (value1.indexOf(".") != -1)
			temp1 = value1.length - value1.indexOf(".") - 1;
		if (value2.indexOf(".") != -1)
			temp2 = value2.length - value2.indexOf(".") - 1;
		var temp = 0;

		if (temp1 > temp2)
			temp = (parseFloat(value1) - parseFloat(value2)).toFixed(temp1);
		else
			temp = (parseFloat(value1) - parseFloat(value2)).toFixed(temp2);

		return temp;

	};

	/**
	 * 财务数据千分为显示
	 */
	var finnanceDataFormat = function(number) {
		number = $.trim(number);
		var re = /\d{1,3}(?=(\d{3})+$)/g;
		var n1 = "";
		if (Number(number) < 0) {
			n1 = "-";
			number = number.replace(/-/g, '');
		}
		n1 += number.replace(/^(\d+)((\.\d+)?)$/, function(s, s1, s2) {
			return s1.replace(re, "$&,") + s2;
		});
		return n1;
	};
	
	var setnum = function(obj) {
		var num = number_format(obj.value,2,'.',',');
		$(obj).val(num);
	};
	
	/**
	 * 财务数据取消千分位显示
	 */
	var finnanceDataCancel = function(number) {
		number = $.trim(number);
		return number.replace(/,/g, '');
	};
	
	/**
	 * 默认千分位分割方法
	 */
	var defaultNumberDataForma = function  (obj) {
		var tempValue = $(obj).val();
		if (tempValue != null && tempValue != "") {
			tempValue = tempValue.replace(/,/g, '');
			var value = number_format(tempValue, 2, '.', ',');
			$(obj).val(value);
		}
	};
	
	/**
	 * 千分位通用函数 Usage: number_format(123456.789, 2, '.', ','); result: 123,456.79
	 */
	var number_format = function(number, decimals, dec_point, thousands_sep) {
		number = (number + '').replace(/[^0-9+-Ee.]/g, '');
		var n = !isFinite(+number) ? 0 : +number, prec = !isFinite(+decimals) ? 0
				: Math.abs(decimals), sep = (typeof thousands_sep === 'undefined') ? ','
				: thousands_sep, dec = (typeof dec_point === 'undefined') ? '.'
				: dec_point, s = '', toFixedFix = function(n, prec) {
			var k = Math.pow(10, prec);
			return '' + Math.round(n * k) / k;
		};
		s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
		if (s[0].length > 3) {
			s[0] = ('' + s[0]).replace(/(\d)(?=(\d{3})+$)/g, '$1' + sep);
		}
		if ((s[1] || '').length < prec) {
			s[1] = s[1] || '';
			s[1] += new Array(prec - s[1].length + 1).join('0');
		}
		return s.join(dec);
	};
	
	/**
	 * +引出的数据取空值处理
	 */
	var dataNullDeal = function(v) {
		if (v == undefined || v == null || v == '') {
			return v = '-';
		} else {
			return v;
		}
	};
	
	/**
	 * 绑定点击事件
	 */
	var bindClickOpenOrCloseTr = function(obj, addDataMethod) {
		$(obj).on('click', ' tbody td .row-details', function () {
	        var tClass = $(this).attr("class").split(" ");
	        var classClose="row-details-close",classOpen="row-details-open";
	        var openDetailClass = $(this).closest("tr").next().attr("class");
	        var tr = $(this).closest("table").find("."+openDetailClass);
	        if (classOpen == tClass[1]) {
	            $(this).addClass(classClose).removeClass(classOpen);
	        } else {
	        	$(this).addClass(classOpen).removeClass(classClose);
	        	if (tr.length <= 0) {
		            addDataMethod(this);
				}
	        }
			$(tr).toggle(700);
	    });
	};
	
	/**
	 * 创建tab标签页
	 * url 页面跳转路径
	 * name iframe的name值
	 * title tab标签页的title
	 */
	var createTab = function(url, name, title) {
        var c=parent.ConTab["c"]; //本页面为iframe嵌入，因此需要调用parent的ConTab对象，才能添加新的Tab
        c(url, name, title);
	};
	
	/**
	 * 删除打开的标签页
	 * prename 父级
	 * name iframe的name名称或排序碼（初始菜單為排序碼）
	 * id 查询按钮id
	 * isQuery 是否查询列表，值为true和false
	 */
	var delTab = function(prename, name, id, isQuery) {
		var cm = "iframe" + prename, nm = "iframe" + name, g = parent.ConTab["c"],index=""; 
		var $tabs = $(".page-tabs-content", window.parent.parent.document);
		var $iframs = $(".J_mainContent .J_iframe", window.parent.parent.document);
		if(isQuery) {
			var $iframeName = $("iframe[name='"+cm+"']",window.parent.document);
			var $dom = $iframeName.contents().find("#"+id);
			$dom.click();
		}
		$tabs.find(".J_menuTab").each(function(i){
			if(i == 0) return true;
			if ($(this).hasClass("active")) {
				$iframs.each(function() {
					var m = $(this).attr("name");
					if(m.indexOf("iframe") <= -1) {
			        	m = "iframe" + m;
					}
		            if (m === cm) {
                        $(this).show().siblings(".J_iframe").hide();
		                return false;
		            }
		        });
				$(this).remove();
				$iframs.each(function() {
					var m = $(this).attr("name");
					if(m.indexOf("iframe") <= -1) {
			        	m = "iframe" + m;
					}
		            if (m === nm) {
                        $(this).remove();
		                return false;
		            }
		        });
			}
			index = $(this).data("index");
			if(prename == index) {
				$(this).addClass("active");
			}
		});
	};
	
	/**
	 * 删除tab标签页
	 * url 页面跳转路径
	 * name iframe的name值
	 * title tab标签页的title
	 */
	var delAndCreateTab = function(url, name, title) {
		//获取父页面的iframe对象
		var iframeName = $("iframe[name='iframe"+name+"']",window.parent.document);
		//判断iframeName是否存在
		if(iframeName.length > 0 && iframeName != null && iframeName != undefined) {
			var $aDom = $(".page-tabs-content a", window.parent.parent.document);
			$aDom.each(function(i,obj){
				if($.trim($(obj).text()) == $.trim(title)) {
					//最后删掉tab标签页
					$(obj).find(".fa.fa-times-circle").click();
				}
			});
			//先创建
			createTab(url, name, title);
		} else {
			createTab(url, name, title);
		}
	};
	
	/**
	 * 文档上传
	 */
	var doChangemvc = function(obj){
		//获取文件名称
//		var filename = $(obj).val();  
		var filename=$(obj)[0].files[0].name;
		//获取上一级dom
		var $divDom = $(obj).closest("div");
		var adom = $divDom.find("a");
		$(adom).removeClass("fileinput-exists");
		$(adom).show();
		//赋值
		$divDom.find("div input").val(filename);
		$.ajaxFileUpload({
			url: "rest/commonUpload/upload.do",
			secureuri: false, //是否开启验证，一般设置为false
			fileElementId: obj.id, // targetFileId 文件上传input的id属性  <input type="file" id="file" name="file" />
			dataType: 'HTML', //返回值类型（后台返回json即可，这里一般不做修改）
			success: function (data){
				if( data && data!="null"){
					//data = data.replace("<pre>","").replace("</pre>","").replace("<PRE>","").replace("</PRE>","");
					$divDom.find("input[id='targetFilename']").val(data);
	          	};
			},
			error: function (data, status, e){
				//错误提示
			}
	  	});
	};
	
	var doRemove = function(obj){
		//获取上一级dom
		var $divDom = $(obj).closest("div");
//		console.info($divDom);
		$divDom.find("div input").val("");
//		console.info($divDom.find("div input"));
		$divDom.find("input[id='targetFilename']").val("");
		
		var adom = $divDom.find("a");
		$(adom).hide();
		$(obj).addClass("fileinput-exists");
		
	};
	
	/**
	 * tab标签页下一步
	 */
	var nextTab = function(obj) {
		$(obj).hide();
		var $nextIndex = $(obj).closest("form").find("input[name='nextIndex']");
		$nextIndex.val(parseInt($nextIndex.val())+1);
		var $tabDiv = $(obj).closest(".portlet-tabs");//根据当前对象获取tab
		var $tab = $tabDiv.find("ul li.active");//获取选中tab的标签页对象
		$tab.removeClass("active");//移除选中
		var $nextTab = $tab.next();//获得当前选中的tab的下一个tab
		var $nextA = $nextTab.find("a");//获得下一个tab下面的a标签
		var hrefId = $nextA.attr("dom-id");//获得id
		$nextA.attr("href", "#"+hrefId).attr("data-toggle", "tab");//绑定锚链接与tab
		$nextA.click();//触发事件
	};
	
	/**
	 * 编辑时定位tab
	 */
	var editNext = function(tab_class, index) {
		if(index == undefined || index == null) index = 1;
		var countIn = index - 1;
		var $tab = $(tab_class);
		var $lis = $tab.find("ul li");
		var $lis_two = $lis;
		$lis.each(function(i, obj){
			if(i == 0 || countIn == 0) return;
			var $tabA = $(obj).find("a");
			if(i < countIn) {
				var tabId = $tabA.attr("dom-id");
				$tabA.attr("href","#"+tabId).attr("data-toggle", "tab");
			}
			if(i == countIn) {
				var tabId = $tabA.attr("dom-id");
				$tabA.attr("href","#"+tabId).attr("data-toggle", "tab");
				$(obj).prevAll().removeClass("active");
				$(obj).nextAll().removeClass("active");
				$("#"+tabId).prevAll().find(".J_menuItem").hide();
				$("#"+tabId).prevAll().removeClass("active");
				$("#"+tabId).nextAll().removeClass("active");
				$(obj).addClass("active");
				$("#"+tabId).addClass("active");
			}
		});
	};
	
	/**
	 * Show Legal/deal Team window
	 */
	var showTeamWindow = function(obj, objs, toExcel) {
		var $inputDom = $(obj).next("input");
		Lobibox.window({
            title: objs.title,
            url: objs.url,
            autoload: true,
            draggable: false,
            width: objs.width,
            height: objs.height,
            loadMethod: 'POST',
            params: objs.data,
            buttons: {
                ok: {
                    'class': 'btn btn-info',
                    text: 'To Excel',
                    closeOnClick: false
                },
                yes: {
                    'class': 'btn btn-success',
                    text: 'save',
                    closeOnClick: true
                },
                close: {
                    'class': 'btn btn-default',
                    text: 'Close',
                    closeOnClick: true
                }
            },
            callback: function ($this, type, ev) {
            	var aClass = $(obj).attr("class");
            	var aClassArr = aClass.split(" ");
                if (type === 'ok') { // To Excel
                	var datas = $("#teamWindowForm").serialize();
                	datas = datas.replace(/\+/g,"");                
                	toExcel(datas);
                } else if (type === 'yes') { // Save
                	var datas = $("#teamWindowForm").serialize();
                	datas = datas.replace(/\+/g,"");
                	$inputDom.val(datas);
                	if (Object.keys(datas).length > 0) {
                		if(aClassArr[1] != "red") {
                			$(obj).addClass("red").removeClass(aClassArr[1]);
                			$(obj).attr("data-color", aClassArr[1]);
                		}
                		$(obj).find("i").addClass("fa-question-circle").removeClass("fa-check-circle");
                	} else {
                		$(obj).find("i").addClass("fa-check-circle").removeClass("fa-question-circle");
                	}
                }
            }
        });
	};
	
	/**
	 * 回车事件
	 * 为保证回车时刷新页面，请确保该页面的form下面的input超过一个
	 */
	var keydownEvent = function(eventMtehod) {
		$(document).keypress(function(e) {
		    // 回车键事件
		    if(e.which == 13) {
		    	eventMtehod();
		    }
	    });
    }
	
	return {
		finnanceDataCancel : function(n) {
			return finnanceDataCancel(n);
		},
		finnanceDataFormat : function(d) {
			return finnanceDataFormat(d);
		},
		paramEncryption : function(d) {
			return paramEncryption(d);
		},
		paramDecryption : function(d) {
			return paramDecryption(d);
		},
		addValue : function(value1, value2) {
			return addValue(value1, value2);
		},
		subValue : function(value1, value2) {
			return subValue(value1, value2);
		},
		dealDataTableAjaxData : function(d) {
			return dealDataTableAjaxData(d);
		},
		bindClickOpenOrCloseTr : function(obj, addDataMethod) {
			bindClickOpenOrCloseTr(obj, addDataMethod);
		},
		createTab : function(url, iframeName, title) {
			createTab(url, iframeName, title);
		},
		delTab : function(prename, name, id, isQuery) {
			delTab(prename, name, id, isQuery);
		},
		delAndCreateTab : function(url, name, title) {
			delAndCreateTab(url, name, title);
		},
		doChangemvc:function(obj){
			doChangemvc(obj);
		},
		doRemove:function(obj){
			doRemove(obj);
		},
		setnum:function(obj,num){
			setnum(obj,num);
		},
		defaultNumberDataForma : function(obj){
			defaultNumberDataForma(obj);
		},
		number_format : function(number, decimals, dec_point, thousands_sep){
			number_format(number, decimals, dec_point, thousands_sep);
		},
		nextTab : function (obj) {
			nextTab(obj);
		},
		editNext : function(tab_class, index) {
			editNext(tab_class, index);
		},
		showTeamWindow : function(obj, objs, toExcel) {
			showTeamWindow(obj, objs, toExcel);
		},
		dataNullDeal : function(v) {
			return dataNullDeal(v);
		},
		keydownEvent : function(eventMtehod) {
			keydownEvent(eventMtehod);
		}
	};
}();
