var BasicExit = function() {
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
    	$("#basicExitListTable").empty().attr("class","").attr("data-resizable","true");
    	listTable=$("#basicExitListTable").bootstrapTable({
    		url:"rest/basicExit/findBasicExitList.do"
    		,queryParams:function(params){
    			//not limit:pageSize, pageNumber, searchText, sortName, sortOrder
    			//limit: limit, offset, search, sort, order
    			draw++;
    			var formData = $("#basicExitListForm").serializeJSON(); //查询表单的参数
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
    	        title: '',
    	        formatter:function(value,rData,index){
    	        	var rHtml;
			    	if (rData.countSize > 1) {
			    		rHtml = "<span class='row-details row-details-close' data_id='"
		    				+ rData.basicExitId + "'></span>&nbsp;&nbsp;" + (index+1);
			    	} else {
			    		rHtml = index+1;
			    	}
    	        	return rHtml;
    	        },
    	        align:"left",
    	        width:"5%"
    	    }, {
    	        field: 'portfolioNameCH',
    	        title: 'Portfolio name(CH)',
    	        //sortable:true,
    	        align:"left"
    	    }, {
    	        field: 'portfolioNameEN',
    	        title: 'Portfolio name(EN)',
    	        //sortable:true,
    	        align:"left"
    	    }
        	, {
        		field: 'sectorName',
        		title: 'Sector',
        		align:"center"
        	}
        	, {
        		field: 'stageName',
        		title: 'Stage',
        		align:"center"
        	}
        	, {
        		field: 'typeName',
        		title: 'Type',
        		align:"center"
        	}
        	, {
        		field: 'proceedsAmount',
        		title: 'Amount of Proceeds',
        		align:"right"
        	}
        	, {
        		field: 'reducedInvestcost',
        		title: 'Reduced investment cost',
        		align:"right"
        	}
        	, {
        		field: 'dateSold',
        		title: 'Date of sold',
        		align:"center"
        	}
        	, {
        		field: 'common_operation',//操作列,key可随意更换
        		title: i18n.t('GENERAL.COMMON_OPERATION'),
        		width: '12%',
    	        formatter:function(value,row,index){  //value,row,index
    	        	var htmlStr = "<img title=\""+i18n.t('GENERAL.ADD')+"\" alt=\""+i18n.t('GENERAL.ADD')+"\" src=\"static/common/img/button/btn_add.png\" " +
    	        			"onclick=\"BasicExit.addBasicExit(\'"+row.paperId+"\')\"/>";
    	        	if(row.countSize == 0){
    	        		htmlStr += " &nbsp;&nbsp;<img title=\""+i18n.t('GENERAL.EDIT')+"\" alt=\""+i18n.t('GENERAL.EDIT')+"\" src=\"static/common/img/button/btn_edit_gray.png\"/>"+
    	        		" &nbsp;&nbsp;<img title=\""+i18n.t('GENERAL.DELETE')+"\" alt=\""+i18n.t('GENERAL.DELETE')+"\" src=\"static/common/img/button/btn_del_gray.png\"/>";
    	        	}else{
    	        		htmlStr += " &nbsp;&nbsp;<img title=\""+i18n.t('GENERAL.EDIT')+"\" alt=\""+i18n.t('GENERAL.EDIT')+"\" src=\"static/common/img/button/btn_edit.png\" " +
    	        		"onclick=\"BasicExit.editBasicExitId(\'" + row.basicExitId + "\')\"/>"+
    	        		" &nbsp;&nbsp;<img title=\""+i18n.t('GENERAL.DELETE')+"\" alt=\""+i18n.t('GENERAL.DELETE')+"\" src=\"static/common/img/button/btn_del.png\" " +
    	        		"onclick=\"BasicExit.delBasicExitId(\'" + row.basicExitId + "\')\"/>";
    	        	}
    	        	return htmlStr;
    	        }
        	}
    	    ]
    	});
	};
	
	/**
	 * 查询按钮绑定事件
	 */
	$("#basicExitSearchBt").click(function() {
		initTable1();
	});

	/**
	 * 跳转新增页面
	 */
	var addBasicExit = function(id) {
		var o="rest/basicExit/initAddBasicExit.do?paperId="+id,m="BasicExitAdd-1000";l=i18n.t('BASICEXIT.ADD');
        var c=parent.ConTab["c"]; //本页面为iframe嵌入，因此需要调用parent的ConTab对象，才能添加新的Tab
        c(o,m,l);
	}
	
	/**
	 * 跳转编辑页面
	 */
	var editBasicExitId = function(id) {
		var o="rest/basicExit/initAddBasicExit.do?basicExitId="+id,m="BasicExitEdit-1000";l=i18n.t('BASICEXIT.EDIT');
        var c=parent.ConTab["c"]; //本页面为iframe嵌入，因此需要调用parent的ConTab对象，才能添加新的Tab
        c(o,m,l);
	};
	
	/**
	 * 保存
	 */
	var saveBasicExit = function() {
		Lobibox.confirm({
		    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
		    callback: function ($this, type, ev) {
		        //Your code goes here
		    	if(type=="yes"){
		    		jQuery.ajax({
		    			type : 'POST',
		    			url : 'rest/basicExit/saveBasicExit.do',
						data : $("#basicExitform").serialize(),
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
				                    		/**
											 * prename 父级
											 * name 排序碼
											 * id 查詢按鈕
											 * isQuery 是否查詢
											 */
											var prename="301", name,id="basicExitSearchBt",isQuery=true;
											var basicExitId = $("input[name='basicExitId'").val();
											if($.trim(basicExitId).length <= 0)
												name = "BasicExitAdd-1000";
											else 
												name = "BasicExitEdit-1000";
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
		    	}
		    }
		});
	};
	
	/**
	 * 删除
	 */
	var delBasicExitId = function(id) {
		
		Lobibox.confirm({
		    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
		    callback: function ($this, type, ev) {
		    	if(type=="yes"){
		    		jQuery.ajax({
		    			type : 'POST',
		    			url : 'rest/basicExit/delBasicExit.do',
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
	 * 移除session
	 */
	var resetSession = function() {
		jQuery.ajax({
			type : 'GET',
			url : 'rest/basicExit/resetSession.do',
			success : function(data) {
				$("input[type='text']").val('');
			}
		});
	};
	
	/**
	 * 点击+号调出的数据
	 */
	var addDataMethod = function(obj) {
		var id = $(obj).attr("data_id");
		var $dom = $(obj).closest("tr"); 
		jQuery.ajax({
			type : 'POST',
			url : 'rest/basicExit/findRowDetails.do',
			data : {
				"id" : id
			},
			success : function(data) {
				var objs = data.objectInfo;
				var innerHtml = "";
				for (var i = 0; i < objs.length; i++) {
					var obj = objs[i];
					innerHtml += "<tr class=\"openDetail"+id+"\"><td></td><td></td><td></td>";
					innerHtml += "<td style='text-align: center;'>"+dataNullDeal(obj.sectorName)+"</td>";
					innerHtml += "<td style='text-align: center;'>"+dataNullDeal(obj.stageName)+"</td>";
					innerHtml += "<td style='text-align: center;'>"+dataNullDeal(obj.typeName)+"</td>";
					innerHtml += "<td style='text-align: right;'>"+dataNullDeal(obj.proceedsAmount)+"</td>";
					innerHtml += "<td style='text-align: right;'>"+dataNullDeal(obj.reducedInvestcost)+"</td>";
					innerHtml += "<td style='text-align: center;'>"+dataNullDeal(obj.dateSold)+"</td>";
					innerHtml += "<td style=\"width:12%;\">";
					innerHtml += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img title=\""+i18n.t('GENERAL.EDIT')+"\" alt=\""+i18n.t('GENERAL.EDIT')+"\" src=\"static/common/img/button/btn_edit.png\" " +
	        					 "onclick=\"BasicExit.editBasicExitId(\'" + obj.basicExitId + "\')\"/>";
					innerHtml += " <img title=\""+i18n.t('GENERAL.DELETE')+"\" alt=\""+i18n.t('GENERAL.DELETE')+"\" src=\"static/common/img/button/btn_del.png\" " +
        						 "onclick=\"BasicExit.delBasicExitId(\'" + obj.basicExitId + "\')\"/>";
					innerHtml += "</td>";
					innerHtml += "</tr>";
				}
				$dom.after(innerHtml);
			}
		})
	};
	
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
			$('#dataTimeTest').datetimepicker({
				format : 'yyyy-mm-dd'
			});
			//绑定+- click事件
			GlobalUtil.bindClickOpenOrCloseTr($("#basicExitListTable"), addDataMethod);
			//回车查询
			GlobalUtil.keydownEvent(function(){
				$("#basicExitSearchBt").click();
			});
		},
		addBasicExit : function(id) {
			addBasicExit(id);
		},
		editBasicExitId : function(id) {
			editBasicExitId(id);
		},
		saveBasicExit : function() {
			saveBasicExit();
		},
		delBasicExitId : function(id) {
			delBasicExitId(id);
		},
		resetSession : function() {
			resetSession();
		},
		addDataMethod : function(obj){
			addDataMethod(obj);
		}
	};

}();
