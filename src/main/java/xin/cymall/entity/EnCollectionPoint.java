package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 采集点信息表
 * 
 * @author wcy
 * @email 228112142@qq.com
 * @date 2019-03-19 11:10:52
 */
public class EnCollectionPoint implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/**采集点名称**/
	private String collectionPointName;
	/**物理地址**/
	private String phyaddr;
	/**虚拟地址**/
	private String virtaddr;
	/**所属集中器ID**/
	private String concentratorId;
	/**采集点类型：1、电 2、水 3、气 4、其他**/
	private String pointType;
	/**采集点设备品牌**/
	private String pointBrand;
	/**采集点设备型号**/
	private String pointModel;
	/****/
	private String createUser;
	/****/
	private Date createTime;
	/****/
	private String updateUser;
	/****/
	private Date updateTime;
	/****/
	private String delFlag;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
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
	/**
	 * 设置：
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：
	 */
	public String getDelFlag() {
		return delFlag;
	}
}
