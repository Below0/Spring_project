package com.example.spring_project_1.domain;

import java.util.List;

public interface MenuItemRepository {
    List<MenuItem> findAllbyRestaurant(Long RestaurantId);
}
