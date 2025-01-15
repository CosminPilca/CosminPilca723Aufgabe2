package Model;

import java.util.List;

public class Vereine {
    private Long id;
    private String name;
    private String stadt;
    private List<Spieler> spieler;

    public Vereine(Long id, String name, String stadt, List<Spieler> spieler) {
        this.id = id;
        this.name = name;
        this.stadt = stadt;
        this.spieler = spieler;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public List<Spieler> getSpieler() {
        return spieler;
    }

    public void setSpieler(List<Spieler> spieler) {
        this.spieler = spieler;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stadt=" + stadt +
                ", spielers=" + spieler +
                '}';
    }
}
}