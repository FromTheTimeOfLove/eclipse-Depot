var tsSigned = function() {
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
    	$("#tsSignedListTable").empty().attr("class","").attr("data-resizable","true");
    	listTable=$("#tsSignedListTable").bootstrapTable({
    		url:"rest/tsSigned/findTsSignedList.do"
    		,queryParams:function(params){
    			//not limit:pageSize, pageNumber, searchText, sortName, sortOrder
    			//limit: limit, offset, search, sort, order
    			draw++;
    			var formData = $("#tsSignedListForm").serializeJSON(); //查询表单的参数
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
    	        title: i18n.t('GENERAL.COMMON_INDEX'),
    	        formatter:function(value,rData,index){
    	        	return index+1;
    	        },
    	        align:"center"
    	    }, {
    	        field: 'portfolioNameCH',
    	        title: 'Portfolio name (CH)',
    	        //sortable:true
    	        align:"left"
    	    }, {
    	        field: 'portfolioNameEN',
    	        title: 'Portfolio name (EN)',
    	        //sortable:true
    	        align:"left"
    	    }
        	, {
        		field: 'sectorName',
        		title: 'Sector'
        		,align:"center"
        	}
        	, {
        		field: 'stageName',
        		title: 'Stage'
        		,align:"left"
        	}
        	, {
        		field: 'fundName',
        		title: 'Fund'
        		,align:"center"
        	}
        	, {
        		field: 'investmentAmount',
        		title: 'amount'
        		,align:"right"
        	}
        	, {
        		field: 'typeSecurityName',
        		title: 'Type of Security'
        		,align:"left"
        	}
        	, {
        		field: 'signDate',
        		title: 'Date of Sign',
        		width: '12%',
        		align:"center"
        	}
        	, {
        		field: 'common_operation',//操作列,key可随意更换
        		title: i18n.t('GENERAL.COMMON_OPERATION'),
        		width: '12%',
        		formatter:function(value,rData,index){  //value,rData,index
        			var Bt = '';
        			if(rData.tsSignedId==null || rData.tsSignedId==undefined){
        				Bt = "<img title=\""+i18n.t('GENERAL.ADD')+"\" alt=\""+i18n.t('GENERAL.ADD')+"\" src=\"static/common/img/button/btn_add.png\" onclick=\"tsSigned.addTsSigned(\'"+rData.portfolioNameCH+"\',\'"+rData.portfolioNameEN+"\',\'"+rData.paperId+"\')\"/>" +
	        				 " &nbsp;&nbsp;<img title=\""+i18n.t('GENERAL.EDIT')+"\" alt=\""+i18n.t('GENERAL.EDIT')+"\" src=\"static/common/img/button/btn_edit_gray.png\"/>" +
	        				 " &nbsp;&nbsp;<img title=\""+i18n.t('GENERAL.DELETE')+"\" disabled='true' alt=\""+i18n.t('GENERAL.DELETE')+"\" src=\"static/common/img/button/btn_del_gray.png\"/>";
        			}else{
        				Bt = "<img title=\""+i18n.t('GENERAL.ADD')+"\" alt=\""+i18n.t('GENERAL.ADD')+"\" src=\"static/common/img/button/btn_add_gray.png\"/>" + 
        					 " &nbsp;&nbsp;<img title=\""+i18n.t('GENERAL.EDIT')+"\" alt=\""+i18n.t('GENERAL.EDIT')+"\" src=\"static/common/img/button/btn_edit.png\" onclick=\"tsSigned.editTsSignedId(\'" + rData.tsSignedId + "\')\"/>" +
        					 " &nbsp;&nbsp;<img title=\""+i18n.t('GENERAL.DELETE')+"\" alt=\""+i18n.t('GENERAL.DELETE')+"\" src=\"static/common/img/button/btn_del.png\" onclick=\"tsSigned.delTsSignedId(\'" + rData.tsSignedId + "\',\'" +rData.attachmentid + "\')\"/>";
        			}
    	        	return Bt;
    	        }
        	}
    	    ]
    	});
	};
	
	//点击‘+’号时，获得id查询数据并展开tr
	var openTr = function(obj) {
		//获得id
		var dataId = $(obj).attr("data_id");
	};
	
	

	$("#tsSignedSearchBt").click(function() {
		initTable1();
	});
	
	//选择Bridge Loan时，验证是否显示
	$("#bridgeLoanSelect").change(function(event){
	   	if (event.target.value == "0") {
			$(".bridgeLoanHide").show();
		} else {
			$(".bridgeLoanHide").hide();
		}
	});
	
	var bridgeLoanSelect = function() {
		//初始化页面时判断是否是Bridge Loan，是则显示否则隐藏
		var valObj = SelectUtils.getSelectVal($("#bridgeLoanSelect"));
		if (valObj.value == "0") {
			$(".bridgeLoanHide").show();
		} else {
			$(".bridgeLoanHide").hide();
		}
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
	
	/**
	 * open新增
	 */
	var addTsSigned = function(ch, en, id) {
		var o="rest/tsSigned/initAddTsSigned.do?portfolioNameCH="+ch+"&portfolioNameEN="+en+"&paperId="+id,m="tsSignedAdd-1000";l=i18n.t('TSSIGNED.ADD');
        var c=parent.ConTab["c"]; //本页面为iframe嵌入，因此需要调用parent的ConTab对象，才能添加新的Tab
        c(o,m,l);
	};
	
	/**
	 * 跳转编辑页面
	 */
	var editTsSignedId = function(tsSignedId) {
		var o="rest/tsSigned/findTsSignedById.do?tsSignedId="+tsSignedId,m="tsSignedEdit-1000";l=i18n.t('TSSIGNED.EDIT');
        var c=parent.ConTab["c"]; //本页面为iframe嵌入，因此需要调用parent的ConTab对象，才能添加新的Tab
        c(o,m,l);
	};
	
	/**
	 * 保存
	 */
	var saveTsSigned = function() {
		Lobibox.confirm({
		    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
		    callback: function ($this, type, ev) {
		        //Your code goes here
		    	if(type=="yes"){
		    		$('#tsSigned_EDIT_FORM').showLoading();
		    		jQuery.ajax({
		    			type : 'POST',
						url : 'rest/tsSigned/saveTsSigned.do',
						data : $("#tsSigned_EDIT_FORM").serialize(),
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
		    	        					var prename = "20", name,id="tsSignedSearchBt",isQuery=true;
		    	        					var tsSignedId = $("input[name='tsSignedId']").val();
		    	        					if($.trim(tsSignedId).length <= 0)
		    									name = "tsSignedAdd-1000";
		    								else 
		    									name = "tsSignedEdit-1000";
		    	        					GlobalUtil.delTab(prename, name, id, isQuery);//关闭标签代码
		    	                    	}
		    	                    }
		    	                });
		    				} else {
		    					$('#tsSigned_EDIT_FORM').hideLoading();
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
	var delTsSignedId = function(id, docid) {
		if(docid != 'undefined' && docid != '')
		id +=',' + docid;
		
		
		Lobibox.confirm({
	    msg:  i18n.t('GENERAL.CONFIRM.GEN'),
	    callback: function ($this, type, ev) {
	    	if(type=="yes"){
	    		jQuery.ajax({
	    			type : 'POST',
	    			url : 'rest/tsSigned/deleteTsSigned.do',
					data : {
						"tsSignedId" : id
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
				$("#tsSignedSearchBt").click();
			});
		},
		editTsSignedId : function(id) {
			editTsSignedId(id);
		},
		delTsSignedId : function(id, docid) {
			delTsSignedId(id, docid);
		},
		saveTsSigned : function() {
			saveTsSigned();
		},
		resetSession : function() {
			resetSession();
		},
		addTsSigned : function(ch, en,id) {
			addTsSigned(ch, en,id);
		},
		bridgeLoanSelect : function() {
			bridgeLoanSelect();
		},
		openTr : function(obj) {
			openTr(obj);
		}
	};
}();
tsSigned.init();


//radio默认选择
function checkedRradio(key,value){
	if(value!=null && value.length>0){
		$("input[name='"+key+"']").eq(value).attr('checked', 'checked');
	}else{
		$("input[name='"+key+"']").eq(0).attr('checked', 'checked');
	}
}