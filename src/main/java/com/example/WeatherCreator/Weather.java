
package com.example.WeatherCreator;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weather extends AbstractPersistable<Long> {
    private String name;
    private double weatherTemp;
    
    public Weather(String name) {
        this.name = name;
    }
    
    public void editWeather(String name, double weatherTemp) {
        this.name = name;
        this.weatherTemp = weatherTemp;
    }
}
