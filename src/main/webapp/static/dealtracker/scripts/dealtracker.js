var Dealtracker = function() {

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
    	$("#dealtrackerListTable").empty().attr("class","").attr("data-resizable","true");
    	listTable=$("#dealtrackerListTable").bootstrapTable({
    		url:"rest/dealtracker/findListDealtracker.do"
    		,queryParams:function(params){
    			//not limit:pageSize, pageNumber, searchText, sortName, sortOrder
    			//limit: limit, offset, search, sort, order
    			draw++;
    			var formData = $("#studentListForm").serializeJSON(); //查询表单的参数
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
				colspan : 1,
				align : 'center',
				valign : 'middle'
			}, {
				title:'INVESTMENT AMOUNT',
				colspan : 5,
				align : 'center',
				valign :  'middle'
			},{
				title : 'PORTFOLIO DETAILS',
				colspan : 6,
				align : 'center',
				valign :  'middle'
			}, {
				title : 'DEAL TEAM',
				colspan : 2,
				align : 'center',
				valign :  'middle'
			}, {
				title : 'PROCEEDS',
				colspan : 5,
				align : 'center',
				valign :  'middle'
			}, {
				title : 'REMARKS',
				colspan : 2,
				align : 'center',
				valign :  'middle'
			}], [ {
				field : 'common_index',// 序号列,key可随意更换
				title : i18n.t('GENERAL.COMMON_INDEX'),
				formatter : function(value, row, index) {
					return index + 1;
				}
			}, {
				field : 'Total',
				title : i18n.t('Total'),
				sortable : true,
				align : "center"
			}, {
				field : 'F/On',
				title : i18n.t('F/On'),
				sortable : true,
				align : "center"
			}, {
				field : 'TS/SP',
				title : i18n.t('TS/SP'),
				align : "center"
			}, {
				field : 'Loan',
				title : i18n.t('Loan'),
				align : "center"
			}, {
				field : 'Invested',
				title : i18n.t('Invested'),
				align : "center"
			}, {
				field : 'Comapny Name',
				title : i18n.t('Comapny Name'),
				align : "center"
			}, {
				field : 'Date of Inv',
				title : i18n.t('Date of Inv'),
				align : "center"
			}, {
				field : 'Sector',
				title : i18n.t('Sector'),
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
				field : 'Business Description',
				title : i18n.t('Business Description'),
				align : "center"
			}, {
				field : 'Lead',
				title : i18n.t('Lead'),
				align : "center"
			}, {
				field : 'Board',
				title : i18n.t('Board'),
				align : "center"
			}, {
				field : 'Received',
				title : i18n.t('Received'),
				align : "center"
			}, {
				field : 'Distributed',
				title : i18n.t('Distributedpdate'),
				align : "center"
			}, {
				field : 'Recycled',
				title : i18n.t('Recycled'),
				align : "center"
			}, {
				field : 'Escrowed',
				title : i18n.t('Escrowed'),
				align : "center"
			}, {
				field : 'Taxes',
				title : i18n.t('Taxes'),
				align : "center"
			}, {
				field : 'Remarks',
				title : i18n.t('Remarks'),
				align : "center"
			}, {
				field : 'FMV',
				title : i18n.t('FMV'),
				align : "center"
			}] ]
    	});
		
		
		
		
/*		var table = jQuery('#studentListTable');
		if ($.fn.DataTable.isDataTable('#studentListTable')) {
			table = $('#studentListTable').DataTable();
			table.draw(true); // true:刷新所有的数据,回到第一页;false:只刷新当前页的数据
		} else {
			table.dataTable({
				"serverSide" : true,
				"ajax" : {
					url : "rest/student/findListStudent.do",
					type : "POST",
					dataType : "json",
					// traditional: true,
					data : function(d) {
						var formData = $("#studentListForm").serializeJSON(); // 查询表单的参数
						var dealData = GlobalUtil.dealDataTableAjaxData(d); // DataTabel自带的分页和排序参数
						var c = $.extend({}, formData, dealData); // 将两个JSON合并
						return c;
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert(XMLHttpRequest.status);
						alert(XMLHttpRequest.readyState);
						alert(textStatus);
					}
				},
				"columns" : [ {
					"data" : "studentName"
				}, {
					"data" : "studentAge"
				}, {
					"data" : "studentEmail"
				}, {
					"data" : "studentAddress"
				}, {
					"data" : null
				} ],
				columnDefs : [
						{
							targets : 4,
							render : function(a, b, c, d) {
								return "<a href=\"javascript:;\" onclick=\"Student.editStudentBtId(\'" + c.studentId + "\')\">"
										+ i18n.t('GENERAL.EDIT') + "</a>&nbsp;&nbsp;"
										+ "<a href=\"javascript:;\" onclick=\"Student.delStudentBtId(\'" + c.studentId + "\')\">"
										+ i18n.t('GENERAL.DELETE') + "</a>";
							}
						}, {
							targets : [ 2, 3, 4 ],
							orderable : false
						} ]
			});
		}*/
	};

	$("#studentAddBt").click(function() {
		jQuery.ajax({
			type : 'POST',
			url : 'rest/student/initAddNewStudent.do',
			success : function(data) {
//				bootbox.dialog({
//					message : data,
//					title : i18n.t('GENERAL.ADD'),
//				});
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
						bootbox.hideAll(); // 隐藏所有的bootbox
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
		})
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
Dealtracker.init();