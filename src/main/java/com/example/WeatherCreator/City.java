
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
public class City extends AbstractPersistable<Long> {
    private String name;
    private double baseTemp;

    public City(String name) {
        this.name = name;
    }
    
    public void editCity(String name, double cityTemperature) {
        this.name = name;
        this.baseTemp = cityTemperature;
    }
}