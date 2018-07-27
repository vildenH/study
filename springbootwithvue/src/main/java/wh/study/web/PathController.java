package wh.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wh
 * @date 2018/7/27
 */
@Controller
public class PathController {

    @RequestMapping(value = "/api/alive)")
    @ResponseBody
    public String alive() {
        return "alive";
    }
}
