package com.qiuhuan.sportplay.bean;

//二级导航
public class Submenu {
    private int id;
    private String title;
    private String path;

    public Submenu(){
    }

    public Submenu(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Submenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
