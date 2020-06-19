package com.example.spring_project_1.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final String name;
    private String addr;
    private final Long id;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();

    public Restaurant(Long id, String name, String addr) {
        this.id = id;
        this.name = name;
        this.addr = addr;
    }

    public String getName(){
        return this.name;
    }

    public String getInformaton(){
        return this.name+" in "+this.addr;
    }

    public String getAddr(){
        return this.addr;
    }

    public Long getId(){ return this.id; }

    public List<MenuItem> getMenuItems(){ return this.menuItems; }

    public void addNewMenu(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setNewMenu(List<MenuItem> menuItems) {
        for(MenuItem menuItem : menuItems)
            addNewMenu(menuItem);
    }
}
