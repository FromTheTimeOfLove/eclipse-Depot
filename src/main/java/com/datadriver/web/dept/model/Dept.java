package com.datadriver.web.dept.model;

public class Dept {

	private String deptid;

	private String deptname;

	private String deptremark;

	private String parentdeptid;

	private String parentdeptname;

	private int status;

	private String leaderid;

	private int type;

	private int resourcetype;

	private int deptord;

	private String assistantemail;

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptremark() {
		return deptremark;
	}

	public void setDeptremark(String deptremark) {
		this.deptremark = deptremark;
	}

	public String getParentdeptid() {
		return parentdeptid;
	}

	public void setParentdeptid(String parentdeptid) {
		this.parentdeptid = parentdeptid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getLeaderid() {
		return leaderid;
	}

	public void setLeaderid(String leaderid) {
		this.leaderid = leaderid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(int resourcetype) {
		this.resourcetype = resourcetype;
	}

	public int getDeptord() {
		return deptord;
	}

	public void setDeptord(int deptord) {
		this.deptord = deptord;
	}

	public String getAssistantemail() {
		return assistantemail;
	}

	public void setAssistantemail(String assistantemail) {
		this.assistantemail = assistantemail;
	}

	public String getParentdeptname() {
		return parentdeptname;
	}

	public void setParentdeptname(String parentdeptname) {
		this.parentdeptname = parentdeptname;
	}
}
