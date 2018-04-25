package com.demo.mapper;

import com.demo.model.Local;
import com.demo.model.LocalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocalMapper {
    int countByExample(@Param("record") Local record);

    int deleteByExample(LocalExample example);

    int insert(Local record);

    int insertSelective(Local record);

    int importExcel(@Param("list") List<Local> list);

    List<Local> checkComunities(@Param("record") Local record);

    List<Local> getComunities(String dist);

    List<Local> getAllComunity();

    List<Local> comunitylist(@Param("record") Local record);

    List<String> comunityidlist(@Param("record") Local record);

    List<Local> selectById(String id);

    int updateByExampleSelective(@Param("record") Local record, @Param("example") LocalExample example);

    int updateByExample(@Param("record") Local record);

    void deleteById(String id);
}