package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 设备信息表
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-03 15:11:53
 */
public class EnDevice extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**设备名称**/
	private String deviceName;
	/**设备编号**/
	private String deviceNo;
	/**设备品牌**/
	private String deviceBrand;
	/**设备型号**/
	private String deviceModel;
	/**所属企业ID**/
	private String companyId;
	/**所属企业名称**/
	private String companyName;
	/**出厂日期**/
	private String productDate;
	/**安装日期**/
	private String installDate;
	/**标称功率（kw）**/
	private String nominalPower;
	/**设备状态：1、在用2、停用3、维修4、备用5、报废**/
	private String deviceStatus;

	/**
	 * 设置：设备名称
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	/**
	 * 获取：设备名称
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * 设置：设备编号
	 */
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}
	/**
	 * 获取：设备编号
	 */
	public String getDeviceNo() {
		return deviceNo;
	}
	/**
	 * 设置：设备品牌
	 */
	public void setDeviceBrand(String deviceBrand) {
		this.deviceBrand = deviceBrand;
	}
	/**
	 * 获取：设备品牌
	 */
	public String getDeviceBrand() {
		return deviceBrand;
	}
	/**
	 * 设置：设备型号
	 */
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	/**
	 * 获取：设备型号
	 */
	public String getDeviceModel() {
		return deviceModel;
	}
	/**
	 * 设置：所属企业ID
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	/**
	 * 获取：所属企业ID
	 */
	public String getCompanyId() {
		return companyId;
	}
	/**
	 * 设置：出厂日期
	 */
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	/**
	 * 获取：出厂日期
	 */
	public String getProductDate() {
		return productDate;
	}
	/**
	 * 设置：安装日期
	 */
	public void setInstallDate(String installDate) {
		this.installDate = installDate;
	}
	/**
	 * 获取：安装日期
	 */
	public String getInstallDate() {
		return installDate;
	}
	/**
	 * 设置：标称功率（kw）
	 */
	public void setNominalPower(String nominalPower) {
		this.nominalPower = nominalPower;
	}
	/**
	 * 获取：标称功率（kw）
	 */
	public String getNominalPower() {
		return nominalPower;
	}
	/**
	 * 设置：设备状态：1、在用2、停用3、维修4、备用5、报废
	 */
	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	/**
	 * 获取：设备状态：1、在用2、停用3、维修4、备用5、报废
	 */
	public String getDeviceStatus() {
		return deviceStatus;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
