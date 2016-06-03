var Content = function() {
	return {
		init : function() {
			// DataTable Init
			GlobalCommon.dataTableInit();
			// bootstrapTable Init
			GlobalCommon.bootstrapTableInit();
			// 日历控件Init
			GlobalCommon.datetimepickerInit();
		}
	};
}();
// 执行
Content.init();
