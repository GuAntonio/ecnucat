package com.example.libraryse.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-04-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat  {
    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getTempr() {
        return tempr;
    }

    public void setSterState(String sterState) {
        this.sterState = sterState;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTempr(String tempr) {
        this.tempr = tempr;
    }

    public String getSterTime() {
        return sterTime;
    }

    public void setSterTime(String sterTime) {
        this.sterTime = sterTime;
    }

    public String getApper() {
        return apper;
    }

    public void setApper(String apper) {
        this.apper = apper;
    }

    private Integer catId;
    private String catName;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getSeenTime() {
        return seenTime;
    }

    public void setSeenTime(String seenTime) {
        this.seenTime = seenTime;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getLinktouser() {
        return linktouser;
    }

    public void setLinktouser(String linktouser) {
        this.linktouser = linktouser;
    }



    public String getHealthState() {
        return healthState;
    }

    public void setHealthState(String healthState) {
        this.healthState = healthState;
    }

    public Integer getFinderId() {
        return finderId;
    }

    public void setFinderId(Integer finderId) {
        this.finderId = finderId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    private String photo;

    private String location;

    private String sterState;

    private String tempr;

    private String sterTime;

    private String apper;

    private String seenTime;

    private String relation;

    private String linktouser;

    private String sex;

    private String healthState;

    private Integer finderId;

    public String getSterState() {
        return sterState;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getSex() {
        return sex;

    }



    private Integer categoryId;
    private String categoryName;
    private Integer likes;



}
