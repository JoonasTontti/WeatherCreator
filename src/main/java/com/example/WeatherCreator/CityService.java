
package com.example.WeatherCreator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    
    @Autowired
    private LargeGlobalService globalServices;

    @Autowired
    private CityRepository cityRepository;
    

    public ArrayList<City> getCities() {
        return this.cityRepository.findAll();
    }
    
    public void addCity(String name,String cityTemperature) {
        double baseTemp=globalServices.checkForNumber(cityTemperature);
        
        this.cityRepository.save(new City(name,baseTemp));
    }
    
    public City findCityByName(String cityName) {
        return this.cityRepository.findByName(cityName).get(0);

    }

    @Transactional
    public void deleteCityByName(String name) {
        this.cityRepository.deleteCityByName(name);

    }
            
}