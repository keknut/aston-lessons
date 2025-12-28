package adapter;

public class WeatherDisplay {
    private WeatherService service;

    public WeatherDisplay(WeatherService service) {
        this.service = service;
    }

    public void show() {
        int temperature = service.getTemperature();
        String weather = service.isSunny() ? "солнечно" : "облачно";
        System.out.println("Температура: " + temperature + "*C, погода: " + weather);
    }
}
