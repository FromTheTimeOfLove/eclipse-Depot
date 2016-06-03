<script type="text/javascript" src="static/common/scripts/select.utils.js"></script>
<script>
     $(function(){
   		$(".js-example-placeholder-single").select2({
		  //placeholder: 'Please choose'
		  //allowClear: true
   		});
   		/* $(".js-example-tokenizer").select2({
		  tags: false//,
		  //placeholder: 'Please choose'
		}); */
		ComponentsPickers.init();
		$(".fixed-table-toolbar").empty();
		$('.dataTimeTest').datetimepicker({
			minView: "month", 
			format: "yyyy-mm-dd", 
			language: 'zh-CN', 
			autoclose:true 
		});
		/* $('select').change(function(event){
		    console.log(event.target.selectedIndex)
		    console.log(event.target.value)
		}) */
     });
</script>
