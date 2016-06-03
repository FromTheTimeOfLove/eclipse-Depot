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
    	$("#loanTrackerTable").empty().attr("class","").attr("data-resizable","true");
    	listTable=$("#loanTrackerTable").bootstrapTable({
    		url:"rest/loanTracker/findLoanTrackerList.do",
    		queryParams:function(params){
    			draw++;
    			var formData = $("#loanTrackerForm").serializeJSON(); //查询表单的参数
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
				field : 'fundName',
				title : 'Fund',
				sortable : true,
				align : "left"
			}, {
				field : 'investmentEntity',
				title : 'Investment Entity',
				sortable : true,
				align : "left"
			}, {
				field : 'companyName',
				title : 'Company',
				align : "left"
			}, {
				field : 'loanAmount',
				title : 'Loan Amount (USD$M)',
				align : "center"
			}, {
				field : 'dateIssued',
				title : 'Date Issued',
				align : "center"
			}, {
				field : 'expiry',
				title : 'Expiry',
				align : "center"
			}, {
				field : 'interestRate',
				title : 'Interest Rate',
				align : "center"
			}, {
				field : 'expiredInterestRate',
				title : 'Expired interest rate',
				align : "center"
			}, {
				field : 'companysShares',
				title : "Which company's shares are pledged?",
				align : "center"
			}, {
				field : 'pledgedEntity',
				title : 'Pledged to which Entity?',
				align : "center"
			}, {
				field : 'personalGuarantee',
				title : 'Personal Guarantee?',
				align : "center"
			}, {
				field : 'recovered',
				title : 'Can be recovered?',
				align : "center"
			}, {
				field : 'dateConvertedOrRepaid',
				title : 'Date Converted or Repaid',
				align : "center"
			}, {
				field : 'daysOS',
				title : 'Days O/S',
				align : "center"
			}, {
				field : 'aging',
				title : 'Aging',
				align : "center"
			}, {
				field : 'note',
				title : 'Note',
				align : "center"
			}]
    	});
	};

	$("#loanTrackerSearchBt").click(function() {
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