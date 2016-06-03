var Fund = function() {
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
    	$("#fundMgmtListTable").empty().attr("class","").attr("data-resizable","true");
    	listTable=$("#fundMgmtListTable").bootstrapTable({
    		url:"rest/fundMgmt/findFundList.do"
    		,queryParams:function(params){
    			//not limit:pageSize, pageNumber, searchText, sortName, sortOrder
    			//limit: limit, offset, search, sort, order
    			draw++;
    			var formData = $("#fundMgmtListForm").serializeJSON(); //查询表单的参数
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
    	        field: 'fundName',
    	        title: '出资主体名称',
    	        //sortable:true
    	        align:"center"
    	    }, {
    	        field: 'fundCurrency',
    	        title: '币种',
    	        //sortable:true
    	        align:"center"
    	    }
        	, {
        		field: 'fundDesc',
        		title: '说明'
        		,align:"center"
        	}
        	, {
        		field: 'common_operation',//操作列,key可随意更换
        		title: i18n.t('GENERAL.COMMON_OPERATION'),
    	        formatter:function(value,c,index){  //value,row,index
					return "<img title=\""+i18n.t('GENERAL.EDIT')+"\" alt=\""+i18n.t('GENERAL.EDIT')+"\" " +
					"src=\"static/common/img/button/btn_edit.png\" onclick=\"Fund.editFundBtId(\'" + c.fundId + "\')\">"+
    	        	" <img title=\""+i18n.t('GENERAL.DELETE')+"\" alt=\""+i18n.t('GENERAL.DELETE')+"\" " +
    	        	"src=\"static/common/img/button/btn_del.png\" onclick=\"Fund.delFundBtId(\'" + c.fundId + "\')\">";
    	        }
        	}
    	    ]
    	});
	};
	
	/**
	 * 修改出资主体
	 */
	var editFundBtId = function(id){
		var o="rest/fundMgmt/initAddFund.do?id=" + id,m="fundEdit-1000";l='Edit Fund';
        var c=parent.ConTab["c"]; //本页面为iframe嵌入，因此需要调用parent的ConTab对象，才能添加新的Tab
        c(o,m,l);
	}
	
	/**
	 * 删除出资主体
	 */
	var delFundBtId = function(id){
		bootbox.confirm({
			size : 'small',
			message : i18n.t('GENERAL.CONFIRM.DELETE'),
			buttons : {
				confirm : {
					label : i18n.t('GENERAL.OK')
				},
				cancel : {
					label : i18n.t('GENERAL.CANCEL')
				}
			},
			callback : function(v) {
				if (v) {
					jQuery.ajax({
						type : 'POST',
						url : 'rest/fundMgmt/delFund.do',
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
					})
				}
			}
		})
	}
	
	var saveFund = function (){
		jQuery.ajax({
			type : 'POST',
			url : 'rest/fundMgmt/saveFund.do',
			data : $("#fundForm").serialize(),
			success : function(data) {
				var result = data;
				var dataHtml = "";
				var type="success";
				if (result.resultCode == 1) {
					type="success";
					dataHtml = i18n.t('GENERAL.SUCCESS');
				} else {
					type="warning";
					dataHtml = result.message;
				}
				Lobibox.alert(type, {
					title: "提示",
                    msg: result.message,
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
                    		var prename = "40", name,id="fundSearchBt",isQuery=true;
        					var fundId = $("input[name='fundId']").val();
        					if($.trim(fundId).length <= 0)
								name = "fundAdd-1000";
							else 
								name = "fundEdit-1000";
        					GlobalUtil.delTab(prename, name, id, isQuery);//关闭标签代码
                    	}
                    }
                });
			}
		});
	}
	
	/**
	 * 出资主体查询
	 */
	$("#fundSearchBt").click(function(){
		initTable1();
	})
	
	/**
	 * 新增出资主体
	 */
	$("#fundAddBt").click(function() {
	    var o="rest/fundMgmt/initAddFund.do",m="fundAdd-1000";l='Add Fund';
        var c=parent.ConTab["c"]; //本页面为iframe嵌入，因此需要调用parent的ConTab对象，才能添加新的Tab
        c(o,m,l);
	});

	return {
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
				$("#fundSearchBt").click();
			});
			$("#fundResetBt").click(function(){
				$("input").val("");
			})
		},
		delFundBtId : function(id) {
			delFundBtId(id);
		},
		editFundBtId : function(id) {
			editFundBtId(id);
		}, 
		saveFund : function() {
			saveFund();
		}
	};

}();
