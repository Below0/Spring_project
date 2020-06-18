package com.example.spring_project_1.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepository(){
        restaurants.add(new Restaurant(1L,"Hayoung","Anyang"));
        restaurants.add(new Restaurant(2L,"Jiwon","Suwon"));
        restaurants.add(new Restaurant(3L,"bob","Seoul"));
        restaurants.add(new Restaurant(4L,"LEE","Busan"));

    }

    public List<Restaurant> findAll(){
         return restaurants;
    }

    public Restaurant findById(Long id){
        Restaurant restaurant = restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
        return restaurant;
    }
}
