package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 采集器信息表
 * 
 * @author zwg
 * @email 228112142@qq.com
 * @date 2019-03-25 20:59:22
 */
public class EnCollector extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**采集器名称**/
	private String collectorName;
	/**采集器型号**/
	private String collectorModel;
	/**所属集中器ID**/
	private String concentratorId;

	/**
	 * 设置：采集器名称
	 */
	public void setCollectorName(String collectorName) {
		this.collectorName = collectorName;
	}
	/**
	 * 获取：采集器名称
	 */
	public String getCollectorName() {
		return collectorName;
	}
	/**
	 * 设置：采集器型号
	 */
	public void setCollectorModel(String collectorModel) {
		this.collectorModel = collectorModel;
	}
	/**
	 * 获取：采集器型号
	 */
	public String getCollectorModel() {
		return collectorModel;
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
}
