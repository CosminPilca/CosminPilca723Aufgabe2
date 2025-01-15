package Model;

import java.util.ArrayList;
import java.util.List;

public class Club {
    private int id;
    private String name;
    private String stadt;
    private List<Player> players;

    public Club() {
        players = new ArrayList<>();
    }

    public Club(int id, String name, String stadt) {
        this.id = id;
        this.name = name;
        this.stadt = stadt;
        this.players = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStadt() {
        return stadt;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stadt='" + stadt + '\'' +
                ", players=" + players +
                '}';
    }
}