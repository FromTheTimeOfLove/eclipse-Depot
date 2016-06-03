/**
 * select
 */
var SelectUtils = function() {
	
	var defaults = {
			opDomDiv : "div",
			opDomInput : "input",
			opDomUl : "ul",
			opDomLi : "li",
			opClass : "class",
 			optionItemClass : "option-item",
			optionSeleteClass : "option-selected",
			optionHoverClass : "option-hover",
			opAttrVal : "data-value",
			opAttrIndex : "data-index"
	};
	
	/**
	 * 获取select的值（失效）
	 * param obj select name 格式
	 * return selectObj 对象
	 * 内容格式 {"text":"",value:""}
	 */
	var getSelectVal = function(obj) {
		if(obj) {
			var selectObj = {}, value, text, texto, texth;
			//根据当前select的dom对象寻找最近的一个div
			var $selectObjs = $(obj).closest(defaults.opDomDiv);
			//根据指定class获取选中的li对象
			texto = $selectObjs.find(
					defaults.opDomUl+">"
					+defaults.opDomLi+"["
					+defaults.opClass+"='"
					+defaults.optionItemClass+" "
					+defaults.optionSeleteClass+"']");
			texth = $selectObjs.find(
					defaults.opDomUl+">"
					+defaults.opDomLi+"["
					+defaults.opClass+"='"
					+defaults.optionItemClass+" "
					+defaults.optionSeleteClass+" "
					+defaults.optionHoverClass+"']");
			if (texto) {
				text = texto.text();// 获取文本
				value = texto.attr(defaults.opAttrVal);// 获取value
			} else if (texth) {
				text = texth.text();// 获取文本
				value = texth.attr(defaults.opAttrVal);// 获取value
			}
			selectObj = {
				"text" : text,
				"value" : value
			};
			return selectObj;
		}
	};
	
	/**
	 * 设置select的值（失效）
	 * param obj select id 格式 $("#id")
	 * param val select>option value 值
	 */
	var setSelectVal = function(obj, val) {
		if (obj) {
			var $selectObj = $(obj).closest(defaults.opDomDiv);
			$selectObj.find(defaults.opDomUl+">"+defaults.opDomLi).each(function(){
				var liVal = $(this).attr(defaults.opAttrVal);
				if(liVal.length<=0) return;
				if (liVal == val) {
					$(this).attr(defaults.opClass, defaults.optionItemClass+" "+defaults.optionSeleteClass);
					$selectObj.find(defaults.opDomInput).val($(this).text());
					$(obj).val(val);
				} else {
					$(this).attr(defaults.opClass, defaults.optionItemClass);
				}
			});
		}
	};
	
	/**
	 * 根据id定位获取值
	 * return id
	 */
	var getMultipleSelectVal = function (id) {
		var data = $("select[id='"+id+"']").select2("data");
		var ids = "";
		if(Object.keys(data).length > 0) {
			for ( var i = 0; i < data.length; i++) {
				ids += data[i].id + ",";
			}
			ids =  ids.substring(0,ids.length-1);
		}
		return ids;
	};
	
	/**
	 * 多选赋值(未完成)
	 */
	var setMultipleSelectVal = function(id, val) {
		var $select2 = $("select[id='"+id+"']");
		if ($select2) {
			$select2.select2("val",val)
		}
	};
	
	/**
	 * reset
	 */
	var resetSelectVal = function() {
		var $exampleTokenizer = $(".js-example-tokenizer").select2();
		$exampleTokenizer.val(null).trigger("change");
		var $examplePlaceholderSingle = $(".js-example-placeholder-single").select2();
		$examplePlaceholderSingle.each(function(){
			if($(this).attr("disabled") != 'disabled') 
				$(this).val(null).trigger("change");
		});
	};
	
	return {
		getSelectVal : function(obj) {
			return getSelectVal(obj);
		},
		setSelectVal : function(obj, val, content) {
			return setSelectVal(obj, val, content);
		},
		getMultipleSelectVal : function(id) {
			return getMultipleSelectVal(id);
		},
		setMultipleSelectVal : function(id,val){
			setMultipleSelectVal(id,val);
		},
		resetSelectVal : function() {
			return resetSelectVal();
		}
	};
}(); 