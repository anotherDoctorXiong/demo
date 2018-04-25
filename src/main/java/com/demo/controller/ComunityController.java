package com.demo.controller;

import com.demo.model.*;
import com.demo.service.comunityservice;
import com.demo.service.localservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import com.demo.PageBean;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
        List<Local> list=cs.comunitylist(local,Integer.parseInt(map.get("index"))).getItems();
        if(cs.comunitylist(local,Integer.parseInt(map.get("index"))).getIsMore()==0){
            return new ResponseEntity<List<Local>>(list,HttpStatus.MULTI_STATUS);
        }else{
            return new ResponseEntity<List<Local>>(list,HttpStatus.OK);
        }

    }
    //更新小区信息
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
    //删除小区信息
    @RequestMapping(value="/comunity",method = RequestMethod.DELETE)
    public ResponseEntity comunitydelete(@RequestParam Map<String,String> map){
        System.out.println(map.get("cId"));
        if(cs.comunitydelete(map.get("cId"))){
            return new ResponseEntity(HttpStatus.OK);
        }else
            return new ResponseEntity(HttpStatus.MULTI_STATUS);
    }
    //获取楼栋信息列表
    @RequestMapping(value="/buildlist",method = RequestMethod.GET)
    public  ResponseEntity<List<Comunity>> getbuild(@RequestParam Map<String,String> map){
        Comunity comunity =new Comunity();
        comunity.setProvince(map.get("province"));
        comunity.setCity(map.get("city"));
        comunity.setDist(map.get("dist"));
        comunity.setcId(map.get("cId"));
        List<Comunity> list=cs.list(comunity,Integer.parseInt(map.get("index"))).getItems();
        if(cs.list(comunity,Integer.parseInt(map.get("index"))).getIsMore()==0){
            return new ResponseEntity<List<Comunity>>(list,HttpStatus.MULTI_STATUS);
        }else{
            return new ResponseEntity<List<Comunity>>(list,HttpStatus.OK);
        }

    }
    //添加
    @RequestMapping(value={"/build","/unit","/host"},method = RequestMethod.POST)
    public ResponseEntity getbuild(@RequestBody Comunity comunity){
        try {
            if(cs.insert(comunity)){
                return new ResponseEntity(HttpStatus.OK);
            }else
                return new ResponseEntity(HttpStatus.ALREADY_REPORTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    //更新楼栋信息
    @RequestMapping(value="/build",method = RequestMethod.PUT)
    public ResponseEntity comunityupdata(@RequestBody Map<String,String> map){
        Comunity comunity=new Comunity();
        comunity.setcId(map.get("cId"));
        comunity.setbName(map.get("bName"));
        Comunity newcomunity=new Comunity();
        newcomunity.setcId(map.get("cId"));
        newcomunity.setbName(map.get("build"));
        try {
            if(cs.update(comunity,newcomunity)){
                return new ResponseEntity(HttpStatus.OK);
            }else{
                System.out.println("已经存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.MULTI_STATUS);
    }
    //删除楼栋信息
    @RequestMapping(value="/build",method = RequestMethod.DELETE)
    public ResponseEntity builddelete(@RequestParam Map<String,String> map){
        Comunity comunity=new Comunity();
        comunity.setcId(map.get("cId"));
        comunity.setbName(map.get("bName"));
        if(cs.delete(comunity)){
            return new ResponseEntity(HttpStatus.OK);
        }else
            return new ResponseEntity(HttpStatus.MULTI_STATUS);
    }

    //更新单元信息
    @RequestMapping(value="/unit",method = RequestMethod.PUT)
    public ResponseEntity unitupdata(@RequestBody Map<String,String> map){
        Comunity comunity=new Comunity();
        comunity.setcId(map.get("cId"));
        comunity.setbName(map.get("bName"));
        comunity.setuName(map.get("uName"));
        Comunity newcomunity=new Comunity();
        newcomunity.setcId(map.get("cId"));
        newcomunity.setbName(map.get("bName"));
        newcomunity.setuName(map.get("unit"));
        try {
            if(cs.update(comunity,newcomunity)){
                return new ResponseEntity(HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.MULTI_STATUS);
    }
    //删除单元信息
    @RequestMapping(value="/unit",method = RequestMethod.DELETE)
    public ResponseEntity unitdelete(@RequestParam Map<String,String> map){
        Comunity comunity=new Comunity();
        comunity.setcId(map.get("cId"));
        comunity.setbName(map.get("bName"));
        comunity.setuName(map.get("uName"));
        if(cs.delete(comunity)){
            return new ResponseEntity(HttpStatus.OK);
        }else
            return new ResponseEntity(HttpStatus.MULTI_STATUS);
    }
    //获取单元信息列表（分页）
    @RequestMapping(value="/unitlist",method = RequestMethod.GET)
    public  ResponseEntity<List<Comunity>> getunit(@RequestParam Map<String,String> map){
        Comunity comunity =new Comunity();
        comunity.setProvince(map.get("province"));
        comunity.setCity(map.get("city"));
        comunity.setDist(map.get("dist"));
        comunity.setcId(map.get("cId"));
        comunity.setbName(map.get("bName"));
        List<Comunity> list=cs.unitlist(comunity,Integer.parseInt(map.get("index"))).getItems();
        if(cs.unitlist(comunity,Integer.parseInt(map.get("index"))).getIsMore()==0){
            return new ResponseEntity<List<Comunity>>(list,HttpStatus.MULTI_STATUS);
        }else{
            return new ResponseEntity<List<Comunity>>(list,HttpStatus.OK);
        }

    }

    //更新房屋信息
    @RequestMapping(value="/host",method = RequestMethod.PUT)
    public ResponseEntity hostupdata(@RequestBody Map<String,String> map){
        Comunity comunity=new Comunity();
        comunity.setcId(map.get("cId"));
        comunity.setbName(map.get("bName"));
        comunity.setuName(map.get("uName"));
        comunity.sethId(Integer.parseInt(map.get("hId")));
        comunity.sethName(map.get("hName"));

        Comunity newcomunity=new Comunity();
        newcomunity.setcId(map.get("cId"));
        newcomunity.setbName(map.get("bName"));
        newcomunity.setuName(map.get("uName"));
        newcomunity.sethId(Integer.parseInt(map.get("hostId")));
        newcomunity.sethName(map.get("hostName"));
        try {
            if(cs.update(comunity,newcomunity)){
                return new ResponseEntity(HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.MULTI_STATUS);
    }
    //删除单元信息
    @RequestMapping(value="/host",method = RequestMethod.DELETE)
    public ResponseEntity hostdelete(@RequestParam Map<String,String> map){
        Comunity comunity=new Comunity();
        comunity.setcId(map.get("cId"));
        comunity.setbName(map.get("bName"));
        comunity.setuName(map.get("uName"));
        comunity.sethId(Integer.parseInt(map.get("hId")));
        comunity.sethName(map.get("hName"));
        if(cs.delete(comunity)){
            return new ResponseEntity(HttpStatus.OK);
        }else
            return new ResponseEntity(HttpStatus.MULTI_STATUS);
    }
    //获取单元信息列表（分页）
    @RequestMapping(value="/hostlist",method = RequestMethod.GET)
    public  ResponseEntity<List<Comunity>> gethost(@RequestParam Map<String,String> map) {
        Comunity comunity = new Comunity();
        comunity.setProvince(map.get("province"));
        comunity.setCity(map.get("city"));
        comunity.setDist(map.get("dist"));
        comunity.setcId(map.get("cId"));
        comunity.setbName(map.get("bName"));
        if(map.get("hId")!=null){
            comunity.sethId(Integer.parseInt(map.get("hId")));
        }
        comunity.sethName(map.get("hName"));
        List<Comunity> list = cs.hostlist(comunity, Integer.parseInt(map.get("index"))).getItems();
        if (cs.hostlist(comunity, Integer.parseInt(map.get("index"))).getIsMore() == 0) {
            return new ResponseEntity<List<Comunity>>(list, HttpStatus.MULTI_STATUS);
        } else {
            return new ResponseEntity<List<Comunity>>(list, HttpStatus.OK);
        }
    }

    @ResponseBody
    @RequestMapping("/local/upload")
    public ResponseEntity<String> upload(MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<String>("格式错误",HttpStatus.MULTI_STATUS);
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //验证文件名是否合格
        if(suffixName==".xlsx"||suffixName==".xlx"||suffixName==".et"){
            return new ResponseEntity<String>("格式错误",HttpStatus.MULTI_STATUS);
        }else{
            try {
                ls.upload(file);
                return new ResponseEntity<String>("上传成功",HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<String>("格式错误",HttpStatus.MULTI_STATUS);
            }
        }

    }
    @RequestMapping("/comunity/upload")
    public ResponseEntity<String> comunityupload(MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<String>("格式错误",HttpStatus.MULTI_STATUS);
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //验证文件名是否合格
        if(suffixName==".xlsx"||suffixName==".et"||suffixName==".xlx"){
            return new ResponseEntity<String>("格式错误",HttpStatus.MULTI_STATUS);
        }else{
            try {
                cs.upload(file);
                return new ResponseEntity<String>("上传成功",HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<String>("格式错误 ",HttpStatus.MULTI_STATUS);
            }
        }

    }


}
