
package com.example.WeatherCreator;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class CityWeatherController {
    
    
    @Autowired
    private CityWeatherService cityWeatherService;
    
    @GetMapping("/cityweather")
    public String getCityWeather(Model model){
        ArrayList<CityWeather> cityWeathers = cityWeatherService.getCityWeather();
        model.addAttribute("cityweather", cityWeathers);
       
        return "cityWeather";
    } 
    
}
