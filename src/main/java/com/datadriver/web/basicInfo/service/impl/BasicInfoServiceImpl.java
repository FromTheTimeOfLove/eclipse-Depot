package com.datadriver.web.basicInfo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.core.generic.GenericServiceImpl;
import com.datadriver.web.basicInfo.dao.BasicInfoMapper;
import com.datadriver.web.basicInfo.dto.BasicInfoDto;
import com.datadriver.web.basicInfo.dto.commonTeamDto;
import com.datadriver.web.basicInfo.model.BasicInfo;
import com.datadriver.web.basicInfo.model.PostFunding;
import com.datadriver.web.basicInfo.model.PreFunding;
import com.datadriver.web.basicInfo.service.BasicInfoService;
import com.datadriver.web.common.model.DataDictionary;
import com.datadriver.web.onePaper.model.OnePaper;
import com.datadriver.web.file.model.DocumentEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: BasicInfoServiceImpl
 * @Description: 业务实现类
 * @Date 2016-4-19 下午5:55:01
 */
@Service
public class BasicInfoServiceImpl extends GenericServiceImpl<BasicInfo, Long>
		implements BasicInfoService {

	@Resource
	private BasicInfoMapper basicinfoMapper;// 调用接口

	@Override
	public GenericDao<BasicInfo, Long> getDao() {
		return basicinfoMapper;
	}
	
	@Override
	public BasicInfo queryBasicInfoObj(String basicInfoId) {
		return basicinfoMapper.queryBasicInfoObj(basicInfoId);
	}
	
	@Override
	public PreFunding queryPreFundingObj(String basicInfoId) {
		return basicinfoMapper.queryPreFundingObj(basicInfoId);
	}

	@Override
	public PostFunding queryPostFundingObj(String basicInfoId) {
		return basicinfoMapper.queryPostFundingObj(basicInfoId);
	}

	@Override
	public List<BasicInfo> findBasicInfo(String record) throws UnitedException {
		return basicinfoMapper.findBasicInfo(record);
	}

	@Override
	public Map<String, Object> selectDocRelatedId(String basicInfoId) {
		return basicinfoMapper.selectDocRelatedId(basicInfoId);
	}

	@Override
	public PageInfo<BasicInfo> findBasicInfoListbyDto(BasicInfoDto record)
			throws UnitedException {
		PageHelper.startPage(record.getPageNum(), record.getPageSize(), true);
		List<BasicInfo> list = basicinfoMapper
				.findBasicInfoListbyDto(record);
		return new PageInfo<BasicInfo>(list);

	}

	@Override
	public OnePaper selectPaperById(String paperid) throws UnitedException {
		return basicinfoMapper.selectPaperById(paperid);
	}

	@Override
	public List<DataDictionary> selectTreeLi(String id) throws UnitedException {
		List<DataDictionary> datas = new ArrayList<DataDictionary>();
		for (int i = 0; i < 5; i++) {
			DataDictionary data = new DataDictionary();
			if((i+1) == Long.valueOf(id))
				data.setType("1");
			switch (i+1) {
				case 1:
					data.setDisplay("A轮");
					break;
				case 2:
					data.setDisplay("B轮");
					break;
				case 3:
					data.setDisplay("C轮");
					break;
				case 4:
					data.setDisplay("D轮");
					break;
				case 5:
					data.setDisplay("E轮");
					break;
				default:
					break;
			}
			data.setCode(String.valueOf(i+1));
			datas.add(data);
		}
		return datas;
		//return basicinfoMapper.selectTreeLi(id);
	}

	@Override
	public void updateByIdBasicInfo(BasicInfo basicInfo) throws UnitedException {
		basicinfoMapper.updateByIdBasicInfo(basicInfo);
	}

	@Override
	public void insertBasicInfo(BasicInfo basicInfo) throws UnitedException {
		basicinfoMapper.insertBasicInfo(basicInfo);
	}

	@Override
	public void insertPreFunding(PreFunding preFunding) throws UnitedException {
		basicinfoMapper.insertPreFunding(preFunding);
	}

	@Override
	public void updatePreFunding(PreFunding preFunding) throws UnitedException {
		basicinfoMapper.updatePreFunding(preFunding);
	}

	@Override
	public void insertPostFunding(PostFunding postFunding)
			throws UnitedException {
		basicinfoMapper.insertPostFunding(postFunding);
	}

	@Override
	public void updatePostFunding(PostFunding postFunding)
			throws UnitedException {
		basicinfoMapper.updatePostFunding(postFunding);
	}

	@Override
	public void deleteByPrimaryKeyAll(Map<String, Object> map)
			throws UnitedException {
		basicinfoMapper.deleteByPrimaryKeyAll(map);
	}

	@Override
	public void insertDocument(DocumentEntity obj) throws UnitedException {
		basicinfoMapper.insertDocument(obj);
	}

	@Override
	public void updateDocument(DocumentEntity obj) {
		basicinfoMapper.updateDocument(obj);
	}

	@Override
	public Object getComplianceDealTeamObj(commonTeamDto dto) {
		return basicinfoMapper.getComplianceDealTeamObj(dto);
	}

	@Override
	public Object getComplianceLegalTeamObj(commonTeamDto dto) {
		return basicinfoMapper.getComplianceLegalTeamObj(dto);
	}

	@Override
	public Object getConfirmationLegalTeamObj(commonTeamDto dto) {
		return basicinfoMapper.getConfirmationLegalTeamObj(dto);
	}

	@Override
	public Object getConfirmationDealObj(commonTeamDto dto) {
		return basicinfoMapper.getConfirmationDealObj(dto);
	}

	@Override
	public void insertTeam(Map<String, Object> maps) {
		basicinfoMapper.insertTeam(maps);
	}

	@Override
	public void deleteTeam(String basicInfoId) {
		basicinfoMapper.deleteTeam(basicInfoId);
	}

	@Override
	public String selectLisgaggStr(String basicInfoId, String teamType) {
		return basicinfoMapper.selectLisgaggStr(basicInfoId, teamType);
	}

}
