package com.datadriver.web.equityInvestment.dao;

import java.util.List;
import java.util.Map;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.web.equityInvestment.model.EquityInvestment;
import com.datadriver.web.equityInvestment.model.EquityInvestmentPage;
import com.datadriver.web.file.model.DocumentEntity;
import com.datadriver.web.onePaper.model.OnePaper;

public interface EquityInvestmentMapper extends GenericDao<EquityInvestment, Long> {
	
	/**
	 * 获取EquityInvestment列表数据
	 * 
	 * @param record
	 * @return
	 */
	List<EquityInvestment> findEquityInvestmentListbyDto(Object record);
	
	/**
	 * 根据OnePaper标识查询其个别信息
	 * 
	 * @param paperid
	 * @return
	 * @throws UnitedException
	 */
	OnePaper selectPaperById(String paperid) throws UnitedException;
	
	/**
	 * 根据id查询EquityInvestment对象
	 * 
	 * @Title: queryEquityInvestmentObj
	 * @param equityInvestmentId
	 * @return EquityInvestment 返回类型
	 */
	EquityInvestment queryEquityInvestmentObj(String equityInvestmentId);
	
	/**
	 * 添加文档
	 * 
	 * @Title: insertDocument
	 * @param obj
	 * @return long 返回类型
	 */
	void insertDocument(DocumentEntity obj);
	
	/**
	 * 编辑文档
	 * 
	 * @Title: updateDocument
	 * @param obj
	 * @return void 返回类型
	 */
	void updateDocument(DocumentEntity obj);
	
	/**
	 * 
	 * @Title: findEquityInvestmentByPaper
	 * @Description: 查询+下面的数据
	 * @param @param equityInvestmentId
	 * @param @return 设定文件
	 * @return List<EquityInvestmentPage> 返回类型
	 * @throws
	 */
	List<EquityInvestmentPage> findEquityInvestmentByPaper(String equityInvestmentId);
	
	/**
	 * 添加Team
	 * 
	 * @Title: insertTeam
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param maps
	 *            void 返回类型
	 */
	void insertTeam(Map<String, Object> maps);
	
	/**
	 * 根据basicInfoId删除
	 * 
	 * @Title: deleteTeam
	 * @param basicInfoId
	 * @param teamType
	 *            void 返回类型
	 */
	void deleteTeam(String basicInfoId);
	
	/**
	 * 查询ComPliance - Confirmation Team
	 * 
	 * @Title: selectLisgaggStr
	 * @param basicInfoId
	 * @param teamType
	 * @return String 返回类型
	 */
	String selectLisgaggStr(String equityInvestmentId, String teamType);

	/**
	 * 根据id查询与其有关联的文档id
	 * @Title: selectDocRelatedId
	 * @param equityInvestmentId
	 * @return Map<String,Object> 返回类型
	 */
	Map<String, Object> selectDocRelatedId(String equityInvestmentId);
	
	/**
	 * 根据主键删除（不做物理删除）
	 * @Title: deleteByPrimaryKeyAll
	 * @param map
	 * @return void 返回类型
	 */
	void deleteByPrimaryKeyAll(Map<String, Object> map) throws UnitedException;
}
