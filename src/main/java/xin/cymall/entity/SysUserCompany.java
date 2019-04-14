package xin.cymall.entity;

import java.io.Serializable;

public class SysUserCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String userId;
    private String companyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
