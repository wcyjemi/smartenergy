package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author wangsu
 * @email 3304737387@qq.com
 * @date 2019-04-02 15:53:34
 */
public class EnWarningInfo extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	

	/**预警的采集点ID**/
	private String collectionPointId;
	/**数据项ID**/
	private String instructionsId;
	/**数据项名称**/
	private String instructionsName;
	/**当前值**/
	private String currentValue;
	/**标准值**/
	private String standardValue;
	/**方向：1、高于标准值，2、低于标准值**/
	private String directionType;
	/**差值**/
	private String differenceValue;
	/**差值百分比**/
	private String percentageValue;
	/**预警等级**/
	private String warningLevel;
	/**
	 * 设置：预警的采集点ID
	 */
	public void setCollectionPointId(String collectionPointId) {
		this.collectionPointId = collectionPointId;
	}
	/**
	 * 获取：预警的采集点ID
	 */
	public String getCollectionPointId() {
		return collectionPointId;
	}
	/**
	 * 设置：数据项ID
	 */
	public void setInstructionsId(String instructionsId) {
		this.instructionsId = instructionsId;
	}
	/**
	 * 获取：数据项ID
	 */
	public String getInstructionsId() {
		return instructionsId;
	}
	/**
	 * 设置：数据项名称
	 */
	public void setInstructionsName(String instructionsName) {
		this.instructionsName = instructionsName;
	}
	/**
	 * 获取：数据项名称
	 */
	public String getInstructionsName() {
		return instructionsName;
	}
	/**
	 * 设置：当前值
	 */
	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}
	/**
	 * 获取：当前值
	 */
	public String getCurrentValue() {
		return currentValue;
	}
	/**
	 * 设置：标准值
	 */
	public void setStandardValue(String standardValue) {
		this.standardValue = standardValue;
	}
	/**
	 * 获取：标准值
	 */
	public String getStandardValue() {
		return standardValue;
	}
	/**
	 * 设置：方向：1、高于标准值，2、低于标准值
	 */
	public void setDirectionType(String directionType) {
		this.directionType = directionType;
	}
	/**
	 * 获取：方向：1、高于标准值，2、低于标准值
	 */
	public String getDirectionType() {
		return directionType;
	}
	/**
	 * 设置：差值
	 */
	public void setDifferenceValue(String differenceValue) {
		this.differenceValue = differenceValue;
	}
	/**
	 * 获取：差值
	 */
	public String getDifferenceValue() {
		return differenceValue;
	}
	/**
	 * 设置：差值百分比
	 */
	public void setPercentageValue(String percentageValue) {
		this.percentageValue = percentageValue;
	}
	/**
	 * 获取：差值百分比
	 */
	public String getPercentageValue() {
		return percentageValue;
	}
	/**
	 * 设置：预警等级
	 */
	public void setWarningLevel(String warningLevel) {
		this.warningLevel = warningLevel;
	}
	/**
	 * 获取：预警等级
	 */
	public String getWarningLevel() {
		return warningLevel;
	}

}
