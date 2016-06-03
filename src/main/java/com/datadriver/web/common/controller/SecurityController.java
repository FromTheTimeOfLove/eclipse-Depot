package com.datadriver.web.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datadriver.core.util.SecurityUtil;

/**
 * @ClassName: SecurityController
 * @Description: 加密字符串(参数等信息)
 * @date 2015年12月17日 上午11:48:59
 */
@Controller
@RequestMapping("/security")
public class SecurityController {
	
	/**
	 * 加密(return JSON)
	 */
	@RequestMapping("/encrypt")
	@ResponseBody
	public String encrypt(Model model, @RequestParam(value = "plainText", defaultValue = "") String plainText) {
		String plaintextResult = null;
		try {
			if (plainText != null && !("").equals(plainText.trim())) {
				plaintextResult = SecurityUtil.encrypt(plainText);
			}
		} catch (Exception e) {
			plaintextResult = null;
		}
		return plaintextResult;
	}
}
