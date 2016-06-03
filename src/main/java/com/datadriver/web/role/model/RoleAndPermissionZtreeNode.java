package com.datadriver.web.role.model;

import com.datadriver.web.common.enums.FinalConfig;
import com.datadriver.web.common.model.ZtreeNode;
import com.datadriver.web.system.util.LocaleUtil;

public class RoleAndPermissionZtreeNode extends ZtreeNode {
	private String	permissionType;
	
	public String getPermissionType() {
		return permissionType;
	}
	
	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}
	
	@Override
	public String getName() {
		// 覆盖Name方法：[资源类型]名称
		String perNameString = null;
		if (permissionType != null && !("").equals(permissionType.trim())) {
			// 国际化
			perNameString = LocaleUtil.loadLocalString(FinalConfig.I18N_MESSAGE, permissionType);
			if (perNameString != null && !("").equals(perNameString.trim())) {
				return this.name = "[" + perNameString + "]" + name;
			}
		}
		return this.name;
	}
}
