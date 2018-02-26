package com.demo.mapper;

import com.demo.model.Dists;
import com.demo.model.DistsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DistsMapper {
    int countByExample(DistsExample example);

    int deleteByExample(DistsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dists record);

    int insertSelective(Dists record);

    List<Dists> selectByExample(@Param("cityid")String cityid);

    String selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Dists record, @Param("example") DistsExample example);

    int updateByExample(@Param("record") Dists record, @Param("example") DistsExample example);

    int updateByPrimaryKeySelective(Dists record);

    int updateByPrimaryKey(Dists record);
}