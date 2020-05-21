package com.example.libraryse.eneity;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-04-30
 */

public class Category  {


    private Integer cId;

    private String name;

    public Integer getCId() {

        System.out.println(cId+name);return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
