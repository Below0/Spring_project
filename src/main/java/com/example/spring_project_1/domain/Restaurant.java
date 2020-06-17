package com.example.spring_project_1.domain;

public class Restaurant {
    private final String name;
    private String addr;
    private final Long id;

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

}
