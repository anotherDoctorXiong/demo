package com.demo.service;

import com.demo.mapper.CitiesMapper;
import com.demo.mapper.DistsMapper;
import com.demo.mapper.LocalMapper;
import com.demo.mapper.ProvincesMapper;
import com.demo.model.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    //添加小区信息
    public boolean insterComunity (Local local){
        if(localMapper.getComunities(local).size()==0){
            local.setcId(Integer.toString(new Random().nextInt(100)+1));
            System.out.println("插入一条");
            localMapper.insert(local);
            return true;
        }else
            return false;
    }
    //获取小区列表
    public List<Local> comunitylist(Local local){
        local.setProvince(provincesMapper.selectByPrimaryKey(local.getProvince()));
        local.setCity(citiesMapper.selectByPrimaryKey(local.getCity()));
        local.setDist(distsMapper.selectByPrimaryKey(local.getDist()));
        return localMapper.comunitylist(local);
    }
    //更新小区信息
    public boolean comunityupdata(Local local){
        if(localMapper.selectById(local.getcId()).size()!=0){

            localMapper.updateByExample(local);
            return true;
        }
        return false;
    }
}
