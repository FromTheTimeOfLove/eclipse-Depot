package com.datadriver.web.dept.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.core.generic.GenericServiceImpl;
import com.datadriver.web.common.model.ZtreeNode;
import com.datadriver.web.dept.dao.DeptMapper;
import com.datadriver.web.dept.dto.DeptDto;
import com.datadriver.web.dept.model.Dept;
import com.datadriver.web.dept.service.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeptServiceImpl extends GenericServiceImpl<Dept, Long> implements
		DeptService {

	@Resource
	private DeptMapper deptMapper;// 调用学生接口

	/**
	 * 按条件查询部门信息
	 */
	@Override
	public PageInfo<DeptDto> findEmpListbyDto(DeptDto record)
			throws UnitedException {
		PageHelper.startPage(record.getPageNum(), record.getPageSize(), true);
		List<DeptDto> list = deptMapper.findDeptListByDto(record);
		return new PageInfo<DeptDto>(list);
	}

	// 新增部门信息
	@Override
	public int insert(Dept model) throws UnitedException {
		return deptMapper.insertDept(model);
	}

	// 修改部门信息
	@Override
	public int update(Dept model) throws UnitedException {
		return deptMapper.updateDept(model);
	}

	//
	@Override
	public GenericDao<Dept, Long> getDao() {
		// TODO Auto-generated method stub
		return deptMapper;
	}

	@Override
	public DeptDto selectDeptById(int deptid) throws UnitedException {
		// TODO Auto-generated method stub
		return deptMapper.selectDeptById(deptid);
	}

	@Override
	public int delete(Long id) throws UnitedException {
		return deptMapper.deleteDept(String.valueOf(id));
	}

	@Override
	public List<ZtreeNode> findDeptPermissionTree() throws UnitedException {
		return deptMapper.findDeptPermissionTree();
	}
}
