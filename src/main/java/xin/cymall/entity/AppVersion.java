package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 应用版本信息
 * @author wcy
 * @since 2019年1月2日15:01:27
 */
public class AppVersion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Long id;
    private Long appId;
    private String appType;
    private String appName;
    private String appEnname;
    private String appIcon;
    private String appOutverno;
    private Integer appInnerverno;
    private String appUpdcms;
    private String appUrl;
    private String appStatus;
    private String appPubstatus;
    private Long appOprauser;
    private String appQr;
    private Integer appUpdcount;
    private Date createTime;
    private Date updateTime;
    private String isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppId() {
        return appId;
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

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
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

    public String getAppUpdcms() {
        return appUpdcms;
    }

    public void setAppUpdcms(String appUpdcms) {
        this.appUpdcms = appUpdcms;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public String getAppPubstatus() {
        return appPubstatus;
    }

    public void setAppPubstatus(String appPubstatus) {
        this.appPubstatus = appPubstatus;
    }

    public Long getAppOprauser() {
        return appOprauser;
    }

    public void setAppOprauser(Long appOprauser) {
        this.appOprauser = appOprauser;
    }

    public String getAppQr() {
        return appQr;
    }

    public void setAppQr(String appQr) {
        this.appQr = appQr;
    }

    public Integer getAppUpdcount() {
        return appUpdcount;
    }

    public void setAppUpdcount(Integer appUpdcount) {
        this.appUpdcount = appUpdcount;
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
