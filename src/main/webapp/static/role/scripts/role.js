var Role = function() {
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
        $("#roleListTable").empty().attr("class","").attr("data-resizable","true");
        listTable=$("#roleListTable").bootstrapTable({
            url : "rest/role/findListRole.do",
            queryParams:function(params){
                //not limit:pageSize, pageNumber, searchText, sortName, sortOrder
                //limit: limit, offset, search, sort, order
                draw++;
                var formData = $("#roleListForm").serializeJSON(); //查询表单的参数
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
				field : 'common_index',// 序号列,key可随意更换
				title :'序号',
				formatter : function(value, row, index) {
					return index+1;
				}
			}, {
                field: 'roleName',
                title: '角色名称',
                width: '20%',
                //sortable:true
                align:"left"
            }, {
                field: 'roleStatus',
                title: '角色状态',
                width: '10%',
                //sortable:true
                align:"center",
                formatter:function(value,row,index){
                	var rHtml;
			    	if (row.roleStatus =='0') {
						rHtml = "启用";
			    	} else {
			    		rHtml = "禁用";
			    	}
    	        	return rHtml;
                }
            }, {
                field: 'roleGroup',
                title: '角色分组',
                width: '20%',
                align:"left"
            }
            , {
                field: 'roleRemark',
                title: '备注',
                width: '25%',
                align:"left"
            }, {
                field: 'common_operation',//操作列,key可随意更换
//                title: i18n.t('GENERAL.COMMON_OPERATION'),
                title: '操作',
                width: '12%',
                formatter:function(value,c,index){  //value,row,index
                	return " <img title=\"" + i18n.t('GENERAL.EDIT') + "\" alt=\"" + i18n.t('GENERAL.EDIT') + "\" src=\"static/common/img/button/btn_edit.png\" onclick=\"Role.editRoleBtId(\'" + c.roleId + "\')\"/>"
					 + " &nbsp;&nbsp;<img title=\"" + i18n.t('GENERAL.DELETE')+ "\" alt=\""+ i18n.t('GENERAL.DELETE')+ "\" src=\"static/common/img/button/btn_del.png\" onclick=\"Role.delRoleBtId(\'"+ c.roleId +"\')\"/>"
					 + " &nbsp;&nbsp;<img title=\"" + i18n.t('GENERAL.ROLESET')+ "\" alt=\""+ i18n.t('GENERAL.ROLESET')+ "\" src=\"static/common/img/button/btn_qx.png\" onclick=\"Role.showRoleCompetenceTree(\'"+ c.roleId +"\')\"/>";
			
                }
            }
            ]
        });
	};

	$("#roleAddBt").click(function() {
		//url
		var url = "rest/role/initAddNewRole.do";
		//iframe的name，生成iframe时它的name前面会追加iframe前缀
		var name = "AddRole-1000";
		//tab标签页的title
		var title = "Add role";
		var c = parent.ConTab["c"];
	    c(url, name, title);
	});

	var saveRoleDataBefore = function() {
		// Form 验证字段内容
		$("#ROLE_EDIT_FORM").validate({
			focusInvalid : false,
			errorClass : 'dd-validate-error', // 使用自定义样式
			validClass : 'dd-validate-valid',// 使用自定义样式
			errorElement : "span",
			rules : {
				"roleName" : {
					required : true
				},
				"roleGroup" : {
					required : true
				}
			},
			onkeyup : false,
			messages : {
				"roleName" : {
					required : i18n.t('ROLE.VALID.ROLENAME_NULL')
				},
				"roleGroup" : {
					required : i18n.t('ROLE.VALID.ROLEGROUP_NULL')
				}
			}
		});

		var addForm = $("#ROLE_EDIT_FORM");
		if (!addForm.valid())
			return false;
		
		Lobibox.confirm({
		    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
		    callback: function ($this, type, ev) {
		    	if(type=="yes"){
		    		saveRoleData();
	    		}
		    }
		}); 
	};

	var saveRoleData = function() {
		jQuery.ajax({
			type : 'POST',
			url : 'rest/role/saveRole.do',
			data : $("#ROLE_EDIT_FORM").serialize(),
			success : function(data) {
				var result = data;
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
	                    		var prename = "901110", name,id="roleSearchBt",isQuery=true;
	        					var roleId = $("input[name='roleId']").val();
	        					if($.trim(roleId).length <= 0)
	        						name = "AddRole-1000";
	        					else 
	        						name = "EditRole-1000";
	        					GlobalUtil.delTab(prename, name, id, isQuery);//关闭标签代码
	                    	}
	                    }
	                });
				} else {
					Lobibox.notify('error', {
	                    msg: result.message,
	                    delay:3000,
	                    soundPath: IMG_PREFIX
	                });
				}
				initTable1();
				
			}
		});
	};

	/**
	 * 编辑
	 */
	var editRoleBtId = function(id) {
		//url
		var url = "rest/role/initEditRole.do?id="+id;
		//iframe的name，生成iframe时它的name前面会追加iframe前缀
		var name = "EditRole-1000";
		//tab标签页的title
		var title = "Edit role";
		var c = parent.ConTab["c"];
	    c(url, name, title);
	};

	/**
	 * 修改权限
	 */
	var showRoleCompetenceTree = function(roleId) {
		Lobibox.window({
            title: "Choose role competence",
            url: 'rest/role/initPermissionBtId.do?roleId=' + roleId,
            width: "600",
            height: "500",
            autoload: true,
            draggable: false,
            loadMethod: 'GET',
            buttons: {
                yes: {
                    'class': 'btn btn-success',
                    text: 'save',
                    closeOnClick: false
                },
                close: {
                    'class': 'btn btn-default',
                    text: 'Close',
                    closeOnClick: true
                }
            },
            callback: function ($this, type, ev) {
                if (type === 'yes') { // Save
                	$("#saveRoleBt").click();
                }
            }
		});
		/*Lobibox.window({
            url: 'rest/role/initPermissionBtId.do?roleId=' + roleId,
            draggable: false,
            width: "600",
            height: "500",
            buttons: {
                yes: {
                    'class': 'btn btn-success',
                    text: 'save',
                    closeOnClick: false
                },
                close: {
                    'class': 'btn btn-default',
                    text: 'Close',
                    closeOnClick: true
                }
            },
            callback: function ($this, type, ev) {
                if (type === 'yes') { // Save
                	$("#saveRoleBt").click();
                }
            }
        });*/
	};

	var saveRolePermissionBefore = function() {
		Lobibox.confirm({
		    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
		    callback: function ($this, type, ev) {
		    	if(type=="yes"){
		    		saveRolePermission();
		    	}
		    }
		}); 
	};

	var saveRolePermission = function() {
		$('#ROLE_ACTION_FORM').showLoading();
		// 1获取已勾选的节点ID
		// 1.1获取ZTree对象
		var treeObj = $.fn.zTree.getZTreeObj("permissionTree");
		// 1.2获取已勾选的节点数组
		var nodes = treeObj.getCheckedNodes(true);
		// 1.3遍历数组，取出ID
		var permissionIds = '';
		for (var i = 0; i < nodes.length; i++) {
			permissionIds += nodes[i].id + ',';
		}
		permissionIds = permissionIds == '' ? '' : permissionIds.substring(0, permissionIds.length - 1);

		jQuery.ajax({
			type : 'POST',
			url : 'rest/role/saveRolePermission.do',
			data : "roleId=" + $("#roleId").val() + "&permissionId=" + permissionIds,
			success : function(data) {
				$('#ROLE_ACTION_FORM').hideLoading();
				var result = data;
				var dataHtml = "";
				var type = "success";
				if (result.resultCode == 1) {
					dataHtml = i18n.t('GENERAL.SUCCESS');
					type = "success";
				} else {
					dataHtml = result.message;
					type = "error";
				}
				Lobibox.notify(type, {
                    msg: dataHtml,
                    delay:1000,
                    soundPath: IMG_PREFIX
                });
				initTable1();
			}
		});
	};

	/**
	 * 删除
	 */
	var delRoleBtId = function(id) {
		
		
			Lobibox.confirm({
		    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
		    callback: function ($this, type, ev) {
		    	if(type=="yes"){
		    		jQuery.ajax({
		    			type : 'POST',
						url : 'rest/role/delRoleById.do',
						data : {
							"id" : id
						},
						success : function(data) {
							var result = data;
							var dataHtml = "";
							if (result.resultCode == 1) {
								dataHtml = i18n.t('GENERAL.SUCCESS');
								Lobibox.notify('success', {
		                            msg: dataHtml,
		                            delay: 1000,
		                            soundPath: IMG_PREFIX
		                        });
							} else {
								var message = result.message;
								dataHtml = message;
								Lobibox.notify('error', {
		                            msg: dataHtml,
		                            delay: 1000,
		                            soundPath: IMG_PREFIX
		                        });
							}
							initTable1();
						}
					});
		    	}
		    }
		}); 
		
		/*bootbox.confirm({
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
						url : 'rest/role/delRoleById.do',
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
		});*/
	};

	$("#roleSearchBt").click(function() {
		initTable1();
	});

	return {
		// main function to initiate the module
		init : function() {
			GlobalCommon.dataTableInit();
			if (!jQuery().dataTable) {
				return;
			}
			initTable1();
			GlobalUtil.keydownEvent(function(){
				$("#roleSearchBt").click();
			});
			$("#roleResetBt").click(function(){
				$("input").val("");
			})
		},
		saveRoleData : function() {
			saveRoleDataBefore();
		},
		editRoleBtId : function(id) {
			editRoleBtId(id);
		},
		delRoleBtId : function(id) {
			delRoleBtId(id);
		},
		showRoleCompetenceTree : function(roleId) {
			showRoleCompetenceTree(roleId);
		},
		saveRolePermission : function() {
			saveRolePermissionBefore();
		}
	};

}();
// 执行
Role.init();