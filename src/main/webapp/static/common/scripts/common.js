var GlobalCommon = function() {
	/**
	 * 获取服务器根目录的全路径
	 * 
	 * @param url
	 * @returns
	 */
	var getRootUrl = function(url) {
		var globalRoot = $("#global_rooturl").val();
		if (globalRoot == undefined || globalRoot == null || globalRoot == '') {
			// 从iframe父页面index.jsp获取
			globalRoot = $("#global_rooturl", parent.document).val();
		}
		url = globalRoot + url;
		return url;
	};

	var getLangType = function() {
		var langType = $("#global_langType").val();
		if (langType == null || langType == '') {
			langType = $('#global_langType', parent.document).val();
			if (langType == null || langType == '') {
				langType = 'zh_CN';
			}
		}
		return langType;
	};

	var i18nInit = function() {
		var langType = getLangType();
		i18n.init({
			lng : langType,
			fallbackLng : langType,
			resGetPath : getRootUrl('i18n/script-__lng__.json'),
			tName : 't',
			getAsync : false,// 设置同步
			i18nName : 'i18n'
		});
	};
	var datetimepickerInit = function() {
		var langType = getLangType();
		// 日历控件国际化全局语言初始化
		$.extend(true, $.fn.datetimepicker.defaults, {
			language : langType
		});
	};

	var dataTableInit = function() {
		// DataTabel全局参数初始化
		$.extend(true, $.fn.DataTable.defaults, {
			"language" : {
				"lengthMenu" : i18n.t('GENERAL.DATATABLE_PAGE.lengthMenu'),
				"zeroRecords" : i18n.t('GENERAL.DATATABLE_PAGE.zeroRecords'),
				"info" : i18n.t('GENERAL.DATATABLE_PAGE.info'),
				"infoEmpty" : i18n.t('GENERAL.DATATABLE_PAGE.infoEmpty'),
				"processing" : "...",
				"infoFiltered" : "",
				"paginate" : {
					"previous" : i18n.t('GENERAL.DATATABLE_PAGE.previous'),
					"next" : i18n.t('GENERAL.DATATABLE_PAGE.next'),
					"page" : "",
					"pageOf" : ""
				}
			},
			"order" : [],
			"searching" : false,
			"processing" : true,
			"lengthMenu" : [ [ 5, 10, 20 ], [ 5, 10, 20 ] ],
			"pageLength" : 10,
			"pagingType" : "bootstrap_extended"
		});
	};

	var bootstrapTableInit = function() {
		// Bootstrap Tabel全局参数初始化
		$.extend(true, $.fn.bootstrapTable.defaults, {
			method : "post",
			contentType : "application/x-www-form-urlencoded",
			sidePagination : "server",
			queryParamsType : "limit",
			pagination : true,
			silent : true,
			showColumns : true,
			showRefresh : true,
			showToggle : true,
			pageNumber : 1,
			pageSize : 10,
			pageList : [ 10, 20, 50, 100, 500 ],
			striped : true,// 间隔底色
			responseHandler : function(res) {
				if (typeof (res.rows) == "undefined") {
					res.total = res.recordsFiltered; // 总数据条数
					res.rows = res.data; // 数据
				}
				return res;
			}
		});
	};

	var ajaxSessionInit = function() {
		/**
		 * Ajax Session 超时处理
		 */
		$.ajaxSetup({
			contentType : "application/x-www-form-urlencoded;charset=utf-8",
			complete : function(XMLHttpRequest, textStatus) {
				var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus"); // 通过XMLHttpRequest取得响应头，sessionstatus，
				if (sessionstatus == "timeout") {
					bootbox.alert({
						size : 'small',
						message : i18n.t('GENERAL.SEESION_TIMEOUT'),
						callback : function(result) {
							// 如果超时就处理 ，指定要跳转的页面
							window.location.href = "index.html";
						}
					});

				}
			}
		});
	};

	var jqueryValidateInit = function() {
		/**
		 * jquery-validate 默认的全局设置
		 */
		$.extend(true, $.fn.validate.defaults, {
			errorClass : 'dd-validate-error', // 使用自定义样式
			validClass : 'dd-validate-error',// 使用自定义样式
			errorElement : "span",
			focusCleanup : false,
			focusInvalid : true
		});
	};

	/**
	 * 处理DataTable传回参数JSON
	 * 
	 * @param d
	 * @returns JSON
	 */
	var dealDataTableAjaxData = function(d) {
		var dd =jQuery.parseJSON(JSON.stringify(d)); // 重新转换一次JSON
		var colums = dd.columns;
		// 删除不必要的参数
		delete dd.columns;
		delete dd.search;
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
		dd.order = JSON.stringify(orderArrary); // 转换为字符串形式传递
		return dd;
	};

	return {
		// main function to initiate the module
		init : function() {
			i18nInit();
			ajaxSessionInit();
			jqueryValidateInit();
		},
		getRootUrl : function(url) {
			return getRootUrl(url);
		},
		i18nInit : function() {
			i18nInit();
		},
		datetimepickerInit : function() {
			datetimepickerInit();
		},
		dataTableInit : function() {
			dataTableInit();
		},
		bootstrapTableInit : function() {
			bootstrapTableInit();
		},
		ajaxSessionInit : function() {
			dataTableInit();
		},
		jqueryValidateInit : function() {
			jqueryValidateInit();
		},
		dealDataTableAjaxData:function(d){
			return dealDataTableAjaxData(d);
		}
	};
}();
// 执行
GlobalCommon.init();
