package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 集中器信息表
 * 
 * @author zwg
 * @email 228112142@qq.com
 * @date 2019-03-28 14:44:28
 */
public class EnConcentrator extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String concentratorName;
	/****/
	private String concentratorModel;
	/****/
	private String monitorUnitId;
	/****/
	private String address;
	/****/
	private String serviceHost;
	/****/
	private String timeCheck;


	private String monitorUnitName;

	public String getMonitorUnitName() {
		return monitorUnitName;
	}

	public void setMonitorUnitName(String monitorUnitName) {
		this.monitorUnitName = monitorUnitName;
	}

	/**
	 * 设置：
	 */
	/**
	 * 获取：
	 */
	/**
	 * 设置：
	 */
	public void setConcentratorName(String concentratorName) {
		this.concentratorName = concentratorName;
	}
	/**
	 * 获取：
	 */
	public String getConcentratorName() {
		return concentratorName;
	}
	/**
	 * 设置：
	 */
	public void setConcentratorModel(String concentratorModel) {
		this.concentratorModel = concentratorModel;
	}
	/**
	 * 获取：
	 */
	public String getConcentratorModel() {
		return concentratorModel;
	}
	/**
	 * 设置：
	 */
	public void setMonitorUnitId(String monitorUnitId) {
		this.monitorUnitId = monitorUnitId;
	}
	/**
	 * 获取：
	 */
	public String getMonitorUnitId() {
		return monitorUnitId;
	}
	/**
	 * 设置：
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：
	 */
	public void setServiceHost(String serviceHost) {
		this.serviceHost = serviceHost;
	}
	/**
	 * 获取：
	 */
	public String getServiceHost() {
		return serviceHost;
	}
	/**
	 * 设置：
	 */
	public void setTimeCheck(String timeCheck) {
		this.timeCheck = timeCheck;
	}
	/**
	 * 获取：
	 */
	public String getTimeCheck() {
		return timeCheck;
	}

	/**
	 * 设置：
	 */
	/**
	 * 获取：
	 */
}
