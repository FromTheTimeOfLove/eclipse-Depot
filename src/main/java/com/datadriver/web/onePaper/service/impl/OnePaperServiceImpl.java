package com.datadriver.web.onePaper.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.core.generic.GenericServiceImpl;
import com.datadriver.core.util.Utils;
import com.datadriver.web.onePaper.dao.OnePaperDao;
import com.datadriver.web.onePaper.dto.CustomerDto;
import com.datadriver.web.onePaper.dto.OnePaperDto;
import com.datadriver.web.onePaper.model.FileDoc;
import com.datadriver.web.onePaper.model.OnePaper;
import com.datadriver.web.onePaper.service.OnePaperService;
import com.datadriver.web.system.model.SystemUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: OnePaperServiceImpl
 * @Description: One Paper业务实现类
 * @Date 2016-4-12 下午2:20:43
 */
@Service
public class OnePaperServiceImpl extends GenericServiceImpl<OnePaper, Long>
		implements OnePaperService {

	@Resource
	private OnePaperDao onePaperDao;

	@Override
	public GenericDao<OnePaper, Long> getDao() {
		return onePaperDao;
	}

	@Override
	public int insert(OnePaper model) throws UnitedException {
		return super.insert(model);
	}

	@Override
	public int update(OnePaper model) throws UnitedException {
		return super.update(model);
	}

	@Override
	public int delete(Long id) throws UnitedException {
		return super.delete(id);
	}

	@Override
	public OnePaper selectById(Long id) throws UnitedException {
		return super.selectById(id);
	}

	@Override
	public PageInfo<OnePaper> selectOnePaperListbyDto(OnePaperDto record)
			throws UnitedException {
		PageHelper.startPage(record.getPageNum(), record.getPageSize(), true);
		List<OnePaper> onePapers = onePaperDao.selectOnePaperList(record);
		return new PageInfo<OnePaper>(onePapers);
	}

	@Override
	public void insertOnepaper(OnePaperDto record, SystemUser systemuser)
			throws UnitedException {
		// TODO Auto-generated method stub
		if (!Utils.isEmpty(record.getAttachmentname())
				&& !Utils.isEmpty(record.getAttachmentload())) {
			// 获取文档表的主键ID值。
			String docid = onePaperDao.getDocid();
			// 向文档表存入一条记录
			FileDoc doc = new FileDoc();
			doc.setDocid(docid);
			doc.setDocpath(record.getAttachmentload());
			doc.setDocname(record.getAttachmentname());
			doc.setUploaderid(systemuser.getUserId());
			doc.setUploadername(systemuser.getUserName());
			// 录入文档文件
			onePaperDao.saveDoc(doc);

			record.setAttachmentid(docid);
		}
		// 录入Onepaper记录
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			record.setVdpdate(sdf.parse(record.getDpdate()));
		} catch (Exception e) {
			System.out.println("该异常可以忽略");
		}
		record.setUserid(systemuser.getUserId());
		onePaperDao.saveOnepaper(record);
	}

	@Override
	public void updateOnepaper(OnePaperDto record, SystemUser systemuser)
			throws UnitedException {
		if (!Utils.isEmpty(record.getAttachmentname())
				&& !Utils.isEmpty(record.getAttachmentload())) {
			// 根据paperid里面的docid修改p-file表
			String docid = record.getAttachmentid();
			// 向文档表存入一条记录
			FileDoc doc = new FileDoc();
			doc.setDocpath(record.getAttachmentload());
			doc.setDocname(record.getAttachmentname());
			doc.setUploaderid(systemuser.getUserId());
			doc.setUploadername(systemuser.getUserName());
			if (docid == null || "".equals(docid)) {// 标示没有
				String num = onePaperDao.getDocid();
				doc.setDocid(num);// 获取一个sqe值
				// 此时做新增处理
				onePaperDao.saveDoc(doc);
				record.setAttachmentid(num);
			} else {
				doc.setDocid(docid);
				onePaperDao.updateDoc(doc);
			}
		} else {
			record.setAttachmentid("");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			record.setVdpdate(sdf.parse(record.getDpdate()));
		} catch (Exception e) {
			System.out.println("该异常可以忽略");
		}
		onePaperDao.updateOnepaper(record);
	}

	@Override
	public void deleteOnepaper(String id) throws UnitedException {
		// TODO Auto-generated method stub
		String str[] = id.split(",");
		// 删除Onepaper
		onePaperDao.deleteOnepaper(str[0]);
		if (str.length > 1 && !"undefined".equals(str[1])) {
			// 删除文档
			onePaperDao.deleteDoc(str[1]);
		}

	}

	@Override
	public OnePaperDto selectOnePaperById(int paperid) throws UnitedException {
		// TODO Auto-generated method stub
		OnePaperDto t = onePaperDao.selectOnePaperById(paperid);
		if (!Utils.isEmpty(t.getDpdate())) {
			t.setDpdate(t.getDpdate().substring(0, 10));
		}
		return t;
	}

	@Override
	public PageInfo<CustomerDto> selectCustomerDto(CustomerDto record)
			throws UnitedException {
		PageHelper.startPage(record.getPageNum(), record.getPageSize(), true);
		List<CustomerDto> onePapers = onePaperDao.selectCustomerDto(record);
		return new PageInfo<CustomerDto>(onePapers);
	}

	@Override
	public String findPortfolioname(OnePaperDto record) {
		// TODO Auto-generated method stub
		// 判断Portfolio name (CH)是否存在
		int count1 = onePaperDao.findPortfolionameCH(record
				.getPortfolionameCH());
		if (count1 >= 1) {// 标示数据库已经存在PortfolionameCH
			return "PortfolionameCH已经存在";
		} else {// 标示数据库不存在
			int count2 = onePaperDao.findPortfolionameEN(record
					.getPortfolionameEN());
			if (count2 >= 1) {// 标示数据库已经存在PortfolionameEN
				return "PortfolionameEN已经存在";
			}
			return "true";
		}
	}

	@Override
	public String updatePortfolioname(OnePaperDto record) {
		// TODO Auto-generated method stub
		// 判断Portfolio name (CH)是否存在
		int count1 = onePaperDao.updatePortfolionameCH(record);
		if (count1 >= 1) {// 标示数据库已经存在PortfolionameCH
			return "PortfolionameCH已经存在";
		} else {// 标示数据库不存在
			int count2 = onePaperDao.updatePortfolionameEN(record);
			if (count2 >= 1) {// 标示数据库已经存在PortfolionameEN
				return "PortfolionameEN已经存在";
			}
			return "true";
		}
	}
}
