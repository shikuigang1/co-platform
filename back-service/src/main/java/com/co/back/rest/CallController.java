package com.co.back.rest;

import com.co.back.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * @auther skg
 * @Date: 2019/12/3
 */
@Controller
@RequestMapping("/call")
public class CallController {

    @Autowired
    private CallService callService;

    /**
     * 单个呼叫任务
     * @param mobile
     * @param senceID
     * @return
     */
    @RequestMapping("/record")
    public ResponseEntity<?> callNumber(@RequestParam("mobile") String mobile,
                                        @RequestParam("senceID") Integer senceID,
                                        @RequestParam("jsonContext") String jsonContext
                    ){

        System.out.println("begin to call !");
        callService.call(mobile,senceID,jsonContext);
        HashMap<String,String> map = new HashMap<>();
        map.put("status","0000");
        return  ResponseEntity.ok(map);

    }

}
