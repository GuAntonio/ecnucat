//package com.example.libraryse;
//
//import com.example.libraryse.dao.CatMapper;
//import com.example.libraryse.dao.CategoryMapper;
//import com.example.libraryse.dao.UserMapper;
//import com.example.libraryse.eneity.Cat;
//import com.example.libraryse.eneity.Category;
//import com.example.libraryse.eneity.JotterArticle;
//import com.example.libraryse.service.*;
//import org.apache.shiro.crypto.SecureRandomNumberGenerator;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.lang.reflect.Array;
//import java.util.*;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//
// public class LibraryseApplicationTests {
//	@Autowired
//	UserMapper userMapper;
//	@Autowired
//    CategoryMapper categoryMapper;
//	@Autowired
//	CategoryService categoryService;
//	@Autowired
//    CatMapper catMapper;
//	@Autowired
//    CatService catService;
//	@Autowired
//    AdminMenuService adminMenuService;
//	@Autowired
//    UserService userService;
//	@Autowired
//    AdminPermissionService adminPermissionService;
//	@Autowired
//    AdminRoleService adminRoleService;
//	@Autowired
//    JotterArticleService jotterArticleService;
//	@org.junit.Test
//
//	public void contextLoads() {
//        Category category=categoryService.get(1);
//
//       // Cat cat=new Cat(null,"s3","f","f",0,"f","s","app","fs","kl","hahahah",0,"b",1,1);
//
//       //catService.addorupdate(cat);
//        //catService.deleteById(3);
//        List<Cat> list=catService.listByCategory(0);
//
////        System.out.println(categoryService.get(1).getName());;
////        System.out.println(category.getName());
////        System.out.println(category.getCId()+"vj");
////        List<Cat> list2= catMapper.findAllByCategory(category);
////        System.out.println(list2.toString());
////        for (Cat c:list2 ) {
////            System.out.println(c.getCatName());
////
////        }
//        Deque<Integer> s=new ArrayDeque<>(Arrays.asList(1,2,3));
//        s.pop();
//        s.remove();
//        System.out.println(s);
//
//        Deque<Integer> a=new LinkedList<>(Arrays.asList(1,2,3));
//a.pop();
//        System.out.println(a);
//
//
//
//        System.out.println(new SecureRandomNumberGenerator().nextBytes());
//        for (Cat c :list)
//        {
//            System.out.println( c.getCatName());
//        }
//
////     System.out.println(user.getDate());
////        userMapper.insertUser(user);
//        System.out.println(adminMenuService.getMenusByCurrentUser());
//	}
//    @org.junit.Test
//
//    public void test1()
//    {
//        //System.out.println(adminPermissionService.listPermissionURLsByUser());;
////        System.out.println(userService.listAllUser());
////        System.out.println(adminRoleService.listRolesByUser("test"));
////        JotterArticle article =new JotterArticle(14,"tima","html","md","zhaiyao","fengmian",null);
////        jotterArticleService.addOrUpdate(article);
//    }
//
//}
