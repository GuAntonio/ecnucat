package com.example.libraryse.dao;

import com.example.libraryse.eneity.AdminRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminRoleMenuDAO {
    @Select("select * from admin_role_menu where rid=#{rid}")
    List<AdminRoleMenu>  findAllByRid(Integer rid);
}
