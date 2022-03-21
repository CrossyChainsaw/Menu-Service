package groep3.test.controller;

import groep3.test.entities.Meal;
import groep3.test.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
