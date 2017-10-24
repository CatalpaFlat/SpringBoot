package com.chen.logic;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Controller
 * @author 陈梓平
 * @date 2017/10/24.
 */
@Controller
@RequestMapping(value = "/api")
public class DemoController {
    private Logger logger = LoggerFactory.getLogger(DemoController.class);
    /**
     * 可以直接使用@ResponseBody响应JSON
     * @return
     */
    @RequestMapping(value = "/getcount", method = RequestMethod.POST)
    @ApiOperation(value="测试-getCount", notes="getCount更多说明")
    @ResponseBody
    public ModelMap getCount() {
        logger.info(">>>>>>>> begin getCount >>>>>>>>");
        ModelMap map = new ModelMap();
        map.addAttribute("count", 158);
        // 后台获取的国际化信息
        map.addAttribute("xstest", "测试");
        return map;
    }
}
