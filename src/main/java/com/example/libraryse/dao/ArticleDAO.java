package com.example.libraryse.dao;

import com.example.libraryse.eneity.JotterArticle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ArticleDAO {
@Insert({"insert into jotter_article (article_title,article_content_html,article_content_md,article_abstract,article_cover,article_date) values(#{articleTitle},#{articleContentHtml},#{articleContentMd},#{articleAbstract},#{articleCover},#{articleDate})"})
     void addArticle(JotterArticle article) ;
@Update("update jotter_article set article_title=#{articleTitle},article_content_html=#{articleContentHtml},article_content_md=#{articleContentMd},article_abstract=#{articleAbstract},article_cover=#{articleCover},article_date=#{articleDate} where id=#{id}")
   void updateArticle(JotterArticle article) ;
@Select({"select *from jotter_article limit #{param1},#{param2}"})
List<JotterArticle> getOnePageArticle(Integer offset,Integer size);
@Select("select count(*) from jotter_article ")
Integer getcount();
@Select("select *from jotter_article where id=#{id}")
   JotterArticle findArticleById(Integer id);
    @Select("SELECT likes FROM jotter_article WHERE id=#{id}")
    Integer getLikesById(Integer id);
    @Update("update jotter_article set likes=#{param1} where id=#{param2}")
    void updateLikesById(Integer likes,Integer id);
}
