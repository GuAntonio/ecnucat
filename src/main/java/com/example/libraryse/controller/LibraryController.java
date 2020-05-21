package com.example.libraryse.controller;

import com.example.libraryse.eneity.Cat;
import com.example.libraryse.result.Result;
import com.example.libraryse.result.ResultFactory;
import com.example.libraryse.service.CatService;
import com.example.libraryse.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    CatService catService;

    @GetMapping("/api/books")
    public List<Cat> list() throws Exception {
        return catService.list();
    }

    @PostMapping("/api/books")
    public Cat addOrUpdate(@RequestBody Cat cat) throws Exception {
        catService.addorupdate(cat);
        return cat;
    }

    @PostMapping("/api/delete")
    public void delete( @RequestBody Cat cat) throws Exception {
        catService.deleteById(cat.getCatId());
    }


    @GetMapping("/api/categories/{cid}/books")
    public Result listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return ResultFactory.buildSuccessResult(catService.listByCategory(cid));
        } else {
            return ResultFactory.buildSuccessResult(catService.list());
        }

    }
    @GetMapping("/api/search")
    public List<Cat> searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return catService.list();
        } else {
            return catService.Search(keywords);
        }
    }

    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "/nodepro/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtil.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://www.ecnucat.top:8082/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    @GetMapping("/api/cat/getlikes/{id}")
    public Integer getlikes(@PathVariable("id") int id) {
        return catService.getLikes(id);
    }
    @GetMapping("/api/cat/updatelikes/{id}")
    public int likes(@NotNull @PathVariable Integer id){
        catService.updateLikes(id);
        return 0;
    }


}

