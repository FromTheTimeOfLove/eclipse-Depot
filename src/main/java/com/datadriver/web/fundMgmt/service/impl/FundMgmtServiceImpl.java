package com.datadriver.web.fundMgmt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.core.generic.GenericServiceImpl;
import com.datadriver.web.fundMgmt.dao.FundMapper;
import com.datadriver.web.fundMgmt.dto.FundDto;
import com.datadriver.web.fundMgmt.model.Fund;
import com.datadriver.web.fundMgmt.service.FundMgmtService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class FundMgmtServiceImpl extends GenericServiceImpl<Fund, Long> implements FundMgmtService{

	@Resource
	private FundMapper fundMapper; 

	@Override
	public PageInfo<Fund> selectFundPage(FundDto fundDto) throws UnitedException {
		PageHelper.startPage(fundDto.getPageNum(), fundDto.getPageSize());
		List<Fund> list = fundMapper.selectFundPage(fundDto);
		return new PageInfo<Fund>(list);
	}
	
	@Override
	public Long isRepeat(Fund fund) throws UnitedException {
		return fundMapper.isRepeat(fund);
	}

	@Override
	public GenericDao<Fund, Long> getDao() {
		return fundMapper;
	}

	
}
