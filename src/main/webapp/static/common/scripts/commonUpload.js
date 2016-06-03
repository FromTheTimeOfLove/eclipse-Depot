var UploadFile = function() {
    var IMG_PREFIX = 'static/common/plugins/notification/dist/img/';
    
    /**
     * CH: 获取data-name集合并初始化file
     * EN: Gets the data-name collection and initial file
     * tag: default div
     * fileNameVal: default file
     */
    var getDataNamesAndInitFile = function(tag, fileNameVal){
    	var $divs= $(tag);
    	if($divs) {
    		$divs.each(function(){
    			$data_name = $(this).attr("data-filename");
    			if($data_name) {
    				var divId = $(this).attr("id");
    				initFileDom(divId, fileNameVal);
    			}
    		})
    	}
    };
	/**
	 * 初始化File元素 / init file
	 * divId： dom id
	 * fileNameVal: file name values
	 */
	var initFileDom = function(divId, fileNameVal){
		if (divId == undefined || divId == null) return;
		//设置默认值 file // Set default values file
		if (fileNameVal == undefined || fileNameVal == null) fileNameVal = "file";
		//根据id定位 / According to divId positioning
		var $rootDiv = $("#"+divId);
		//获得自定义属性 'data-name' / Get a custom attribute 'data-name'
		var _name = $rootDiv.attr("data-filename");
		var _parent = $rootDiv.attr("data-parent");
		//开始组装文件上传元素 / Start assembly file upload element
		var fileDiv = "<div class='fileinput fileinput-new' data-provides='fileinput'>";
		fileDiv += "<input type='hidden' name='"+_name+".fileId'>";
		fileDiv += "<div class='input-group input-large'>";
		fileDiv += "<div class='form-control uneditable-input input-fixed input-medium' data-trigger='fileinput'>";
		fileDiv += "<i class='fa fa-file fileinput-exists'></i>&nbsp;";
		fileDiv += "<span class='fileinput-filename text_overflow_hide'></span>&nbsp;";
		fileDiv += "<input type='hidden' name='"+_name+".fileName'></div>";
		fileDiv += "<input type='hidden' name='"+_name+".filePath'>";
		fileDiv += "<span class='input-group-addon btn default btn-file'>";
		fileDiv += "<span class='fileinput-new'> Select file </span>";
		fileDiv += "<input id='"+divId+"UploadFileId' type='file' name='"+fileNameVal+"' onchange='UploadFile.commonSignedUpload(this);'>";
		fileDiv += "</span>";
		fileDiv += "<a href='javascript:;' class='input-group-addon btn default red fileinput-exists' data-dismiss='fileinput'>&nbsp;Remove&nbsp;</a>";
		fileDiv += "</div></div>";
		$rootDiv.after(fileDiv);
		$rootDiv.hide();
	};
	
	/**
	 * 设置File value值
	 */
	var setEditFileValue = function(obj) {
		var $span = $("#"+obj.fileDivId);
		var $divDom = $span.next();
		var fileId = obj.fileId;
		if(fileId != undefined && fileId != null && fileId != "") {
			$divDom.find("span.btn-file").hide();
			$divDom.find("a").removeClass("fileinput-exists");
			$divDom.find("a").css("width","100%");
			var $inputFirst = $divDom.find(":first");
			var $sdom = $divDom.find("div div span");//获得div下面的span元素
			var $idom = $divDom.find("div div input");//获得div下面的input元素
			$divDom.find("i").removeClass("fileinput-exists");
			$inputFirst.val($.trim(fileId));//文件id
			$sdom.text($.trim(obj.fileName));//文件名称
			$idom.val($.trim(obj.fileName));//文件名称
			$divDom.find("div div").next().val($.trim(obj.filePath));//文件路径input
		}
	};
	
	/**
	 * 文档上传
	 */
	var commonSignedUpload = function(obj) {
		var filename="", file, cloneElement, newElement, $divDom, 
			$sdom, $idom, $oldDom, $twoInput;
		var objId = $(obj).attr("id");//获取对象id
		filename = $(obj).val();//获取值（文件名称）
		if(objId.indexOf("jUploadFile") > -1) {//判断该对象id是否存在该字符串
			var $obj = $("#"+objId.substring(11));//截取id
			console.info($obj);
			$divDom = $obj.closest("div");//获得上一级dom对象
			file = $obj[0].files[0] = null;//设空值
		} else {
			$divDom = $(obj).closest("div");//获取上一级dom
			file = $(obj)[0].files[0];//赋值
		}
		$div = $divDom.find("span.btn-file");//获得span元素
		$div.hide();//隐藏元素
		$adom = $divDom.find("a");//获得a元素
		if(file == null || file == undefined) { //remove
			$(obj).attr("name","");//设置name值为空
			$(obj).prev().attr("name","file");//设值为file，对应controller方法中参数
			$adom.addClass("fileinput-exists");//添加隐藏样式
			$divDom.find("i").addClass("fileinput-exists");
			$div.show();//显示span元素
			return;
		} else { //select file
			$(obj).attr("name","file");
			$(obj).prev().attr("name","");
			$adom.removeClass("fileinput-exists");
			$adom.css("width","100%");
		}
		
		if(filename.length <= 0) {
			return;
		}
		$sdom = $divDom.find("div span");//获得div下面的span元素
		$idom = $divDom.find("div input");//获得div下面的input元素
		$sdom.text(filename);//设值
		$idom.val(filename);//设值
		//发送请求
		$.ajaxFileUpload({
			url: "rest/commonUpload/upload.do",
			secureuri: false, //是否开启验证，一般设置为false
			fileElementId: obj.id, //文件上传input的id属性  <input type="file" id="file" name="file" />
			dataType: 'HTML', //返回值类型（后台返回json即可，这里一般不做修改）
			success: function (data){
				if( data && data!="null"){
					$twoInput = $divDom.find("div").next();//文件路径input
					$twoInput.val(data);
	          	} else {
	          		$divDom.find('a.input-group-addon').click();
	          		Lobibox.notify('error', {
                        msg: "Sorry, upload failed!",
                        delay: 2000,
                        soundPath: IMG_PREFIX
                    });
	          	}
			}
	  	});
	};
	
	/**
	 * 重置
	 */
	var resetUploadVal = function() {
		$(".fileinput a").click();
	};
	
	return {
		init : function() {
			getDataNamesAndInitFile("span", "file");
		},
		commonSignedUpload :function(obj){
			commonSignedUpload(obj);
		},
		getDataNamesAndInitFile : function(tag, fileNameVal) {
			getDataNamesAndInitFile(tag, fileNameVal);
		},
		initFileDom : function(divId, fileNameVal) {
			initFileDom(divId, fileNameVal);
		},
		setEditFileValue : function(obj) {
			setEditFileValue(obj);
		},
		resetUploadVal : function() {
			resetUploadVal();
		}
	};
}();
UploadFile.init();
