package com.demo.mapper;

import com.demo.model.Adminer;
import com.demo.model.AdminerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminerMapper {
    int countById(@Param("list") List<String> comunityidlist);

    int deleteByExample(AdminerExample example);

    int insert(Adminer record);

    int insertSelective(Adminer record);

    Adminer login(Adminer record);

    Adminer userexit(Adminer record);

    List<Adminer> selectByExample();


    int updateByName(@Param("record") Adminer record);

    List<Adminer> selectById(@Param("list") List<String> comunityidlist);

    void deleteByName(String name);

    Adminer selectByName(String name);
}