package xin.cymall.entity;

import java.io.Serializable;

/**
 * 监测单位 entity
 * @author wcy
 * @date 2019年3月8日11:19:02
 */
public class EnMonitorUnit extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -782070782453185488L;
    /**
     * 企业ID
     */
    private Integer companyId;
    /**
     * 监测单位名称
     */
    private String monitorUnitName;
    /**
     * 监测单位类型
     */
    private Integer monitorType;
    /**
     * 监测单位父级ID
     */
    private Integer parentId;
    /**
     * 监测单位父级IDs
     */
    private String parentIds;
    /**
     * 监测单位级别
     */
    private Integer level;
    /**
     * 排序
     */
    private Integer sort;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getMonitorUnitName() {
        return monitorUnitName;
    }

    public void setMonitorUnitName(String monitorUnitName) {
        this.monitorUnitName = monitorUnitName;
    }

    public Integer getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(Integer monitorType) {
        this.monitorType = monitorType;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
