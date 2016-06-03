var EquityInvestment = function() {
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
    	$("#equityInvestmentListTable").empty().attr("class","").attr("data-resizable","true");
    	listTable=$("#equityInvestmentListTable").bootstrapTable({
    		url:"rest/equityInvestment/findListEquityInvestment.do",
    		queryParams:function(params){
    			draw++;
    			var formData = $("#EquityInvestmentListForm").serializeJSON(); //查询表单的参数
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
		    				+ row.equityInvestmentId + "'></span>&nbsp;&nbsp;" + (index+1);
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
    	       // sortable:true,
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
        	}, {
        		field: 'signDate',
        		title: i18n.t('Date of Sign'),
        		align:"center",
        	},  {
        		field: 'common_operation',//操作列,key可随意更换
        		title: i18n.t('Operation'),
        		width: '12%',
    	        formatter:function(value,c,index){  //value,row,index
    	        	var editClick,delClick,imgColor="_gray";
    	        	if(c.equityInvestmentId != undefined) {
    	        		editClick ="onclick=\"EquityInvestment.editEquityInvestmentBtId(\'" + c.equityInvestmentId + "," + c.paperId + "\')\"";
    	        		delClick = "onclick=\"EquityInvestment.delEquityInvestmentBtId(\'" + c.equityInvestmentId + "\')\"";
    	        		imgColor = "";
    	        	}
    	        	return "<img title=\""+i18n.t('GENERAL.ADD')+"\" alt=\""+i18n.t('GENERAL.ADD')+"\" src=\"static/common/img/button/btn_add.png\" onclick=\"EquityInvestment.addEquityInvestmentBtId(\'" + c.paperId + "\')\"/>"+
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
	
	$("#equityInvestmentSearchBt").click(function() {
		initTable1();
	});
	
	/**
	 * 验证
	 */
	var initValidate = function() {
		$("#equityInvestmentSaveForm").validate({
			focusInvalid : false,
			errorClass : 'dd-validate-error', // 使用自定义样式
			validClass : 'dd-validate-valid',// 使用自定义样式
			errorElement : "span",
			rules : {
                contactEmail : {
					email: true
				},
				contactPhone : {
					number : true,
					minlength : 11,
					maxlength : 11,
				},
				portfolionameCH : {
					required : true
				},
				portfolionameEN : {
					required : true
				},
				vemailAddress : {
					email: true
				},
				vphone : {
					//required : true,
					number : true,
					minlength : 11,
					maxlength : 11,
				},
				namountFund : {
					number : true
				},
				costPerShare : {
					number : true
				},
				holdingShares : {
					digits : true
				},
				npreMoney : {
					number: true
				},
				npostMoney : {
					number: true
				},
				prefMoney : {
					number: true
				},
				postfMoney : {
					number: true
				},
				ipoPrice : {
					number: true
				},
				closingIPOPrice : {
					number: true
				}
			
			},
			onkeyup : false,
            messages: { //提示
				contactEmail : {
					email: "Please enter the valid email.",
				},
				contactPhone: {
                    //required: "Please enter your number",
                    number : "Please enter the valid number.",
                    maxlength : "Please enter is less 11.",
                    maxlength : "Please enter is more 11."
                },
            	portfolionameCH : {
					required : "Portfolio name (CH) not null."
				},
				portfolionameEN : {
					required : "Portfolio name (EN) not null."
				},vemailAddress : {
					email: "Please enter the valid email.",
				},
                vphone: {
                    //required: "Please enter your number",
                    number : "Please enter the valid number.",
                    maxlength : "Please enter is less 11.",
                    maxlength : "Please enter is more 11."
                },
				namountFund : {
					number: "Please enter the valid number."
				},
				costPerShare : {
					number: "Please enter the valid number."
				},
				holdingShares : {
					digits: "Please enter the valid digits."
				},
				npreMoney : {
					number: "Please enter the valid number."
				},
				npostMoney : {
					number: "Please enter the valid number."
				},
				prefMoney : {
					number: "Please enter the valid number."
				},
				postfMoney : {
					number: "Please enter the valid number."
				},
				ipoPrice : {
					number: "Please enter the valid number."
				},
				closingIPOPrice : {
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
	var saveEquityInvestmentDataBefore = function() {
		//验证
		if (!$("#equityInvestmentSaveForm").valid()) {
			Lobibox.notify('warning', {
                msg: '请检查数据是否填写正确',
                delay: 2000,
                soundPath: IMG_PREFIX
            });
			return false;	
		} else {
			saveEquityInvestmentData();
		}
	};

	/**
	 * 保存
	 */
	var saveEquityInvestmentData = function() {
		var formValue = $("#equityInvestmentSaveForm").serialize();
		var complianceDeal = $("#complianceDeal").val();
		var complianceLegal = $("#complianceLegal").val();
		var data = formValue;
		if(complianceDeal.length > 0) {
			if(data.length > 0) {
				data += "&"+complianceDeal;
			}
		}else{
			data += "&isNullDeal=1";
		}
		
		if(complianceLegal.length > 0) {
			if(data.length > 0) {
				data += "&"+complianceLegal;
			}
		}else{
			data += "&isNullLegal=1";
		}
		jQuery.ajax({
			type : 'POST',
			url : 'rest/equityInvestment/saveEquityInvestment.do',
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
	                    		var prename = "300", name,id="equityInvestmentSearchBt",isQuery=true;
	                    		var equityInvestmentId = $("input[name='equityInvestmentId']").val();
	        					if($.trim(equityInvestmentId).length <= 0)
									name = "AddOneEquityInvestment-1000";
								else 
									name = "EditOneEquityInvestment-1000";
	        					GlobalUtil.delTab(prename, name, id, isQuery);//关闭标签代码
	                    	}
	                    }
	                });
					
				} else {
					Lobibox.notify('error', {
	                    msg: result.message,
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
	var addEquityInvestmentBtId = function(paperid){
	    var url = "rest/equityInvestment/initAddEquityInvestment.do?universalStr=false&universalId="+paperid;
	    var name = "AddOneEquityInvestment-1000";
	    var title = "Add Equity Investment";
	    var c = parent.ConTab["c"];
	    c(url, name, title);
	};
	
	/**
	 * 编辑页面跳转
	 */
	var editEquityInvestmentBtId = function(id) {
		//url
		var url = "rest/equityInvestment/initAddEquityInvestment.do?universalStr=true&universalId="+id;
		//iframe的name，生成iframe时它的name前面会追加iframe前缀
		var name = "EditOneEquityInvestment-1000";
		//tab标签页的title
		var title = "Edit Equity Investment";
		var c = parent.ConTab["c"];
	    c(url, name, title);
	};
	
	/**
	 * 删除
	 */
	var delEquityInvestmentBtId = function(id) {
		Lobibox.confirm({
            msg: i18n.t('GENERAL.CONFIRM.DELETE'),
            callback: function ($this, type, ev) {
                if (type === 'yes') {
                	jQuery.ajax({
						type : 'POST',
						url : 'rest/equityInvestment/deleteByPrimaryKeyAll.do',
						data : {
							"equityInvestmentId" : id
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
		
		var objt=null;
		//获得paperid
		var equityInvestmentId = $(obj).attr("data_id");
		var $dom = $(obj).closest("tr"); 
		$.ajax({
			url : 'rest/equityInvestment/findEquityInvestmentByPaper.do',
			data : {
				"equityInvestmentId" : equityInvestmentId
			},
			cache : false,
			async : false,
			type : "POST",
			success : function(data) {
				var objs = data.objectInfo;
				var innerHtml = "";
				for (var i = 0; i < objs.length; i++) {
					var obj = objs[i];
					innerHtml += "<tr class=\"openDetail"+equityInvestmentId+"\"><td></td><td></td><td></td>";
					innerHtml += "<td style='text-align: center;'>"+dataNullDeal(obj.sectorName)+"</td>";
					innerHtml += "<td style='text-align: center;'>"+dataNullDeal(obj.stageName)+"</td>";
					innerHtml += "<td style='text-align: center;'>"+dataNullDeal(obj.fundName)+"</td>";
					innerHtml += "<td style='text-align: center;'>"+dataNullDeal(obj.signDate)+"</td>";
					innerHtml += "<td style=\"width:12%;\">";
					innerHtml += "<img src=\"static/common/img/button/btn_add.png\" style=\"visibility:hidden;\"/>";
					innerHtml += " &nbsp;&nbsp;<img title=\""+i18n.t('GENERAL.EDIT')+"\" alt=\""+i18n.t('GENERAL.EDIT')+"\" src=\"static/common/img/button/btn_edit.png\" " +
								 "onclick=\"EquityInvestment.editEquityInvestmentBtId(\'" + obj.equityInvestmentId + "," + obj.paperId + "\')\">";
					innerHtml += " &nbsp;&nbsp;<img title=\""+i18n.t('GENERAL.DELETE')+"\" alt=\""+i18n.t('GENERAL.DELETE')+"\" src=\"static/common/img/button/btn_del.png\" " +
								 "onclick=\"EquityInvestment.delEquityInvestmentBtId(\'" + obj.equityInvestmentId + "\')\">";
					innerHtml += "</td>";
					innerHtml += "</tr>";
				}
				$dom.after(innerHtml);
			}
		});
	};
	
	
	/**
	 * Legal Team
	 */
	var legalTeamWindow = function(obj) {
		var url = "rest/equityInvestment/initLegalTeamPage.do",data="";
		var $inputDom = $(obj).next("input");
		var inputVal = $inputDom.val();
		var objs = {
				title : 'Equity- Legal team',
				url : url,
				width : '800',
				height : '500',
				data : inputVal
		}
		GlobalUtil.showTeamWindow(obj, objs, ToLegalExcel);
	};
	
	var ToLegalExcel = function(datas){
		if (datas == undefined || datas == null || datas == '') {
			window.open('rest/equityInvestment/toLegalExcel.do', 'newwindow');
		}else{
			window.open('rest/equityInvestment/toLegalExcel.do?'+datas, 'newwindow');
		}
	}
	/**
	 * Deal Team
	 */
	var dealTeamWindow = function(obj) {
		var url = "rest/equityInvestment/initDealTeamPage.do",data="";
		var $inputDom = $(obj).next("input");
		var inputVal = $inputDom.val();
		var objs = {
				title : 'Equity- Deal team',
				url : url,
				width : '800',
				height : '500',
				data : inputVal
		}
		GlobalUtil.showTeamWindow(obj, objs, ToDealExcel);
	};
	
	var ToDealExcel = function(datas){
		if (datas == undefined || datas == null || datas == '') {
			window.open('rest/equityInvestment/toDealExcel.do', 'newwindow');
			//href，IE浏览器地址会被影响，只能用window.open()
//			window.location.href = "rest/equityInvestment/toDealExcel.do";
		}else{
			window.open('rest/equityInvestment/toDealExcel.do?'+datas, 'newwindow');
//			window.location.href = "rest/equityInvestment/toDealExcel.do?"+datas;
		}
		return false;
	}
	
	/**
	 * +引出的数据取空值处理
	 */
	var dataNullDeal = function(v) {
		if (v == undefined || v == null || v == '') {
			return v = '-';
		} else {
			return v;
		}
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
			GlobalUtil.bindClickOpenOrCloseTr($("#equityInvestmentListTable"),addDataMethod);
			//回车查询
			GlobalUtil.keydownEvent(function(){
				$("#equityInvestmentSearchBt").click();
			});
			var universalStr = $("#universalStr").val();
			if(universalStr) {//为true时查询轮次信息
				
			}
			$("#file").click(function(){
				var url = "rest/EquityInvestment/ininFile.do";
			    var name = "file-1000";
			    var title = "FILE";
			    var c = parent.ConTab["c"];
			    c(url, name, title);
			});
		},
		delEquityInvestmentBtId : function(id) {
			delEquityInvestmentBtId(id);
		},
		saveEquityInvestmentDataBefore : function() {
			return saveEquityInvestmentDataBefore();
		},
		editEquityInvestmentBtId : function(id) {
			editEquityInvestmentBtId(id);
		},
		saveEquityInvestmentData : function() {
			saveEquityInvestmentData();
		},
		addEquityInvestmentBtId:function(paperid){
			addEquityInvestmentBtId(paperid);
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
		}
	};

}();
// 执行
EquityInvestment.init();