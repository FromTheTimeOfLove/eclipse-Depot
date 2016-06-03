package com.datadriver.web.upload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.datadriver.core.util.PropertiesUtil;
import com.datadriver.core.util.Utils;

/**
 * @ClassName: OnePaperController
 * @Description: One paper控制类
 * @date 2016-3-22 上午10:48:57
 */
@Controller
@RequestMapping(value = "/commonUpload")
public class UploadController {

	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	@ResponseBody
	public String upload(Model model, HttpServletRequest request,
			@RequestParam(value = "file") MultipartFile file) {
		String fileName = null;
		String path = null;
		try {
			//path = request.getSession().getServletContext().getRealPath("/doc/");

			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
			String str = format.format(new Date());
			path = PropertiesUtil.loadValue("/path.properties", "path");

			String orgName = file.getOriginalFilename();
			if(Utils.isEmpty(orgName)) 
				return "";
			String buff = orgName.substring(orgName.lastIndexOf("."));
			fileName = new Date().getTime() + buff;

			path = path + (path.endsWith("/") ? "" : "/") + str
					+ (path.endsWith("/") ? "" : "/") + fileName;

			InputStream in = file.getInputStream();
			File to = new File(path);
			FileUtils.copyInputStreamToFile(in, to);

		} catch (IOException e) {
			fileName = null;
			e.printStackTrace();
		}
		return path;
	}
}
