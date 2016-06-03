var BasicInfo = function() {
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
    	$("#flowtrackerListTable").empty().attr("class","").attr("data-resizable","true");
    	listTable=$("#flowtrackerListTable").bootstrapTable({
    		url:"rest/flowtracker/findListFlowtracker.do",
    		queryParams:function(params){
    			draw++;
    			var formData = $("#BasicInfoListForm").serializeJSON(); //查询表单的参数
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
    	    ,columns: [ [ {
				title:'',
				colspan : 15,
				align : 'center',
				valign : 'middle'
			}, {
				title:'TS',
				colspan : 2,
				align : 'center',
				valign :  'middle'
			},{
				title : 'Loan',
				colspan : 2,
				align : 'center',
				valign :  'middle'
			}, {
				title : 'SPA',
				colspan : 1,
				align : 'center',
				valign :  'middle'
			}, {
				title : 'Funding',
				colspan : 6,
				align : 'center',
				valign :  'middle'
			}, {
				title : 'Follow on investment',
				colspan : 4,
				align : 'center',
				valign :  'middle'
			},  {
				title : 'Valuation',
				colspan : 3,
				align : 'center',
				valign :  'middle'
			}], [ {
				field : 'common_index',// 序号列,key可随意更换
				title : i18n.t('GENERAL.COMMON_INDEX'),
				formatter : function(value, row, index) {
					return index + 1;
				}
			}, {
				field : 'Update Date',
				title : i18n.t('Update Date'),
				sortable : true,
				align : "center"
			}, {
				field : 'Name EN',
				title : i18n.t('Name EN'),
				sortable : true,
				align : "center"
			}, {
				field : 'Name CH',
				title : i18n.t('Name CH'),
				align : "center"
			}, {
				field : 'Fund',
				title : i18n.t('Fund'),
				align : "center"
			}, {
				field : 'Source Full name',
				title : i18n.t('Source Full name'),
				align : "center"
			}, {
				field : 'Partner',
				title : i18n.t('Partner'),
				align : "center"
			}, {
				field : 'MD',
				title : i18n.t('MD'),
				align : "center"
			}, {
				field : 'VP',
				title : i18n.t('VP'),
				align : "center"
			}, {
				field : 'Associate/Analysts',
				title : i18n.t('Associate/Analysts'),
				align : "center"
			}, {
				field : 'Stage',
				title : i18n.t('Stage'),
				align : "center"
			}, {
				field : 'Sector',
				title : i18n.t('Sector'),
				align : "center"
			}, {
				field : 'Business description',
				title : i18n.t('Business description'),
				align : "center"
			}, {
				field : 'Valuation (per One Pager: $M)',
				title : i18n.t('Valuation  (per One Pager: $M)'),
				align : "center"
			}, {
				field : 'Company presentation',
				title : i18n.t('Company presentation'),
				align : "center"
			}, {
				field : 'Date of sign',
				title : i18n.t('Date of sign'),
				align : "center"
			}, {
				field : 'Accept / Lost',
				title : i18n.t('Accept / Lost'),
				align : "center"
			}, {
				field : 'Date of funding',
				title : i18n.t('Date of funding'),
				align : "center"
			}, {
				field : 'Funding amount',
				title : i18n.t('Funding amount'),
				align : "center"
			}, {
				field : 'Date of signed',
				title : i18n.t('Date of signed'),
				align : "center"
			}, {
				field : 'Date of funding',
				title : i18n.t('Date of funding'),
				align : "center"
			}, {
				field : 'Funding amount',
				title : i18n.t('Funding amount'),
				align : "center"
			}, {
				field : 'Series',
				title : i18n.t('Series'),
				align : "center"
			}, {
				field : 'Ownership',
				title : i18n.t('Ownership'),
				align : "center"
			}, {
				field : 'Pre money',
				title : i18n.t('Pre money'),
				align : "center"
			}, {
				field : 'Post money',
				title : i18n.t('Post money'),
				align : "center"
			}, {
				field : 'Date of funding',
				title : i18n.t('Date of funding'),
				align : "center"
			}, {
				field : 'Funding amount',
				title : i18n.t('Funding amount'),
				align : "center"
			}, {
				field : 'Pre money',
				title : i18n.t('Pre money'),
				align : "center"
			}, {
				field : 'Post money',
				title : i18n.t('Post money'),
				align : "center"
			},  {
				field : 'IPO',
				title : i18n.t('IPO'),
				align : "center"
			}, {
				field : 'Trade sale',
				title : i18n.t('Trade sale'),
				align : "center"
			}, {
				field : 'Redemption',
				title : i18n.t('Redemption'),
				align : "center"
			}] ]
    	});
	};

	$("#BasicInfoAddBt").click(function() {
		jQuery.ajax({
			type : 'POST',
			url : 'rest/BasicInfo/initAddNewBasicInfo.do',
			success : function(data) {
//				bootbox.dialog({
//					message : data,
//					title : i18n.t('GENERAL.ADD'),
//				});
			}
		});
	});

	$("#basicInfoSearchBt").click(function() {
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
BasicInfo.init();