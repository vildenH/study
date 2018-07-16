package observer.guava.eventBusStation;

import com.google.common.eventbus.EventBus;

public class WeatherData {


    private EventBus WeatherNotify;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        WeatherNotify = new EventBus();
    }


    public void measurementsChanged() {
        WeatherNotify.post(this);
    }


    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();

    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public EventBus getWeatherNotify() {
        return WeatherNotify;
    }
}
