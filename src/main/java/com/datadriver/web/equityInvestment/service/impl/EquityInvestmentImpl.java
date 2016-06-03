package com.datadriver.web.equityInvestment.service.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.datadriver.core.entity.UnitedException;
import com.datadriver.core.generic.GenericDao;
import com.datadriver.core.generic.GenericServiceImpl;
import com.datadriver.core.util.DateUtil;
import com.datadriver.core.util.OrderProperties;
import com.datadriver.web.equityInvestment.dao.EquityInvestmentMapper;
import com.datadriver.web.equityInvestment.dto.EquityInvestmentDto;
import com.datadriver.web.equityInvestment.model.EquityDealTeam;
import com.datadriver.web.equityInvestment.model.EquityInvestment;
import com.datadriver.web.equityInvestment.model.EquityInvestmentPage;
import com.datadriver.web.equityInvestment.service.EquityInvestmentService;
import com.datadriver.web.file.model.DocumentEntity;
import com.datadriver.web.onePaper.model.OnePaper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: BasicInfoServiceImpl
 * @Description: 业务实现类
 * @Date 2016-4-19 下午5:55:01
 */
@Service
public class EquityInvestmentImpl extends GenericServiceImpl<EquityInvestment, Long> implements
		EquityInvestmentService {
	
	@Resource
	private EquityInvestmentMapper	equityInvestmentMapper;	// 调用接口
															
	@Override
	public GenericDao<EquityInvestment, Long> getDao() {
		return equityInvestmentMapper;
	}
	
	@Override
	public PageInfo<EquityInvestment> findEquityInvestmentListbyDto(EquityInvestmentDto record)
			throws UnitedException {
		PageHelper.startPage(record.getPageNum(), record.getPageSize(), true);
		List<EquityInvestment> list = equityInvestmentMapper.findEquityInvestmentListbyDto(record);
		return new PageInfo<EquityInvestment>(list);
	}
	
	@Override
	public OnePaper selectPaperById(String paperid) throws UnitedException {
		return equityInvestmentMapper.selectPaperById(paperid);
	}
	
	@Override
	public EquityInvestment queryEquityInvestmentObj(String equityInvestmentId) {
		return equityInvestmentMapper.queryEquityInvestmentObj(equityInvestmentId);
	}
	
	@Override
	public void insertDocument(DocumentEntity obj) throws UnitedException {
		equityInvestmentMapper.insertDocument(obj);
	}
	
	@Override
	public void updateDocument(DocumentEntity obj) {
		equityInvestmentMapper.updateDocument(obj);
	}
	
	@Override
	public List<EquityInvestmentPage> findEquityInvestmentByPaper(String equityInvestmentId) {
		return equityInvestmentMapper.findEquityInvestmentByPaper(equityInvestmentId);
	}
	
	@Override
	public void insertTeam(Map<String, Object> maps) {
		equityInvestmentMapper.insertTeam(maps);
	}
	
	@Override
	public void deleteTeam(String equityInvestmentId) {
		equityInvestmentMapper.deleteTeam(equityInvestmentId);
	}
	
	@Override
	public String selectLisgaggStr(String equityInvestmentId, String teamType) {
		return equityInvestmentMapper.selectLisgaggStr(equityInvestmentId, teamType);
	}
	
	@Override
	public Map<String, Object> selectDocRelatedId(String equityInvestmentId) {
		return equityInvestmentMapper.selectDocRelatedId(equityInvestmentId);
	}
	
	@Override
	public void deleteByPrimaryKeyAll(Map<String, Object> map)
			throws UnitedException {
		equityInvestmentMapper.deleteByPrimaryKeyAll(map);
	}

	@Override
	public void toExcel(HttpServletResponse response, Map teamMap,String pathName) throws IOException {
		String dateStrign = DateUtil.getYMDTO(new Date());
		// 获取文件名
		String fileName = pathName + "-" + dateStrign + ".xls";
		
		// 创建Excel的工作书册 Workbook,对应到一个excel文档
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("第" + 1 + "页");
		// 设置excel每列宽度
		sheet.setColumnWidth(0, 150*256);
		sheet.setColumnWidth(1, 10*256);
		// 创建第一列单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setWrapText(true);//设置自动换行
		// 创建第二列单元格样式
		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//
		/*********** 创建页 ****************/
		/***************** 创建标题和表头 *****************/
		// 创建第一行,标题行
		HSSFRow row = sheet.createRow(0);
		row.setHeight((short) 500);// 设定行的高度
		HSSFCell cell = row.createCell(0);
		cell.setCellStyle(style1);
		cell.setCellValue("title");
		HSSFCell cell1 = row.createCell(1);
		cell1.setCellStyle(style1);
		cell1.setCellValue("Y OR N");
		//读取配置文件中的问题和对应的map主键
		Properties prop = new OrderProperties();     
		InputStream in = this.getClass().getResourceAsStream("/"+pathName+".properties");
		prop.load(in);     ///加载属性列表 
		Iterator<String> it=prop.stringPropertyNames().iterator();
		int i = 0;
		//从第二行开始,为每行添加数据
		while(it.hasNext()){
			i++;
			// 创建行
			row = sheet.createRow((i));
			row.setHeight((short) 500);
			//标题
			String key = it.next();
			HSSFCell cell2 = row.createCell(0);
			cell2.setCellStyle(style);
			cell2.setCellValue(key);
			//选项
			HSSFCell cell3 = row.createCell(1);
			cell3.setCellStyle(style1);
			if("0".equals(teamMap.get(prop.getProperty(key)))){
				cell3.setCellValue("Y");
			}else if ("1".equals(teamMap.get(prop.getProperty(key)))){
				cell3.setCellValue("N");
			}
		}
		in.close();
		
		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename="
				+ new String((fileName).getBytes(), "iso8859-1") + "");
		OutputStream ouputStream = response.getOutputStream();     
        wb.write(ouputStream);     
        ouputStream.flush();     
        ouputStream.close();   
	}
}
