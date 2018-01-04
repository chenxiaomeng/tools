package com.cxm.springmvc.mapper;

import com.cxm.springmvc.entity.DataTemplate;
import com.cxm.springmvc.entity.DataTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DataTemplateMapper {
    @SelectProvider(type=DataTemplateSqlProvider.class, method="countByExample")
    long countByExample(DataTemplateExample example);

    @DeleteProvider(type=DataTemplateSqlProvider.class, method="deleteByExample")
    int deleteByExample(DataTemplateExample example);

    @Delete({
        "delete from data_template",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into data_template (id, name_zh, ",
        "name_en, owner, owner_name, ",
        "is_deploy, tag, tag_name, ",
        "description, is_valid, ",
        "add_time, update_time, ",
        "detail)",
        "values (#{id,jdbcType=VARCHAR}, #{nameZh,jdbcType=VARCHAR}, ",
        "#{nameEn,jdbcType=VARCHAR}, #{owner,jdbcType=VARCHAR}, #{ownerName,jdbcType=VARCHAR}, ",
        "#{isDeploy,jdbcType=INTEGER}, #{tag,jdbcType=VARCHAR}, #{tagName,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{isValid,jdbcType=INTEGER}, ",
        "#{addTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{detail,jdbcType=LONGVARCHAR})"
    })
    int insert(DataTemplate record);

    @InsertProvider(type=DataTemplateSqlProvider.class, method="insertSelective")
    int insertSelective(DataTemplate record);

    @SelectProvider(type=DataTemplateSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name_zh", property="nameZh", jdbcType=JdbcType.VARCHAR),
        @Result(column="name_en", property="nameEn", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner", property="owner", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner_name", property="ownerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deploy", property="isDeploy", jdbcType=JdbcType.INTEGER),
        @Result(column="tag", property="tag", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_name", property="tagName", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="detail", property="detail", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<DataTemplate> selectByExampleWithBLOBs(DataTemplateExample example);

    @SelectProvider(type=DataTemplateSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name_zh", property="nameZh", jdbcType=JdbcType.VARCHAR),
        @Result(column="name_en", property="nameEn", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner", property="owner", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner_name", property="ownerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deploy", property="isDeploy", jdbcType=JdbcType.INTEGER),
        @Result(column="tag", property="tag", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_name", property="tagName", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DataTemplate> selectByExample(DataTemplateExample example);

    @Select({
        "select",
        "id, name_zh, name_en, owner, owner_name, is_deploy, tag, tag_name, description, ",
        "is_valid, add_time, update_time, detail",
        "from data_template",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name_zh", property="nameZh", jdbcType=JdbcType.VARCHAR),
        @Result(column="name_en", property="nameEn", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner", property="owner", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner_name", property="ownerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deploy", property="isDeploy", jdbcType=JdbcType.INTEGER),
        @Result(column="tag", property="tag", jdbcType=JdbcType.VARCHAR),
        @Result(column="tag_name", property="tagName", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_valid", property="isValid", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="detail", property="detail", jdbcType=JdbcType.LONGVARCHAR)
    })
    DataTemplate selectByPrimaryKey(String id);

    @UpdateProvider(type=DataTemplateSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") DataTemplate record, @Param("example") DataTemplateExample example);

    @UpdateProvider(type=DataTemplateSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") DataTemplate record, @Param("example") DataTemplateExample example);

    @UpdateProvider(type=DataTemplateSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") DataTemplate record, @Param("example") DataTemplateExample example);

    @UpdateProvider(type=DataTemplateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DataTemplate record);

    @Update({
        "update data_template",
        "set name_zh = #{nameZh,jdbcType=VARCHAR},",
          "name_en = #{nameEn,jdbcType=VARCHAR},",
          "owner = #{owner,jdbcType=VARCHAR},",
          "owner_name = #{ownerName,jdbcType=VARCHAR},",
          "is_deploy = #{isDeploy,jdbcType=INTEGER},",
          "tag = #{tag,jdbcType=VARCHAR},",
          "tag_name = #{tagName,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "is_valid = #{isValid,jdbcType=INTEGER},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "detail = #{detail,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(DataTemplate record);

    @Update({
        "update data_template",
        "set name_zh = #{nameZh,jdbcType=VARCHAR},",
          "name_en = #{nameEn,jdbcType=VARCHAR},",
          "owner = #{owner,jdbcType=VARCHAR},",
          "owner_name = #{ownerName,jdbcType=VARCHAR},",
          "is_deploy = #{isDeploy,jdbcType=INTEGER},",
          "tag = #{tag,jdbcType=VARCHAR},",
          "tag_name = #{tagName,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "is_valid = #{isValid,jdbcType=INTEGER},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(DataTemplate record);
}