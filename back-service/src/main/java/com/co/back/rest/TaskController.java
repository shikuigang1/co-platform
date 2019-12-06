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
@RequestMapping("/task")
public class TaskController {

    /**
     * 开始呼叫任务
     * @param taskID
     * @return
     */
    @RequestMapping("/start")
    public ResponseEntity<?> startTask(@RequestParam("taskID") Integer taskID){

        return  null;
    }
}
