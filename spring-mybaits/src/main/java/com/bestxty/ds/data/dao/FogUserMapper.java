package com.bestxty.ds.data.dao;

import com.bestxty.ds.data.bean.FogUser;
import com.bestxty.ds.data.bean.FogUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface FogUserMapper {
    int countByExample(FogUserExample example);

    int deleteByExample(FogUserExample example);

    @Delete({
            "delete from tb_fog_user",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
            "insert into tb_fog_user (id, token, ",
            "username, password)",
            "values (#{id,jdbcType=VARCHAR}, #{token,jdbcType=VARCHAR}, ",
            "#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR})"
    })
    int insert(FogUser record);

    int insertSelective(FogUser record);

    List<FogUser> selectByExample(FogUserExample example);

    @Select({
            "select",
            "id, token, username, password",
            "from tb_fog_user",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    FogUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FogUser record, @Param("example") FogUserExample example);

    int updateByExample(@Param("record") FogUser record, @Param("example") FogUserExample example);

    int updateByPrimaryKeySelective(FogUser record);

    @Update({
            "update tb_fog_user",
            "set token = #{token,jdbcType=VARCHAR},",
            "username = #{username,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(FogUser record);
}