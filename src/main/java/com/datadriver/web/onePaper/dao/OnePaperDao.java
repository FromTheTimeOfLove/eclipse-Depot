package com.datadriver.web.onePaper.dao;

import java.util.List;

import com.datadriver.core.generic.GenericDao;
import com.datadriver.web.onePaper.dto.CustomerDto;
import com.datadriver.web.onePaper.dto.OnePaperDto;
import com.datadriver.web.onePaper.model.FileDoc;
import com.datadriver.web.onePaper.model.OnePaper;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: OnePaperDao
 * @Description: One Paper Dao层
 * @Date 2016-4-12 下午12:30:06
 */
public interface OnePaperDao extends GenericDao<OnePaper, Long> {

	/**
	 * 按条件查询One Paper
	 * 
	 * @Title: selectOnePaperList
	 * @Description:
	 * @param obj
	 * @return List<OnePaper> 返回类型
	 */
	public List<OnePaper> selectOnePaperList(Object obj);

	/**
	 * 获取文档表的主键ID
	 * 
	 * @return
	 */
	public String getDocid();

	/**
	 * 保存文档
	 * 
	 * @param doc
	 */
	public void saveDoc(FileDoc doc);

	/**
	 * 修改
	 * 
	 * @param doc
	 */
	public void updateDoc(FileDoc doc);

	/**
	 * 录入Onepaper
	 * 
	 * @param onePaperDto
	 */
	public void saveOnepaper(OnePaperDto onePaperDto);

	/**
	 * 修改Onepaper
	 * 
	 * @param onePaperDto
	 */
	public void updateOnepaper(OnePaperDto onePaperDto);

	/**
	 * 根据onepaper查询一条记录
	 * 
	 * @param paperid
	 * @return
	 */
	public OnePaperDto selectOnePaperById(int paperid);

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public List<CustomerDto> selectCustomerDto(Object obj);

	/**
	 * 删除Onepaper
	 * 
	 * @param paperid
	 */
	public void deleteOnepaper(String paperid);

	/**
	 * 删除文档
	 * 
	 * @param docid
	 */
	public void deleteDoc(String docid);

	/**
	 * 判断Portfolio name (CH)是否存在
	 * 
	 * @param pname
	 * @return
	 */
	public int findPortfolionameCH(String pname);

	/**
	 * 判断Portfolio name (EN)是否存在
	 * 
	 * @param pname
	 * @return
	 */
	public int findPortfolionameEN(String pname);

	/**
	 * 判断Portfolio name (CH)是否存在
	 * 
	 * @param pname
	 * @return
	 */
	public int updatePortfolionameCH(OnePaperDto record);

	/**
	 * 判断Portfolio name (EN)是否存在
	 * 
	 * @param pname
	 * @return
	 */
	public int updatePortfolionameEN(OnePaperDto record);

}
