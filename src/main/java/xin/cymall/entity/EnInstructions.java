package xin.cymall.entity;

import java.io.Serializable;


/**
 * 数据项信息
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-04-03 10:42:59
 */
public class EnInstructions extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	

	/**指令**/
	private String instructions;
	/**指令名称**/
	private String instructionsName;
	/**指令类型：1、电2、水3、气4、其他**/
	private String instructionsType;
	/**数据项单位**/
	private String instructionsUnit;

	/**
	 * 设置：指令
	 */
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	/**
	 * 获取：指令
	 */
	public String getInstructions() {
		return instructions;
	}
	/**
	 * 设置：指令名称
	 */
	public void setInstructionsName(String instructionsName) {
		this.instructionsName = instructionsName;
	}
	/**
	 * 获取：指令名称
	 */
	public String getInstructionsName() {
		return instructionsName;
	}
	/**
	 * 设置：指令类型：1、电2、水3、气4、其他
	 */
	public void setInstructionsType(String instructionsType) {
		this.instructionsType = instructionsType;
	}
	/**
	 * 获取：指令类型：1、电2、水3、气4、其他
	 */
	public String getInstructionsType() {
		return instructionsType;
	}
	/**
	 * 设置：数据项单位
	 */
	public void setInstructionsUnit(String instructionsUnit) {
		this.instructionsUnit = instructionsUnit;
	}
	/**
	 * 获取：数据项单位
	 */
	public String getInstructionsUnit() {
		return instructionsUnit;
	}

}
