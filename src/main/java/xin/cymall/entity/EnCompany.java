package xin.cymall.entity;

import xin.cymall.common.utils.ChineseToEnglishUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

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
     * 地区路径
     */
    private String companyAreapath;

    private String[] companyAreaIds;
    /**
     * 企业地址
     */
    private String companyAddress;
    /**
     * 企业法人
     */
    private String companyFr;

    /**
     * 企业法人联系方式
     */
    private String companyFrPhone;
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
     * 企业类型 1、化工厂 2、机械制造、3、 制药
     */
    private Integer companyType;
    /**
     * 企业用电容量
     */
    private BigDecimal companyCapacity;
    /**
     * 企业 经度
     */
    private String companyLo;
    /**
     * 企业 纬度
     */
    private String companyLa;
    /**
     * 缴费类型1、试用企业 2、租赁企业 3、落地企业 4、定制企业 5、孤岛企业
     */
    private Integer payType;

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

    public String getCompanyAreapath() {
        return companyAreapath;
    }

    public void setCompanyAreapath(String companyAreapath) {
        this.companyAreapath = companyAreapath;
    }

    public String[] getCompanyAreaIds() {
        return companyAreaIds;
    }

    public void setCompanyAreaIds(String[] companyAreaIds) {
        this.companyAreaIds = companyAreaIds;
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


    public String getCompanyFrPhone() {
        return companyFrPhone;
    }

    public void setCompanyFrPhone(String companyFrPhone) {
        this.companyFrPhone = companyFrPhone;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public BigDecimal getCompanyCapacity() {
        return companyCapacity;
    }

    public void setCompanyCapacity(BigDecimal companyCapacity) {
        this.companyCapacity = companyCapacity;
    }

    public String getCompanyLo() {
        return companyLo;
    }

    public void setCompanyLo(String companyLo) {
        this.companyLo = companyLo;
    }

    public String getCompanyLa() {
        return companyLa;
    }

    public void setCompanyLa(String companyLa) {
        this.companyLa = companyLa;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
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

    /**
     * 给地区路径赋值
     */
    public void toAreaPath(){
        String areaPath = "";
        if (this.companyAreaIds !=null && this.companyAreaIds.length>0){
            for (int i=0;i<this.companyAreaIds.length;i++){
                if (i != this.companyAreaIds.length-1){
                    areaPath = areaPath + this.companyAreaIds[i]+",";
                }else {
                    areaPath = areaPath + this.companyAreaIds[i];
                }
            }
            this.companyAreapath = areaPath;
        }else {
            this.companyAreapath = "";
        }
    }

    /**
     * 补充拼音首字母
     */
    public void toPinYing(){
        if (this.companyName != null){
            this.pinyinIndex = ChineseToEnglishUtil.getPinYinHeadChar(this.companyName);
        }
    }

    /**
     * 生成KEY
     */
    public void generKey(){
        if (this.companyKey == null){
            this.companyKey = UUID.randomUUID().toString();
        }
    }

}
