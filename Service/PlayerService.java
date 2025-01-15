package Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import Model.Player;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private static final String PLAYERS_JSON = "players.json";
    private List<Player> players;

    public PlayerService() {
        this.players = new ArrayList<>();
        loadPlayersFromJson();
    }

    private void loadPlayersFromJson() {
        try (FileReader reader = new FileReader(PLAYERS_JSON)) {
            Gson gson = new Gson();
            Type playerListType = new TypeToken<List<Player>>() {}.getType();
            this.players = gson.fromJson(reader, playerListType);
            if (players == null) {
                players = new ArrayList<>();
            }
        } catch (Exception e) {
            System.out.println("Could not load players from JSON: " + e.getMessage());
            players = new ArrayList<>();
        }
    }

    private void savePlayersToJson() {
        try (FileWriter writer = new FileWriter(PLAYERS_JSON)) {
            Gson gson = new Gson();
            gson.toJson(players, writer);
        } catch (Exception e) {
            System.out.println("Could not save players to JSON: " + e.getMessage());
        }
    }

    public List<Player> getAllPlayers() {
        return players;
    }

    public void addPlayer(Player p) {
        players.add(p);
        savePlayersToJson();
    }

    public void editPlayer(String name, Player updatedPlayer) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equalsIgnoreCase(name)) {
                players.set(i, updatedPlayer);
                savePlayersToJson();
                return;
            }
        }
        System.out.println("Player with name '" + name + "' not found.");
    }

    public void removePlayer(String name) {
        players.removeIf(p -> p.getName().equalsIgnoreCase(name));
        savePlayersToJson();
    }

    public void listAllPlayers() {
        if (players.isEmpty()) {
            System.out.println("No players found.");
            return;
        }
        for (Player p : players) {
            System.out.println(p);
        }
    }
}