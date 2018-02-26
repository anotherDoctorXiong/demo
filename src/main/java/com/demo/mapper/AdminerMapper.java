package com.demo.mapper;

import com.demo.model.Adminer;
import com.demo.model.AdminerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminerMapper {
    int countByExample(AdminerExample example);

    int deleteByExample(AdminerExample example);

    int insert(Adminer record);

    int insertSelective(Adminer record);

    List<Adminer> selectByExample(AdminerExample example);

    int updateByExampleSelective(@Param("record") Adminer record, @Param("example") AdminerExample example);

    int updateByExample(@Param("record") Adminer record, @Param("example") AdminerExample example);
}