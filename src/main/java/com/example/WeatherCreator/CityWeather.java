
package com.example.WeatherCreator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CityWeather {
    
    private Long id;
    private String cityName;
    private String weatherName;
    private double temperature;
    
    public CityWeather(Long id,String cityName,String weatherName,double temperature){
        this.id=id;
        this.cityName = cityName;
        this.weatherName = weatherName;
        this.temperature = temperature;
    }
    
}
