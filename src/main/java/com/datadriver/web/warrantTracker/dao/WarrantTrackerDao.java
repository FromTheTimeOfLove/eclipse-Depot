package com.datadriver.web.warrantTracker.dao;

import java.util.List;

import com.datadriver.core.generic.GenericDao;
import com.datadriver.web.loanTracker.model.LoanTracker;
import com.datadriver.web.warrantTracker.model.WarrantTracker;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: LoanTrackerDao
 * @Description: dao
 * @Date 2016-4-14 上午9:56:10
 */
public interface WarrantTrackerDao extends GenericDao<WarrantTracker, Long> {
	/**
	 * 按条件查询
	 * @Title: selectWarrantTrackerList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param obj
	 * @return List<WarrantTracker> 返回类型
	 */
	public List<WarrantTracker> selectWarrantTrackerList(Object obj);
}
