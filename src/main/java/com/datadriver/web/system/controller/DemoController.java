package com.datadriver.web.system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * JSON
 **/
@RestController
@RequestMapping("/api/demo")
public class DemoController {
	
	/**
	 * userJson
	 */
	@RequestMapping(value = "/jsonTest")
	public List<String> jsonTest(Model model, @RequestParam(value = "userName", defaultValue = "") String userName) {
		List<String> jsonList = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			jsonList.add("字符串" + i);
		}
		return jsonList;
	}
	
}