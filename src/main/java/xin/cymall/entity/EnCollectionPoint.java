package xin.cymall.entity;

import xin.cymall.common.utils.CommparaUtil;

import java.io.Serializable;
import java.util.List;


/**
 * 采集点信息表
 *
 * @author wcy
 * @email 228112142@qq.com
 * @date 2019-03-19 11:10:52
 */
public class EnCollectionPoint extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 采集点名称
     **/
    private String collectionPointName;
    /**
     * 物理地址
     **/
    private String phyaddr;
    /**
     * 虚拟地址
     **/
    private String virtaddr;

    /**
     * 父级ID
     */
    private String parentId;
    /**
     * 父级IDs
     */
    private String parentIds;

    /**
     * 所属集中器ID
     **/
    private String concentratorId;

    private String concentratorName;
    /**
     * 采集点类型：1、电 2、水 3、气 4、其他
     **/
    private String pointType;

    private String pointLabel;
    /**
     * 采集点设备品牌
     **/
    private String pointBrand;
    /**
     * 采集点设备型号
     **/
    private String pointModel;

    private Integer cyNodeType;

    private List<EnPoinstandardset> enPoinstandardsets;

    /**
     * 设置：采集点名称
     */
    public void setCollectionPointName(String collectionPointName) {
        this.collectionPointName = collectionPointName;
    }

    /**
     * 获取：采集点名称
     */
    public String getCollectionPointName() {
        return collectionPointName;
    }

    /**
     * 设置：物理地址
     */
    public void setPhyaddr(String phyaddr) {
        this.phyaddr = phyaddr;
    }

    /**
     * 获取：物理地址
     */
    public String getPhyaddr() {
        return phyaddr;
    }

    /**
     * 设置：虚拟地址
     */
    public void setVirtaddr(String virtaddr) {
        this.virtaddr = virtaddr;
    }

    /**
     * 获取：虚拟地址
     */
    public String getVirtaddr() {
        return virtaddr;
    }

    /**
     * 设置：所属集中器ID
     */
    public void setConcentratorId(String concentratorId) {
        this.concentratorId = concentratorId;
    }

    /**
     * 获取：所属集中器ID
     */
    public String getConcentratorId() {
        return concentratorId;
    }

    /**
     * 设置：采集点类型：1、电 2、水 3、气 4、其他
     */
    public void setPointType(String pointType) {
        this.pointType = pointType;
    }

    /**
     * 获取：采集点类型：1、电 2、水 3、气 4、其他
     */
    public String getPointType() {
        return pointType;
    }

    /**
     * 设置：采集点设备品牌
     */
    public void setPointBrand(String pointBrand) {
        this.pointBrand = pointBrand;
    }

    /**
     * 获取：采集点设备品牌
     */
    public String getPointBrand() {
        return pointBrand;
    }

    /**
     * 设置：采集点设备型号
     */
    public void setPointModel(String pointModel) {
        this.pointModel = pointModel;
    }

    /**
     * 获取：采集点设备型号
     */
    public String getPointModel() {
        return pointModel;
    }

    public List<EnPoinstandardset> getEnPoinstandardsets() {
        return enPoinstandardsets;
    }

    public void setEnPoinstandardsets(List<EnPoinstandardset> enPoinstandardsets) {
        this.enPoinstandardsets = enPoinstandardsets;
    }

    public String getConcentratorName() {
        return concentratorName;
    }

    public void setConcentratorName(String concentratorName) {
        this.concentratorName = concentratorName;
    }

    public String getPointLabel() {
        return pointLabel;
    }

    public void setPointLabel(String pointLabel) {
        this.pointLabel = pointLabel;
    }

    public Integer getCyNodeType() {
        return cyNodeType;
    }

    public void setCyNodeType(Integer cyNodeType) {
        this.cyNodeType = cyNodeType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public void toTypeLabel(){
        this.pointLabel = CommparaUtil.getCommparaLabel("monitorType",this.pointType,"");
    }
}
