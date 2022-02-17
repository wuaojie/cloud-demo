package cn.itcast.user.mapper;

import cn.itcast.user.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    
    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Long id);
    @Delete("delete from user where id = #{id}")
    void deleteById(@Param("id") Long id);
    @Delete("delete from user where username = #{name}")
    void deleteByName(@Param("name") String name);
}