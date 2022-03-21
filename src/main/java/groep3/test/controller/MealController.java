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
    public List<Meal> getAll()
    {
        return mealService.getAllMeals();
    }

    @PostMapping("/create")
    public Meal createMeal()
    {
        int mealId = 5;
        String mealName = "david";
        double mealPrice = 5.99;
        return mealService.createMeal(mealId, mealName, mealPrice);
    }

//    @PutMapping("/update")
//    public List<Meal> getAll()
//    {
//        return mealService.getAllMeals();
//    }
}
