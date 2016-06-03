package com.datadriver.web.basicExit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.core.generic.GenericServiceImpl;
import com.datadriver.web.basicExit.dao.BasicExitMapper;
import com.datadriver.web.basicExit.dto.BasicExitDto;
import com.datadriver.web.basicExit.model.BasicExit;
import com.datadriver.web.basicExit.service.BasicExitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: BasicExitServiceImpl
 * @Description: 业务实现类
 * @Date 2016-4-12 下午2:20:43
 */
@Service
public class BasicExitServiceImpl extends GenericServiceImpl<BasicExit, Long>
		implements BasicExitService {
	
	@Resource
	private BasicExitMapper basicExitMapper;

	@Override
	public int insert(BasicExit model) throws UnitedException {
		return super.insert(model);
	}

	@Override
	public int update(BasicExit model) throws UnitedException {
		return super.update(model);
	}

	@Override
	public int delete(Long id) throws UnitedException {
		return super.delete(id);
	}

	@Override
	public BasicExit selectById(Long id) throws UnitedException {
		return super.selectById(id);
	}

	@Override
	public PageInfo<BasicExit> selectBasicExitListbyDto(BasicExitDto record)
			throws UnitedException {
		PageHelper.startPage(record.getPageNum(), record.getPageSize(), true);
		List<BasicExit> basicExits = basicExitMapper.selectBasicExitList(record);
		return new PageInfo<BasicExit>(basicExits);
	}

	@Override
	public GenericDao<BasicExit, Long> getDao() {
		return basicExitMapper;
	}

	@Override
	public List<BasicExit> findRowDetails(String id) throws UnitedException {
		return basicExitMapper.findRowDetails(id);
	}

	@Override
	public BasicExit selectByPaperId(String id) throws UnitedException {
		return basicExitMapper.selectByPaperId(id);
	}

}
