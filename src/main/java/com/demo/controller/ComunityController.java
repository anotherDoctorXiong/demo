package com.demo.controller;

import com.demo.model.Cities;
import com.demo.model.Dists;
import com.demo.model.Local;
import com.demo.model.Provinces;
import com.demo.service.comunityservice;
import com.demo.service.localservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ComunityController {
    @Autowired
    private localservice ls;
    @Autowired
    private comunityservice cs;

    //添加一个小区信息
    @RequestMapping(value="/comunity",method = RequestMethod.POST)
    public ResponseEntity getcomunities(@RequestBody Local local){
        try {
            if(cs.insterComunity(local)){
                return new ResponseEntity(HttpStatus.OK);
            }else
                return new ResponseEntity(HttpStatus.ALREADY_REPORTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    //获取小区信息列表
    @RequestMapping(value="/comunitylist",method = RequestMethod.GET)
    public  ResponseEntity<List<Local>> getcomunities(@RequestParam Map<String,String> map){
        Local local=new Local();
        local.setProvince(map.get("province"));
        local.setCity(map.get("city"));
        local.setDist(map.get("dist"));
        cs.comunitylist(local);
        return new ResponseEntity<List<Local>>(cs.comunitylist(local),HttpStatus.OK);
    }
    @RequestMapping(value="/comunity",method = RequestMethod.PUT)
    public ResponseEntity comunityupdata(@RequestBody Local local){
        try {
            if(cs.comunityupdata(local)){
                return new ResponseEntity(HttpStatus.OK);
            }else{
                System.out.println("已经存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.MULTI_STATUS);
    }

}
