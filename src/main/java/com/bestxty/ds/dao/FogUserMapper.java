package com.bestxty.ds.dao;

import com.bestxty.ds.bean.FogUser;
import com.bestxty.ds.bean.FogUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FogUserMapper {
    int countByExample(FogUserExample example);

    int deleteByExample(FogUserExample example);

    @Delete({
        "delete from tb_fog_user",
        "where fog_user_id = #{fogUserId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer fogUserId);

    @Insert({
        "insert into tb_fog_user (fog_user_id, userId, ",
        "token)",
        "values (#{fogUserId,jdbcType=INTEGER}, #{userid,jdbcType=VARCHAR}, ",
        "#{token,jdbcType=VARCHAR})"
    })
    int insert(FogUser record);

    int insertSelective(FogUser record);

    List<FogUser> selectByExample(FogUserExample example);

    @Select({
        "select",
        "fog_user_id, userId, token",
        "from tb_fog_user",
        "where fog_user_id = #{fogUserId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    FogUser selectByPrimaryKey(Integer fogUserId);

    int updateByExampleSelective(@Param("record") FogUser record, @Param("example") FogUserExample example);

    int updateByExample(@Param("record") FogUser record, @Param("example") FogUserExample example);

    int updateByPrimaryKeySelective(FogUser record);

    @Update({
        "update tb_fog_user",
        "set userId = #{userid,jdbcType=VARCHAR},",
          "token = #{token,jdbcType=VARCHAR}",
        "where fog_user_id = #{fogUserId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FogUser record);
}