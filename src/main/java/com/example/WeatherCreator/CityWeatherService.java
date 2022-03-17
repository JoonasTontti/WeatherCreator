
package com.example.WeatherCreator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CityWeatherService {
    
    @Autowired
    private WeatherService weatherService;
    
    @Autowired
    private CityService cityService;
    
    private ArrayList<CityWeather> cityWeather;
      
    public ArrayList<CityWeather> getCityWeather(){
        
        addToDto();                    
        return this.cityWeather;
      
    }
   
    public boolean addToDto(){
        List<Weather> weather = weatherService.getWeathers();
        ArrayList<City> tempCity = cityService.getCities();
        CityWeather a = new CityWeather();
        long noId=0;
        ArrayList<CityWeather> citWeatTemp=new ArrayList<>();
        
        if(weather.isEmpty()){
                        
            if(tempCity.isEmpty()){
                
                a.setCityName("No cities go add one and"); 
            }
            else
                a.setCityName(" ");
            
            a.setTemperature(0);
            a.setWeatherName("no weathers go add one");
            a.setId(noId);
            
            citWeatTemp.add(a);
            cityWeather=citWeatTemp;
            return false;
        }
        else if(tempCity.isEmpty()){
            
            a.setCityName("No cities go add one");
            a.setWeatherName(" ");
            a.setTemperature(0);
            a.setId(noId);
 
            citWeatTemp.add(a);
            cityWeather=citWeatTemp;
            return false;
        }
        else{
            
            Random rand = new Random();
            Weather tempWeather = new Weather();
            int min=-15, max=15;
            DecimalFormat numberFormat = new DecimalFormat("#.0");
        
            for(City h : tempCity){
                String wName,cName;
                double temperature;
                double modifier = Math.random()*(max-min)+min;

                Long id = h.getId();

                tempWeather = weather.get(rand.nextInt(weather.size()));
                wName=tempWeather.getName();
                cName=h.getName();
                temperature = tempWeather.getWeatherTemp() + modifier + h.getBaseTemp();

                temperature = Double.parseDouble(numberFormat.format(temperature));

                a = new CityWeather(id,cName,wName,temperature);

                citWeatTemp.add(a);

            }
            this.cityWeather=citWeatTemp;
            
        }
       return true;
    }    
    
}
