package com.datadriver.web.loanTracker.service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericService;
import com.datadriver.web.loanTracker.dto.LoanTrackerDto;
import com.datadriver.web.loanTracker.model.LoanTracker;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: LoanTrackerService
 * @Description: LoanTracker业务类
 * @Date 2016-4-14 上午9:58:49
 */
public interface LoanTrackerService extends GenericService<LoanTracker, Long> {
	/**
	 * 按条件查询
	 * @Title: selectLoanTrackerListbyDto
	 * @Description: 按条件查询
	 * @param record
	 * @return
	 * @throws UnitedException PageInfo<LoanTracker> 返回类型
	 */
	PageInfo<LoanTracker> selectLoanTrackerListbyDto(LoanTrackerDto record) throws UnitedException;
}
