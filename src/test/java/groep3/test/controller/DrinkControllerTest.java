package groep3.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import groep3.test.entities.Drink;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class DrinkControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldGetAllDrinks() throws Exception {
        mvc.perform(get("/drinks/all").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].drinkId").value(1))
                .andExpect(jsonPath("$[0].img_Src")
                        .value("https://www.shinzo.nl/wp-content/uploads/2020/05/cocacola.png"))
                .andExpect(jsonPath("$[0].drinkName").value("Coca Cola"))
                .andExpect(jsonPath("$[0].drinkPrice").value(2.49))
                .andExpect(jsonPath("$[0].categoryId").value(4));

    }

    @Test
    void shouldPostDrink() throws Exception {
        Drink postDrink = new Drink();
        postDrink.ID = 1;
        postDrink.name = "Coca Cola";
        postDrink.image = "https://www.shinzo.nl/wp-content/uploads/2020/05/cocacola.png";
        postDrink.price = 2.49;
        postDrink.categoryID = 4;

        String drinkAsString = mapper.writeValueAsString(postDrink);

        mvc.perform(post("/drinks/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(drinkAsString)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.drinkId").value(1))
                .andExpect(jsonPath("$.drinkName").value("Coca Cola"))
                .andExpect(jsonPath("$.img_Src")
                        .value("https://www.shinzo.nl/wp-content/uploads/2020/05/cocacola.png"))
                .andExpect(jsonPath("$.drinkPrice").value(2.49))
                .andExpect(jsonPath("$.categoryId").value(4));
    }

    @Test
    void shouldDeleteDrinkById() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.delete("/drinks/delete/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateDrinkById() throws Exception
    {
        Drink putDrink = new Drink();
        putDrink.ID = 1;
        putDrink.name = "Coca Cola";
        putDrink.image = "https://www.shinzo.nl/wp-content/uploads/2020/05/cocacola.png";
        putDrink.price = 2.49;
        putDrink.categoryID = 4;

        String drinkAsString = mapper.writeValueAsString(putDrink);

        mvc.perform(put("/drinks/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(drinkAsString)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.drinkId").value(1))
                .andExpect(jsonPath("$.drinkName").value("Coca Cola"))
                .andExpect(jsonPath("$.img_Src")
                        .value("https://www.shinzo.nl/wp-content/uploads/2020/05/cocacola.png"))
                .andExpect(jsonPath("$.drinkPrice").value(2.49))
                .andExpect(jsonPath("$.categoryId").value(4));
    }
}


