package groep3.test.controller;

import groep3.test.entities.Meal;
import groep3.test.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
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

    @PutMapping("/update/{id}")
    public Meal updateMeal(@RequestBody Meal meal) {
        return mealService.updateMeal(meal);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMapping(@PathVariable("id") long id){
        mealService.deleteMealById(id);
    }

    @GetMapping("/getByID/{id}")
    public Optional<Meal> getByID(@PathVariable("id") long ID) {
        Optional<Meal> meal = mealService.getByID(ID);
        System.out.print(meal);
        return meal;
    }
}

