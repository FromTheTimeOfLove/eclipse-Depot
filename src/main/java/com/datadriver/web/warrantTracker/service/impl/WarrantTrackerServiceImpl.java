package com.datadriver.web.warrantTracker.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.core.generic.GenericServiceImpl;
import com.datadriver.web.warrantTracker.dao.WarrantTrackerDao;
import com.datadriver.web.warrantTracker.dto.WarrantTrackerDto;
import com.datadriver.web.warrantTracker.model.WarrantTracker;
import com.datadriver.web.warrantTracker.service.WarrantTrackerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: WarrantTrackerServiceImpl
 * @Description: WarrantTracker业务实现类
 * @Date 2016-4-12 下午2:20:43
 */
@Service
public class WarrantTrackerServiceImpl extends GenericServiceImpl<WarrantTracker, Long>
		implements WarrantTrackerService {
	
	@Resource
	private WarrantTrackerDao warrantTrackerDao;

	@Override
	public int insert(WarrantTracker model) throws UnitedException {
		return super.insert(model);
	}

	@Override
	public int update(WarrantTracker model) throws UnitedException {
		return super.update(model);
	}

	@Override
	public int delete(Long id) throws UnitedException {
		return super.delete(id);
	}

	@Override
	public WarrantTracker selectById(Long id) throws UnitedException {
		return super.selectById(id);
	}

	@Override
	public PageInfo<WarrantTracker> selectWarrantTrackerListbyDto(WarrantTrackerDto record)
			throws UnitedException {
		PageHelper.startPage(record.getPageNum(), record.getPageSize(), true);
		List<WarrantTracker> WarrantTrackers = new ArrayList<WarrantTracker>();
		int cid = 10000;
		for (int i = 0; i < 10; i++) {
			WarrantTracker one = new WarrantTracker(String.valueOf(cid++),"COMPANY", "PARTNER", "Imminent exit?", "FUND"
					, "Warrants OWNED", "CLASS", "PURCHASE PRICE", "EXERCISE PRICE/SH", "TOTAL EXERCISE COST", "FV/SH"
					, "TOTAL FV", "COMMENTS", "Quist Valuation?", "Value per Quist", "Difference", "Notes");
			WarrantTrackers.add(one);
		}
		//WarrantTrackerDao.selectWarrantTrackerList(record)
		return new PageInfo<WarrantTracker>(WarrantTrackers);
	}

	@Override
	public GenericDao<WarrantTracker, Long> getDao() {
		return warrantTrackerDao;
	}
}
