package com.example.libraryse.controller;

import com.example.libraryse.eneity.JotterArticle;
import com.example.libraryse.result.Result;
import com.example.libraryse.result.ResultFactory;
import com.example.libraryse.service.JotterArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
public class ContentController {
    @Autowired
    JotterArticleService jotterArticleService;
    @PostMapping("api/admin/content/article")
    public Result saveArticle(@RequestBody JotterArticle article) {
        jotterArticleService.addOrUpdate(article);
        return ResultFactory.buildSuccessResult("保存成功");
    }
    @GetMapping("/api/article/{size}/{page}")
    public Result listArticles(@PathVariable("size") int size, @PathVariable("page") int page) {
        return ResultFactory.buildSuccessResult(jotterArticleService.list(page - 1, size));
    }
    @GetMapping("/api/article/{id}")
    public JotterArticle getOneArticle(@PathVariable("id") int id) {
        return jotterArticleService.findById(id);
    }
    @GetMapping("/api/article/getlikes/{id}")
    public Integer getlikes(@PathVariable("id") int id) {
        return jotterArticleService.getLikes(id);
    }
    @GetMapping("/api/article/updatelikes/{id}")
    public int likes(@NotNull @PathVariable Integer id){
        jotterArticleService.updateLikes(id);
        return 0;
    }





}
