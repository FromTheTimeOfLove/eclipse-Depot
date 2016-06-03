var BasicInfo = function() {
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
    	$("#basicInfoListTable").empty().attr("class","").attr("data-resizable","true");
    	listTable=$("#basicInfoListTable").bootstrapTable({
    		url:"rest/basicInfo/findListBasicInfo.do",
    		queryParams:function(params){
    			draw++;
    			var formData = $("#BasicInfoListForm").serializeJSON(); //查询表单的参数
    			var json={
        				"draw" : draw,
        				"start" : params.offset,
        				"length" : params.limit
        				
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
    	        title: '',
    	        formatter:function(value,row,index){
    	        	var rHtml;
			    	if (row.countsize > 1) {
						rHtml = "<span class='row-details row-details-close' data_id='"
		    				+ row.paperId + "'></span>&nbsp;&nbsp;" + (index+1);
			    	} else {
			    		rHtml = index+1;
			    	}
    	        	return rHtml;
    	        },
    	        align:"left",
    	        width:"5%"
    	    }, {
    	        field: 'portfolioNameCH',
    	        title: i18n.t('Portfolio name(CH)'),
    	        //sortable:true,
    	        align:"center",
    	    }, {
    	        field: 'portfolioNameEN',
    	        title: i18n.t('Portfolio name(EN)'),
    	        //sortable:true,
    	        align:"center",
    	    }, {
        		field: 'sectorName',
        		title: i18n.t('Sector'),
        		align:"center",
        	}, {
        		field: 'stageName',
        		title: i18n.t('Stage'),
        		align:"center",
        	}, {
        		field: 'fundName',
        		title: i18n.t('Fund'),
        		align:"center",
        	},  {
        		field: 'signDate',
        		title: i18n.t('Date of Sign'),
        		align:"center",
        	},  {
        		field: 'common_operation',//操作列,key可随意更换
        		title: i18n.t('Operation'),
        		width: '8%',
    	        formatter:function(value,c,index){  //value,row,index
    	        	var editClick,delClick,imgColor="_gray";
    	        	if(c.basicInfoId != undefined) {
    	        		editClick ="onclick=\"BasicInfo.editBasicInfoBtId(\'" + c.basicInfoId + "," + c.paperId + "\')\"";
    	        		delClick = "onclick=\"BasicInfo.delBasicInfoBtId(\'" + c.basicInfoId + "\')\"";
    	        		imgColor = "";
    	        	}
    	        	return "<img title=\""+i18n.t('GENERAL.ADD')+"\" alt=\""+i18n.t('GENERAL.ADD')+"\" src=\"static/common/img/button/btn_add.png\" onclick=\"BasicInfo.addBasicInfoBtId(\'" + c.paperId + "\')\"/>"+
    	        	" &nbsp;&nbsp;<img title=\""+i18n.t('GENERAL.EDIT')+"\" alt=\""+i18n.t('GENERAL.EDIT')+"\" src=\"static/common/img/button/btn_edit"+imgColor+".png\" "+editClick+"/>"+
    	        	" &nbsp;&nbsp;<img title=\""+i18n.t('GENERAL.DELETE')+"\" alt=\""+i18n.t('GENERAL.DELETE')+"\" src=\"static/common/img/button/btn_del"+imgColor+".png\" "+delClick+" />";
    	        }
        	}
    	    ]
    	});
	};
	
	/**
	 * 移除session
	 */
	var resetSession = function() {
		jQuery.ajax({
			type : 'GET',
			url : 'rest/onePaper/resetSession.do',
			success : function(data) {
				$("input[type='text").val("");
			}
		});
	};
	
	$("#basicInfoSearchBt").click(function() {
		initTable1();
	});
	
	/**
	 * 验证
	 */
	var initValidate = function() {
		$("#basicInfoSaveForm").validate({
			focusInvalid : false,
			errorClass : 'dd-validate-error', // 使用自定义样式
			validClass : 'dd-validate-valid',// 使用自定义样式
			errorElement : "span",
			rules : {
				contactsEmail : {
					email: true
				},
				contactsPhone : {
					//required : true,
					number : true,
					minlength : 11,
					maxlength : 11,
				},
				preMoney : {
					number: true
				},
				postMoney : {
					number: true
				},
				expectedReturn : {
					number: true
				}
			},
			onkeyup : false,
            messages: { //提示
            	contactsEmail : {
					email: "Please enter the valid email.",
				},
				contactsPhone: {
                    //required: "Please enter your number",
                    number : "Please enter the valid number.",
                    maxlength : "Please enter is less 11.",
                    maxlength : "Please enter is more 11."
                },
				prefMoney : {
					number: "Please enter the valid number."
				},
				postfMoney : {
					number: "Please enter the valid number."
				},
				expectedReturn : {
					number: "Please enter the valid number."
				}
            },
            highlight : function(element) {  
                $(element).closest('div').addClass('has-error');  
                $(element).closest('div').prev().css("color","#d9534f");
            }, 
            errorPlacement : function(error, element) {  
                element.parent('div').append(error);
            },
            success: function (label) {
                label.closest('div').removeClass('has-error'); // set success class to the control group
                label.closest('div').prev().css("color","#34495e");
            }
        });
	};

	/**
	 * 保存前验证
	 */
	var saveBasicInfoDataBefore = function() {
		//验证
		if (!$("#basicInfoSaveForm").valid()) {
			Lobibox.notify('warning', {
                msg: '请检查数据是否填写正确',
                delay: 2000,
                soundPath: IMG_PREFIX
            });
			return false;	
		} else {
			saveBasicInfoData();
		}
	};

	/**
	 * 保存
	 */
	var saveBasicInfoData = function() {
		var basicinfo = $("#basicInfoSaveForm").serialize();
		var complianceDeal = $("#complianceDeal").val();
		var confirmationDeal = $("#confirmationDeal").val();
		var complianceLegal = $("#complianceLegal").val();
		var confirmationLegal = $("#confirmationLegal").val();
		var data = basicinfo;
		if(complianceDeal.length > 0) {
			if(data.length > 0) {
				data += "&"+complianceDeal;
			}
		}
		
		if(confirmationDeal.length > 0) {
			if(data.length > 0) {
				data += "&"+confirmationDeal;
			}
		}
		if(complianceLegal.length > 0) {
			if(data.length > 0) {
				data += "&"+complianceLegal;
			}
		}
		if(confirmationLegal.length > 0) {
			if(data.length > 0) {
				data += "&"+confirmationLegal;
			}
		}
		jQuery.ajax({
			type : 'POST',
			url : 'rest/basicInfo/saveBasicInfo.do',
			data : data,
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
	        					var prename = "30", name,id="basicInfoSearchBt",isQuery=true;
	        					var basicInfoId = $("input[name='basicInfoId']").val();
	        					if($.trim(basicInfoId).length <= 0)
									name = "AddOneBasicInfo-1000";
								else 
									name = "EditOneBasicInfo-1000";
	        					GlobalUtil.delTab(prename, name, id, isQuery);//关闭标签代码
	                    	}
	                    }
	                });
				} else {
					Lobibox.notify('error', {
	                    msg: result.message == "" ? "未知错误":result.message,
	                    delay: 2000,
	                    soundPath: IMG_PREFIX
	                });
				}
				
			}
		});
	};
	
	/**
	 * 新增页面跳转
	 */
	var addBasicInfoBtId = function(paperid){
	    var url = "rest/basicInfo/initAddBasicInfo.do?universalStr=false&universalId="+paperid;
	    var name = "AddOneBasicInfo-1000";
	    var title = "Add Basic Info";
	    var c = parent.ConTab["c"];
	    c(url, name, title);
	};
	
	/**
	 * 编辑页面跳转
	 */
	var editBasicInfoBtId = function(id) {
		//url
		var url = "rest/basicInfo/initAddBasicInfo.do?universalStr=true&universalId="+id;
		//iframe的name，生成iframe时它的name前面会追加iframe前缀
		var name = "EditOneBasicInfo-1000";
		//tab标签页的title
		var title = "Edit Basic Info";
		var c = parent.ConTab["c"];
	    c(url, name, title);
	};
	
	/**
	 * 删除
	 */
	var delBasicInfoBtId = function(id) {
		Lobibox.confirm({
            msg: i18n.t('GENERAL.CONFIRM.DELETE'),
            callback: function ($this, type, ev) {
                if (type === 'yes') {
                	jQuery.ajax({
						type : 'POST',
						url : 'rest/basicInfo/deleteByPrimaryKeyAll.do',
						data : {
							"basicInfoId" : id
						},
						success : function(data) {
							var result = data;
							var dataHtml = "";
							if (result.resultCode == 1) {
								dataHtml = i18n.t('GENERAL.SUCCESS');
								initTable1();
								Lobibox.notify('success', {
	                                msg: dataHtml,
	                                delay: 2000,
	                                soundPath: IMG_PREFIX
	                            });
							} else {
								var message = result.message;
								dataHtml = message;
								Lobibox.notify('error', {
	                                msg: dataHtml,
	                                delay: 2000,
	                                soundPath: IMG_PREFIX
	                            });
							}
						}
					});
                }
            }
        });
	};

	var addDataMethod = function(obj, openOrClose) {
		var objs = "";
		var paperid = $(obj).attr("data_id");
		$.ajax({
			url : 'rest/basicInfo/findBasicInfoByPaper.do',
			data : {
				"paperid" : paperid
			},
			cache : false,
			async : false,
			type : "POST",
			success : function(data) {
				//获得
				objs = data;
			}
		});
		var innerHtml = "";
		var $dom = $(obj).closest("tr"); 
		for (var i = 0; i < objs.length; i++) {
			var obj = objs[i];
			innerHtml += "<tr class=\"openDetail"+paperid+"\"><td></td><td></td><td></td>";
			innerHtml += "<td style='text-align: center;'>"+GlobalUtil.dataNullDeal(obj.sectorName)+"</td>";
			innerHtml += "<td style='text-align: center;'>"+GlobalUtil.dataNullDeal(obj.stageName)+"</td>";
			innerHtml += "<td style='text-align: center;'>"+GlobalUtil.dataNullDeal(obj.fundName)+"</td>";
			innerHtml += "<td style='text-align: center;'>"+GlobalUtil.dataNullDeal(obj.signDate)+"</td>";
			innerHtml += "<td style=\"width:12%;\">";
			innerHtml += " <img title=\""+i18n.t('GENERAL.EDIT')+"\" alt=\""+i18n.t('GENERAL.EDIT')+"\" src=\"static/common/img/button/btn_edit.png\" onclick=\"BasicInfo.editBasicInfoBtId(\'" + obj.basicInfoId+","+obj.paperId+ "\')\"/>";
			innerHtml += " <img title=\""+i18n.t('GENERAL.DELETE')+"\" alt=\""+i18n.t('GENERAL.DELETE')+"\" src=\"static/common/img/button/btn_del.png\" onclick=\"BasicInfo.delBasicInfoBtId(\'" + obj.basicInfoId + "\')\"/>";
			innerHtml += "</td></tr>";
			//大于10的时候，添加更多，并停止循环
			if(i > 8) {
				innerHtml += "<tr class='openDetail"+paperid+"'><td colspan='8' align='cendter'>";
				innerHtml += "<img title=\""+i18n.t('GENERAL.ADD')+"\" alt=\""+i18n.t('GENERAL.ADD')+"\" src=\"static/common/img/button/btn_more.png\" onclick=\"BasicInfo.addBasicInfoBtId(\'" + obj.paperId + "\')\"/>";
				innerHtml += "</tr>";
				$dom.after(innerHtml);
				return false;
			}
		}
		$dom.after(innerHtml);
	};
	
	/**
	 * toComplianceDealTeamExcel
	 * 
	 */
	var toComplianceDealTeamExcel = function(datas) {
		window.open('rest/basicInfo/reportExcelComplianceDeal.do?'+datas, 'newwindow');
	};
	/**
	 * toConfirmationDealTeamExcel
	 * 
	 */
	var toConfirmationDealTeamExcel = function(datas) {
		window.open('rest/basicInfo/reportExcelConfirmationDeal.do?'+datas, 'newwindow');
	};
	/**
	 * toComplianceLegalTeamExcel
	 * 
	 */
	var toComplianceLegalTeamExcel = function(datas) {
		window.open('rest/basicInfo/reportExcelComplianceLegal.do?'+datas, 'newwindow');
	};
	/**
	 * toConfirmationLegalTeamExcel
	 * 
	 */
	var toConfirmationLegalTeamExcel = function(datas) {
		window.open('rest/basicInfo/reportExcelConfirmationLegal.do?'+datas, 'newwindow');
	};
	
	/**
	 * Legal Team - compliance
	 */
	var legalTeamWindow = function(obj) {
		var url = "rest/basicInfo/initLagalTeam.do",data="";
		var $inputDom = $(obj).next("input");
		var inputVal = $inputDom.val();
		var objs = {
				title : 'P-note confirmation',
				url : url,
				width : '800',
				height : '500',
				data : inputVal
		}
		GlobalUtil.showTeamWindow(obj, objs, toConfirmationLegalTeamExcel);
	};
	
	
	/**
	 * Legal Team - compliance
	 */
	var legalTeamWindow_com = function(obj) {
		var url = "rest/basicInfo/initLagalTeam_compliance.do",data="";
		var $inputDom = $(obj).next("input");
		var inputVal = $inputDom.val();
		var objs = {
				title : 'Compliance Checklist',
				url : url,
				width : '800',
				height : '500',
				data : inputVal
		}
		GlobalUtil.showTeamWindow(obj, objs, toComplianceLegalTeamExcel);
	};
	
	/**
	 * Deal Team - confirmation
	 */
	var dealTeamWindow = function(obj) {
		var url = "rest/basicInfo/initDealTeam.do",data="";
		var $inputDom = $(obj).next("input");
		var inputVal = $inputDom.val();
		var objs = {
				title : 'P-note Confirmation',
				url : url,
				width : '800',
				height : '500',
				data : inputVal
		}
		GlobalUtil.showTeamWindow(obj, objs, toConfirmationDealTeamExcel);
	};
	
	/**
	 * Deal Team - compliance
	 */
	var dealTeamWindow_com = function(obj) {
		var url = "rest/basicInfo/initDealTeam_compliance.do",data="";
		var $inputDom = $(obj).next("input");
		var inputVal = $inputDom.val();
		var objs = {
				title : 'P-note Confirmation',
				url : url,
				width : '800',
				height : '500',
				data : inputVal
		}
		GlobalUtil.showTeamWindow(obj, objs, toComplianceDealTeamExcel);
	};
	
	return {
		// main function to initiate the module
		init : function() {
			if (!jQuery().dataTable) {
				return;
			}
			initTable1();
			initValidate();
			$('#dataTimeTest').datetimepicker({
				format : 'yyyy-mm-dd'
			});
			GlobalUtil.bindClickOpenOrCloseTr($("#basicInfoListTable"),addDataMethod);
			//回车查询
			GlobalUtil.keydownEvent(function(){
				$("#basicInfoSearchBt").click();
			});
			var universalStr = $("#universalStr").val();
			if(universalStr) {//为true时查询轮次信息
				
			}
			$("#file").click(function(){
				var url = "rest/basicInfo/ininFile.do";
			    var name = "file-1000";
			    var title = "FILE";
			    var c = parent.ConTab["c"];
			    c(url, name, title);
			});
		},
		delBasicInfoBtId : function(id) {
			delBasicInfoBtId(id);
		},
		saveBasicInfoDataBefore : function() {
			return saveBasicInfoDataBefore();
		},
		editBasicInfoBtId : function(id) {
			editBasicInfoBtId(id);
		},
		saveBasicInfoData : function() {
			saveBasicInfoData();
		},
		addBasicInfoBtId:function(paperid){
			addBasicInfoBtId(paperid);
		},
		addDataMethod : function(obj, openOrClose){
			addDataMethod(obj, openOrClose);
		},
		resetSession : function () {
			resetSession();
		},
		legalTeamWindow : function(obj) {
			legalTeamWindow(obj);
		},
		dealTeamWindow : function(obj) {
			dealTeamWindow(obj);
		},
		legalTeamWindow_com : function(obj) {
			legalTeamWindow_com(obj);
		},
		dealTeamWindow_com : function(obj) {
			dealTeamWindow_com(obj);
		}, 
		toExcel : function(module) {
			toExcel(module);
		}
		
	};

}();
// 执行
BasicInfo.init();