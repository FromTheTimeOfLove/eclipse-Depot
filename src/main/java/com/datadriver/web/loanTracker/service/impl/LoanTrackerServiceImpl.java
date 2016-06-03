package com.datadriver.web.loanTracker.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.core.generic.GenericServiceImpl;
import com.datadriver.web.loanTracker.dao.LoanTrackerDao;
import com.datadriver.web.loanTracker.dto.LoanTrackerDto;
import com.datadriver.web.loanTracker.model.LoanTracker;
import com.datadriver.web.loanTracker.service.LoanTrackerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: LoanTrackerServiceImpl
 * @Description: LoanTracker业务实现类
 * @Date 2016-4-12 下午2:20:43
 */
@Service
public class LoanTrackerServiceImpl extends GenericServiceImpl<LoanTracker, Long>
		implements LoanTrackerService {
	
	@Resource
	private LoanTrackerDao loanTrackerDao;

	@Override
	public int insert(LoanTracker model) throws UnitedException {
		return super.insert(model);
	}

	@Override
	public int update(LoanTracker model) throws UnitedException {
		return super.update(model);
	}

	@Override
	public int delete(Long id) throws UnitedException {
		return super.delete(id);
	}

	@Override
	public LoanTracker selectById(Long id) throws UnitedException {
		return super.selectById(id);
	}

	@Override
	public PageInfo<LoanTracker> selectLoanTrackerListbyDto(LoanTrackerDto record)
			throws UnitedException {
		PageHelper.startPage(record.getPageNum(), record.getPageSize(), true);
		List<LoanTracker> LoanTrackers = new ArrayList<LoanTracker>();
		int cid = 10000;
		for (int i = 0; i < 10; i++) {
			LoanTracker one = new LoanTracker(String.valueOf(cid++),"fund", "Investment Entity", "Company", "Loan Amount"
					, "Date Issued", "Expiry", "Interest Rate", "Expired interest rate", "company's shares", "Pledged Entity"
					, "Personal Guarantee", "recovered", "Date Converted or Repaid", "Days O/S", "Aging", "Note");
			LoanTrackers.add(one);
		}
		//LoanTrackerDao.selectLoanTrackerList(record)
		return new PageInfo<LoanTracker>(LoanTrackers);
	}

	@Override
	public GenericDao<LoanTracker, Long> getDao() {
		return loanTrackerDao;
	}
}
