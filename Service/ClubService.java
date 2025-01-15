package Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import Model.Club;
import Model.Player;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ClubService {
    private static final String CLUBS_JSON = "clubs.json";

    private List<Club> clubs;

    public ClubService() {
        this.clubs = new ArrayList<>();
        loadClubsFromJson();
    }

    private void loadClubsFromJson() {
        try (FileReader reader = new FileReader(CLUBS_JSON)) {
            Gson gson = new Gson();
            Type clubListType = new TypeToken<List<Club>>() {}.getType();
            clubs = gson.fromJson(reader, clubListType);
            if (clubs == null) {
                clubs = new ArrayList<>();
            }
        } catch (Exception e) {
            System.out.println("Could not load clubs from JSON: " + e.getMessage());
            clubs = new ArrayList<>();
        }
    }

    private void saveClubsToJson() {
        try (FileWriter writer = new FileWriter(CLUBS_JSON)) {
            Gson gson = new Gson();
            gson.toJson(clubs, writer);
        } catch (Exception e) {
            System.out.println("Could not save clubs to JSON: " + e.getMessage());
        }
    }

    public void addClub(Club club) {
        clubs.add(club);
        saveClubsToJson();
    }

    public void editClub(int clubId, Club updatedClub) {
        for (int i = 0; i < clubs.size(); i++) {
            if (clubs.get(i).getId() == clubId) {
                clubs.set(i, updatedClub);
                saveClubsToJson();
                return;
            }
        }
        System.out.println("Club with ID " + clubId + " not found.");
    }

    public void removeClub(int clubId) {
        clubs.removeIf(c -> c.getId() == clubId);
        saveClubsToJson();
    }

    public void listAllClubs() {
        if (clubs.isEmpty()) {
            System.out.println("No clubs found.");
            return;
        }
        for (Club c : clubs) {
            System.out.println(c);
        }
    }

    public List<Club> getAllClubs() {
        return clubs;
    }

    public void addPlayerToClub(int clubId, Player player) {
        for (Club club : clubs) {
            if (club.getId() == clubId) {
                club.getPlayers().add(player);
                saveClubsToJson();
                return;
            }
        }
        System.out.println("Club with ID " + clubId + " not found.");
    }

    public void listClubsByCity(String city) {
        boolean found = false;
        for (Club c : clubs) {
            if (c.getStadt().equalsIgnoreCase(city)) {
                System.out.println(c);
                found = true;
            }
        }
        if(!found) {
            System.out.println("No clubs found in city: " + city);
        }
    }

    public void listPlayersInClub(String clubName) {
        for (Club c : clubs) {
            if (c.getName().equalsIgnoreCase(clubName)) {
                List<Player> players = c.getPlayers();
                if (players.isEmpty()) {
                    System.out.println("No players in this club.");
                    return;
                }
                for (Player p : players) {
                    System.out.println(p);
                }
                return;
            }
        }
        System.out.println("No club found with name: " + clubName);
    }

    public void listPlayersInClubSortedByMarketValue(String clubName, boolean ascending) {
        for (Club c : clubs) {
            if (c.getName().equalsIgnoreCase(clubName)) {
                List<Player> players = c.getPlayers();
                if (players.isEmpty()) {
                    System.out.println("No players in this club.");
                    return;
                }
                players.sort((p1, p2) -> ascending
                        ? Double.compare(p1.getMarktwert(), p2.getMarktwert())
                        : Double.compare(p2.getMarktwert(), p1.getMarktwert()));

                System.out.println("Players in " + c.getName() + " sorted by market value ("
                        + (ascending ? "ASC" : "DESC") + "):");
                for (Player p : players) {
                    System.out.println(p);
                }
                return;
            }
        }
        System.out.println("No club found with name: " + clubName);
    }
}