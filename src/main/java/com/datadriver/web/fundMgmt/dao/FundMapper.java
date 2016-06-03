package com.datadriver.web.fundMgmt.dao;


import java.math.BigDecimal;
import java.util.List;

import com.datadriver.core.generic.GenericDao;
import com.datadriver.web.fundMgmt.model.Fund;

public interface FundMapper extends GenericDao<Fund, Long> {
	
	List<Fund> selectFundPage(Object fund);
	
	Long isRepeat(Object fund);
}