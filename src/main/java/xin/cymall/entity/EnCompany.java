package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业信息
 * @author wcy
 * @date 2019年2月28日15:03:03
 */
public class EnCompany extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 企业名称
     */
    private String companyName;
    /**
     * 企业简称
     */
    private String companyShortname;
    /**
     * 企业英文
     */
    private String companyEname;
    /**
     * 拼音首字母
     */
    private String pinyinIndex;
    /**
     * 企业地址
     */
    private String companyAddress;
    /**
     * 企业法人
     */
    private String companyFr;
    /**
     * 企业联系人
     */
    private String companyContact;
    /**
     * 联系方式
     */
    private String contactPhone;
    /**
     * 企业序列号
     */
    private String companyKey;
    /**
     * 企业LOGO
     */
    private String companyLogo;
    /**
     * 序列号类型
     */
    private Integer keyType;
    /**
     * 序列号有效开始时间
     */
    private Date keySttime;
    /**
     * 序列号有效期截止时间
     */
    private Date keyEdtime;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyShortname() {
        return companyShortname;
    }

    public void setCompanyShortname(String companyShortname) {
        this.companyShortname = companyShortname;
    }

    public String getPinyinIndex() {
        return pinyinIndex;
    }

    public void setPinyinIndex(String pinyinIndex) {
        this.pinyinIndex = pinyinIndex;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyFr() {
        return companyFr;
    }

    public void setCompanyFr(String companyFr) {
        this.companyFr = companyFr;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getCompanyKey() {
        return companyKey;
    }

    public void setCompanyKey(String companyKey) {
        this.companyKey = companyKey;
    }

    public String getCompanyEname() {
        return companyEname;
    }

    public void setCompanyEname(String companyEname) {
        this.companyEname = companyEname;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public Integer getKeyType() {
        return keyType;
    }

    public void setKeyType(Integer keyType) {
        this.keyType = keyType;
    }

    public Date getKeySttime() {
        return keySttime;
    }

    public void setKeySttime(Date keySttime) {
        this.keySttime = keySttime;
    }

    public Date getKeyEdtime() {
        return keyEdtime;
    }

    public void setKeyEdtime(Date keyEdtime) {
        this.keyEdtime = keyEdtime;
    }
}
