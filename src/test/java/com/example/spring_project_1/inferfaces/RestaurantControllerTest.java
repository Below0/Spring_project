package com.example.spring_project_1.inferfaces;

import com.example.spring_project_1.application.RestaurantService;
import com.example.spring_project_1.domain.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {

    @MockBean
    private RestaurantService restaurantService;

    @Autowired
    private MockMvc mvc;
    @Test
    public void list() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1L, "BOB","Seoul"));
        given(restaurantService.getRestaurants()).willReturn(restaurants);
        mvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"BOB\"")));
    }

    @Test
    public void detail() throws Exception{
        Restaurant restaurant = new Restaurant(1L,"Hayoung","Seoul");
        restaurant.addNewMenu(new MenuItem("Kimchi"));
        Restaurant restaurant1 = new Restaurant(2L, "Jiwon", "Anyang");
        given(restaurantService.getRestaurant(1L)).willReturn(restaurant);
        given(restaurantService.getRestaurant(2L)).willReturn(restaurant1);

        mvc.perform(get("/restaurants/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Hayoung\"")))
                .andExpect(content().string(containsString("Kimchi")));
        mvc.perform(get("/restaurants/2"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Jiwon\"")));
    }

}