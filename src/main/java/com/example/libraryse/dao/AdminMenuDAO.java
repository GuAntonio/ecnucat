package com.example.libraryse.dao;

import com.example.libraryse.eneity.AdminMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMenuDAO {
    @Select("select * from admin_menu where id=#{id}")
    List<AdminMenu>findAllById (Integer id);
    @Select("select * from admin_menu where parent_id=#{id}")
    List<AdminMenu>getAllByParentId(Integer id);
}
