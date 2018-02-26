package com.demo.mapper;

import com.demo.model.Comunity;
import com.demo.model.ComunityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComunityMapper {
    int countByExample(ComunityExample example);

    int deleteByExample(ComunityExample example);

    int insert(Comunity record);

    int insertSelective(Comunity record);

    List<Comunity> selectByExample(ComunityExample example);

    int updateByExampleSelective(@Param("record") Comunity record, @Param("example") ComunityExample example);

    int updateByExample(@Param("record") Comunity record, @Param("example") ComunityExample example);
}