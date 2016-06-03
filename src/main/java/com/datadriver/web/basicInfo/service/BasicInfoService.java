package com.datadriver.web.basicInfo.service;

import java.util.List;
import java.util.Map;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericService;
import com.datadriver.web.basicInfo.dto.BasicInfoDto;
import com.datadriver.web.basicInfo.dto.commonTeamDto;
import com.datadriver.web.basicInfo.model.BasicInfo;
import com.datadriver.web.basicInfo.model.PostFunding;
import com.datadriver.web.basicInfo.model.PreFunding;
import com.datadriver.web.common.model.DataDictionary;
import com.datadriver.web.onePaper.model.OnePaper;
import com.datadriver.web.file.model.DocumentEntity;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: BasicInfoService
 * @Description: 业务接口
 * @Date 2016-4-19 下午5:55:35
 */
public interface BasicInfoService extends GenericService<BasicInfo, Long> {
	
	/**
	 * 根据id查询BasicInfo对象
	 * @Title: queryBasicInfoObj
	 * @param basicInfoId
	 * @return BasicInfo 返回类型
	 */
	BasicInfo queryBasicInfoObj(String basicInfoId);
	
	/**
	 *  根据id查询PreFunding对象
	 * @Title: queryPreFundingObj
	 * @param basicInfoId
	 * @return PreFunding 返回类型
	 */
	PreFunding queryPreFundingObj(String basicInfoId);
	
	/**
	 *  根据id查询PostFunding对象
	 * @Title: queryPostFundingObj
	 * @param basicInfoId
	 * @return PostFunding 返回类型
	 */
	PostFunding queryPostFundingObj(String basicInfoId);
	
	/**
	 * 根据one paper id查询
	 * @Title: findBasicInfo
	 * @param record
	 * @return List<BasicInfo> 返回类型
	 */
	List<BasicInfo> findBasicInfo(String record) throws UnitedException;
	
	/**
	 * 根据id查询与其有关联的文档id
	 * @Title: selectDocRelatedId
	 * @param basicInfoId
	 * @return Map<String,Object> 返回类型
	 */
	Map<String, Object> selectDocRelatedId(String basicInfoId);

	/**
	 * 按条件查询BasicInfo信息
	 * 
	 * @Title: findStuList
	 * @param record
	 * @return PageInfo<BasicInfo> 返回类型
	 */
	PageInfo<BasicInfo> findBasicInfoListbyDto(BasicInfoDto record)
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
	 * 根据id查询列表
	 * @Title: selectTreeLi
	 * @param id
	 * @return 返回键值对
	 * @throws UnitedException List<DataDictionary> 返回类型
	 */
	List<DataDictionary> selectTreeLi(String id) throws UnitedException;
	/**
	 * 添加BasicInfo
	 * @Title: insertBasicInfo
	 * @param basicInfo
	 * @return void 返回类型
	 */
	void insertBasicInfo(BasicInfo basicInfo) throws UnitedException;
	
	/**
	 * 根据标识修改BasicInfo信息
	 * @Title: updateByIdBasicInfo
	 * @param onepaper
	 * @return void 返回类型
	 */
	void updateByIdBasicInfo(BasicInfo basicInfo) throws UnitedException;
	
	/**
	 * 添加PreFunding
	 * @Title: insertPreFunding
	 * @param preFunding
	 * @return void 返回类型
	 */
	void insertPreFunding(PreFunding preFunding) throws UnitedException;
	
	/**
	 * 根据标识修改PreFunding信息
	 * @Title: updatePreFunding
	 * @param preFunding
	 * @return void 返回类型
	 */
	void updatePreFunding(PreFunding preFunding) throws UnitedException;
	
	/**
	 * 添加PostFunding
	 * @Title: insertPostFunding
	 * @param postFunding
	 * @return void 返回类型
	 */
	void insertPostFunding(PostFunding postFunding) throws UnitedException;
	
	/**
	 * 根据标识修改PostFunding信息
	 * @Title: updatePostFunding
	 * @param postFunding
	 * @return void 返回类型
	 */
	void updatePostFunding(PostFunding postFunding) throws UnitedException;
	
	/**
	 * 根据主键删除（不做物理删除）
	 * @Title: deleteByPrimaryKeyAll
	 * @param map
	 * @return void 返回类型
	 */
	void deleteByPrimaryKeyAll(Map<String, Object> map) throws UnitedException;
	
	/**
	 * 添加文档并返回id
	 * @Title: insertDocument
	 * @param obj
	 * @return void 返回类型
	 */
	void insertDocument(DocumentEntity obj) throws UnitedException;
	
	/**
	 * 编辑文档
	 * @Title: updateDocument
	 * @param obj
	 * @return void 返回类型
	 */
	void updateDocument(DocumentEntity obj);
	
	/**
	 * 查询ComplianceDeal单个对象
	 * @Title: getComplianceDealTeamObj
	 * @param dto
	 * @return Object 返回类型
	 */
	Object getComplianceDealTeamObj(commonTeamDto dto);
	
	/**
	 * 查询ComplianceLegal单个对象
	 * @Title: getComplianceLegalTeamObj
	 * @param dto
	 * @return Object 返回类型
	 */
	Object getComplianceLegalTeamObj(commonTeamDto dto);
	
	/**
	 * 查询ConfirmationLegal单个对象
	 * @Title: getConfirmationLegalTeamObj
	 * @param dto
	 * @return Object 返回类型
	 */
	Object getConfirmationLegalTeamObj(commonTeamDto dto);
	
	/**
	 * 查询ConfirmationDeal单个对象
	 * @Title: getConfirmationDealObj
	 * @param dto
	 * @return Object 返回类型
	 */
	Object getConfirmationDealObj(commonTeamDto dto);
	
	/**
	 * 添加Team
	 * @Title: insertTeam
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param maps void 返回类型
	 */
	void insertTeam(Map<String, Object> maps);
	
	/**
	 * 根据basicInfoId删除
	 * @Title: deleteTeam
	 * @param basicInfoId
	 * @param teamType void 返回类型
	 */
	void deleteTeam(String basicInfoId);
	
	/**
	 * 查询ComPliance - Confirmation Team
	 * @Title: selectLisgaggStr
	 * @param basicInfoId
	 * @param teamType
	 * @return String 返回类型
	 */
	String selectLisgaggStr(String basicInfoId, String teamType);
}
