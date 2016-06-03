package com.datadriver.web.loanTracker.dao;

import java.util.List;

import com.datadriver.core.generic.GenericDao;
import com.datadriver.web.loanTracker.model.LoanTracker;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: LoanTrackerDao
 * @Description: dao
 * @Date 2016-4-14 上午9:56:10
 */
public interface LoanTrackerDao extends GenericDao<LoanTracker, Long> {
	/**
	 * 按条件查询LoanTracker
	 * @Title: selectLoanTrackerList
	 * @Description: 
	 * @param obj
	 * @return List<LoanTracker> 返回类型
	 */
	public List<LoanTracker> selectLoanTrackerList(Object obj);
}
