package com.example.libraryse.service;

import com.example.libraryse.dao.ArticleDAO;
import com.example.libraryse.dto.Page;
import com.example.libraryse.eneity.JotterArticle;
import com.example.libraryse.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JotterArticleService {
    @Autowired
    ArticleDAO articleDAO;
    @Autowired
    RedisUtil redisUtil;
    private static String LIKE_KEY(Integer id){
        return "redisdemo:likes:" + id;
    }

    public  void addOrUpdate(JotterArticle article) {
        if(article.getId()==null)
         articleDAO.addArticle(article);
        else
             articleDAO.updateArticle(article);
    }
    public Page list(int page, int size) {
        int offset = page  * size;
        Page page1=new Page();
        List<JotterArticle > list= articleDAO.getOnePageArticle(offset,size);
       page1.setContent(list);
        Integer totalcount=articleDAO.getcount();
//        if(totalcount%size==0)
//            page1.setTotalCount(totalcount/size);
//        else page1.setTotalCount(totalcount/size+1);
        page1.setTotalCount(totalcount);
        return page1;

    }

    public JotterArticle findById(int id) {
        return articleDAO.findArticleById(id);
    }
    private Integer getLikesFromRedis(Integer id){
        Integer likes;
        try{
            //从redis中取出键为LIKE_KEY(Integer id)的值
            likes = (Integer)redisUtil.get(LIKE_KEY(id));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return likes;
    }

    public int getLikes(Integer id){
        Integer likes = getLikesFromRedis(id);
        //如果redis里能取出一个非null值（说明redis有维护这个帖子的点赞数），就直接返回
        if(likes != null)return likes;

        //redis中没存点赞数的情况
        //先从mysql里把点赞数取出来
        likes = Optional.ofNullable(articleDAO.getLikesById(id)).orElse(0);

        //存到redis里
        redisUtil.set(LIKE_KEY(id),likes);
        return likes;
    }


    public void updateLikes(Integer id){
        Integer likes = getLikesFromRedis(id);
        //如果redis里能取出一个非null值（说明redis有维护这个帖子的点赞数），就直接在原基础上+1
        if(likes != null){
            redisUtil.set(LIKE_KEY(id),likes + 1);
        }else{
            //redis取不出，就从mysql取
            likes = Optional.ofNullable(articleDAO.getLikesById(id)).orElse(0);
            //存到redis里
            redisUtil.set(LIKE_KEY(id),likes + 1);
        }
    }
    }

