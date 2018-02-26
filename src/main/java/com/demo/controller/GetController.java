package com.demo.controller;


import com.demo.mapper.ComunityMapper;
import com.demo.model.*;
import com.demo.service.localservice;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class GetController {
    @Autowired
    private localservice ls;

    @RequestMapping(value="/provinces",method = RequestMethod.GET)
    public ResponseEntity<List<Provinces>> getprovinces() {
        try {
            return new ResponseEntity<List<Provinces>>(ls.getprovince(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(null,HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/cities",method = RequestMethod.GET)
    public ResponseEntity<List<Cities>> getprovinces(@RequestParam Map<String,String> map) {
        try {
            return new ResponseEntity<List<Cities>>(ls.getcities(map.get("provinceid")), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/dists",method = RequestMethod.GET)
    public ResponseEntity<List<Dists>> getdists(@RequestParam Map<String,String> map) {
        try {
            return new ResponseEntity<List<Dists>>(ls.getdists(map.get("cityid")), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/comunities",method = RequestMethod.GET)
    public  ResponseEntity<List<Local>> getcomunities(@RequestParam Map<String,String> map){
        Local local=new Local();
        local.setProvince(map.get("province"));
        local.setCity(map.get("city"));
        local.setDist(map.get("dist"));
        try {
            return new ResponseEntity<List<Local>>(ls.getcomunities(local), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
