package main.model;

/**
 * Text Here
 *
 * @author Patrick Elias
 * @version 2021-10-19
 */
public class WeatherData {
    private double windspeed;
    private String unitWindspeed;
    private double temperature;
    private char unitTemperature;
    private int precipitation;
    private String unitPrecipitation;
    private double atmosphericPressure;
    private String unitAtmosphericPressure;

    public WeatherData() {
        this.unitAtmosphericPressure = "hPA";
        this.unitPrecipitation = "ml";
        this.unitTemperature = 'C';
        this.unitWindspeed = "kmH";
    }

    public WeatherData(double windspeed, String unitWindspeed, double temperature, char unitTemperature, int precipitation, String unitPrecipitation, double atmosphericPressure, String unitAtmosphericPressure) {
        this.windspeed = windspeed;
        this.unitWindspeed = unitWindspeed;
        this.temperature = temperature;
        this.unitTemperature = unitTemperature;
        this.precipitation = precipitation;
        this.unitPrecipitation = unitPrecipitation;
        this.atmosphericPressure = atmosphericPressure;
        this.unitAtmosphericPressure = unitAtmosphericPressure;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    public String getUnitWindspeed() {
        return unitWindspeed;
    }

    public void setUnitWindspeed(String unitWindspeed) {
        this.unitWindspeed = unitWindspeed;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public char getUnitTemperature() {
        return unitTemperature;
    }

    public void setUnitTemperature(char unitTemperature) {
        this.unitTemperature = unitTemperature;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }

    public String getUnitPrecipitation() {
        return unitPrecipitation;
    }

    public void setUnitPrecipitation(String unitPrecipitation) {
        this.unitPrecipitation = unitPrecipitation;
    }

    public double getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(double atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }

    public String getUnitAtmosphericPressure() {
        return unitAtmosphericPressure;
    }

    public void setUnitAtmosphericPressure(String unitAtmosphericPressure) {
        this.unitAtmosphericPressure = unitAtmosphericPressure;
    }
}
