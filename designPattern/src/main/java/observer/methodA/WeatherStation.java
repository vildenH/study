package observer.methodA;

/**
 * @author wh
 * @date 2018/3/13
 */
public class WeatherStation {
    public static void main(String[] args) {
        //WatherData的变动要要实时通知面板展示，display是观察者
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay =
                new CurrentConditionsDisplay(weatherData);
        // StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        // ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
