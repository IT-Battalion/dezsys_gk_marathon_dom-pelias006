package main.model;

import org.springframework.beans.factory.annotation.Value;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimingstationData {
    private String timingstationID;
    private String timestamp;

    private double distance;
    private String unitDistance;

    private double altitude;
    private String unitAltitude;
    private WeatherData weatherData;
    private CompetitionData competitionData;

    /**
     * Constructor
     */
    public TimingstationData() {
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        this.unitDistance = "m";
        this.unitAltitude = "hm";
    }

    /**
     * Setter and Getter Methods
     */
    public String getTimingstationID() {
        return timingstationID;
    }

    public void setTimingstationID(String timingstationID) {
        this.timingstationID = timingstationID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public String getUnitDistance() {
        return unitDistance;
    }

    public void setUnitDistance(String unitDistance) {
        this.unitDistance = unitDistance;
    }

    public String getUnitAltitude() {
        return unitAltitude;
    }

    public void setUnitAltitude(String unitAltitude) {
        this.unitAltitude = unitAltitude;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public CompetitionData getCompetitionData() {
        return competitionData;
    }

    public void setCompetitionData(CompetitionData competitionData) {
        this.competitionData = competitionData;
    }

    /**
     * Methods
     */
    @Override
    public String toString() {
        String info = String.format("Timing Station Info: ID = %s, timestamp = %s, distance = %d",
                timingstationID, timestamp, distance);
        return info;
    }
}
