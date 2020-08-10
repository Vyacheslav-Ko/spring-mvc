package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

@Controller
public class CarsController {

    private CarService carService;

    @Autowired
    //@Qualifier(value = "carService")
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String carsToPrint(ModelMap model,
                              @RequestParam(value = "locale", required = false) String loc) {
        if (loc!=null && loc.equals("ru")) {
            model.addAttribute("tableHeader", "Машины");
        } else if (loc!=null && loc.equals("en")) {
            model.addAttribute("tableHeader", "Cars");
        } else if (loc==null){
            model.addAttribute("tableHeader", "No matching found");
        }
        model.addAttribute("listCars", this.carService.listCars());
        return "cars";
    }
}