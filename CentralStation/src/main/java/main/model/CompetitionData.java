package main.model;


/**
 * Text Here
 *
 * @author Patrick Elias
 * @version 2021-10-19
 */
public class CompetitionData {
    private String unitTiming;
    private Party[] party;

    public CompetitionData() {
        this.unitTiming = "hh:mm:ss";
        this.party = new Party[0];
    }

    public String getUnitTiming() {
        return unitTiming;
    }

    public void setUnitTiming(String unitTiming) {
        this.unitTiming = unitTiming;
    }

    public Party[] getParty() {
        return party;
    }

    public void setParty(Party[] party) {
        this.party = party;
    }
}
