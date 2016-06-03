package com.datadriver.web.tsSigned.service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericService;
import com.datadriver.web.system.model.SystemUser;
import com.datadriver.web.tsSigned.dto.TsSignedDto;
import com.datadriver.web.tsSigned.model.TsSigned;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: TsSignedService
 * @Description: TsSigned业务实现接口
 * @Date 2016-4-12 下午12:35:10
 */
public interface TsSignedService extends GenericService<TsSigned, Long> {
	/**
	 * 按条件查询
	 * @Title: selectTsSignedListbyDto
	 * @Description: 按条件查询
	 * @param record
	 * @return
	 * @throws UnitedException PageInfo<TsSigned> 返回类型
	 */
	PageInfo<TsSigned> selectTsSignedListbyDto(TsSignedDto record) throws UnitedException;
	/**
	 * 
	* @Title: selectTsSignedById
	* @Description: 按id查询数据
	* @param @param tsSignedId
	* @param @return 设定文件
	* @return TsSigned 返回类型
	* @throws
	 */
	TsSigned selectTsSignedById(String tsSignedId);
	
	/**
	 * 
	* @Title: updateThruDate
	* @Description: 删除功能，实际修改字段D_THRUDATE 为1代表已删除0未删除
	* @param @param tsSignedId 设定文件
	* @return void 返回类型
	* @throws
	 */
	void updateThruDate(String tsSignedId);
	
	/**
	 * 
	* @Title: insertTsSigned
	* @Description: 新增TsSigned文档保存
	* @param @param model
	* @param @param systemuser 设定文件
	* @return void 返回类型
	* @throws
	 */
	void insertTsSigned(TsSigned model, SystemUser systemuser);
	
	/**
	 * 
	* @Title: updateTsSigned
	* @Description: 修改TsSigned
	* @param @param tsSigned
	* @param @param systemuser 设定文件
	* @return void 返回类型
	* @throws
	 */
	void updateTsSigned(TsSigned tsSigned, SystemUser systemuser);
	
	/**
	 * 
	* @Title: selectOnepaparById
	* @Description: 新增页面查询onePaper
	* @param @param paperId
	* @param @return 设定文件
	* @return TsSigned 返回类型
	* @throws
	 */
	TsSigned selectOnepaparById(String paperId);
}
