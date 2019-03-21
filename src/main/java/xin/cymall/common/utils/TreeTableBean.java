package xin.cymall.common.utils;

import java.io.Serializable;

/**
 * 树形表格数据 entity
 * @author wcy
 * @date 2019年3月14日15:00:39
 */
public class TreeTableBean implements Serializable {
    private static final long serialVersionUID = 1501703932589702493L;
    private Integer id;
    private Integer pid;
    private String title;
    private Integer monitorType;
    private String parentName;
    private String companyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(Integer monitorType) {
        this.monitorType = monitorType;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
