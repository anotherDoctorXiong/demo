package com.demo.mapper;

import com.demo.model.Local;
import com.demo.model.LocalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocalMapper {
    int countByExample(LocalExample example);

    int deleteByExample(LocalExample example);

    int insert(Local record);

    int insertSelective(Local record);

    List<Local> getComunities(@Param("record")Local record);

    List<Local> comunitylist(@Param("record")Local record);

    List<Local> selectById(String id);

    int updateByExampleSelective(@Param("record") Local record, @Param("example") LocalExample example);

    int updateByExample(@Param("record") Local record);
}