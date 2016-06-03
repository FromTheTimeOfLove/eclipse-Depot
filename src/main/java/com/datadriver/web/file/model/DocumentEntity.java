package com.datadriver.web.file.model;

import com.datadriver.web.user.model.User;

/**
 * 
 * @Acthor：hurentao
 * @ClassName: FileEntity
 * @Description: 文档实体
 * @Date 2016-4-25 上午10:24:55
 */
public class DocumentEntity {
	
	private String fileId;//文档标识
	
	private String fileName;//文档名称
	
	private String filePath;//文档路径
	
	private String userId;// 用户标识
	
	private String userName;// 用户名称

	private String updateUserId;// 更新人标识
	
	private String updateUserName;// 更新人名称
	
	private String thruDate;//删除标识
	
	public String getThruDate() {
		return thruDate;
	}

	public void setThruDate(String thruDate) {
		this.thruDate = thruDate;
	}

	public DocumentEntity() {
		super();
	}

	public DocumentEntity(String fileId, String fileName, String filePath) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.filePath = filePath;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	
	
}
