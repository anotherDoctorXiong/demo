package com.demo.service;

import com.demo.mapper.CitiesMapper;
import com.demo.mapper.DistsMapper;
import com.demo.mapper.LocalMapper;
import com.demo.mapper.ProvincesMapper;
import com.demo.model.Cities;
import com.demo.model.Dists;
import com.demo.model.Local;
import com.demo.model.Provinces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public List<Local> getcomunities(Local local){
        return localMapper.getComunities(local);
    }

}
