package com.demo.service;

import com.github.pagehelper.PageHelper;
import com.demo.PageBean;
import com.demo.mapper.ComunityMapper;
import com.demo.model.Comunity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class   page {
    @Autowired
    private ComunityMapper comunityMapper;

    /*public List<Comunity> findItemByPage(int currentPage, int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);

        List<Comunity> allItems = itemMapper.findAll();        //全部商品
        int countNums = itemMapper.countItem();            //总记录数
        PageBean<Comunity> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allItems);
        return pageData.getItems();
    }*/
}
