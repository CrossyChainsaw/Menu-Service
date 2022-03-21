package groep3.test.controller;

import groep3.test.entities.Meal;
import groep3.test.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping("/all")
    public List<Meal> getAll() {
        return mealService.getAllMeals();
    }

    @PostMapping("/create")
    public Meal createMeal(@RequestBody Meal meal) {
        return mealService.createMeal(meal);
    }
    /*
    {
        "mealId": "1",
            "mealName": "Cheese Burger",
            "mealPrice": 5.49
    }
     */

    @PutMapping("/update")
    public Meal updateMeal(@RequestBody Meal meal) {
        return mealService.updateMeal(meal);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMapping(@PathVariable("id") long id){
        mealService.deleteMealById(id);
    }
}

