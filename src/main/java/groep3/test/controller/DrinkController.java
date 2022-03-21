package groep3.test.controller;
import groep3.test.entities.Drink;
import groep3.test.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    @Autowired
    private DrinkService drinkService;

    @GetMapping("/all")
    public List<Drink> getAll()
    {
        return drinkService.getAllDrinks();
    }
}
