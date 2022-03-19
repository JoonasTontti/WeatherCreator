
package com.example.WeatherCreator;

import java.util.ArrayList;
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
        try{
            return this.cityRepository.findByName(cityName).get(0);

        }catch(IndexOutOfBoundsException e){
            return null;
        }

    }

    @Transactional
    public void editCity(String name,String cityTemperature) {
        City city = this.findCityByName(name);
        if(city!=null){
            city.editCity(name, Double.parseDouble(cityTemperature));
            this.cityRepository.save(city); 
        }


    }

    @Transactional
    public void deleteCityByName(String name) {
        this.cityRepository.deleteCityByName(name);

    }
             
}