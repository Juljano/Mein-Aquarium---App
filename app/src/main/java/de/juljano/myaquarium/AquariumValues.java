package de.juljano.myaquarium;

public class AquariumValues {

    private String temperatur;
    private String tds;
    private String lightStatus;
    private String pH;
    private String wattage;


    public AquariumValues(String temperatur, String tds, String lightStatus, String pH, String wattage) {
        this.temperatur = temperatur;
        this.tds = tds;
        this.lightStatus = lightStatus;
        this.pH = pH;
        this.wattage = wattage;



    }

    public String getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(String temperatur) {
        this.temperatur = temperatur;
    }

    public String getTds() {
        return tds;
    }

    public void setTds(String tds) {
        this.tds = tds;
    }

    public String getLightStatus() {
        return lightStatus;
    }

    public void setLightStatus(String lightStatus) {
        this.lightStatus = lightStatus;
    }

    public String getpH() {
        return pH;
    }

    public void setpH(String pH) {
        this.pH = pH;
    }

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }
}