var Emp = function() {

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
    	$("#empListTable").empty().attr("class","").attr("data-resizable","true");
    	listTable=$("#empListTable").bootstrapTable({
    		url:"rest/emp/findEmp.do",
    		queryParams:function(params){
    			draw++;
    			var formData = $("#empListForm").serializeJSON(); //查询表单的参数
    			var obj = document.getElementById("selectsex");
    			var json={
        				"draw":draw
        				,"start":params.offset
        				,"length":params.limit
        				,"empsex":obj.options[obj.selectedIndex].value
        			};
    			if(params.sort){
    				json["order"]="[{\"column\":\""+params.sort+"\",\"dir\":\""+params.order+"\"}]";
    			}
    			var c = $.extend({}, formData, json);
    			return c;
    		}
    	    ,columns: [
    	    {
    	        field: 'common_index',//序号列,key可随意更换
    	        title: i18n.t('GENERAL.COMMON_INDEX'),
    	        formatter:function(value,row,index){
    	        	return index+1;
    	        }
    	    }, {
    	        field: 'empname',
    	        title: i18n.t('姓名'),
    	        sortable:true
    	        ,align:"center"
    	    }, {
    	        field: 'empsex',
    	        title: i18n.t('性别'),
    	        sortable:true
    	        ,align:"center"
    	    }
        	, {
        		field: 'empage',
        		title: i18n.t('年龄')
        		,align:"center"
        	}
        	, {
        		field: 'empcom',
        		title: i18n.t('入职时间')
        		,align:"center"
        	}
        	, {
        		field: 'empcid',
        		title: i18n.t('身份证号')
        		,align:"center"
        	}
        	, {
        		field: 'common_operation',//操作列,key可随意更换
        		title: i18n.t('GENERAL.COMMON_OPERATION'),
    	        formatter:function(value,c,index){  //value,row,index
					return "<a href=\"javascript:;\" onclick=\"Emp.editEmpBtId(\'" + c.empid + "\')\">"
					+ i18n.t('GENERAL.EDIT') + "</a>&nbsp;&nbsp;"
					+ "<a href=\"javascript:;\" onclick=\"Student.delEmpBtId(\'" + c.empid + "\')\">"
					+ i18n.t('GENERAL.DELETE') + "</a>";
    	        }
        	}
    	    ]
    	});
	};

	$("#empAddBt").click(function() {
		var obj = document.getElementById("selectsex");
		jQuery.ajax({
			type : 'POST',
//			url : 'rest/emp/initAddNewEmp.do',
			url : 'rest/emp/initAddNewEmp.do?empsex='+obj.options[obj.selectedIndex].value,
			success : function(data) {
				bootbox.dialog({
					message : data,
					title : i18n.t('GENERAL.ADD'),
				});
			}
		});
	});

	$("#empSearchBt").click(function() {
		initTable1();
	});

	var saveEmpDataBefore = function() {
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
					saveEmpData();
				}
			}
		})
	};

	var saveEmpData = function() {
		$('#EMP_EDIT_FORM').showLoading();
		jQuery.ajax({
			type : 'POST',
//			url : 'rest/emp/saveStuObj.do?empsex=' + id,
			url : 'rest/emp/saveStuObj.do',
			data : $("#EMP_EDIT_FORM").serialize(),
			success : function(data) {
				var result = data;
				var dataHtml = "";
				if (result.resultCode == 1) {
					dataHtml = i18n.t('GENERAL.SUCCESS');
				} else {
					dataHtml = result.message;
				}
				$('#EMP_EDIT_FORM').hideLoading();
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
	var editEmpBtId = function(id) {
		jQuery.ajax({
			type : 'GET',
			url : 'rest/emp/initEditEmpInfo.do?empid=' + id,
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
	var delEmpBtId = function(id) {
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
						url : 'rest/stu/delStuInfo.do',
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
		delEmpBtId : function(id) {
			delEmpBtId(id);
		},
		editEmpBtId : function(id) {
			editEmpBtId(id);
		},
		saveEmpData : function() {
			saveEmpDataBefore();
		}
	};

}();
// 执行
Emp.init();