package com.datadriver.web.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datadriver.core.util.Utils;
import com.datadriver.web.common.dao.DataDictionaryMapper;
import com.datadriver.web.common.model.DataDictionary;
import com.datadriver.web.common.service.DataDictionaryService;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
	
	@Resource
	private DataDictionaryMapper	dataDictionaryMapper;
	
	@Override
	public List<DataDictionary> selectByType(String type) {
		if (type == null || ("").equals(type.trim())) {
			return null;
		}
		return dataDictionaryMapper.selectByType(type);
	}

	@Override
	public List<DataDictionary> selectUsers() {
		return dataDictionaryMapper.selectUsers();
	}

	@Override
	public List<DataDictionary> selectFunds() {
		return dataDictionaryMapper.selectFunds();
	}
	
}
