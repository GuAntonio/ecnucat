package com.example.libraryse.dao;

import com.example.libraryse.eneity.AdminRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminRolePermissionDAO {

    @Select("select *from admin_role_permission where rid=#{rid}")
    AdminRolePermission findAllByRid(Integer rid);

}
