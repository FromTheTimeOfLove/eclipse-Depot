package com.datadriver.web.dept.dao;

import java.util.List;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.web.common.model.ZtreeNode;
import com.datadriver.web.dept.dto.DeptDto;
import com.datadriver.web.dept.model.Dept;

public interface DeptMapper extends GenericDao<Dept, Long> {

	List<DeptDto> findDeptListByDto(Object record);

	/**
	 * 
	 * @Title: insertStu
	 * @Description: 新增学生信息
	 * @param record
	 * @return int 返回类型
	 */
	int insertDept(Dept record);

	/**
	 * 
	 * @Title: updateStu
	 * @Description: 编辑学生信息
	 * @param record
	 * @return int 返回类型
	 */
	int updateDept(Dept record);

	/**
	 * 根据ID查询某一条记录
	 * 
	 * @param deptid
	 * @return
	 */
	DeptDto selectDeptById(int deptid);

	/**
	 * 
	 * @Title: deleteStu
	 * @Description: 删除部门信息
	 * @param id
	 * @return int 返回类型
	 */
	int deleteDept(String id);

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
