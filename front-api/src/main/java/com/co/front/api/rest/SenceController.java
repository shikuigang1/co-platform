package com.co.front.api.rest;

import com.co.front.api.entity.Sence;
import com.co.front.api.service.SenceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

/**
 * @auther skg
 * @Date: 2019/12/3
 */
@Controller
@RequestMapping("/sence")
public class SenceController {


    @Autowired
    private SenceService senceService;


    @RequestMapping("/list")
    @ResponseBody
    public ResponseEntity<?> findList(){
       return   ResponseEntity.ok(new Object());
    }

    @RequestMapping("/find")
    @ResponseBody
    public ResponseEntity<?> findById(@RequestParam("senceID") String senceID){

        return   ResponseEntity.ok(new Object());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> saveSence(@RequestParam(value = "id",required = false) Integer id,
                                       @RequestParam(value = "sence_desc",required = false,defaultValue = "") String sence_desc,
                                       @RequestParam(value = "sence_flow") String sence_flow,
                                       @RequestParam(value = "sence_global") String sence_global,
                                       @RequestParam(value = "sence_name",required = false,defaultValue = "") String sence_name){
        Sence sence = new Sence();
        sence.setId(id);
        sence.setSence_desc(sence_desc);
        sence.setSence_flow(sence_flow);
        sence.setSence_name(sence_name);
        sence.setSence_global(sence_global);
        senceService.insertOrUpdate(sence);
        return   ResponseEntity.ok(new Object());
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseEntity<?> delSence(@RequestParam("senceID") String senceID){

        return   ResponseEntity.ok(null);
    }
}
