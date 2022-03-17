
package com.example.WeatherCreator;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {
    
    @Autowired
    private WeatherService weatherService;
    
    @GetMapping("/weathers")
    public String getWeather(Model model) {
        List<Weather> weathers = weatherService.getWeathers();
        model.addAttribute("weathers", weathers);
        return "weathers";
    }
    
    @PostMapping("/weathers")
    public String addWeather(@RequestParam String weatherName, double weatherTemperature) {
        weatherService.addWeather(weatherName, weatherTemperature);
        return "redirect:/weathers";
    }
    
    @PostMapping("/deleteweather")
    public String deleteWeather(@RequestParam String weatherName) {
        weatherService.deleteWeatherByName(weatherName);
        return "redirect:/weathers";
    }
    
    
    
}