package com.datadriver.web.role.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.core.generic.GenericServiceImpl;
import com.datadriver.web.role.dao.RoleMapper;
import com.datadriver.web.role.dto.RoleDto;
import com.datadriver.web.role.model.Role;
import com.datadriver.web.role.model.RoleAndPermissionZtreeNode;
import com.datadriver.web.role.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> implements
		RoleService {
	@Resource
	private RoleMapper roleMapper;

	@Override
	public PageInfo<Role> selectPageByRoleName(RoleDto roleDto)
			throws UnitedException {
		PageHelper.startPage(roleDto.getPageNum(), roleDto.getPageSize(), true);
		List<Role> list = roleMapper.selectPageByRoleName(roleDto);
		return new PageInfo<Role>(list);
	}

	@Override
	public int insert(Role model) throws UnitedException {
		return roleMapper.insert(model);
	}

	@Override
	public int update(Role model) throws UnitedException {
		return roleMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public Role selectById(Long id) throws UnitedException {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int delete(Long id) throws UnitedException {
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public GenericDao<Role, Long> getDao() {
		return roleMapper;
	}

	@Override
	public List<RoleAndPermissionZtreeNode> findPermissionTree(RoleDto roleDto)
			throws UnitedException {
		return roleMapper.findPermissionTree(roleDto);
	}

	@Override
	public void saveRolePermission(RoleDto roleDto) throws UnitedException {
		// 获取权限ID数组
		String[] permissionIdArr = roleDto.getPermissionId().split(",");
		// 设置参数
		RoleDto paramDto = null;
		List<RoleDto> roleDtoList = new ArrayList<RoleDto>();
		for (int i = 0; i < permissionIdArr.length; i++) {
			paramDto = new RoleDto();
			paramDto.setRoleId(roleDto.getRoleId());
			paramDto.setPermissionId(permissionIdArr[i]);
			paramDto.setAuthority("01");
			roleDtoList.add(paramDto);
		}
		// 先删除角色旧的权限
		roleMapper.deleteRolePermission(paramDto);
		// 再插入角色新的权限
		roleMapper.saveRolePermission(roleDtoList);
	}

	@Override
	public int findUserRole(Role role, String type) {
		// TODO Auto-generated method stub
		int count = 0;
		if ("insert".equals(type)) {// 标示新增
			count = roleMapper.findRoleInsert(role);
		} else {
			count = roleMapper.findRoleUpdate(role);
		}
		return count;
	}

}
