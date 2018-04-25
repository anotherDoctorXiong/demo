package com.demo.service;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.demo.mapper.*;
import com.demo.model.Cities;
import com.demo.model.Dists;
import com.demo.model.Local;
import com.demo.model.Provinces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class localservice {

    @Autowired
    private ProvincesMapper provincesMapper;
    @Autowired
    private CitiesMapper citiesMapper;
    @Autowired
    private DistsMapper distsMapper;
    @Autowired
    private LocalMapper localMapper;
    @Autowired
    private ComunityMapper comunityMapper;

    //获取省份列表
    public List<Provinces> getprovince(){
        return provincesMapper.selectByExample();
    }
    //获取城市列表
    public List<Cities> getcities(String provinceid) {
        return citiesMapper.selectByExample(provinceid);
    }
    //获取县区列表
    public List<Dists> getdists(String cityid) {
        return distsMapper.selectByExample(cityid);
    }
    /*public List<Cities> getcities(String id){
        return citiesMapper.selectByExample(id);
    }
    public List<Dists> getdists(String id){
        return distsMapper.selectByExample(id);
    }*/
    public List<Local> checkcomunities(Local local){
        return localMapper.checkComunities(local);
    }

    public List<Local> getcomunities(String dist){
        return localMapper.getComunities(dist);
    }

    public List<String> getbuilds(String cId) {
        return comunityMapper.getbuilds(cId);
    }
    public List<String> getunits(String cId,String bName) {
        return comunityMapper.getunits(cId,bName);
    }
    public List<String> gethost(String cId,String bName,String uName) {
        return comunityMapper.gethost(cId,bName,uName);
    }

    public List<Local> getallcomunity() {
        return localMapper.getAllComunity();
    }
    public void upload(MultipartFile file) throws Exception{
        String fileName = file.getOriginalFilename();

        String prefix=fileName.substring(fileName.lastIndexOf("."));

        final File excelFile = File.createTempFile(prefix,".xls");
        // MultipartFile to File
        file.transferTo(excelFile);
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        List<Local> lists= ExcelImportUtil.importExcel(excelFile,Local.class,params);
        localMapper.importExcel(lists);
        if (excelFile.exists()) {
            excelFile.delete();
        }
    }
}
