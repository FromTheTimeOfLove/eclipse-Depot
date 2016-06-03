package com.datadriver.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.datadriver.core.entity.UnitedLogger;
import com.datadriver.core.export.ExcelFile;

import net.sf.excelutils.ExcelUtils;

/**
* @ClassName: WebServiceUtils
* @Description: WebService帮助类
* @date 2016-4-5 下午1:27:14
 */
public class Utils {
	public static StringBuffer	filePackage;
	public static StringBuffer	filename;
	public static String config;
	
	/**
	 * 
	 * @Title: isObj
	 * @Description: 根据请求值执行相应操作
	 * @param is
	 * @param objects void 返回类型
	 */
	@SuppressWarnings("all")
	public static void isObj(Integer is, Object[] objects) {
		switch (is) {
			case 1:
				ExcelUtils.addValue("list", objects[0]);
				break;
			case 2:
				ExcelUtils.addValue("bean", objects[0]);
				break;
			case 3://多集合
				for (int i = 0; i < objects.length; i++) {
					ExcelUtils.addValue("list" + (i+1), objects[i]);
				}
				break;
			case 4://集合与对象，参数位置顺序要对
				ExcelUtils.addValue("bean", objects[0]);
				ExcelUtils.addValue("list", objects[1]);
				break;
			case 5://多集合与对象，参数位置顺序要对
				ExcelUtils.addValue("bean", objects[0]);
				for (int i = 1; i < objects.length; i++) {
					ExcelUtils.addValue("list" + (i+1), objects[i]);
				}
				break;
			default:
				ExcelUtils.addValue("list", objects[0]);
				break;
		}
	}
	
	/**
	 * 通用-通过模板导出方法
	 * 
	 * @return
	 */
	public static void export(ExcelFile excelFile
			, HttpServletRequest request
			, HttpServletResponse response) {
		try {
			ExcelUtils.addValue("title", excelFile.getTitle()); 
			ExcelUtils.addValue("headTitle", excelFile.getHeadTitle());
			//区分是集合或是兑换,亦或者是多集合或集合与对象等
			isObj(excelFile.getIsObj(), excelFile.getObjs());
			if(!Utils.isEmpty(excelFile.getFile())) {
				Utils.config = request.getSession().getServletContext().getRealPath("/WEB-INF/xls/" + excelFile.getFile());
			} else {
				
			}
			// 为每个用户创建一个导出文件夹
			excelFile.setFilePackage(PropertiesUtil.loadValue("/path.properties", "excelFilePath") 
					+ "/" + DateUtil.parseFormatYYYYMM(new Date()) + "/excel");
			excelFile.setFilename(excelFile.getTitle() + "-(" + DateUtil.getYMDTO(new Date()) + ")" + ".xls");
			excelFile.setFilename(new String(excelFile.getFilename().getBytes("gb2312"), "iso8859-1"));
			Utils.filePackage = new StringBuffer(excelFile.getFilePackage());
			Utils.filename = new StringBuffer(excelFile.getFilename());
			File filex = new File(String.valueOf(filePackage));
			if(!filex.exists()) {
				filex.mkdirs();
			}
			System.out.println("----------------------------");
			System.out.println("Start export excel.....");
			
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ new String(excelFile.getFile().getBytes(), "iso8859-1"));
			FileOutputStream out = new FileOutputStream(filePackage + "/" + filename);
			ExcelUtils.export(config, out);
            InputStream inputStream = new FileInputStream(filePackage + "/" + filename);  
			OutputStream ouputStream = response.getOutputStream();
			byte[] b = new byte[1024];
			int length;  
            while((length = inputStream.read(b)) > 0){  
            	ouputStream.write(b, 0, length);  
            }  
            inputStream.close();  
			ouputStream.flush();     
	        ouputStream.close();
			System.out.println("End export excel!");
			System.out.println("----------------------------");
		} catch (Exception ex) {
			System.out.println("Excel error");
			System.out.println("----------------------------");
			UnitedLogger.error(ex);
		}
	}
	
	/**
	 * 是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null || "".equals(obj)) {
			return true;
		}
		if (obj instanceof Collection) {
			@SuppressWarnings("rawtypes")
			Collection coll = (Collection) obj;
			if (coll.size() <= 0) {
				return true;
			}
		}
		if (obj instanceof Map) {
			@SuppressWarnings("rawtypes")
			Map map = (Map) obj;
			return map.isEmpty();
		}
		if(obj instanceof Object []) {
			Object[] objs = (Object [])obj;
			if(objs.length > 0) {
				boolean flag = false;
				for (Object objl : objs) {
					if(objl instanceof String) {
						String str = (String)objl;
						if (str == null || str == "null" || "".equals(str) || str.length() <= 0) {
							flag = true;
							break;
						}
					}
				}
				return flag;
			}
		}
		return false;
	}
	
	/**
	 * 是否是整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String... strs) {
		if (isEmpty(strs))
			return false;
		Pattern pattern = Pattern.compile("\\d*");
		boolean isNumber = true;
		for (String str : strs) {
			isNumber = pattern.matcher(str).matches();
		}
		return isNumber;
	}
	
	/**
	 * 
	 * @Title: replaceSymbol
	 * @Description: 替换符号
	 * @param str
	 * @param oldSymbol
	 * @param newSymbol
	 * @return String 返回类型
	 */
	public static String replaceSymbol(String str,String oldSymbol,String newSymbol) {
		if(!Utils.isEmpty(str)) {
			str = str.replace(oldSymbol, newSymbol);
		}
		return str;
	}
}
