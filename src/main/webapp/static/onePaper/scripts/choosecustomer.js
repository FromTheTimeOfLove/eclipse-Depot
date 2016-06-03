var ChooseCustomers = function() {

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
    	$("#choosecustomer").empty().attr("class","").attr("data-resizable","true");
    	listTable=$("#choosecustomer").bootstrapTable({
    		url:"rest/onePaper/findChooseList.do", 
    		queryParams:function(params){
    			draw++;
    			var formData = $("#choosecustomerListForm").serializeJSON(); //查询表单的参数
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
    	        formatter:function(value,row,index){
    	        	var rHtml = "<input type='radio' name='radioindex' class='btn btn-sm green'/>";
    	        	return rHtml;
    	        
    	        }
    	    }, {
        		field: 'customercode',
        		title: 'customercode'
        		,align:"center"
        	}
        	, {
        		field: 'customername',
        		title: 'customername'
        		,align:"center"
        	}]
    	});
	};

	$("#onePagerSearchBt").click(function() {
		initTable1();
	});
	
	$("#onePagerCustomersSure").click(function() {
//		jQuery.ajax({
//			type : 'POST',
//			url : 'rest/onePaper/returethis.do',
//			data : '',
//			success : function(data) {
//				bootbox.alert({
//					size : 'small',
//					callback : function(result) {
//						bootbox.hideAll(); // 隐藏所有的bootbox
//					}
//				});
//			}
//		});
	});
	
//	$(document).ready(function() {
//		alert("数据加载成功");
//		$("#choosecustomer tr").click(function() {
//				$(this).find('td').each(function(i) {
//				var text = $(this).text();
//				if(i==1){
//					$("#onepapercustomercode").val(text);
//				}
//				if(i==2){
//					$("#onepapercustomers").val(text);
//				}
//				});
//			});
//		});
	
	
	/**
	 * 编辑
	 */
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
	};
}();
// 执行
ChooseCustomers.init();