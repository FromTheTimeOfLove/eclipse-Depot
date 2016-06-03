package com.datadriver.web.tsSigned.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.core.generic.GenericServiceImpl;
import com.datadriver.core.util.Utils;
import com.datadriver.web.onePaper.model.FileDoc;
import com.datadriver.web.system.model.SystemUser;
import com.datadriver.web.tsSigned.dao.TsSignedDao;
import com.datadriver.web.tsSigned.dto.TsSignedDto;
import com.datadriver.web.tsSigned.model.TsSigned;
import com.datadriver.web.tsSigned.service.TsSignedService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: TsSignedServiceImpl
 * @Description: 业务实现类
 * @Date 2016-4-12 下午2:20:43
 */
@Service
public class TsSignedServiceImpl extends GenericServiceImpl<TsSigned, Long>
		implements TsSignedService {
	
	@Resource
	private TsSignedDao tsSignedDao;

	@Override
	public int insert(TsSigned model) throws UnitedException {
		return super.insert(model);
	}

	@Override
	public int update(TsSigned model) throws UnitedException {
		return super.update(model);
	}

	@Override
	public int delete(Long id) throws UnitedException {
		return super.delete(id);
	}

	@Override
	public TsSigned selectById(Long id) throws UnitedException {
		return super.selectById(id);
	}

	@Override
	public PageInfo<TsSigned> selectTsSignedListbyDto(TsSignedDto record)
			throws UnitedException {
		PageHelper.startPage(record.getPageNum(), record.getPageSize(), true);
		List<TsSigned> TsSigneds = new ArrayList<TsSigned>();
		TsSigneds = tsSignedDao.selectTsSignedListbyDto(record);
		return new PageInfo<TsSigned>(TsSigneds);
	}

	@Override
	public GenericDao<TsSigned, Long> getDao() {
		return tsSignedDao;
	}

	@Override
	public TsSigned selectTsSignedById(String tsSignedId) {
		return tsSignedDao.selectTsSignedById(tsSignedId); 
	}

	@Override
	public void updateThruDate(String tsSignedId) {
		String str[] = tsSignedId.split(",");
		tsSignedDao.updateThruDate(str[0]);
		// 删除文档
		if(str.length==2)
		tsSignedDao.deleteDoc(str[1]);
	}
	
	@Override
	public void insertTsSigned(TsSigned tsSigned, SystemUser systemuser){
		try {
			if(!Utils.isEmpty(tsSigned.getAttachmentname()) && !Utils.isEmpty(tsSigned.getAttachmentload())){
				// 向文档表存入一条记录
				FileDoc doc = new FileDoc();
				doc.setDocpath(tsSigned.getAttachmentload());
				doc.setDocname(tsSigned.getAttachmentname());
				doc.setUploaderid(systemuser.getUserId());
				doc.setUploadername(systemuser.getUserName());
				// 录入文档文件
				tsSignedDao.saveDoc(doc);
				tsSigned.setAttachmentid(doc.getDocid());
			}
			tsSignedDao.insertTsSigned(tsSigned);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateTsSigned(TsSigned tsSigned, SystemUser systemuser) {
		// 向文档表存入一条记录
		try {
			if (!Utils.isEmpty(tsSigned.getAttachmentname())
					&& !Utils.isEmpty(tsSigned.getAttachmentload())) {
				FileDoc doc = new FileDoc();
				doc.setDocpath(tsSigned.getAttachmentload());
				doc.setDocname(tsSigned.getAttachmentname());
				doc.setUploaderid(systemuser.getUserId());
				doc.setUploadername(systemuser.getUserName());
				// 录入文档文件
				if(tsSigned.getAttachmentid()==null || "".equals(tsSigned.getAttachmentid())){//判断文档是否存在
					tsSignedDao.saveDoc(doc);
					tsSigned.setAttachmentid(doc.getDocid());
				}else{
					doc.setDocid(tsSigned.getAttachmentid());
					tsSignedDao.updateDoc(doc);
				}
			}else{
				tsSignedDao.deleteDoc(tsSigned.getAttachmentid());
				tsSigned.setAttachmentid("");
			}
			tsSignedDao.updateTsSigned(tsSigned);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public TsSigned selectOnepaparById(String paperId) {
		return tsSignedDao.selectOnepaparById(paperId);
	}
}
