var OnePaper = function() {
	 var IMG_PREFIX = 'static/common/plugins/notification/dist/img/';
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
		$("#onePagerListTable").empty().attr("class", "").attr(
				"data-resizable", "true");
		listTable = $("#onePagerListTable")
				.bootstrapTable(
						{
							url : "rest/onePaper/findOnePaperList.do",
							queryParams : function(params) {
								// not limit:pageSize, pageNumber, searchText,
								// sortName, sortOrder
								// limit: limit, offset, search, sort, order
								draw++;
								var formData = $("#onePagerListForm")
										.serializeJSON(); // 查询表单的参数
								var json = {
									"draw" : draw,
									"start" : params.offset,
									"length" : params.limit
								};
								if (params.sort) {
									json["order"] = "[{\"column\":\""
											+ params.sort + "\",\"dir\":\""
											+ params.order + "\"}]";
								}
								var c = $.extend({}, formData, json);
								return c;
							},
							columns : [
									{
										field : 'common_index',// 序号列,key可随意更换
										title : i18n.t('GENERAL.COMMON_INDEX'),
										formatter : function(value, row, index) {
											return index+1;
										}
									},
									{
										field : 'portfolionameCH',
										title : 'Portfolio name (CH)',
										//sortable : true,
										align : "left"
									},
									{
										field : 'portfolionameEN',
										title : 'Portfolio name (EN)',
										//sortable : true,
										align : "left"
									}
									/*
									 * , { field: 'source', title: 'Source'
									 * ,align:"left" } , { field:
									 * 'investmentThesis', title: 'Investment
									 * Thesis' ,align:"left" }
									 */
									,
									{
										field : 'sectorname',
										title : 'Sector',
										align : "center"
									},
									{
										field : 'fundname',
										title : 'Fund',
										align : "center"
									},
									{
										field : 'stagename',
										title : 'Stage',
										align : "center"
									},
									{
										field : 'statusname',
										title : 'Status',
										align : "center"
									},
									{
										field : 'dpdate',
										title : 'Date',
										width : '12%',
										align : "center"
									}
									/*
									 * , { field: 'business', title: 'Business'
									 * ,align:"center" } , { field: 'market',
									 * title: 'Market' ,align:"center" } , {
									 * field: 'Product', title: 'product'
									 * ,align:"center" }
									 */
									,
									{
										field : 'common_operation',// 操作列,key可随意更换
										title : i18n.t('GENERAL.COMMON_OPERATION'),
										width : '12%',
										formatter : function(value, c, index) { // value,row,index
											return " <img title=\""
													+ i18n.t('GENERAL.EDIT')
													+ "\" alt=\""
													+ i18n.t('GENERAL.EDIT')
													+ "\" src=\"static/common/img/button/btn_edit.png\" onclick=\"OnePaper.editOnePaperId(\'"
													+ c.paperid + "\')\"/>"
													+ " &nbsp;&nbsp;<img title=\""
													+ i18n.t('GENERAL.DELETE')
													+ "\" alt=\""
													+ i18n.t('GENERAL.DELETE')
													+ "\" src=\"static/common/img/button/btn_del.png\" onclick=\"OnePaper.delOnepaperBtId(\'"
													+ c.paperid +','+c.attachmentid +"\')\"/>";
										}
									} ]
						});
	};

	$("#onePagerAddBt").click(function() {
		var o = "rest/onePaper/initAddOnePaper.do", m = "onePagerAdd-1000";
		l = i18n.t('ONEPAPER.ADD');
		var c = parent.ConTab["c"]; // 本页面为iframe嵌入，因此需要调用parent的ConTab对象，才能添加新的Tab
		c(o, m, l);
	});

	$("#onePagerSearchBt").click(function() {
		 initTable1();
	});
	
	var resetSession = function() {
		jQuery.ajax({
			type : 'GET',
			url : 'rest/onePaper/resetSession.do',
			success : function(data) {
				$("input[type='text").val("");
			}
		});
	};

	/**
	 * 跳转编辑页面
	 */
	var editOnePaperId = function(id) {
		var o = "rest/onePaper/initEditOnePaper.do?paperid=" + id, 
		m = "onePagerEdit-1000";
		l = i18n.t('one paper edit');
		var c = parent.ConTab["c"]; // 本页面为iframe嵌入，因此需要调用parent的ConTab对象，才能添加新的Tab
		c(o, m, l);
	};

	delOnepaperBtId=function(id){
		
		Lobibox.confirm({
	    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
	    callback: function ($this, type, ev) {
	    	if(type=="yes"){
	    		jQuery.ajax({
	    			type : 'POST',
					url : 'rest/onePaper/delOnepaperBtId.do',
					data : {
						"paperid" : id
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
	
	
	var saveOnePaperDataBefore = function() {
		// Form 验证字段内容
		$("#ONEPAPER_EDIT_FORM").validate({
			focusInvalid : false,
			errorClass : 'dd-validate-error', // 使用自定义样式
			validClass : 'dd-validate-valid',// 使用自定义样式
			errorElement : "span",
			rules : {
				"portfolionameCH" : {
					required : true
				},
				"portfolionameEN" : {
					required : true
				}
			
			},
			onkeyup : false,
			messages : {
				"portfolionameCH" : {
					required : i18n.t('Portfolio name (CH) not null')
				},
				"portfolionameEN" : {
					required : i18n.t('Portfolio name (EN) not null')
				}
			}
		});

		var addForm = $("#ONEPAPER_EDIT_FORM");
		if (!addForm.valid())
			return false;
		Lobibox.confirm({
		    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
		    callback: function ($this, type, ev) {
		        //Your code goes here
		    	if(type=="yes"){
		    		saveOnePaper();
	    		}
		    }
		}); 
	};

	
	var saveOnePaper = function() {
		jQuery.ajax({
			type : 'POST',
			url : 'rest/onePaper/saveOnePaperObj.do',
			data : $("#ONEPAPER_EDIT_FORM").serialize(),
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
	                    		var prename = "10", name,id="onePagerSearchBt",isQuery=true;
	        					var paperid = $("input[name='paperid']").val();
	        					if($.trim(paperid).length <= 0)
	        						name = "onePagerAdd-1000";
	        					else 
	        						name = "onePagerEdit-1000";
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
			}
		});
	};


	var ChooseCustomers = function() {
		jQuery.ajax({
			type : 'GET',
			url : 'rest/onePaper/chooseCustomers.do',
			success : function(data) {
				bootbox.dialog({
					size : 'large',
					message : data,
					title : 'Customers',
				});
			}
		});
	};
	
	var resetInputVal = function() {
		
	}
	
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
			//回车查询
			GlobalUtil.keydownEvent(function(){
				$("#onePagerSearchBt").click();
			});
		},
		editOnePaperId : function(id) {
			editOnePaperId(id);
		},
		delOnepaperBtId:function(id){
			delOnepaperBtId(id);
		},
		delOnePaperId : function(id) {
			delOnePaperId(id);
		},
		saveOnePaper : function() {
			saveOnePaperDataBefore();
		},
		resetSession : function() {
			resetSession();
		},
		ChooseCustomers : function() {
			ChooseCustomers();
		},
	};
	
	}();
// 执行
OnePaper.init();