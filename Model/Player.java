package Model;

public class Player {
    private String name;
    private int alter;
    private String position;
    private double marktwert;

    public Player() {
    }

    public Player(String name, int alter, String position, double marktwert) {
        this.name = name;
        this.alter = alter;
        this.position = position;
        this.marktwert = marktwert;
    }

    public String getName() {
        return name;
    }

    public int getAlter() {
        return alter;
    }

    public String getPosition() {
        return position;
    }

    public double getMarktwert() {
        return marktwert;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setMarktwert(double marktwert) {
        this.marktwert = marktwert;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", alter=" + alter +
                ", position='" + position + '\'' +
                ", marktwert=" + marktwert +
                '}';
    }
}