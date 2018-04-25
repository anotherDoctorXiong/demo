package com.demo.mapper;

import com.demo.model.Comunity;
import com.demo.model.ComunityExample;
import java.util.List;

import com.demo.model.Local;
import org.apache.ibatis.annotations.Param;

public interface ComunityMapper {
    int countByExample(@Param("record") Comunity record);

    int deleteByExample(ComunityExample example);

    int insert(Comunity record);

    int insertSelective(Comunity record);

    List<Comunity> selectByExample(ComunityExample example);

    int update(@Param("record") Comunity record, @Param("newrecord") Comunity newrecord);

    int delete(@Param("record") Comunity record);

    int updateByExample(@Param("record") Comunity record, @Param("example") ComunityExample example);

    List<String> getbuilds(String cId);

    List<String> getunits(@Param("cId")String cId,@Param("bName")String bName);

    List<String> gethost(@Param("cId")String cId,@Param("bName")String bName,@Param("uName")String uName);

    List<Comunity> alreadyexit(@Param("record") Comunity record);


    List<Comunity> selectById(@Param("cId")String cId);

    List<Comunity> selectByIdList(@Param("list") List<String> idlist);


    List<Comunity> selectUnitByIdList(@Param("list") List<String> idlist);

    List<Comunity> selectUnit(@Param("record") Comunity record);

    List<Comunity> selectHostByIdList(@Param("list") List<String> idlist);

    List<Comunity> selectHost(@Param("record") Comunity record);

    void importExcel(@Param("list") List<Comunity> lists);
}