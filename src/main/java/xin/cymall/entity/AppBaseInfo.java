package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 应用基本信息
 * @author wcy
 * @since 2019年1月2日15:01:27
 */
public class AppBaseInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String appName;
	private String appEnname;
	private String appIcon;
	private String appIntr;
	private String appStatus;
	private String remark;
	private Long opraUser;
	private Date createTime;
	private Date updateTime;
	private String isDelete;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppEnname() {
		return appEnname;
	}

	public void setAppEnname(String appEnname) {
		this.appEnname = appEnname;
	}

	public String getAppIcon() {
		return appIcon;
	}
	public void setAppIcon(String appIcon) {
		this.appIcon = appIcon;
	}
	public String getAppIntr() {
		return appIntr;
	}
	public void setAppIntr(String appIntr) {
		this.appIntr = appIntr;
	}
	public String getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getOpraUser() {
		return opraUser;
	}
	public void setOpraUser(Long opraUser) {
		this.opraUser = opraUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
}
