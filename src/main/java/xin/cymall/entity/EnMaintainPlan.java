package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 设备维保计划
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-07 18:35:07
 */
public class EnMaintainPlan extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**维保设备ID**/
	private String deviceId;
	/**维保设备名称**/
	private String deviceName;
	/**计划名称**/
	private String planName;
	/**计划开始时间**/
	private String planSt;
	/**计划结束时间**/
	private String panEd;
	/**责任人**/
	private String contact;
	/**责任人联系方式**/
	private String contactPhone;
	/**维保反馈信息**/
	private String maintRs;
	/**维保反馈附件**/
	private String maintFile;
	/**计划状态**/
	private String planStatus;


	/**
	 * 设置：维保设备ID
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * 获取：维保设备ID
	 */
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * 设置：维保设备名称
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	/**
	 * 获取：维保设备名称
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * 设置：计划名称
	 */
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	/**
	 * 获取：计划名称
	 */
	public String getPlanName() {
		return planName;
	}
	/**
	 * 设置：计划开始时间
	 */
	public void setPlanSt(String planSt) {
		this.planSt = planSt;
	}
	/**
	 * 获取：计划开始时间
	 */
	public String getPlanSt() {
		return planSt;
	}
	/**
	 * 设置：计划结束时间
	 */
	public void setPanEd(String panEd) {
		this.panEd = panEd;
	}
	/**
	 * 获取：计划结束时间
	 */
	public String getPanEd() {
		return panEd;
	}
	/**
	 * 设置：责任人
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取：责任人
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置：责任人联系方式
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	/**
	 * 获取：责任人联系方式
	 */
	public String getContactPhone() {
		return contactPhone;
	}
	/**
	 * 设置：维保反馈信息
	 */
	public void setMaintRs(String maintRs) {
		this.maintRs = maintRs;
	}
	/**
	 * 获取：维保反馈信息
	 */
	public String getMaintRs() {
		return maintRs;
	}
	/**
	 * 设置：维保反馈附件
	 */
	public void setMaintFile(String maintFile) {
		this.maintFile = maintFile;
	}
	/**
	 * 获取：维保反馈附件
	 */
	public String getMaintFile() {
		return maintFile;
	}
	/**
	 * 设置：计划状态
	 */
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	/**
	 * 获取：计划状态
	 */
	public String getPlanStatus() {
		return planStatus;
	}

}
