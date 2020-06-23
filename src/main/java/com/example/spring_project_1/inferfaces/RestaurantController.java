package com.example.spring_project_1.inferfaces;

import com.example.spring_project_1.application.RestaurantService;
import com.example.spring_project_1.domain.MenuItem;
import com.example.spring_project_1.domain.MenuItemRepository;
import com.example.spring_project_1.domain.Restaurant;
import com.example.spring_project_1.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){

        Restaurant restaurant = restaurantService.getRestaurant(id);
        return restaurant;
    }

    @PostMapping("/restaurants")
    public ResponseEntity create() throws URISyntaxException {
        Restaurant restaurant = new Restaurant(100L, "KAKAO","Pangyo");
        restaurantService.addRestaurant(restaurant);
        URI uri = new URI("/restaurants/1234");
        return ResponseEntity.created(uri).body("{}");
    }



}
