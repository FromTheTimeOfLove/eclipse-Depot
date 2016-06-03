package com.datadriver.web.common.dao;

import java.util.List;

import com.datadriver.web.common.model.DataDictionary;

public interface DataDictionaryMapper {
	List<DataDictionary> selectByType(String type);
	
	List<DataDictionary> selectUsers();
	
	public List<DataDictionary> selectFunds();
}
