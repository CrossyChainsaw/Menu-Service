package groep3.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import groep3.test.entities.Meal;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
public class MealControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldGetAllMeals() throws Exception {
        mvc.perform(get("/meals/all").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].mealId").value(1))
                .andExpect(jsonPath("$[0].img_Src")
                        .value("https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg"))
                .andExpect(jsonPath("$[0].mealName").value("Wortelsoep"))
                .andExpect(jsonPath("$[0].mealPrice").value(4.99))
                .andExpect(jsonPath("$[0].categoryId").value(1));

    }

    @Test
    void shouldPostMeal() throws Exception {
        Meal postMeal = new Meal();
        postMeal.mealId = 1;
        postMeal.mealName = "Wortelsoep";
        postMeal.img_Src = "https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg";
        postMeal.mealPrice = 4.99;
        postMeal.categoryId = 1;

        String mealAsString = mapper.writeValueAsString(postMeal);

        mvc.perform(post("/meals/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mealAsString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mealId").value(1))
                .andExpect(jsonPath("$.mealName").value("Wortelsoep"))
                .andExpect(jsonPath("$.img_Src")
                        .value("https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg"))
                .andExpect(jsonPath("$.mealPrice").value(4.99))
                .andExpect(jsonPath("$.categoryId").value(1));
    }

    @Test
    void shouldDeleteMealById() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.delete("/meals/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateMealById() throws Exception
    {
        Meal putMeal = new Meal();
        putMeal.mealId = 1;
        putMeal.mealName = "Wortelsoep met extra groente";
        putMeal.img_Src = "https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg";
        putMeal.mealPrice = 5.99;
        putMeal.categoryId = 1;

        String mealAsString = mapper.writeValueAsString(putMeal);

        mvc.perform(put("/meals/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mealAsString)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mealId").value(1))
                .andExpect(jsonPath("$.mealName").value("Wortelsoep met extra groente"))
                .andExpect(jsonPath("$.img_Src")
                        .value("https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg"))
                .andExpect(jsonPath("$.mealPrice").value(5.99))
                .andExpect(jsonPath("$.categoryId").value(1));
    }
}
