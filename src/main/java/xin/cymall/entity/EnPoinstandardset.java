package xin.cymall.entity;

import java.io.Serializable;

/**
 * 监测点数据项标准值设置
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-02 15:59:22
 */
public class EnPoinstandardset extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**采集点ID**/
	private String collectionPointId;
	/**数据项ID**/
	private String instructionsId;
	/**数据项名称**/
	private String instructionName;
	/**标准值最小**/
	private String standardValueMin;
	/**标准值最大**/
	private String standardValueMax;

	/**
	 * 设置：采集点ID
	 */
	public void setCollectionPointId(String collectionPointId) {
		this.collectionPointId = collectionPointId;
	}
	/**
	 * 获取：采集点ID
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
	public void setInstructionName(String instructionName) {
		this.instructionName = instructionName;
	}
	/**
	 * 获取：数据项名称
	 */
	public String getInstructionName() {
		return instructionName;
	}
	/**
	 * 设置：标准值最小
	 */
	public void setStandardValueMin(String standardValueMin) {
		this.standardValueMin = standardValueMin;
	}
	/**
	 * 获取：标准值最小
	 */
	public String getStandardValueMin() {
		return standardValueMin;
	}
	/**
	 * 设置：标准值最低
	 */
	public void setStandardValueMax(String standardValueMax) {
		this.standardValueMax = standardValueMax;
	}
	/**
	 * 获取：标准值最低
	 */
	public String getStandardValueMax() {
		return standardValueMax;
	}
}
