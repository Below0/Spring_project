package com.example.spring_project_1.inferfaces;

import com.example.spring_project_1.domain.RestaurantRepository;
import com.example.spring_project_1.domain.RestaurantRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {

    @SpyBean(RestaurantRepositoryImpl.class)
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MockMvc mvc;
    @Test
    public void list() throws Exception {
        mvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Hayoung\"")));
    }

    @Test
    public void detail() throws Exception{
        mvc.perform(get("/restaurants/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Hayoung\"")));
        mvc.perform(get("/restaurants/2"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Jiwon\"")));
    }

}