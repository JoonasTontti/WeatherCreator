
package com.example.WeatherCreator;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CityRepository extends JpaRepository<City, Long> {
    @Override
    ArrayList<City> findAll();
    ArrayList<City> findByName(String name);

    Long deleteCityByName(String cityName);

      
}
