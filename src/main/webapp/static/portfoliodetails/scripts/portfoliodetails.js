var Portfoliodetails = function() {

	/**
	 * 查询表格
	 */
	var draw = 0;
	var listTable = null;
	var initTable1 = function() {
		if (listTable != null) {
			listTable.bootstrapTable("refresh", {
				silent : true
			});
			return;
		}
		$("#portfoliListTable").empty().attr("class", "").attr(
				"data-resizable", "true");
		listTable = $("#portfoliListTable").bootstrapTable(
				{
					url : "rest/portfoliodetails/findListPortfoliodetails.do",
					queryParams : function(params) {
						draw++;
						var formData = $("#studentListForm").serializeJSON(); // 查询表单的参数
						var json = {
							"draw" : draw,
							"start" : params.offset,
							"length" : params.limit
						};
						if (params.sort) {
							json["order"] = "[{\"column\":\"" + params.sort
									+ "\",\"dir\":\"" + params.order + "\"}]";
						}
						var c = $.extend({}, formData, json);
						return c;
					},
					width:100,
					columns : [ [ {
						title:'BASIC',
						colspan : 4,
						align : 'center',
						valign : 'middle'
					}, {
						title:'FOR AUDITORS/SECTOR TEAM REQUEST',
						colspan : 1,
						align : 'center',
						valign :  'middle'
					},{
						title : 'FOR MARKETING',
						colspan : 4,
						align : 'center',
						valign :  'middle'
					}, {
						title : 'INV STRUCTURE/RESTRUCTURE',
						colspan : 5,
						align : 'center',
						valign :  'middle'
					}, {
						title : 'BOD',
						colspan : 2,
						align : 'center',
						valign :  'middle'
					}, {
						title : 'Date of investments',
						colspan : 2,
						align : 'center',
						valign :  'middle'
					}, {
						title : 'Transaction document filing',
						colspan : 5,
						align : 'center',
						valign :  'middle'
					}, {
						title : 'For US - projected funding',
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
						field : 'studentName',
						title : i18n.t('CID'),
						sortable : true,
						align : "center"
					}, {
						field : 'studentAge',
						title : i18n.t('Company Name'),
						sortable : true,
						align : "center"
					}, {
						field : 'studentEmail',
						title : i18n.t('Detailed Remarks'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('Investment type/Status'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('STEALTH'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('ZERO2IPO/CVCA'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('FORBES'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('WEBSITE'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('VIE'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('JV'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('FOF'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('DE-REDCHIP'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('ATYPICAL'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('Previous BOD'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('Date of Update'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('Equity'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('Loan'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('Date of Signed Docs'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('Date of Closing binder received'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('Godown'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('Date of Share Cert Received'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('Share cert location'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('Q1 16'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('Q2 16'),
						align : "center"
					}, {
						field : 'studentAddress',
						title : i18n.t('After'),
						align : "center"
					} ] ]
				});
	};

	$("#studentAddBt").click(function() {
		jQuery.ajax({
			type : 'POST',
			url : 'rest/student/initAddNewStudent.do',
			success : function(data) {
			}
		});
	});

	$("#studentSearchBt").click(function() {
		initTable1();
	});

	var saveStudentDataBefore = function() {
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
					saveStudentData();
				}
			}
		})
	};

	var saveStudentData = function() {
		$('#STUDENT_EDIT_FORM').showLoading();
		jQuery.ajax({
			type : 'POST',
			url : 'rest/student/saveStudent.do',
			data : $("#STUDENT_EDIT_FORM").serialize(),
			success : function(data) {
				var result = data;
				var dataHtml = "";
				if (result.resultCode == 1) {
					dataHtml = i18n.t('GENERAL.SUCCESS');
				} else {
					dataHtml = result.message;
				}
				$('#STUDENT_EDIT_FORM').hideLoading();
				bootbox.alert({
					size : 'small',
					message : dataHtml,
					callback : function(result) {
						initTable1();
						bootbox.hideAll(); //隐藏所有的bootbox
					}
				});
			}
		});
	};

	/**
	 * 编辑
	 */
	var editStudentBtId = function(id) {
		jQuery.ajax({
			type : 'GET',
			url : 'rest/student/initEditStudent.do?id=' + id,
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
	var delStudentBtId = function(id) {
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
						url : 'rest/student/delStudentById.do',
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
		var o = "rest/basicInfo/initAddBasicInfo.do", m = "oneBasicInfo-1000";
		l = "Add Basic Info";
		var c = parent.ConTab["c"]; // 本页面为iframe嵌入，因此需要调用parent的ConTab对象，才能添加新的Tab
		c(o, m, l);
	});

	return {
		init : function() {
			if (!jQuery().dataTable) {
				return;
			}
			initTable1();
			$('#dataTimeTest').datetimepicker({
				format : 'yyyy-mm-dd'
			});
		},
		delStudentBtId : function(id) {
			delStudentBtId(id);
		},
		editStudentBtId : function(id) {
			editStudentBtId(id);
		},
		saveStudentData : function() {
			saveStudentDataBefore();
		}
	};

}();
// 执行
Portfoliodetails.init();