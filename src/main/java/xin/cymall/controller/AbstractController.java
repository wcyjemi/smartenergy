package xin.cymall.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xin.cymall.common.shiro.ShiroUtils;
import xin.cymall.entity.SysUser;

/**
 * Controller公共组件
 * 
 * @author wcy
 * @date 2018年11月9日 下午9:42:26
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected SysUser getUser() {
		return ShiroUtils.getUserEntity();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
}
