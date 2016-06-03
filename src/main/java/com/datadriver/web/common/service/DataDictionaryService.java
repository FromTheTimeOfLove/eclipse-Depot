package com.datadriver.web.common.service;

import java.util.List;

import com.datadriver.web.common.model.DataDictionary;

public interface DataDictionaryService {
	List<DataDictionary> selectByType(String type);
	
	List<DataDictionary> selectUsers();
	
	List<DataDictionary> selectFunds();
}
