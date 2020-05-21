package com.example.libraryse.dao;

import com.example.libraryse.eneity.Category;
import org.apache.ibatis.annotations.*;

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
public interface CategoryMapper  {
    @Select("select * from category order by c_id ")
    List<Category>  findAll();
    @ResultType(Category.class)
    @Select({"select * from category where c_id=#{cId} "})
    Category   findById(int cId);

}
