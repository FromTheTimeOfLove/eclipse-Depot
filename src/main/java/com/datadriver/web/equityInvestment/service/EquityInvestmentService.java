package com.datadriver.web.equityInvestment.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericService;
import com.datadriver.web.equityInvestment.dto.EquityInvestmentDto;
import com.datadriver.web.equityInvestment.model.EquityDealTeam;
import com.datadriver.web.equityInvestment.model.EquityInvestment;
import com.datadriver.web.equityInvestment.model.EquityInvestmentPage;
import com.datadriver.web.file.model.DocumentEntity;
import com.datadriver.web.onePaper.model.OnePaper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: EquityInvestmentService
 * @Description: 业务接口
 * @Date 2016-4-19 下午5:55:35
 */
public interface EquityInvestmentService extends GenericService<EquityInvestment, Long> {
	
	/**
	 * 按条件查询EquityInvestment信息
	 * 
	 * @Title: findEquityInvestment
	 * @param record
	 * @return PageInfo<EquityInvestment> 返回类型
	 */
	PageInfo<EquityInvestment> findEquityInvestmentListbyDto(EquityInvestmentDto record)
			throws UnitedException;
	
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
	 * 添加文档并返回id
	 * 
	 * @Title: insertDocument
	 * @param obj
	 * @return void 返回类型
	 */
	void insertDocument(DocumentEntity obj) throws UnitedException;
	
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
	 * @Description: 查询+下列的数据
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
	void deleteTeam(String equityInvestmentId);
	
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
	 * 
	* @Title: toExcel
	* @Description: 导出excel方法
	* @param @param response
	* @param @param teamMap
	* @param @param pathName
	* @param @throws IOException 设定文件
	* @return void 返回类型
	* @throws
	 */
	void toExcel(HttpServletResponse response,Map teamMap,String pathName) throws IOException;
	
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
