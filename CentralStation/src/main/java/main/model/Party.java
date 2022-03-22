package main.model;


/**
 * Text Here
 *
 * @author Patrick Elias
 * @version 2021-10-19
 */
public class Party {
    private int partyID;
    private String timing;

    public Party(int partyID, String timing) {
        this.partyID = partyID;
        this.timing = timing;
    }

    public Party() {}

    public int getPartyID() {
        return partyID;
    }

    public void setPartyID(int partyID) {
        this.partyID = partyID;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
}