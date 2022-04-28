package groep3.test.controller;

import groep3.test.entities.Drink;
import groep3.test.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/drinks")
public class DrinkController {

    @Autowired
    private DrinkService drinkService;

    @GetMapping("/all")
    public List<Drink> getAll() {
        return drinkService.getAllDrinks();
    }

    @PostMapping("/create")
    public Drink createDrink(@RequestBody Drink drink) {
        return drinkService.createDrink(drink);
    }

    @PutMapping("/update/{id}")
    public Drink updateDrink(@RequestBody Drink drink) {
        return drinkService.updateDrink(drink);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDrink(@PathVariable("id") long id) {
        drinkService.deleteDrinkById(id);
    }
}
