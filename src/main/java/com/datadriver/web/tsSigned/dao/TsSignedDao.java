package com.datadriver.web.tsSigned.dao;

import java.util.List;

import com.datadriver.core.generic.GenericDao;
import com.datadriver.web.tsSigned.model.TsSigned;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: TsSignedDao
 * @Description: One Paper Dao层
 * @Date 2016-4-12 下午12:30:06
 */
public interface TsSignedDao extends GenericDao<TsSigned, Long> {
	
	/**
	 * 按条件查询
	 * @Title: selectTsSignedListbyDto
	 * @Description: 
	 * @param obj
	 * @return List<OnePaper> 返回类型
	 */
	public List<TsSigned> selectTsSignedListbyDto(Object obj);
	
	/**
	 * 
	* @Title: selectTsSignedById
	* @Description: 按id查询数据
	* @param @param tsSignedId
	* @param @return 设定文件
	* @return TsSigned 返回类型
	* @throws
	 */
	public TsSigned selectTsSignedById(String tsSignedId);
	
	/**
	 * 
	* @Title: updateThruDate
	* @Description: 删除功能，实际修改字段D_THRUDATE 为1代表已删除0未删除
	* @param @param tsSignedId 设定文件
	* @return void 返回类型
	* @throws
	 */
	public void updateThruDate(String tsSignedId);
	
	/**
	 * 
	* @Title: saveDoc
	* @Description: 新增上传文档
	* @param @param obj
	* @param @return 设定文件
	* @return String 返回类型
	* @throws
	 */
	public void saveDoc(Object obj);
	
	/**
	 * 
	* @Title: updateDoc
	* @Description: 修改文档
	* @param  设定文件
	* @return void 返回类型
	* @throws
	 */
	public void updateDoc(Object obj);
	
	/**
	 * 
	* @Title: deleteDoc
	* @Description: 删除文档
	* @param @param docid 设定文件
	* @return void 返回类型
	* @throws
	 */
	public void deleteDoc(String docid);
	/**
	 * 
	* @Title: insertTsSigned
	* @Description: 新增TsSigned
	* @param @param obj 设定文件
	* @return void 返回类型
	* @throws
	 */
	public void insertTsSigned(Object obj);
	
	/**
	 * 
	* @Title: updateTsSigned
	* @Description: 修改TsSigned
	* @param  设定文件
	* @return void 返回类型
	* @throws
	 */
	public void updateTsSigned(Object obj);
	
	/**
	 * 
	* @Title: selectOnepaparById
	* @Description: 新增页面查询onePaper
	* @param @param paperId
	* @param @return 设定文件
	* @return TsSigned 返回类型
	* @throws
	 */
	public TsSigned selectOnepaparById(String paperId);
	
}
