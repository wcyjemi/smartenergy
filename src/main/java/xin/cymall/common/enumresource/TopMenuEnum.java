package xin.cymall.common.enumresource;

/**
 * Created by wcy on 2016/12/7.
 * 顶级菜单
 */
public enum TopMenuEnum {
    TopMonitorUnit("0","根监测单位"),
    TopMenu("0","顶级菜单"),
    TopOrg("0","顶级部门");
    private final String desc;
    private final String code;

    private TopMenuEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }
}
