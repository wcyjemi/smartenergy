package xin.cymall.entity;

import java.io.Serializable;
/**
 * 用户和管理应用关联关系
 * @author wcy
 * @date 2019年1月3日17:47:59
 */
public class SysUserApp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long userId;
	private Long appId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getAppId() {
		return appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}

}
