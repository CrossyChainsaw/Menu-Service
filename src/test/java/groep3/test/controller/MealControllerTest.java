package groep3.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import groep3.test.entities.Meal;

import javax.print.attribute.standard.Media;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MealControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldGetAllMeals() throws Exception {
        mvc.perform(get("/meals/all").
                contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].mealId").value(1))
                .andExpect(jsonPath("$[0].img_Src").value("https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg"))
                .andExpect(jsonPath("$[0].mealName").value("Wortelsoep"))
                .andExpect(jsonPath("$[0].mealPrice").value(4.99));

    }

    @Test
    void shouldPostMeal() throws Exception {
        Meal postMeal = new Meal(1, "Wortelsoep", "https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg", 4.99,1);

        String mealAsString = mapper.writeValueAsString(postMeal);

        mvc.perform(post("/meals/create")
                .contentType(MediaType.APPLICATION_JSON)
                        .contentType(mealAsString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mealId").value(1))
                .andExpect(jsonPath("$.mealName").value("Wortelsoep"))
                .andExpect(jsonPath("$.img_Src").value("https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg"))
                .andExpect(jsonPath("$.mealPrice").value(4.99))
                .andExpect(jsonPath("$.CategoryId").value(1));
    }
}
