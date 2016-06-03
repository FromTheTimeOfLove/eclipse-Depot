package com.datadriver.web.warrantTracker.service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericService;
import com.datadriver.web.warrantTracker.dto.WarrantTrackerDto;
import com.datadriver.web.warrantTracker.model.WarrantTracker;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: WarrantTrackerService
 * @Description: 业务接口
 * @Date 2016-4-14 上午10:14:48
 */
public interface WarrantTrackerService extends GenericService<WarrantTracker, Long> {
	/**
	 * 按条件查询
	 * @Title: selectWarrantTrackerListbyDto
	 * @Description: 按条件查询
	 * @param record
	 * @return
	 * @throws UnitedException PageInfo<WarrantTracker> 返回类型
	 */
	PageInfo<WarrantTracker> selectWarrantTrackerListbyDto(WarrantTrackerDto record) throws UnitedException;
}
