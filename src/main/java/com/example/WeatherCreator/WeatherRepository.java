
package com.example.WeatherCreator;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WeatherRepository extends JpaRepository<Weather, Long> {
    ArrayList<Weather> findByName(String name);
    Long deleteWeatherByName(String name);
    
}
