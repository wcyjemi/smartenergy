package xin.cymall.vo;

import xin.cymall.common.utils.CommparaUtil;
import xin.cymall.entity.BaseEntity;
import xin.cymall.entity.EnPoinstandardset;

import java.io.Serializable;
import java.util.List;


/**
 * 采集点信息表
 *
 * @author wcy
 * @email 228112142@qq.com
 * @date 2019-03-19 11:10:52
 */
public class EnCollectionPointVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String pid;
    private String title;

    /**
     * 物理地址
     **/
    private String phyaddr;
    /**
     * 虚拟地址
     **/
    private String virtaddr;

    /**
     * 所属集中器ID
     **/
    private String concentratorId;

    private String concentratorName;
    /**
     * 采集点类型：1、电 2、水 3、气 4、其他
     **/
    private String pointType;

    /**
     * 采集点设备品牌
     **/
    private String pointBrand;
    /**
     * 采集点设备型号
     **/
    private String pointModel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhyaddr() {
        return phyaddr;
    }

    public void setPhyaddr(String phyaddr) {
        this.phyaddr = phyaddr;
    }

    public String getVirtaddr() {
        return virtaddr;
    }

    public void setVirtaddr(String virtaddr) {
        this.virtaddr = virtaddr;
    }

    public String getConcentratorId() {
        return concentratorId;
    }

    public void setConcentratorId(String concentratorId) {
        this.concentratorId = concentratorId;
    }

    public String getConcentratorName() {
        return concentratorName;
    }

    public void setConcentratorName(String concentratorName) {
        this.concentratorName = concentratorName;
    }

    public String getPointType() {
        return pointType;
    }

    public void setPointType(String pointType) {
        this.pointType = pointType;
    }

    public String getPointBrand() {
        return pointBrand;
    }

    public void setPointBrand(String pointBrand) {
        this.pointBrand = pointBrand;
    }

    public String getPointModel() {
        return pointModel;
    }

    public void setPointModel(String pointModel) {
        this.pointModel = pointModel;
    }
}
