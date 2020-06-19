package com.example.spring_project_1.application;

import com.example.spring_project_1.domain.MenuItem;
import com.example.spring_project_1.domain.MenuItemRepository;
import com.example.spring_project_1.domain.Restaurant;
import com.example.spring_project_1.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List<Restaurant> getRestaurants(){
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }


    public Restaurant getRestaurant(Long id){
        Restaurant restaurant = restaurantRepository.findById(id);
        restaurant.setNewMenu(menuItemRepository.findAllbyRestaurant(id));

        return restaurant;

    }
}
