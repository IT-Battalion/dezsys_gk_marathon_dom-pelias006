package main.timingstation;

import main.model.CompetitionData;
import main.model.Party;
import main.model.TimingstationData;
import main.model.WeatherData;
import org.springframework.beans.factory.annotation.Value;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimingstationSimulation {
    private TimingstationData data;

    public TimingstationSimulation() {
        this.data = new TimingstationData();
    }

    private double getRandomDouble(int inMinimum, int inMaximum) {
        double number = (Math.random() * ((inMaximum - inMinimum) + 1)) + inMinimum;
        double rounded = Math.round(number * 100.0) / 100.0;
        return rounded;
    }

    private int getRandomInt(int inMinimum, int inMaximum) {
        double number = (Math.random() * ((inMaximum - inMinimum) + 1)) + inMinimum;
        long rounded = Math.round(number);
        return (int) rounded;
    }

    private long getRandomLong(long inMinimum, long inMaximum) {
        double number = (Math.random() * ((inMaximum - inMinimum) + 1)) + inMinimum;
        return Math.round(number);
    }

    public TimingstationData getData() {
        CompetitionData cData;
        if (data == null) {
            data = new TimingstationData();
            data.setDistance(1);
            data.setAltitude(200);
            cData = new CompetitionData();
        } else {
            cData = data.getCompetitionData();
            if (cData == null) cData = new CompetitionData();
        }

        WeatherData wData = new WeatherData();
        wData.setPrecipitation(this.getRandomInt(0, 10));
        wData.setAtmosphericPressure(this.getRandomDouble(750, 1250));
        wData.setTemperature(this.getRandomInt(-30, 45));
        wData.setWindspeed(this.getRandomDouble(5, 1000));
        data.setWeatherData(wData);

        Party[] oldParty = cData.getParty();
        Party[] newParty = new Party[this.getRandomInt(1, 10)];
        for (int i = 0; i < newParty.length; i++) {
            int partyID = this.getRandomInt(1, 10000);
            long millis = this.getRandomLong(1634645697165L, new Date().getTime());
            String partyTiming = new SimpleDateFormat(cData.getUnitTiming()).format(new Date(millis));
            newParty[i] = new Party(partyID, partyTiming);
        }

        Party[] totalParty = new Party[oldParty.length + newParty.length];
        System.arraycopy(oldParty, 0, totalParty, 0, oldParty.length);
        System.arraycopy(newParty, 0, totalParty, oldParty.length, newParty.length);
        cData.setParty(totalParty);
        data.setCompetitionData(cData);
        return data;
    }
}
