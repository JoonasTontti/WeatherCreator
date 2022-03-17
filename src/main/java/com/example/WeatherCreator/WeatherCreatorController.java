
package com.example.WeatherCreator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherCreatorController {
    
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
    
    @GetMapping("*")
    public String getDefault() {
        return "redirect:/";
    }
}
