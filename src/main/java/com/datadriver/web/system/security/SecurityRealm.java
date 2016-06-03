package com.datadriver.web.system.security;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.web.system.model.SystemPermissionAction;
import com.datadriver.web.system.model.SystemRole;
import com.datadriver.web.system.model.SystemUser;
import com.datadriver.web.system.service.SystemPermissionActionService;
import com.datadriver.web.system.service.SystemRoleService;
import com.datadriver.web.system.service.SystemUserService;

/**
 * 用户身份验证,授权 Realm 组件
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {
	
	@Resource
	private SystemUserService				systemUserService;
	@Resource
	private SystemRoleService				systemRoleService;
	@Resource
	private SystemPermissionActionService	systemPermissionActionService;
	
	/**
	 * 权限检查
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		try {
			String username = String.valueOf(principals.getPrimaryPrincipal());
			SystemUser user = systemUserService.selectByUsername(username);
			final List<SystemRole> roleInfos = systemRoleService.selectRolesByUserId(user.getUserId());
			final List<SystemPermissionAction> permissions = systemPermissionActionService.selectPermissionsByUserId(user.getUserId());
			for (SystemRole role : roleInfos) {
				// 添加角色
				authorizationInfo.addRole(role.getRoleName());
			}
			for (SystemPermissionAction permission : permissions) {
				// 添加权限
				authorizationInfo.addStringPermission(permission.getActionCode());
			}
		} catch (UnitedException e) {
			throw new AuthorizationException(e.getErrorMessage());
		}
		return authorizationInfo;
	}
	
	/**
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
		try {
			String username = String.valueOf(token.getPrincipal());
			String password = new String((char[]) token.getCredentials());
			// 通过数据库进行验证
			final SystemUser authentication = systemUserService.selectByUserNameAndPw(username, password);
			if (authentication == null) {
				throw new AuthenticationException("MSG.10003");
			}
			authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
		} catch (UnitedException e) {
			throw new AuthenticationException(e.getErrorMessage());
		}
		return authenticationInfo;
	}
	
}
