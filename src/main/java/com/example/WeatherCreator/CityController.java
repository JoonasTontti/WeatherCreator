
package com.example.WeatherCreator;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CityController {
    
    @Autowired
    private CityService cityService;
           
    
    @GetMapping("/cities")
    public String getCities(Model model) {
        ArrayList<City> cities = cityService.getCities();
        model.addAttribute("cities", cities);
        return "cities";
        
    }
    
    @PostMapping("/cities")
    public String addCity(@RequestParam String cityName,String cityTemperature) {
        System.out.println("Saatiin: " + cityName);
        cityService.addCity(cityName,cityTemperature);
        return "redirect:/cities";
    }
    
    @PostMapping("/deletecity")
    public String deleteCity(@RequestParam String cityName) {
        cityService.deleteCityByName(cityName);
        return "redirect:/cities";
    }
    
    @PostMapping("/editcity")
    public String editCity(@RequestParam String cityName,String cityTemperature) {
        System.out.println("Saatiin: " + cityName);
        cityService.editCity(cityName,cityTemperature);
        return "redirect:/cities";
    }

}
