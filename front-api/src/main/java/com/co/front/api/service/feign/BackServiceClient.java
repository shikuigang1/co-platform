package com.co.front.api.service.feign;

import com.co.front.api.base.ResultBody;
import com.co.front.api.constant.BaseConstants;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @auther skg
 * @Date: 2019/12/6
 */

@Component
@FeignClient(value = BaseConstants.BACK_SERVER)
public interface BackServiceClient {


    /**
     * 单个呼叫任务
     * @return
     */
    @GetMapping("/call/record")
    ResultBody callMobile(@RequestParam(value ="mobile") String mobile,
                          @RequestParam(value = "senceID") Integer senceID,
                          @RequestParam(value ="jsonContext" ,required = false) String jsonContext) ;


}
