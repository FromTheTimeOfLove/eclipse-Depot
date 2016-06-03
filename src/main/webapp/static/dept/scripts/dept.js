var Deptment = function() {
	 var IMG_PREFIX = 'static/common/plugins/notification/dist/img/';
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
    	$("#deptListTable").empty().attr("class","").attr("data-resizable","true");
    	listTable=$("#deptListTable").bootstrapTable({
    		url:"rest/dept/findDept.do",
    		queryParams:function(params){
    			draw++;
    			var formData = $("#deptListForm").serializeJSON(); //查询表单的参数
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
    	    ,columns: [
    	    {
    	        field: 'common_index',//序号列,key可随意更换
    	        title: '序号',
    	        width: '10%',
    	        align:"left",
    	        formatter:function(value,row,index){
    	        	return index+1;
    	        }
    	    }, {
    	        field: 'deptname',
    	        title: i18n.t('部门名称'),
    	        width: '30%',
    	        //sortable:true
    	        align:"left"
    	    }, {
    	        field: 'leaderid',
    	        title: i18n.t('部门领导'),
    	        width: '20%',
    	        //sortable:true
    	        align:"left"
    	    }
        	, {
        		field: 'parentdeptname',
        		width: '30%',
        		title: i18n.t('上级部门'),
        		align:"left"
        	}
        
        	, {
        		field: 'common_operation',//操作列,key可随意更换
        		width: '12%',
        		title: i18n.t('GENERAL.COMMON_OPERATION'),
    	        formatter:function(value,c,index){  //value,row,index
					return " <img title=\""
							+ i18n.t('GENERAL.EDIT')
							+ "\" alt=\""
							+ i18n.t('GENERAL.EDIT')
							+ "\" src=\"static/common/img/button/btn_edit.png\" onclick=\"Deptment.editDeptBtId(\'"
							+ c.deptid + "\')\"/>"
							+ "&nbsp;&nbsp; <img title=\""
							+ i18n.t('GENERAL.DELETE')
							+ "\" alt=\""
							+ i18n.t('GENERAL.DELETE')
							+ "\" src=\"static/common/img/button/btn_del.png\" onclick=\"Deptment.delDeptBtId(\'"
							+ c.deptid +"\')\"/>";
				
    	        }
        	}
    	    ]
    	});
	};

	$("#deptSearchBt").click(function() {
		initTable1();
	});
	
	
	$("#deptAddBt").click(function() {
		//url
		var url = "rest/dept/initAddNewDept.do";
		//iframe的name，生成iframe时它的name前面会追加iframe前缀
		var name = "AddDept-1000";
		//tab标签页的title
		var title = "Add Dept";
		var c = parent.ConTab["c"];
	    c(url, name, title);
	});
	
	/**
	 * 编辑
	 */
	var editDeptBtId = function(id) {
		//url
		var url = "rest/dept/initEditDeptInfo.do?deptid="+id;
		//iframe的name，生成iframe时它的name前面会追加iframe前缀
		var name = "EditDept-1000";
		//tab标签页的title
		var title = "Edit Dept";
		var c = parent.ConTab["c"];
	    c(url, name, title);
	};

	var saveDeptDataBefore = function() {
		// Form 验证字段内容
		$("#DEPT_EDIT_FORM").validate({
			focusInvalid : false,
			errorClass : 'dd-validate-error', // 使用自定义样式
			validClass : 'dd-validate-valid',// 使用自定义样式
			errorElement : "span",
			rules : {
				"deptname" : {
					required : true
				}
			},
			onkeyup : false,
			messages : {
				"deptname" : {
					required : i18n.t('ROLE.VALID.ROLENAME_NULL')
				}
			}
		});

		var addForm = $("#DEPT_EDIT_FORM");
		if (!addForm.valid())
			return false;
	
		Lobibox.confirm({
		    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
		    callback: function ($this, type, ev) {
		        //Your code goes here
		    	if(type=="yes"){
		    		saveDeptData();
	    		}
		    }
		}); 
	};

	var saveDeptData = function() {
		jQuery.ajax({
			type : 'POST',
			url : 'rest/dept/saveDeptObject.do',
			data : $("#DEPT_EDIT_FORM").serialize(),
			success : function(data) {
				var result = data;
				var dataHtml = "";
				if (result.resultCode == 1) {
					dataHtml = i18n.t('GENERAL.SUCCESS');
				} else {
					dataHtml = result.message;
				}
				if (result.resultCode == 1) {
					Lobibox.alert('success', {
						title: "提示",
	                    msg: "保存"+result.message,
	                    delay: 2000,
	                    soundPath: IMG_PREFIX,
	                    buttons: {
	                        ok: {
	                            'class': 'btn btn-success',
	                            closeOnClick: false
	                        }
	                    },
	                    callback : function(lobibox, type) {
	                    	if(type == "ok") {
	                    		var prename = "9016", name,id="deptSearchBt",isQuery=true;
	        					var deptid = $("#deptid").val();
	        					if($.trim(deptid).length <= 0)
	        						name = "AddDept-1000";
	        					else 
	        						name = "EditDept-1000";
	        					GlobalUtil.delTab(prename, name, id, isQuery);//关闭标签代码
	                    	}
	                    }
	                });
				} else {
					Lobibox.notify('error', {
	                    msg: result.message,
	                    delay:2000,
	                    soundPath: IMG_PREFIX
	                });
				}
			}
		});
	};


	/**
	 * 删除
	 */
	var delDeptBtId = function(id) {
		Lobibox.confirm({
		    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
//		    buttons : {
//				 yes: {
//                    'class': 'btn btn-primary',
//                    closeOnClick: false
//                },
//                no: {
//                    'class': 'btn btn-primary',
//                    closeOnClick: false
//                }
//			},
		    callback: function ($this, type, ev) {
		        //Your code goes here
		    	if(type=="yes"){
		    		jQuery.ajax({
						type : 'POST',
						url : 'rest/dept/delDeptInfo.do?deptid=' + id,
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
							Lobibox.notify('success', {
                                msg: dataHtml,
                                delay: 1000,
                                soundPath: IMG_PREFIX
                            });
						}
					});
		    	}
		    }
		});    
	};

	var showDeptTree = function() {
		Lobibox.window({
            title: "Choose Higher office",
            url: "rest/dept/initPermissionBtId.do",
            autoload: true,
            draggable: false,
            width: "600",
            height: "500",
            loadMethod: 'GET',
            buttons: {
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
                if (type === 'yes') { // Save
                }
            }
        });
	};
	
	/**
	 * 修改上级部门
	 */
	/*
	var initPermissionBtId = function() {
		jQuery.ajax({
			type : 'GET',
			url : 'rest/dept/initPermissionBtId.do',
			success : function(data) {
				bootbox.alert({
//					size : 'small',
					title : i18n.t('上级部门'),
					message : data,
				});
				initPermissionTree();
			}
		});
	};*/

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
			GlobalUtil.keydownEvent(function(){
				$("#deptSearchBt").click();
			});
			$("#deptResetBt").click(function(){
				$("input").val("");
			})
		},
		delDeptBtId : function(id) {
			delDeptBtId(id);
		},
		editDeptBtId : function(id) {
			editDeptBtId(id);
		},
		saveDeptData : function() {
			saveDeptDataBefore();
		},
		initPermissionBtId : function() {
			initPermissionBtId();
		},
		showDeptTree : function() {
			showDeptTree();
		}
	};

}();
// 执行
Deptment.init();