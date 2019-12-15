package com.co.front.api.rest;

import com.co.front.api.base.ResultBody;
import com.co.front.api.service.feign.BackServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 呼叫主接口
 * @auther skg
 * @Date: 2019/12/6
 */
@Controller
@RequestMapping("/call")
public class CallController {

    @Autowired
    private BackServiceClient backServiceClient;

    @RequestMapping(value="/mobile",method = RequestMethod.POST)
    public ResultBody callMobile(@RequestParam(value = "mobile")String  mobile,
                                 @RequestParam(value = "senceID") Integer senceID,
                                 @RequestParam(value = "jsonContext") String jsonContext){

        return  backServiceClient.callMobile(mobile,senceID,jsonContext);
    }

}
