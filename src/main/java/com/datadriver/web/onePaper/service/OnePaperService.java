package com.datadriver.web.onePaper.service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericService;
import com.datadriver.web.onePaper.dto.CustomerDto;
import com.datadriver.web.onePaper.dto.OnePaperDto;
import com.datadriver.web.onePaper.model.OnePaper;
import com.datadriver.web.system.model.SystemUser;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: OnePaperService
 * @Description: OnePaper业务实现接口
 * @Date 2016-4-12 下午12:35:10
 */
public interface OnePaperService extends GenericService<OnePaper, Long> {
	/**
	 * 按条件查询
	 * 
	 * @Title: selectOnePaperListbyDto
	 * @Description: 按条件查询
	 * @param record
	 * @return
	 * @throws UnitedException
	 *             PageInfo<OnePaper> 返回类型
	 */
	PageInfo<OnePaper> selectOnePaperListbyDto(OnePaperDto record)
			throws UnitedException;

	/**
	 * 新增OnePaper
	 * 
	 * @param record
	 * @throws UnitedException
	 */
	void insertOnepaper(OnePaperDto record, SystemUser systemuser)
			throws UnitedException;

	/**
	 * 判断Portfolio name， Portfolio name (EN)是否存在
	 * 
	 * @param record
	 * @return
	 */
	String findPortfolioname(OnePaperDto record);

	/**
	 * 修改 判断Portfolio name， Portfolio name (EN)是否存在
	 * 
	 * @param record
	 * @return
	 */
	String updatePortfolioname(OnePaperDto record);

	/**
	 * OnePaper修改
	 * 
	 * @param record
	 * @param systemuser
	 * @throws UnitedException
	 */
	void updateOnepaper(OnePaperDto record, SystemUser systemuser)
			throws UnitedException;

	/**
	 * 根据onepaper查询一条记录
	 * 
	 * @param paperid
	 * @return
	 * @throws UnitedException
	 */
	OnePaperDto selectOnePaperById(int paperid) throws UnitedException;

	/**
	 * 按条件查询Customer信息
	 * 
	 * @param record
	 * @return
	 * @throws UnitedException
	 */
	PageInfo<CustomerDto> selectCustomerDto(CustomerDto record)
			throws UnitedException;

	/**
	 * 删除One paper
	 * 
	 * @param id
	 * @throws UnitedException
	 */
	void deleteOnepaper(String id) throws UnitedException;

}
