package com.datadriver.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.datadriver.web.system.model.SystemPermissionAction;
import com.datadriver.web.system.service.SystemPermissionActionService;

@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class MenuTest extends AbstractJUnit4SpringContextTests {
	
	@Resource
	private SystemPermissionActionService	systemPermissionActionService;
	
	@Test
	public void test() {
		try {
			List<SystemPermissionAction> menuList = systemPermissionActionService.selectMenuByUserId("21");
			String htmlString = "<ul>";
			int level = 0;
			int tempLevel = 0;
			int diffLevel = 0;
			String parentId = null;
			int i = 0;
			if (menuList.size() > 0) {
				level = menuList.get(0).getActionPin().length() / 2;
			}
			SystemPermissionAction menu = null;
			for (int j = 0; j < menuList.size(); j++) {
				menu = menuList.get(j);
				parentId = menu.getActionParentId();// 菜单的父ID
				tempLevel = menu.getActionPin().length() / 2;// 多少层级
				diffLevel = tempLevel - level;// 层级差异
				System.err.println(tempLevel + "|" + level + "--" + menu.getActionPin() + "///" + parentId);
				System.err.println("diffLevel=" + diffLevel);
				// 非根节点
				if ("0".equals(parentId)) {// 根节点
					if (j != 0) {
						for (i = 0; i < Math.abs(diffLevel); i++) {
							// 生成层级的</li>
							htmlString += "</li></ul>";
						}
					} else {
						level = menu.getActionPin().length() / 2;
						htmlString += "<li>" + menu.getActionPin();
					}
					continue;// 根节点，直接到下一次循环
				}
				if (diffLevel > 0) {// 大于当前的深度的是子菜单
					// 开始新的子层级
					htmlString += "<ul>";
					htmlString += "<li>" + menu.getActionPin();
				} else if (diffLevel == 0) {// 同级的菜单
					htmlString += "</li>";
					htmlString += "<li>" + menu.getActionPin();
				} else if (diffLevel < 0) {// 父级同级别的
					// 计算相差的级别
					for (i = 0; i < Math.abs(diffLevel); i++) {
						// 生成层级的</li>
						htmlString += "</li></ul></li>";
					}
					htmlString += "<li>" + menu.getActionPin();
				}
				level = tempLevel;
			}
			htmlString += "</ul>";
			System.err.println(htmlString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
