package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 应用版本信息
 * @author wcy
 * @since 2019年1月2日15:01:27
 */
public class AppUpdRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Long id;
    private Long appId;
    private String appType;
    private String appName;
    private String appOutverno;
    private Integer appInnerverno;
    private String appDownurl;
    private String ipAddr;
    private String pyAddr;
    private String mobileType;
    private String downUser;
    private String downUsername;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppOutverno() {
        return appOutverno;
    }

    public void setAppOutverno(String appOutverno) {
        this.appOutverno = appOutverno;
    }

    public Integer getAppInnerverno() {
        return appInnerverno;
    }

    public void setAppInnerverno(Integer appInnerverno) {
        this.appInnerverno = appInnerverno;
    }

    public String getAppDownurl() {
        return appDownurl;
    }

    public void setAppDownurl(String appDownurl) {
        this.appDownurl = appDownurl;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getPyAddr() {
        return pyAddr;
    }

    public void setPyAddr(String pyAddr) {
        this.pyAddr = pyAddr;
    }

    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }

    public String getDownUser() {
        return downUser;
    }

    public void setDownUser(String downUser) {
        this.downUser = downUser;
    }

    public String getDownUsername() {
        return downUsername;
    }

    public void setDownUsername(String downUsername) {
        this.downUsername = downUsername;
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
}
