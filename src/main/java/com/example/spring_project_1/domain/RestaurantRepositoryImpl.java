package com.example.spring_project_1.domain;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {
    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepositoryImpl(){
        restaurants.add(new Restaurant(1L,"Hayoung","Anyang"));
        restaurants.add(new Restaurant(2L,"Jiwon","Suwon"));
        restaurants.add(new Restaurant(3L,"bob","Seoul"));
        restaurants.add(new Restaurant(4L,"LEE","Busan"));

    }

    @Override
    public List<Restaurant> findAll(){
         return restaurants;
    }

    @Override
    public Restaurant findById(Long id){
        Restaurant restaurant = restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
        return restaurant;
    }
}
