package xin.cymall.common.enumresource;

import xin.cymall.common.utils.EnumMessage;

/**
 * @Author: wcy
 * @Email: 228112142@qq.com
 * @Description: 默认密码
 * @Date: 2017/9/2 21:27
 */
public enum AppStatusEnum implements EnumMessage {
    APP_STATUS_UP("1","已上架"),
    APP_STATUS_DOWN("0","未上架");
    private final String code;
    private final String value;
    private AppStatusEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
    @Override
    public String getCode() { return code;}
    @Override
    public String getValue() { return value; }
}