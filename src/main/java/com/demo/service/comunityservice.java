package com.demo.service;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.demo.PageBean;
import com.demo.mapper.*;
import com.demo.model.Comunity;
import com.demo.model.Local;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class comunityservice {
    @Autowired
    private LocalMapper localMapper;
    @Autowired
    private ProvincesMapper provincesMapper;
    @Autowired
    private CitiesMapper citiesMapper;
    @Autowired
    private DistsMapper distsMapper;
    @Autowired
    private ComunityMapper comunityMapper;
    //添加小区信息
    public boolean insterComunity (Local local){
        if(localMapper.checkComunities(local).size()==0){
            local.setcId(Integer.toString(new Random().nextInt(100)+1));
            System.out.println("插入一条");
            localMapper.insert(local);
            return true;
        }else
            return false;
    }
    //获取小区列表(带分页)
    public PageBean<Local> comunitylist(Local local,int index){
        PageHelper.startPage(index, 10);
        List<Local> allItems = localMapper.comunitylist(local);
        int countNums = localMapper.countByExample(local);
        PageBean<Local> pageData = new PageBean<>(index, 10, countNums);
        pageData.setItems(allItems);
        return pageData;
        //return localMapper.comunitylist(local);
    }
    //更新小区信息
    public boolean comunityupdata(Local local){
        if(localMapper.selectById(local.getcId()).size()!=0&&localMapper.checkComunities(local).size()==0){
            localMapper.updateByExample(local);
            return true;
        }
        return false;
    }
    //删除小区信息
    public boolean comunitydelete(String id) {
        if(localMapper.selectById(id).size()!=0){
            localMapper.deleteById(id);
            return true;
        }else
            return false;
    }

    //获取楼栋列表(带分页)
    public PageBean<Comunity> list(Comunity comunity,int index){
        PageHelper.startPage(index, 10);
        List<Comunity> allItems=new ArrayList<Comunity>();
        if(comunity.getcId()==""){
            Local local=new Local();
            local.setProvince(comunity.getProvince());
            local.setCity(comunity.getCity());
            local.setDist(comunity.getDist());
            System.out.println(localMapper.comunityidlist(local).size());
            allItems=comunityMapper.selectByIdList(localMapper.comunityidlist(local));
        }else {
            allItems = comunityMapper.selectById(comunity.getcId());
        }
        int countNums = comunityMapper.countByExample(comunity);
        PageBean<Comunity> pageData = new PageBean<>(index, 10, countNums);
        pageData.setItems(allItems);
        return pageData;
    }

    //获取单元列表(带分页)
    public PageBean<Comunity> unitlist(Comunity comunity,int index){
        PageHelper.startPage(index, 10);
        List<Comunity> allItems=new ArrayList<Comunity>();
        if(comunity.getcId()==""){
            Local local=new Local();
            local.setProvince(comunity.getProvince());
            local.setCity(comunity.getCity());
            local.setDist(comunity.getDist());
            if(localMapper.comunityidlist(local).size()!=0){
                allItems=comunityMapper.selectUnitByIdList(localMapper.comunityidlist(local));
            }
        }else {
            Comunity comunity1=new Comunity();
            comunity1.setcId(comunity.getcId());
            comunity1.setbName(comunity.getbName());
            allItems = comunityMapper.selectUnit(comunity1);
        }
        int countNums = comunityMapper.countByExample(comunity);
        PageBean<Comunity> pageData = new PageBean<>(index, 10, countNums);
        pageData.setItems(allItems);
        return pageData;
    }
    //获取房屋列表(带分页)
    public PageBean<Comunity> hostlist(Comunity comunity,int index){
        PageHelper.startPage(index, 10);
        List<Comunity> allItems=new ArrayList<Comunity>();
        if(comunity.getcId()==""){
            Local local=new Local();
            local.setProvince(comunity.getProvince());
            local.setCity(comunity.getCity());
            local.setDist(comunity.getDist());
            if(localMapper.comunityidlist(local).size()!=0){
                allItems=comunityMapper.selectHostByIdList(localMapper.comunityidlist(local));
            }
        }else {
            Comunity comunity1=new Comunity();
            comunity1.setcId(comunity.getcId());
            comunity1.setbName(comunity.getbName());
            comunity1.setuName(comunity.getuName());
            allItems = comunityMapper.selectHost(comunity1);
        }
        int countNums = comunityMapper.countByExample(comunity);
        PageBean<Comunity> pageData = new PageBean<>(index, 10, countNums);
        pageData.setItems(allItems);
        return pageData;
    }
    //更新
    public boolean update(Comunity comunity,Comunity newcomunity) {
        System.out.println(comunity.gethId()+comunity.gethName());

        System.out.println(comunityMapper.alreadyexit(comunity).size()+""+comunityMapper.alreadyexit(newcomunity).size());

        if(comunityMapper.alreadyexit(comunity).size()!=0&&comunityMapper.alreadyexit(newcomunity).size()==0){
            comunityMapper.update(comunity,newcomunity);
            return true;
        }
        return false;
    }
    //删除
    public boolean delete(Comunity comunity) {
        if(comunityMapper.alreadyexit(comunity).size()!=0){
            comunityMapper.delete(comunity);
            return true;
        }
        return false;
    }
    //添加
    public boolean insert(Comunity comunity){
        if(comunityMapper.alreadyexit(comunity).size()==0){
            comunityMapper.insertSelective(comunity);
            return true;
        }
        return false;
    }

    public void upload(MultipartFile file) throws Exception{
        String Name = file.getOriginalFilename();
        String prefix=Name.substring(Name.lastIndexOf("."));
        final File excelFile = File.createTempFile(prefix,".xls");
        // MultipartFile to File
        file.transferTo(excelFile);
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        List<Comunity> lists= ExcelImportUtil.importExcel(excelFile,Comunity.class,params);
        comunityMapper.importExcel(lists);
        if (excelFile.exists()) {
            excelFile.delete();
        }
    }

}
