package com.example.spring_project_1.inferfaces;

import com.example.spring_project_1.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1004L,"BOB","Seoul");
        Restaurant restaurant1 = new Restaurant(1005L, "Hayoung","Anyang");
        restaurants.add(restaurant);
        restaurants.add(restaurant1);
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1L, "BOB","Seoul"));
        restaurants.add(new Restaurant(2L, "LEE","Seoul"));
        restaurants.add(new Restaurant(3L, "BB","Seoul"));
        restaurants.add(new Restaurant(4L, "OB","Seoul"));

        Restaurant restaurant = restaurants.stream().filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
        return restaurant;
    }

}
