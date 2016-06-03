/**
 * @param {Object} obj 对象
 * @param {Object} isMsg 是否输出错误信息
 * @return {boolean}
 */
function isMust(obj, isMsg) {
	var flag = true;
	var objId = obj.id;
	removeError(obj);
	var objValue = obj.value;
	if (objValue == null || objValue == '') {
		if (isMsg) {
			removeError(obj);
			$("#" + objId).css("background-color", "#FFF2E9");
			$("#" + objId).after("<span id='" + objId + "errorField'   class='errorField'>此为必输项</span>");
		}
		flag = false;
		hideLoading();
	} else {
		objValue = objValue.replace(/^\s+|\s+$/g, "");
		removeError(obj);
	}
	return flag;
}

/**
 *
 * @param {Object} obj(对象)
 * @param {Object} limit(限制长度)
 * @param {boolean} isMustValue(是否为必选/必输项)
 * @return {boolean}
 */
function lengthV(obj, limit, isMustValue, isMsg) {
	var flag = true;
	var limitTemp = Number(limit);
	var objId = obj.id;
	var goOn = true;
	removeError(obj);
	var objValue = obj.value.toString();
	var p1 = new RegExp('%u..', 'g');
	var p2 = new RegExp('%.', 'g');
	//var length = escape(objValue).replace(p1, '').replace(p2, '').length;
	var length = objValue.length;
	if (isMustValue) {
		goOn = isMust(obj, true);
	}
	if (goOn) {
		if (objValue != null && objValue != '') {
			if (length == 0 || length > limitTemp) {
				if (isMsg) {
					removeError(obj);
					$("#" + objId).css("background-color", "#FFF2E9");
					$("#" + objId).after("<span id='" + objId + "errorField' class='errorField'>长度已超过" + limit + "字符，请修改</span>");
				}

				flag = false;
				hideLoading();
			} else {
				if (isMsg) {
					removeError(obj);
//					var less=limitTemp-length;
//					$("#" + objId).css("background-color", "#fff");
//					$("#" + objId).after("<span id='" + objId + "waringField' class='waringField'>还可输入" + less + "字符</span>");
				}else{
					removeError(obj);
				}
			}
		}
	}else{
		flag = false;
	}
	return flag;
}

/**
 * 验证数字
 * @param {Object} obj(对象)
 * @param {Object} isMsg(是否弹出提示框)
 * @return {boolean}
 */
function numberV(obj, isMsg) {
	var flag = true;
	var objId = obj.id;
	removeError(obj);
	//var objValue = obj.value;
	var objValue = finnanceDataCancel(obj.value);
	var re = /^-?[1-9]+(\.\d+)?$|^-?0(\.\d+)?$|^-?[1-9]+[0-9]*(\.\d+)?$/;
	if (objValue != null && objValue != '') {
		if (!re.test(objValue)) {
			removeError(obj);
			flag = false;
			hideLoading();
			if (isMsg) {
				$("#" + objId).css("background-color", "#FFF2E9");
				$("#" + objId).after("<span id='" + objId + "errorField'  class='errorField'>请输入有效的数字</span>");
			}
			flag = false;
		}
	}
	return flag;
}

/**
 * 数字范围
 * @param {Object} obj(对象)
 * @param {Object} start(起始范围)
 * @param {Object} end(结束范围)
 * @param {Object} isMsg(是否弹出提示框)
 * @return {boolean}
 */
function numberLimitV(obj, start, end, isMsg) {
	var flag = true;
	var flag00 = true;
	var objId = obj.id;
	removeError(obj);
	flag00 = numberV(obj, true);
	var objValue = obj.value;
	if (objValue != null && objValue != '') {
		if (flag00) {
			if (objValue < start || objValue > end) {
				flag = false;
				hideLoading();
				if (isMsg) {
					removeError(obj);
					$("#" + objId).css("background-color", "#FFF2E9");
					$("#" + objId).after("<span id='" + objId + "errorField'  class='errorField'>请输入" + start + "至" + end + "之间的数字</span>");
				}
			} else {
				removeError(obj);
			}
		}else{
			hideLoading();
			flag = false;
		}
	}
	return flag;
}

/**
 * 数字范围
 * @param {Object} obj(对象)
 * @param {Object} start(起始范围)
 * @param {Object} end(结束范围)
 * @param {Object} isMustValue(是否为必输项)
 * @param {Object} isMsg(是否弹出提示框)
 * @return {boolean}
 */
function numberLimitV(obj, start, end, isMustValue, isMsg) {
	var flag = true;
	var flag00 = true;
	var goOn = true;
	var objId = obj.id;
	removeError(obj);
	var objValue = obj.value;
	if (isMustValue) {
		goOn = isMust(obj, true);
	}
	flag00 = numberV(obj, true);
	if (goOn) {
		if (objValue != null && objValue != '') {
			if (flag00) {
				if (objValue < start || objValue > end) {
					flag = false;
					hideLoading();
					if (isMsg) {
						removeError(obj);
						$("#" + objId).css("background-color", "#FFF2E9");
						$("#" + objId).after("<span id='" + objId + "errorField'  class='errorField'>请输入" + start + "至" + end + "之间的数字</span>");
					}
				} else {
					removeError(obj);
				}
			} else {
				hideLoading();
				flag = false;
			}
		}
	}else{
		flag = false;
	}
	return flag;
}

/**
 * 验证邮箱地址
 * @param {Object} obj(对象)
 * @param {Object} isMsg(是否弹出提示框)
 * @return {boolean}
 */
function emailV(obj, isMsg) {
	var flag = true;
	var objId = obj.id;
	removeError(obj);
	var objValue = obj.value;
	var re = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if (objValue != null && objValue != '') {
		if (!re.test(objValue)) {
			if (isMsg) {
				removeError(obj);
				$("#" + objId).css("background-color", "#FFF2E9");
				$("#" + objId).after("<span id='" + objId + "errorField'  class='errorField'>邮箱地址错误</span>");
			}
			flag = false;
			hideLoading();
		} else {
			removeError(obj);
		}
	}
	return flag;

}

/**
 * 验证邮箱地址
 * @param {Object} obj(对象)
 * @param {Object} isMustValue(是否为必输项)
 * @param {Object} isMsg(是否弹出提示框)
 * @return {boolean}
 */
function emailV(obj, isMustValue, isMsg) {
	var flag = true;
	var goOn = true;
	var objId = obj.id;
	removeError(obj);
	var objValue = obj.value;
	var re = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if (isMustValue) {
		goOn = isMust(obj, true);
	}
	if (goOn) {
		if (objValue != null && objValue != '') {
			if (!re.test(objValue)) {
				if (isMsg) {
					removeError(obj);
					$("#" + objId).css("background-color", "#FFF2E9");
					$("#" + objId).after("<span id='" + objId + "errorField'  class='errorField'>邮箱地址错误</span>");
				}
				flag = false;
				hideLoading();
			} else {
				removeError(obj);
			}
		}
	}else{
		flag = false;
	}
	return flag;

}

/**
 * 验证电话号码(非特殊字符)
 * @param {Object} obj(对象)
 * @param {Object} isMsg(是否弹出提示框)
 * @return {boolean}
 */
function phoneV(obj, isMsg) {
	var flag = true;
	var objId = obj.id;
	removeError(obj);
	var objValue = obj.value;
	var re = /^[0-9]*$/;
	if (objValue != null && objValue != '') {
		if (!re.test(objValue)) {
			if (isMsg) {
				removeError(obj);
				$("#" + objId).css("background-color", "#FFF2E9");
				$("#" + objId).after("<span id='" + objId + "errorField'  class='errorField'>电话号码错误</span>");
			}
			flag = false;
			hideLoading();
		} else {
			removeError(obj);
		}
	}
	return flag;
}

/**
 * 验证电话号码(非特殊字符)
 * @param {Object} obj(对象)
 * @param {Object} isMustValue(是否为必输项)
 * @param {Object} isMsg(是否弹出提示框)
 * @return {boolean}
 */
function phoneV(obj, isMustValue, isMsg) {
	var flag = true;
	var objId = obj.id;
	removeError(obj);
	var goOn = true;
	var objValue = obj.value;
	var re = /^[0-9]*$/;
	if (isMustValue) {
		goOn = isMust(obj, true);
	}
	if (goOn) {
		if (objValue != null && objValue != '') {
			if (!re.test(objValue)) {
				if (isMsg) {
					removeError(obj);
					$("#" + objId).css("background-color", "#FFF2E9");
					$("#" + objId).after("<span id='" + objId + "errorField'  class='errorField'>电话号码错误</span>");
				}
				flag = false;
				hideLoading();
			} else {
				removeError(obj);
			}
		}
	}else{
		flag = false;
	}
	return flag;
}

//清除错误信息
function removeError(obj) {
	var objId = obj.id;
	var error = $("#" + objId + "errorField");
	if (error != undefined && error != null) {
		$("#" + objId).css("background-color", "#fff");
		$("#" + objId + "errorField").remove();
		$("#" + objId + "waringField").remove();
	}
}

//验证URL资源是否存在
function internalresourcesV(obj, limit, isMustValue, isMsg){
	var linkUrl=obj.value;
	var objId=obj.id;
	$.post("internalresources/internalresourcesV.action",{"strUrl":linkUrl},function(data,status){
		if(data==false){
			removeError(obj);
			$("#" + objId).after("<span id='" + objId + "errorField'   class='errorField'>网络资源"+linkUrl+"不存在</span>");
		}else{
			removeError(obj);
		}
//		$("#" + objId).after("<span id='" + objId + "errorField'   class='errorField'>"+linkUrl+data+"</span>");
	},"json");
}