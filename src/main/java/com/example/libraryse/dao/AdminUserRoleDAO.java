package com.example.libraryse.dao;

import com.example.libraryse.eneity.AdminUserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminUserRoleDAO {
    @Select("select * from admin_user_role where uid=#{uid}")
    List<AdminUserRole> findAllByUid(int uid);
@Delete("delete from admin_user_role where uid=#{uid}")
    void deleteAllByUid(int uid);
@Insert({"insert into admin_user_role (uid,rid) values(#{uid},#{rid})"})
    void insertAdminUserRole(AdminUserRole adminUserRole);
}
