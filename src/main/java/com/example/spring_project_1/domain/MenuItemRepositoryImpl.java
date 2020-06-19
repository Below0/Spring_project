package com.example.spring_project_1.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemRepositoryImpl implements MenuItemRepository{

    private List<MenuItem> menuItems = new ArrayList<>();

    @Override
    public List<MenuItem> findAllbyRestaurant(Long RestaurantId) {
        menuItems.add(new MenuItem("Kimchi"));
        return menuItems;
    }
}
