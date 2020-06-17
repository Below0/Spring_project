package com.example.spring_project_1.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

class RestaurantTests {

    @Test
    public void creation(){
        Restaurant restaurant = new Restaurant("BOB");
        assertThat(restaurant.getName(), is("BOB"));
    }

    @Test
    public void information(){
        Restaurant restaurant = new Restaurant("BOB","Seoul");
        assertThat(restaurant.getInformaton(), is("BOB in Seoul"));
        assertThat(restaurant.getAddr(), is("Seoul"));
    }
}