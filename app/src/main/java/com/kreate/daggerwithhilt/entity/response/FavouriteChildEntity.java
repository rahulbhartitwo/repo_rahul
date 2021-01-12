package com.kreate.daggerwithhilt.entity.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FavouriteChildEntity {

    @SerializedName("menu_name")
    @Expose
    private String menuName;
    @SerializedName("menu_id")
    @Expose
    private Integer menuId;
    @SerializedName("url")
    @Expose
    private String url;

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

    @SerializedName("menu_class")
    @Expose
    private String menuClass;

//    @SerializedName("subMenu")
//    @Expose
//    private List<SubChildModel> subChildModels = new ArrayList<>();


}
