package adapter;

public class WeatherAdapter implements WeatherService{
    private ModernWeatherAPI modernAPI;

    public WeatherAdapter(ModernWeatherAPI modernAPI) {
        this.modernAPI = modernAPI;
    }

    @Override
    public int getTemperature() {
        int farenheit = modernAPI.getTempFarenheit();
        return (int) ((farenheit - 32) * 5.0 / 9.0);
    }
    @Override
    public boolean isSunny() {
        return "sunny".equalsIgnoreCase(modernAPI.getCondition());
    }
}
