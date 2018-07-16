package observer.guava.eventBusStation;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import observer.methodA.DisplayElement;

/**
 * @author wh
 * @date 2018/3/13
 */
public class CurrentConditionsDisplay implements DisplayElement {
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(EventBus eventBus) {
        eventBus.register(this);
    }

    @Subscribe
    public void update(WeatherData weatherData) {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }


    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
