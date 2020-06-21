package com.example.spring_project_1.application;

import com.example.spring_project_1.domain.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;

class RestaurantServiceTest {

    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private MenuItemRepository menuItemRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        List<Restaurant> restaurantList = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1L, "BOB","Seoul");
        restaurant.addNewMenu(new MenuItem("Kimchi"));
        restaurantList.add(restaurant);


        given(restaurantRepository.findAll()).willReturn(restaurantList);
        given(restaurantRepository.findById(1L)).willReturn(restaurant);
        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
    }

    @Test
    public void getRestaurant(){
        Restaurant restaurant = restaurantService.getRestaurant(1L);
        assertThat(restaurant.getId(),is(1L));
        assertThat(restaurant.getMenuItems().get(0).getName(),is("Kimchi"));

    }

    @Test
    public void getRestaurants() {
        Restaurant restaurant = restaurantService.getRestaurants().get(0);
        assertThat(restaurant.getId(),is(1L));

    }


}