package com.example.libraryse;

import com.example.libraryse.eneity.Cat;
import com.example.libraryse.eneity.JotterArticle;

import java.lang.reflect.Field;
public class EntityGe {


    public static void printAllFields(Object obj){
        Class    cls=obj.getClass();
        //String a="cat_id,cat_name,photo,location,ster_state,tempr,ster_time,apper,seen_time,relation,linktouser,sex,health_state,finder_id,category_id";
        String a="id,article_title,article_content_html,article_content_md,article_abstract,article_cover,article_date";
        String b="未知\n" +
                "美国短毛猫\n" +
                "英国短毛猫\n" +
                "布偶猫\n" +
                "波斯猫\n" +
                "加菲猫\n" +
                "苏格兰折耳猫\n" +
                "暹罗猫\n" +
                "斯芬克斯猫\n" +
                "卷毛猫\n" +
                "阿比西尼亚猫\n" +
                "狸花猫\n" +
                "橘猫";
        String splint[]= a.split(",") ;
        String splint2[]=b.split("\n");
        Field[] fields=cls.getDeclaredFields();
        System.out.println("共有"+splint.length+"个属性");
        for (int i=0;i<fields.length;i++) {
            fields[i].setAccessible(true);
            try {
                System.out.print(splint[i]+"=#{"+fields[i].getName()+"},");
                //System.out.print("\""+fields[i].getName()+"\":,");
                //System.out.println(fields[i].getName()+":item."+fields[i].getName()+",");
                //System.out.print("#{"+fields[i].getName()+"}"+",");
                //System.out.println(fields[i].getName()+":this.form."+fields[i].getName()+",");
                //System.out.println(" <el-option label=\""+splint2[i]+"\" value=\""+i+"\"></el-option>");
//                System.out.println(" <el-menu-item index=\""+i+"\">\n" +
//                        "      <i class=\"el-icon-menu\"></i>\n" +
//                        "      <span slot=\"title\">"+splint2[i]+"</span>\n" +
//                        "    </el-menu-item>");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
         Cat cat=new Cat() ;
        JotterArticle jotterArticle=new JotterArticle();
       EntityGe. printAllFields(jotterArticle);
    }
}
