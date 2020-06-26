package com.qiuhuan.sportplay.bean;

import java.util.List;

//主导航
public class MainMenu {
    private int id;
    private String title;
    private String path;
    private List<Submenu> sList;

    public MainMenu(){
    }

    public MainMenu(String title, String path, List<Submenu> sList) {
        this.title = title;
        this.path = path;
        this.sList = sList;
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

    public void setsList(List<Submenu> sList) {
        this.sList = sList;
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

    public List<Submenu> getsList() {
        return sList;
    }

    @Override
    public String toString() {
        return "MainMenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", sList=" + sList +
                '}';
    }
}
