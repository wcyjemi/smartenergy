package xin.cymall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 能源分析
 *
 * @author wcy
 * @email 228112142@qq.com
 * @date 2019-03-19 11:10:52
 */
@Controller
@RequestMapping("/encollectionpoint")
public class PowerStitcsController {

    @RequestMapping("/powerVis")
    public String powerVis(){
        return "powrvis/powerstatic";
    }

}
