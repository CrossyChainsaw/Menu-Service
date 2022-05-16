package groep3.test.controller;

import groep3.test.entities.Product;
import groep3.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/all")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getByID(@PathVariable("id") long id) {
        return productService.getById(id);
    }

    @PostMapping("/product")
    public Product createMeal(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/product/{id}")
    public Product updateMeal(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteMapping(@PathVariable("id") long id) {
        productService.deleteProductById(id);
    }
}
