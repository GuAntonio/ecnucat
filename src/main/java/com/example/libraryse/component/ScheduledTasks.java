package com.example.libraryse.component;

import com.example.libraryse.dao.ArticleDAO;
import com.example.libraryse.dao.CatMapper;
import com.example.libraryse.eneity.Cat;
import com.example.libraryse.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledTasks {
    @Autowired
    RedisUtil redisUtil;

    @Autowired
    ArticleDAO articleDAO;
@Autowired
    CatMapper catMapper;
    //半夜执行一次
    //@Scheduled(cron = "0 0 0 * * ?")
    @Scheduled(fixedRate = 30000)
    public void reportCurrentTime() {
        Integer likes;
        try{
            //从redis中取出键为LIKE_KEY(Integer id)的值
//            likes = (Integer)redisUtil.get("redisdemo:likes:1");
//            if(likes != null){
//                articleDAO.updateLikesById(likes,1);
//
//            }
            List<Cat> l=catMapper.findAll();
            for (Cat c:l) {
               Integer id=c.getCatId();
                likes = (Integer)redisUtil.get("rediscat:likes:"+id);
                if(likes != null){
                    catMapper.updateLikesById(likes,id);

                }
            }

        }catch (Exception e){
        }
    }
}
