
package com.example.WeatherCreator;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    
    @Autowired
    private LargeGlobalService globalServices;
    
    @Autowired
    private WeatherRepository weatherRepository;
    
    public List<Weather> getWeathers() {
        return this.weatherRepository.findAll();
   
    }
    
    public void addWeather(String name, String weatherTemperature) {
        
        double weatherTemp=globalServices.checkForNumber(weatherTemperature);
        this.weatherRepository.save(new Weather(name, weatherTemp));
    }
    
    public Weather findWeatherByName(String weatherName) {
        try{
            return this.weatherRepository.findByName(weatherName).get(0);

        }catch(IndexOutOfBoundsException e){
            return null;
        }
        
    }
    
    @Transactional
    public void editWeather(String name,String weatherTemperature) {
        Weather weather = this.findWeatherByName(name);
        if(weather!=null){
            weather.editWeather(name, Double.parseDouble(weatherTemperature));
            this.weatherRepository.save(weather);
        }
        

    }
    
    @Transactional
    public void deleteWeatherByName(String name) {
        this.weatherRepository.deleteWeatherByName(name);

    }
    
}