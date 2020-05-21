package com.example.libraryse.dao;

import com.example.libraryse.eneity.AdminPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminPermissionDAO {
@Select("select * from  admin_permission  tb1 join admin_role_permission tb2 on(tb1.id=tb2.pid) where rid=#{red}")
    List<AdminPermission> listallpermbyRid(Integer rid);
@Select("select *from admin_permission ")
    List<AdminPermission> findAll();
}
