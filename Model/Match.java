package Model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class Match {
    @SerializedName("Id")
    private int id;
    @SerializedName("Team1")
    private String team1;
    @SerializedName("Team2")
    private String team2;
    @SerializedName("Datum")
    private String datum;
    @SerializedName("Spielort")
    private String spielort;
    @SerializedName("Kapazität")
    private String kapazitaet;


    public Match(int id, String team1, String team2, String datum, String spielort, String kapazitaet) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.datum = datum;
        this.spielort = spielort;
        this.kapazitaet = kapazitaet;
    }

    public int getId() {
        return id;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getDatum() {
        return datum;
    }

    public String getSpielort() {
        return spielort;
    }

    public String getKapazitaet() {
        return kapazitaet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setSpielort(String spielort) {
        this.spielort = spielort;
    }

    public void setKapazitaet(String kapazitaet) {
        this.kapazitaet = kapazitaet;
    }

    @Override
    public String toString() {
        return "Match {" +
                "id=" + id +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", datum='" + datum + '\'' +
                ", spielort='" + spielort + '\'' +
                ", kapazitaet='" + kapazitaet + '\'' +
                '}';
    }
}