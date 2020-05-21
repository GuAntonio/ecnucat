package com.example.libraryse.service;

import com.example.libraryse.dao.CategoryMapper;
import com.example.libraryse.eneity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryDAO;

    public List<Category> list() {

        return categoryDAO.findAll();
    }

    public Category get(int id) {
        Category c= categoryDAO.findById(id);
        return c;
    }
}
