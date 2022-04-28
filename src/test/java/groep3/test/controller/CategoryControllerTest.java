package groep3.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import groep3.test.entities.Category;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class CategoryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void shouldGetAllCategories() throws Exception {
        mvc.perform(get("/categories/all").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].categoryId").value(1))
                .andExpect(jsonPath("$[0].categoryName").value("Voorgerecht"));


    }

    @Test
    void shouldPostCategory() throws Exception {
        Category postCategory = new Category();
        postCategory.categoryId = 1L;
        postCategory.categoryName = "Voorgerecht";

        String categoryAsString = mapper.writeValueAsString(postCategory);

        mvc.perform(post("/categories/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoryAsString)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoryId").value(1L))
                .andExpect(jsonPath("$.categoryName").value("Voorgerecht"));

    }

    @Test
    void shouldDeleteCategoryById() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.delete("/categories/delete/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateCategoryById() throws Exception
    {
        Category putCategory = new Category();
        putCategory.categoryId = 1L;
        putCategory.categoryName = "Voorgerecht";

        String categoryAsString = mapper.writeValueAsString(putCategory);

        mvc.perform(put("/categories/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoryAsString)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoryId").value(1L))
                .andExpect(jsonPath("$.categoryName").value("Voorgerecht"));
    }
}


