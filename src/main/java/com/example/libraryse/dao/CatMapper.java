package com.example.libraryse.dao;

import com.example.libraryse.eneity.Cat;
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
public interface CatMapper  {
    @Select("select * from cat order by cat_id ")
    List<Cat> findAll( );
    @Select("select * from cat  where category_id=#{cId} order by cat_id")
    List<Cat> findAllByCategory(Category category);
@Select("select * from cat where cat_name like #{0} or location like #{1}")
    List<Cat> findAllByNameLikeAndLocationLike( String name,  String location);
    @Insert({"insert into cat(cat_name,photo,location,ster_state,tempr,ster_time,apper,seen_time,relation,linktouser,sex,health_state,finder_id,category_id) values (#{catName},#{photo},#{location},#{sterState},#{tempr},#{sterTime},#{apper},#{seenTime},#{relation},#{linktouser},#{sex},#{healthState},#{finderId},#{categoryId})"})
    int insert(Cat cat);
    @Delete("delete from cat where cat_id=#{id}")
    int deleteById(int id);
    @Update({"update cat set cat_name=#{catName},photo=#{photo},location=#{location},ster_state=#{sterState},tempr=#{tempr},ster_time=#{sterTime},apper=#{apper},seen_time=#{seenTime},relation=#{relation},linktouser=#{linktouser},sex=#{sex},health_state=#{healthState},finder_id=#{finderId},category_id=#{categoryId} where cat_id=#{catId}"})
    int update(Cat cat);
    @Select("select * from cat where cat_name=#{0}")
    Cat findByName(String name);
    @Select("select * from cat where cat_id=#{0}")
    Cat findById(Integer id);
    @Select("SELECT likes FROM cat WHERE cat_id=#{id}")
    Integer getLikesById(Integer id);
    @Update("update cat set likes=#{param1} where cat_id=#{param2}")
    void updateLikesById(Integer likes,Integer id);
}
