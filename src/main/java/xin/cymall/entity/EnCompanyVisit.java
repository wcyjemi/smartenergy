package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 企业回访记录信息表
 * 
 * @author wcy
 * @email 3304737387@qq.com
 * @date 2019-03-29 11:11:07
 */
public class EnCompanyVisit extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**企业ID**/
	private Integer companyId;
	/**回访时间**/
	private Date visitTime;
	/**回访人**/
	private String visitPerson;
	/**接待人**/
	private String receptionist;
	/**回访方式**/
	private String visitType;
	/**回访类容**/
	private String visitContent;
	/**回访附件**/
	private String visitFile;

	/**
	 * 设置：企业ID
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	/**
	 * 获取：企业ID
	 */
	public Integer getCompanyId() {
		return companyId;
	}
	/**
	 * 设置：回访时间
	 */
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	/**
	 * 获取：回访时间
	 */
	public Date getVisitTime() {
		return visitTime;
	}
	/**
	 * 设置：回访人
	 */
	public void setVisitPerson(String visitPerson) {
		this.visitPerson = visitPerson;
	}
	/**
	 * 获取：回访人
	 */
	public String getVisitPerson() {
		return visitPerson;
	}
	/**
	 * 设置：接待人
	 */
	public void setReceptionist(String receptionist) {
		this.receptionist = receptionist;
	}
	/**
	 * 获取：接待人
	 */
	public String getReceptionist() {
		return receptionist;
	}
	/**
	 * 设置：回访方式
	 */
	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}
	/**
	 * 获取：回访方式
	 */
	public String getVisitType() {
		return visitType;
	}
	/**
	 * 设置：回访类容
	 */
	public void setVisitContent(String visitContent) {
		this.visitContent = visitContent;
	}
	/**
	 * 获取：回访类容
	 */
	public String getVisitContent() {
		return visitContent;
	}
	/**
	 * 设置：回访附件
	 */
	public void setVisitFile(String visitFile) {
		this.visitFile = visitFile;
	}
	/**
	 * 获取：回访附件
	 */
	public String getVisitFile() {
		return visitFile;
	}
}
