package com.datadriver.web.basicExit.service;

import java.util.List;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericService;
import com.datadriver.web.basicExit.dto.BasicExitDto;
import com.datadriver.web.basicExit.model.BasicExit;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: BasicExitService
 * @Description: BasicExit业务实现接口
 * @Date 2016-4-12 下午12:35:10
 */
public interface BasicExitService extends GenericService<BasicExit, Long> {
	/**
	 * 按条件查询
	 * @Title: selectBasicExitListbyDto
	 * @param record
	 * @return PageInfo<BasicExit> 返回类型
	 */
	PageInfo<BasicExit> selectBasicExitListbyDto(BasicExitDto record) throws UnitedException;
	
	/**
	 * 查询+号内部的数据
	 * @Title: findRowDetails
	 * @param id
	 * @return List<BasicExit> 返回类型
	 */
	List<BasicExit> findRowDetails(String id) throws UnitedException;
	
	/**
	 * 查询跳转新增页面需要填充的数据
	 * @Title: selectByPaperId
	 * @param id
	 * @return BasicExit 返回类型
	 */
	BasicExit selectByPaperId(String id) throws UnitedException;
}
