package de.juljano.myaquarium;

public class AquariumValues {


    private String Beleuchtung;
    private float  Info;
    private float  Temperatur;
    private float pH;
    private float tds;


    public AquariumValues(String beleuchtung, float info, float temperatur, float pH, float tds) {
        Beleuchtung = beleuchtung;
        Info = info;
        Temperatur = temperatur;
        this.pH = pH;
        this.tds = tds;
    }


    public String getBeleuchtung() {
        return Beleuchtung;
    }

    public void setBeleuchtung(String beleuchtung) {
        Beleuchtung = beleuchtung;
    }

    public float getInfo() {
        return Info;
    }

    public void setInfo(float info) {
        Info = info;
    }

    public float getTemperatur() {
        return Temperatur;
    }

    public void setTemperatur(float temperatur) {
        Temperatur = temperatur;
    }

    public float getpH() {
        return pH;
    }

    public void setpH(float pH) {
        this.pH = pH;
    }

    public float getTds() {
        return tds;
    }

    public void setTds(float tds) {
        this.tds = tds;
    }

}
