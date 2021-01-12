package com.kreate.daggerwithhilt.entity.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FavouritePerentEntity {

    @SerializedName("menu_name")
    @Expose
    private String menuName;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuClass() {
        return menuClass;
    }

    public void setMenuClass(String menuClass) {
        this.menuClass = menuClass;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public List<FavouriteChildEntity> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<FavouriteChildEntity> subMenu) {
        this.subMenu = subMenu;
    }

    @SerializedName("menu_id")
    @Expose
    private Integer menuId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("menu_class")
    @Expose
    private String menuClass;

    @SerializedName("order_by")
    @Expose
    private String orderBy;

    @SerializedName("subMenu")
    @Expose
    private List<FavouriteChildEntity> subMenu = new ArrayList<>();

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    private int pos;


}
