
package com.example.WeatherCreator;

import org.springframework.stereotype.Service;

@Service
public class LargeGlobalService {
    
    public double checkForNumber(String baseTemperature){
        double temperature=0;
        String a=baseTemperature.replace(",", ".");
        
        if(isNumeric(a)){
            temperature = Double.parseDouble(a);
        }
        
        
        return temperature;
    }
    public static boolean isNumeric(String temperatureInput){
        if(temperatureInput==null){
            return false;
        }
        try{
            double d=Double.parseDouble(temperatureInput);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
}
