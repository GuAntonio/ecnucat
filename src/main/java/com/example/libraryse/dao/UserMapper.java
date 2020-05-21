package com.example.libraryse.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.libraryse.eneity.User;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-04-30
 */
@Mapper
public interface UserMapper  {
    @Insert({"insert into user(profile_path,username, password, grade,sex,date,salt,name,phone,email,enabled) values (#{profilePath},#{username},#{password},#{grade},#{sex},#{date},#{salt},#{name},#{phone},#{email},#{enabled})"})
    int insertUser(User user);

    @Select("select * from user where username=#{username}")
    User getUserByUsername(String username);
    @Select("select * from user where username=#{username}and password=#{password}")

    User getByUsernameAndPassword(String username,String password);
    @Select("select *from user")
    List<User> listAllUser();
    @Update("update user set profile_path=#{profilePath},username=#{username}, password=#{password}, grade=#{grade},sex=#{sex},date=#{date},salt=#{salt},name=#{name},phone=#{phone},email=#{email},enabled=#{enabled} where id=#{id}")
    void updateUser(User user);


}
