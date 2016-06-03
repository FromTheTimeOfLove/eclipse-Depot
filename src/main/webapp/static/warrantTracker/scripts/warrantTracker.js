var LoanTracker = function() {
	/**
	 * 查询表格
	 */
	var draw=0;
	var listTable=null;
	var initTable1 = function() {
    	if(listTable!=null){
    		listTable.bootstrapTable("refresh",{silent: true});
    		return;
    	}
    	$("#warrantTrackerTable").empty().attr("class","").attr("data-resizable","true");
    	listTable=$("#warrantTrackerTable").bootstrapTable({
    		url:"rest/warrantTracker/findWarrantTrackerList.do",
    		queryParams:function(params){
    			draw++;
    			var formData = $("#warrantTrackerForm").serializeJSON(); //查询表单的参数
    			var json={
        				"draw":draw
        				,"start":params.offset
        				,"length":params.limit
        			};
    			if(params.sort){
    				json["order"]="[{\"column\":\""+params.sort+"\",\"dir\":\""+params.order+"\"}]";
    			}
    			var c = $.extend({}, formData, json);
    			return c;
    		}
    	    ,columns: [ {
				field : 'common_index',// 序号列,key可随意更换
				title : i18n.t('GENERAL.COMMON_INDEX'),
				formatter : function(value, row, index) {
					return index + 1;
				}
			}, {
				field : 'companyName',
				title : 'COMPANY',
				sortable : true,
				align : "left"
			}, {
				field : 'partner',
				title : 'PARTNER',
				sortable : true,
				align : "left"
			}, {
				field : 'imminentExit',
				title : 'Imminent exit?',
				align : "left"
			}, {
				field : 'fundName',
				title : 'FUND',
				align : "center"
			}, {
				field : 'warrantsOwned',
				title : 'Warrants OWNED',
				align : "center"
			}, {
				field : 'ivestmentRounds',
				title : 'CLASS',
				align : "center"
			}, {
				field : 'purchasePrice',
				title : 'PURCHASE PRICE',
				align : "center"
			}, {
				field : 'exercisePriceSH',
				title : 'EXERCISE PRICE/SH',
				align : "center"
			}, {
				field : 'totalExerciseCost',
				title : "TOTAL Exercise COST",
				align : "center"
			}, {
				field : 'fvsh',
				title : 'FV/SH',
				align : "center"
			}, {
				field : 'totalFV',
				title : 'TOTAL FV',
				align : "center"
			}, {
				field : 'comments',
				title : 'Comments',
				align : "center"
			}, {
				field : 'quistValuation',
				title : 'Quist Valuation',
				align : "center"
			}, {
				field : 'valuePerQuist',
				title : 'Value per Quist',
				align : "center"
			}, {
				field : 'difference',
				title : 'Difference',
				align : "center"
			}, {
				field : 'notes',
				title : 'Notes',
				align : "center"
			}]
    	});
	};

	$("#warrantTrackerSearchBt").click(function() {
		initTable1();
	});

	var saveBasicInfoDataBefore = function() {
		bootbox.confirm({
			size : 'small',
			message : i18n.t('GENERAL.CONFIRM.GEN'),
			buttons : {
				confirm : {
					label : i18n.t('GENERAL.OK')
				},
				cancel : {
					label : i18n.t('GENERAL.CANCEL')
				}
			},
			callback : function(result) {
				if (result) {
					saveBasicInfoData();
				}
			}
		});
	};

	var saveBasicInfoData = function() {
		$('#BasicInfo_EDIT_FORM').showLoading();
		jQuery.ajax({
			type : 'POST',
			url : 'rest/BasicInfo/saveBasicInfo.do',
			data : $("#BasicInfo_EDIT_FORM").serialize(),
			success : function(data) {
				var result = data;
				var dataHtml = "";
				if (result.resultCode == 1) {
					dataHtml = i18n.t('GENERAL.SUCCESS');
				} else {
					dataHtml = result.message;
				}
				$('#BasicInfo_EDIT_FORM').hideLoading();
				bootbox.alert({
					size : 'small',
					message : dataHtml,
					callback : function(result) {
						initTable1();
						bootbox.hideAll(); // 隐藏所有的bootbox
					}
				});
			}
		});
	};

	/**
	 * 新增
	 */
	
	var AddBasicInfoBtId=function(paperid){
	    var o="rest/basicInfo/initAddBasicInfo.do?paperid="+paperid,m="oneBasicInfo-1000";l="Add Basic Info";
        var c=parent.ConTab["c"]; //本页面为iframe嵌入，因此需要调用parent的ConTab对象，才能添加新的Tab
        c(o,m,l);
	
	};
	
	/**
	 * 编辑
	 */
	var editBasicInfoBtId = function(id) {
		jQuery.ajax({
			type : 'GET',
			url : 'rest/BasicInfo/initEditBasicInfo.do?id=' + id,
			success : function(data) {
				bootbox.dialog({
					message : data,
					title : i18n.t('GENERAL.EDIT'),
				});
			}
		});
	};

	/**
	 * 删除
	 */
	var delBasicInfoBtId = function(id) {
		bootbox.confirm({
			size : 'small',
			message : i18n.t('GENERAL.CONFIRM.GEN'),
			buttons : {
				confirm : {
					label : i18n.t('GENERAL.OK')
				},
				cancel : {
					label : i18n.t('GENERAL.CANCEL')
				}
			},
			callback : function(result) {
				if (result) {
					jQuery.ajax({
						type : 'POST',
						url : 'rest/BasicInfo/delBasicInfoById.do',
						data : {
							"id" : id
						},
						success : function(data) {
							var result = data;
							var dataHtml = "";
							if (result.resultCode == 1) {
								dataHtml = i18n.t('GENERAL.SUCCESS');
							} else {
								var message = result.message;
								dataHtml = message;
							}
							initTable1();
							bootbox.alert({
								size : 'small',
								message : dataHtml
							});
						}
					});
				}
			}
		});
	};

	$("#basicInfoAddBt").click(function() {
	    var o="rest/basicInfo/initAddBasicInfo.do",m="oneBasicInfo-1000";l="Add Basic Info";
        var c=parent.ConTab["c"]; //本页面为iframe嵌入，因此需要调用parent的ConTab对象，才能添加新的Tab
        c(o,m,l);
	});
	
	return {
		// main function to initiate the module
		init : function() {
			if (!jQuery().dataTable) {
				return;
			}
			initTable1();
			$('#dataTimeTest').datetimepicker({
				format : 'yyyy-mm-dd'
			});
		},
		delBasicInfoBtId : function(id) {
			delBasicInfoBtId(id);
		},
		editBasicInfoBtId : function(id) {
			editBasicInfoBtId(id);
		},
		saveBasicInfoData : function() {
			saveBasicInfoDataBefore();
		},
		AddBasicInfoBtId:function(paperid){
			AddBasicInfoBtId(paperid);
		}
	};

}();
// 执行
LoanTracker.init();