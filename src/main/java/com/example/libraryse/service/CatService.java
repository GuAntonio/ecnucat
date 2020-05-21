package com.example.libraryse.service;

import com.example.libraryse.dao.CatMapper;
import com.example.libraryse.eneity.Cat;
import com.example.libraryse.eneity.Category;
import com.example.libraryse.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatService
{
    @Autowired
    CatMapper catDAO;
    @Autowired
    CategoryService categoryService;
    @Autowired
    RedisUtil redisUtil;
    private static String LIKE_KEY(Integer id){
        return "rediscat:likes:" + id;
    }

    public List<Cat> list() {
    List<Cat> list=catDAO.findAll();
        for (Cat c:list
             ) {String name=categoryService.get(c.getCategoryId()).getName();
             c.setCategoryName(name);
            }
        return list;
    }

    public void addorupdate(Cat cat) {//如果有名字更新，无名字插入
        Integer catId=cat.getCatId();
        if(catId==null)
        catDAO.insert(cat);
        else
            catDAO.update(cat);
    }

    public void deleteById(int id) {
        catDAO.deleteById(id);
    }

    public List<Cat> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        List<Cat> list=catDAO.findAllByCategory(category);
        for (Cat c:list
                ) {
            System.out.println(c.getCatName());
            String name=categoryService.get(c.getCategoryId()).getName();
            c.setCategoryName(name);
        }
        return list;
    }
    public List<Cat> Search(String keywords) {
      List<Cat> list=catDAO.findAllByNameLikeAndLocationLike('%' + keywords + '%', '%' + keywords + '%');
        for (Cat c:list
                ) {String name=categoryService.get(c.getCategoryId()).getName();
            c.setCategoryName(name);
        }
        return list;
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
        likes = Optional.ofNullable(catDAO.getLikesById(id)).orElse(0);

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
            likes = Optional.ofNullable(catDAO.getLikesById(id)).orElse(0);
            //存到redis里
            redisUtil.set(LIKE_KEY(id),likes + 1);
        }
    }

}
