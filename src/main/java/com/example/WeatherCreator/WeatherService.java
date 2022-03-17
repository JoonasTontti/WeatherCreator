
package com.example.WeatherCreator;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    
    @Autowired
    private WeatherRepository weatherRepository;
    
    public List<Weather> getWeathers() {
        return this.weatherRepository.findAll();
   
    }
    
    public void addWeather(String name, double weatherTemperature) {
        this.weatherRepository.save(new Weather(name, weatherTemperature));
    }
    
    public Weather findWeatherByName(String weatherName) {
        return this.weatherRepository.findByName(weatherName).get(0);
        
    }
    
    @Transactional
    public void deleteWeatherByName(String name) {
        this.weatherRepository.deleteWeatherByName(name);

    }
    
    
}