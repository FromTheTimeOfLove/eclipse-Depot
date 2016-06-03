package com.datadriver.web.dept.service;

import java.util.List;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericService;
import com.datadriver.web.common.model.ZtreeNode;
import com.datadriver.web.dept.dto.DeptDto;
import com.datadriver.web.dept.model.Dept;
import com.github.pagehelper.PageInfo;

public interface DeptService extends GenericService<Dept, Long> {

	/**
	 * 按条件查询部门信息
	 * 
	 * @Title: findStuList
	 * @param record
	 * @return List<Stu> 返回类型
	 */
	PageInfo<DeptDto> findEmpListbyDto(DeptDto record) throws UnitedException;

	/**
	 * 根据ID查询某一条部门记录
	 * 
	 * @param empid
	 * @return
	 * @throws UnitedException
	 */
	DeptDto selectDeptById(int deptid) throws UnitedException;

	/**
	 * 查询树公司
	 * 
	 * @param roleDto
	 *            传递角色ID
	 * @return 符合zTree结构的权限列表
	 * @throws UnitedException
	 */
	List<ZtreeNode> findDeptPermissionTree() throws UnitedException;
}
