package xin.cymall.common.utils;

import xin.cymall.service.CommparaService;

import java.util.HashMap;
import java.util.Map;

public class CommparaUtil {
    private static CommparaService commparaService = SpringContextUtils.getBean("commparaService",CommparaService.class);

    public static String getCommparaLabel(String codeName,String value,String defaul){
        Map<String,Object> params = new HashMap<>();
        params.put("key",value);
        params.put("code",codeName);
        String labelName = commparaService.queryObjByKeyValue(params);
        return StringUtil.isBlank(labelName)?defaul:labelName;
    }

}
