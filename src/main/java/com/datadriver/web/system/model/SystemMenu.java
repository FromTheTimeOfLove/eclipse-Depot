package com.datadriver.web.system.model;

/**
 * @ClassName: SystemMenu
 * @Description: 系统菜单
 */
public class SystemMenu {
	/**
	 * 主键ID
	 */
	private String	menuId;
	/**
	 * 父节点
	 */
	private String	menuParentId;
	/**
	 * 菜单名
	 */
	private String	menuName;
	/**
	 * URL
	 */
	private String	menuURL;
	/**
	 * 图标URL(相对路径)
	 */
	private String	menuIcon;
	/**
	 * 菜单类型
	 */
	private String	menuType;
	/**
	 * 菜单排序码
	 */
	private String	menuPin;
	
	public String getMenuId() {
		return menuId;
	}
	
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
	public String getMenuParentId() {
		return menuParentId;
	}
	
	public void setMenuParentId(String menuParentId) {
		this.menuParentId = menuParentId;
	}
	
	public String getMenuName() {
		return menuName;
	}
	
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	public String getMenuURL() {
		return menuURL;
	}
	
	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}
	
	public String getMenuIcon() {
		return menuIcon;
	}
	
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	
	public String getMenuType() {
		return menuType;
	}
	
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	
	public String getMenuPin() {
		return menuPin;
	}
	
	public void setMenuPin(String menuPin) {
		this.menuPin = menuPin;
	}
	
}
