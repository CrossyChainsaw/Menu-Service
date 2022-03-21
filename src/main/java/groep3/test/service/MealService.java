package groep3.test.service;

import groep3.test.entities.Meal;
import groep3.test.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;

    public List<Meal> getAllMeals(){
        return mealRepository.findAll();
    }

    public Meal createMeal(int mealId, String mealName, double mealPrice){
        Meal meal = new Meal(mealId, mealName, mealPrice);
        mealRepository.save(new Meal(mealId, mealName, mealPrice));
        return meal;
    }
}
