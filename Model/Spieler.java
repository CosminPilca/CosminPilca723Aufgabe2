package Model;

public class Spieler {
    private String name;
    private String alter;
    private String position;
    private String marktwert;

    public Spieler(String name, String alter, String position, String marktwert) {
        this.name = name;
        this.alter = alter;
        this.position = position;
        this.marktwert = marktwert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlter() {
        return alter;
    }

    public void setAlter(String alter) {
        this.alter = alter;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMarktwert() {
        return marktwert;
    }

    public void setMarktwert(String marktwert) {
        this.marktwert = marktwert;
    }

   @Override

    public String toString() {
        return "Medication{" +
                "name='" + name + '\'' +
                ", alter=" + alter +
                ", position=" + position +
                ", marktwert='"+ marktwert+ '\'' +
                '}';
    }
}