var Login = function() {

	var handleLogin = function() {
		$("#loginPwHidden").val("");
		$("#loginAccountHidden").val("");
		$('.login-form').validate({
			focusInvalid : false,
			errorClass : 'dd-validate-error', // 使用自定义样式
			validClass : 'dd-validate-valid',// 使用自定义样式
			errorElement : "span",
			rules : {
				loginName : {
					required : true
				},
				loginPassword : {
					required : true
				}
			},
			messages : {
				loginName : {
					required : i18n.t('LOGIN.VALID.LOGINNAME_NULL')
				},
				loginPassword : {
					required : i18n.t('LOGIN.VALID.PASSWORD_NULL')
				}
			},
			invalidHandler : function(event, validator) {
				// $('.alert-danger', $('.login-form')).show();
			},
			highlight : function(element) { // hightlight error inputs
				$(element).closest('.form-group').addClass('has-error');
			},
			success : function(label) {
				label.closest('.form-group').removeClass('has-error');
				label.remove();
			},
			errorPlacement : function(error, element) {
				error.insertAfter(element.closest('.input-icon'));
			},
			submitHandler : function(form) {
				loginSubmitForm();
			}
		});
		/**
		 * 回车事件
		 */
		$('.login-form input').keypress(function(e) {
			if (e.which == 13) {
				if ($('.login-form').validate().form()) {
					loginSubmitForm();
				}
				return false;
			}
		});
	};

	var loginSubmitForm = function() {
		var account = $("#loginAccount").val();
		var passwd = $("#loginPw").val();
		// 密码Base64位处理
		passwd = GlobalUtil.paramEncryption(passwd);
		account = GlobalUtil.paramEncryption(account);
		// 密码SHA512加密处理
		passwd = CryptoJS.SHA512(passwd);
		// 传输信息加密
		$("#loginPw").val(passwd);
		$("#loginPwHidden").val(passwd);
		$("#loginAccountHidden").val(account);
		$("#login-a-form").submit();
	};
	return {
		init : function() {
			handleLogin();
			// 语言切换
			jQuery('#languageSelect').change(function() {
				var langType = $(this).val();
				window.location.href = "rest/system/loginPage.do?langType=" + langType;
			});
			// 背景图片自动切换
			$.backstretch([ "static/system/img/bg/1.jpg", "static/system/img/bg/2.jpg", "static/system/img/bg/3.jpg", "static/system/img/bg/4.jpg" ],
					{
						fade : 1000,
						duration : 8000
					});
			// 默认输入框聚焦
			$("#loginAccount").focus();

			jQuery('#submitLoginBt').click(function() {
				if ($('.login-form').validate().form()) {
					loginSubmitForm();
				}
			});

		}
	};

}();

jQuery(document).ready(function() {
	Login.init();
});