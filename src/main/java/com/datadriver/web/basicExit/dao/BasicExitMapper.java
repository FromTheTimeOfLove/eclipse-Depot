package com.datadriver.web.basicExit.dao;

import java.util.List;

import com.datadriver.core.generic.GenericDao;
import com.datadriver.web.basicExit.model.BasicExit;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: BasicExitDao
 * @Description: BasicExitDao层
 * @Date 2016-4-12 下午12:30:06
 */
public interface BasicExitMapper extends GenericDao<BasicExit, Long> {
	
	/**
	 * 按条件查询Basic Exit
	 * @Title: selectBasicExitList
	 * @Description: 
	 * @param obj
	 * @return List<BasicExit> 返回类型
	 */
	public List<BasicExit> selectBasicExitList(Object obj);
	
	/**
	 * 查询+号内部的数据
	 * @Title: findRowDetails
	 * @Description: 
	 * @param id
	 * @return List<BasicExit> 返回类型
	 */
	public List<BasicExit> findRowDetails(String id);
	
	/**
	 * 查询跳转新增页面需要填充的数据
	 * @Title: selectByPaperId
	 * @Description: 
	 * @param id
	 * @return BasicExit 返回类型
	 */
	public BasicExit selectByPaperId(String id);
	
}
