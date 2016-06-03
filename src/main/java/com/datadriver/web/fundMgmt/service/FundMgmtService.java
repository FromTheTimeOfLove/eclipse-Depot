package com.datadriver.web.fundMgmt.service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericService;
import com.datadriver.web.fundMgmt.dto.FundDto;
import com.datadriver.web.fundMgmt.model.Fund;
import com.github.pagehelper.PageInfo;

public interface FundMgmtService extends GenericService<Fund, Long>{
	
	PageInfo<Fund> selectFundPage(FundDto fundDto) throws UnitedException;
	
	Long isRepeat(Fund fund) throws UnitedException;
}
