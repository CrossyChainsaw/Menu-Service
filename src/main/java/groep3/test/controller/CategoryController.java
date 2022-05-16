package groep3.test.controller;

import groep3.test.entities.Category;
import groep3.test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/all")
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/category/create")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/category/{id}")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable("id") long id) {
        categoryService.deleteCategoryById(id);
    }
}
