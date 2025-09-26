// Slip 3 and slip 18 :- Q.1 Write a JAVA Program to implement built-in support (java.util.Observable) Weather station with members temperature, humidity, pressure and methods mesurmentsChanged(), setMesurment(), getTemperature(), getHumidity(), getPressure() 

import java.util.Observable;
import java.util.Observer;

class WeatherStation extends Observable {
    private float temperature, humidity, pressure;

    public void setMeasurement(float temperature, float humidity, float pressure) 
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        setChanged();
        notifyObservers();
    }

    public float getTemperature() { return temperature; }
    public float getHumidity() { return humidity; }
    public float getPressure() { return pressure; }
}

class WeatherDisplay implements Observer 
{
    public void update(Observable obs, Object arg) 
    {
        if (obs instanceof WeatherStation) {
            WeatherStation ws = (WeatherStation) obs;
            System.out.println("Temperature: " + ws.getTemperature());
            System.out.println("Humidity: " + ws.getHumidity());
            System.out.println("Pressure: " + ws.getPressure());
        }
    }
}

public class WeatherStationDemo
 {
    public static void main(String[] args) 
    {
        WeatherStation station = new WeatherStation();
        station.addObserver(new WeatherDisplay());
        station.setMeasurement(25.3f, 65.0f, 1013.1f);
    }
}

// Output :- Temperature: 25.3
// Humidity: 65.0   
// Pressure: 1013.1