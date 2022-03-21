package groep3.test.service;

import groep3.test.entities.Drink;
import groep3.test.entities.Meal;
import groep3.test.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;

    public List<Drink> getAllDrinks(){
        return drinkRepository.findAll();
    }
}
