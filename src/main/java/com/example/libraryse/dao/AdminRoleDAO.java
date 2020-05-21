package com.example.libraryse.dao;

import com.example.libraryse.eneity.AdminRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminRoleDAO {
    @Select("select *from admin_role  tb1 join  user tb2 join admin_user_role tb3 on(tb2.id=tb3.uid and tb1.id=tb3.rid) where username=#{username}")
    List<AdminRole> listRolesByUsername(String username);
    @Select("select *from admin_role ")
    List<AdminRole> listallRoles();
}
