var User = function() {
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
        $("#userListTable").empty().attr("class","").attr("data-resizable","true");
        listTable=$("#userListTable").bootstrapTable({
            url : "rest/user/findListUser.do",
            queryParams:function(params){
                draw++;
                var formData = $("#userListForm").serializeJSON(); //查询表单的参数
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
                width: '5%',
                formatter:function(value,row,index){
                    return index+1;
                }
            }, {
                field: 'userName',
                title: '用户名称',
                width: '15%',
                //sortable:true
                align:"left"
            }, {
                field: 'uname',
                title: '登录名',
                width: '10%',
                //sortable:true
                align:"left"
            }
            , {
                field: 'userStatus',
                title: '状态',
                width: '10%',
                align:"center",
                formatter:function(value,row,index){
                	var rHtml;
			    	if (row.userStatus =='0') {
						rHtml = "启用";
			    	} else {
			    		rHtml = "禁用";
			    	}
    	        	return rHtml;
                }
            }
            , {
                field: 'leave',
                title: '在职状态',
                width: '10%',
                align:"center",
                formatter:function(value,row,index){
                	var rHtml;
			    	if (row.leave =='0') {
						rHtml = "在职";
			    	} else {
			    		rHtml = "离职";
			    	}
    	        	return rHtml;
                }
            }
            , {
                field: 'userType',
                title: '用户类型',
                width: '10%',
                align:"center"
            }
            , {
                field: 'userRemark',
                title: '备注',
                width: '20%',
                align:"left"
            }
            , {
                field: 'common_operation',//操作列,key可随意更换
                title: i18n.t('GENERAL.COMMON_OPERATION'),
                width: '12%',
                formatter:function(value,c,index){  //value,row,index
					return " <img title=\"" + i18n.t('GENERAL.EDIT') + "\" alt=\"" + i18n.t('GENERAL.EDIT') + "\" src=\"static/common/img/button/btn_edit.png\" onclick=\"User.editUserBtId(\'" + c.userId + "\')\"/>"
						 + " &nbsp;&nbsp;<img title=\"" + i18n.t('GENERAL.DELETE')+ "\" alt=\""+ i18n.t('GENERAL.DELETE')+ "\" src=\"static/common/img/button/btn_del.png\" onclick=\"User.delUserBtId(\'"+ c.userId +"\')\"/>"
						 + " &nbsp;&nbsp;<img title=\"" + i18n.t('GENERAL.RESETPASS')+ "\" alt=\""+ i18n.t('GENERAL.RESETPASS')+ "\" src=\"static/common/img/button/btn_repass.png\" onclick=\"User.rePassword(\'"+ c.userId +"\')\"/>"
						 + " &nbsp;&nbsp;<img title=\"" + i18n.t('GENERAL.ROLESET')+ "\" alt=\""+ i18n.t('GENERAL.ROLESET')+ "\" src=\"static/common/img/button/btn_rolesset.png\" onclick=\"User.showUserCompetenceTree(\'"+ c.userId +"\')\"/>";
				
    	        
                }
            }
            ]
        });
	};
	/**
	 * 新增按钮事件
	 */
	$("#userAddBt").click(function() {
		var url = "rest/user/initAddNewUser.do";
	    var name = "AddUser-1000";
	    var title = "Add User";
	    var c = parent.ConTab["c"];
	    c(url, name, title);
	});
	
	/**
	 * 编辑页面跳转
	 */
	var editUserBtId = function(id) {
		//url 
		var url = "rest/user/initEditUser.do?id="+id;
		//iframe的name，生成iframe时它的name前面会追加iframe前缀
		var name = "EditUser-1000";
		//tab标签页的title
		var title = "Edit User";
		var c = parent.ConTab["c"];
	    c(url, name, title);
	};
	

	var saveUserDataBefore = function() {
		// Form 验证字段内容
		$("#USER_EDIT_FORM").validate({
			focusInvalid : false,
			errorClass : 'dd-validate-error', // 使用自定义样式
			validClass : 'dd-validate-valid',// 使用自定义样式
			errorElement : "span",
			rules : {
				"uname" : {
					required : true
				},
				"userName" : {
					required : true
				},
				"userType" : {
					required : true
				},
				"workNumber" : {
					required : true
				}
			},
			onkeyup : false,
			messages : {
				"uname" : {
					required : i18n.t('USER.VALID.USERNAME_NULL')
				},
				"userName" : {
					required : i18n.t('USER.VALID.LOGINNAME_NULL')
				},
				"userType" : {
					required : i18n.t('USER.VALID.USERTYPE_NULL')
				},
				"workNumber" : {
					required : i18n.t('USER.VALID.WORKNUMBER_NULL')
				}
			}
		});

		var addForm = $("#USER_EDIT_FORM");
		if (!addForm.valid()) {
			return false;
		}
		
		Lobibox.confirm({
		    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
		    callback: function ($this, type, ev) {
		        //Your code goes here
		    	if(type=="yes"){
		    		saveUserData();
	    		}
		    }
		}); 

	};

	var saveUserData = function() {
		var passwd = $("#userPass").val();
		// 密码Base64位处理
		passwd = GlobalUtil.paramEncryption(passwd);
		// 密码SHA512加密处理
		passwd = CryptoJS.SHA512(passwd);
		 $("#userPass").val(passwd);
		jQuery.ajax({
			type : 'POST',
			url : 'rest/user/saveUser.do',
			data : $("#USER_EDIT_FORM").serialize(),
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
	        					var prename = "901010", name,id="userSearchBt",isQuery=true;
	        					var userId = $("input[name='userId']").val();
	        					if($.trim(userId).length <= 0)
									name = "AddUser-1000";
								else 
									name = "EditUser-1000";
	        					GlobalUtil.delTab(prename, name, id, isQuery);//关闭标签代码
	                    	}
	                    }
	                });
				} else {
					Lobibox.notify('error', {
	                    msg: "操作失败",
	                    delay:3000,
	                    soundPath: IMG_PREFIX
	                });
				}
				initTable1();
				//
			}
		});
	};

	/**
	 * 编辑个人信息
	 */
	var initUserInfoById = function(id) {
		//url
		var url = 'rest/user/initUserInfo.do?id=' + id;
		//iframe的name，生成iframe时它的name前面会追加iframe前缀
		var name = "EditUserInfo-1000";
		//tab标签页的title
		var title = "Edit User Info";
		var c = parent.ConTab["c"];
	    c(url, name, title);
	};

	/**
	 * 修改密码
	 */
	var initPasswordById = function(id) {
		//url
		var url = 'rest/user/initPasswordById.do?id=' + id;
		//iframe的name，生成iframe时它的name前面会追加iframe前缀
		var name = "EditPassword-1000";
		//tab标签页的title
		var title = "Edit password";
		var c = parent.ConTab["c"];
	    c(url, name, title);
	};

	var editUserInfoByIdBefore = function() {
		// Form 验证字段内容
		$("#USER_EDIT_FORM").validate({
			focusInvalid : false,
			errorClass : 'dd-validate-error', // 使用自定义样式
			validClass : 'dd-validate-valid',// 使用自定义样式
			errorElement : "span",
			rules : {
				"userName" : {
					required : true
				},
				"userPass" : {
					required : true
				},
			},
			onkeyup : false,
			messages : {
				"userName" : {
					required : "登录名不能为空！"
				},
				"userPass" : {
					required : "用户密码不能为空！"
				},
			}
		});

		var addForm = $("#USER_EDIT_FORM");
		if (!addForm.valid())
			return false;
		Lobibox.confirm({
			msg:  i18n.t('GENERAL.CONFIRM.GEN'),
		    callback: function ($this, type, ev) {
		    	if(type=="yes"){
		    		editUserInfoById();
		    	}
		    }
		});
	};

	var editUserInfoById = function() {
		$('#USER_EDIT_FORM').showLoading();
		jQuery.ajax({
			type : 'POST',
			url : 'rest/user/editUserInfoById.do',
			data : $("#USER_EDIT_FORM").serialize(),
			success : function(data) {
				var result = data;
				var dataHtml = "";
				var type = "success";
				if (result.resultCode == 1) {
					type = "success";
					dataHtml = i18n.t('GENERAL.SUCCESS');
				} else {
					type = "error";
					dataHtml = result.message;
				}
				$('#USER_EDIT_FORM').hideLoading();
				Lobibox.notify(type, {
                    msg: dataHtml,
                    delay: 1000,
                    soundPath: IMG_PREFIX,
					callback : function($type) {
						initTable1();
						
					}
                });
			}
		});
	};
	/**
	 * 修改密码校验
	 */
	var updatePwdByUserIdBefore = function() {
		// Form 验证字段内容
		$("#oldPasswordHidden").val("");
		$("#newPasswordHidden").val("");
		$("#confirmPasswordHidden").val("");
		$("#PWD_EDIT_FORM").validate({
			focusInvalid : false,
			errorClass : 'dd-validate-error', // 使用自定义样式
			validClass : 'dd-validate-valid',// 使用自定义样式
			errorElement : "span",
			onkeyup : false,
			rules : {
				"oldPasswordV" : {
					required : true
				},
				"newPasswordV" : {
					required : true,
					rangelength : [ 4, 20 ]
				},
				"confirmPasswordV" : {
					required : true,
					equalTo : "#newPassword",
					rangelength : [ 4, 20 ]
				}
			},
			messages : {
				"oldPasswordV" : {
					required : i18n.t('USER.VALID.PASSWORD_NULL')
				},
				"newPasswordV" : {
					required : i18n.t('USER.VALID.NEW_PASSWORD_NULL'),
					rangelength : i18n.t('USER.VALID.PASSWORD_LENGTH_ERROR')
				},
				"confirmPasswordV" : {
					required : i18n.t('USER.VALID.TWICE_PASSWORD_NOT'),
					equalTo : i18n.t('USER.VALID.TWICE_PASSWORD_NOT'),
					rangelength : i18n.t('USER.VALID.PASSWORD_LENGTH_ERROR')
				}
			}
		});
		if ($('#PWD_EDIT_FORM').validate().form()) {
			Lobibox.confirm({
				msg:  i18n.t('GENERAL.CONFIRM.GEN'),
			    callback: function ($this, type, ev) {
			    	if(type=="yes"){
			    		// 密码加密处理
						var oldPassword = $("#oldPassword").val();
						var newPassword = $("#newPassword").val();
						var confirmPassword = $("#confirmPassword").val();
						// 密码Base64位处理
						oldPassword = GlobalUtil.paramEncryption(oldPassword);
						newPassword = GlobalUtil.paramEncryption(newPassword);
						confirmPassword = GlobalUtil.paramEncryption(confirmPassword);
						// 密码SHA512加密处理
						oldPassword = CryptoJS.SHA512(oldPassword);
						newPassword = CryptoJS.SHA512(newPassword);
						confirmPassword = CryptoJS.SHA512(confirmPassword);
						// 传输信息加密
						$("#oldPasswordHidden").val(oldPassword);
						$("#newPasswordHidden").val(newPassword);
						$("#confirmPasswordHidden").val(confirmPassword);
						updatePwdByUserId();
			    	}
			    }
			})
		}
	};
	/**
	 * 修改密码
	 */
	var updatePwdByUserId = function() {
		jQuery.ajax({
			type : 'POST',
			url : 'rest/user/updatePwdByUserId.do',
			data : $("#PWD_HIDDEN_FORM").serialize(),
			success : function(data) {
				var result = data;
				var dataHtml = "";
				var type = "success";
				if (result.resultCode == 1) {
					type = "success";
					dataHtml = i18n.t('GENERAL.SUCCESS');
					$("input[type='password']").val("");
				} else if (result.resultCode == 2) {
					type = "error";
					dataHtml = i18n.t('USER.VALID.PASSWORD_OLD_ERROR');
				} else {
					type = "error";
					dataHtml = result.message;
				}
				Lobibox.notify(type, {
                    msg: dataHtml,
                    delay:3000,
                    soundPath: IMG_PREFIX
                });
			}
		});
	};

	/**
	 * 删除
	 */
	var delUserBtId = function(id) {
		
		Lobibox.confirm({
		    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
		    callback: function ($this, type, ev) {
		    	if(type=="yes"){
		    		jQuery.ajax({
		    			type : 'POST',
		    			url : 'rest/user/delUserById.do',
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
		
	};

	
	/**
	 * 重置密碼
	 */
	var rePassword = function(id) {
		var passwd = "111111";
		passwd = GlobalUtil.paramEncryption(passwd);
		passwd = CryptoJS.SHA512(passwd);
		
		Lobibox.confirm({
		    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
		    callback: function ($this, type, ev) {
		    	if(type=="yes"){
		    		jQuery.ajax({
		    			type : 'POST',
		    			url : 'rest/user/rePassword.do',
						data : {
							"id" : id+";"+passwd
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
	};
	
	$("#userSearchBt").click(function() {
		initTable1();
	});

	/**
	 * Show user competence tree
	 */
	var showUserCompetenceTree = function(id) {
		Lobibox.window({
            title: "Choose user competence",
            url: "rest/user/initRoleEmp.do?userId="+id,
            autoload: true,
            draggable: false,
            width: "600",
            height: "500",
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
                	$("#saveUserBt").click();
                }
            }
        });
	};
	
	var saveUserRole = function(id) {
		Lobibox.confirm({
		    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
		    callback: function ($this, type, ev) {
		    	if(type=="yes"){
		    		var treeObj = $.fn.zTree.getZTreeObj("treeDemo"), nodes = treeObj.getCheckedNodes(true), c_id = "";
					for (var i = 0; i < nodes.length; i++) {
						c_id += nodes[i].id + ",";
					}
					var formUserid = $("#USER_ROLE_FORM").serializeJSON(); // 查询表单的参
					var c_id = {
						"userName" : c_id
					};// 使用name参数传送
					var c = $.extend({}, formUserid, c_id); // 将两个JSON合并
					$.ajax({
						cache : false,
						type : 'POST',
						dataType : "json",
						data : c,
						url : 'rest/user/saveUserRole.do',
						error : function() {
							alert(i18n.t('GENERAL.FAIL'));
						},
						success : function(data) {
							var result = data;
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
				                    msg: result.message,
				                    delay:2000,
				                    soundPath: IMG_PREFIX
				                });
							}
						}
					});
		    	}
		    }
		}); 
	}

	return {
		// main function to initiate the module
		init : function() {
			if (!jQuery().dataTable) {
				return;
			}
			initTable1();//回车查询
			GlobalUtil.keydownEvent(function(){
				$("#userSearchBt").click();
			});
			$("#userResetBt").click(function(){
				$("input").val("");
			})
		},
		saveUserData : function() {
			saveUserDataBefore();
		},
		editUserBtId : function(id) {
			editUserBtId(id);
		},
		initUserInfoById : function(id) {
			initUserInfoById(id);
		},
		editUserInfoById : function(id) {
			editUserInfoByIdBefore(id);
		},
		delUserBtId : function(id) {
			delUserBtId(id);
		},
		rePassword : function(id) {
			rePassword(id);
		},
		showUserCompetenceTree : function(id) {
			showUserCompetenceTree(id);
		},
		saveUserRole : function(id) {
			saveUserRole(id);
		},
		initPasswordById : function(id) {
			initPasswordById(id);
		},
		updatePwdByUserId : function() {
			updatePwdByUserIdBefore();
		}

	};

}();
// 执行
User.init();