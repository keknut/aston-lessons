package App;

import adapter.*;

public class Adapter {
    public static void main(String[] args) {
        WeatherService oldService = new WeatherService() {
            @Override
            public int getTemperature() {
                return 15;
            }

            @Override
            public boolean isSunny() {
                return false;
            }
        };

        System.out.println("Старый сервис:");
        WeatherDisplay display1 = new WeatherDisplay(oldService);
        display1.show();

        ModernWeatherAPI modernAPI = new ModernWeatherAPI();
        WeatherService adapter = new WeatherAdapter(modernAPI);

        System.out.println("\nчерез адаптер и новый API: ");
        WeatherDisplay display2 = new WeatherDisplay(adapter);
        display2.show();
    }
}
