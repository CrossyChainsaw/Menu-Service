package groep3.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import groep3.test.entities.Product;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@EnableWebMvc
public class ProductControllerTest {

        @Autowired
        private MockMvc mvc;

        @Autowired
        private ObjectMapper mapper;

        @Test
        void shouldGetAllProducts() throws Exception {
                mvc.perform(get("/products/all").contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$[0].productId").value(1))
                                .andExpect(jsonPath("$[0].img_Src")
                                                .value("https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg"))
                                .andExpect(jsonPath("$[0].productName").value("Wortelsoep"))
                                .andExpect(jsonPath("$[0].productPrice").value(4.99))
                                .andExpect(jsonPath("$[0].categoryId").value(1));

        }

        @Test
        void shouldPostProduct() throws Exception {
                Product postProduct = new Product();
                postProduct.ID = 1;
                postProduct.name = "Wortelsoep";
                postProduct.image = "https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg";
                postProduct.price = 4.99;
                postProduct.categoryID = 1;

                String productAsString = mapper.writeValueAsString(postProduct);

                mvc.perform(post("/products/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(productAsString)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.productId").value(1))
                                .andExpect(jsonPath("$.productName").value("Wortelsoep"))
                                .andExpect(jsonPath("$.img_Src")
                                                .value("https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg"))
                                .andExpect(jsonPath("$.productPrice").value(4.99))
                                .andExpect(jsonPath("$.categoryId").value(1));
        }

        @Test
        void shouldDeleteProductById() throws Exception {
                mvc.perform(MockMvcRequestBuilders.delete("/products/delete/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk());
        }

        @Test
        void shouldUpdateProductById() throws Exception {
                Product putProduct = new Product();
                putProduct.ID = 1;
                putProduct.name = "Wortelsoep met extra groente";
                putProduct.image = "https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg";
                putProduct.price = 5.99;
                putProduct.categoryID = 1;

                String productAsString = mapper.writeValueAsString(putProduct);

                mvc.perform(put("/products/update/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(productAsString)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.productId").value(1))
                                .andExpect(jsonPath("$.productName").value("Wortelsoep met extra groente"))
                                .andExpect(jsonPath("$.img_Src")
                                                .value("https://weckenonline.eu/wp-content/uploads/2015/12/Wortelsoep-1.jpg"))
                                .andExpect(jsonPath("$.productPrice").value(5.99))
                                .andExpect(jsonPath("$.categoryId").value(1));
        }
}
