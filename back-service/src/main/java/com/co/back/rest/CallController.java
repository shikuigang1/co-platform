package com.co.back.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther skg
 * @Date: 2019/12/3
 */
@Controller
@RequestMapping("/call")
public class CallController {

    /**
     * 单个呼叫
     * @param mobile
     * @param senceID
     * @return
     */
    @RequestMapping("/record")
    public ResponseEntity<?> callNumber(@RequestParam("mobile") String mobile,@RequestParam("senceID") Integer senceID ){
        return  null;
    }

}
