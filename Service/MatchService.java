package Service;

import Model.Match;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MatchService {
    private static final String MATCHES_JSON = "spielorte.json";
    private List<Match> matches;

    public MatchService() {
        this.matches = new ArrayList<>();
        loadMatchesFromJson();
    }

    private void loadMatchesFromJson() {
        try (FileReader reader = new FileReader(MATCHES_JSON)) {
            Gson gson = new Gson();
            Type matchListType = new TypeToken<List<Match>>() {}.getType();
            this.matches = gson.fromJson(reader, matchListType);
            if (this.matches == null) {
                this.matches = new ArrayList<>();
            }
        } catch (Exception e) {
            System.out.println("Could not load matches from JSON: " + e.getMessage());
            this.matches = new ArrayList<>();
        }
    }

    private void saveMatchesToJson() {
        try (FileWriter writer = new FileWriter(MATCHES_JSON)) {
            Gson gson = new Gson();
            gson.toJson(this.matches, writer);
        } catch (Exception e) {
            System.out.println("Could not save matches to JSON: " + e.getMessage());
        }
    }

    public void listAllMatches() {
        if (matches.isEmpty()) {
            System.out.println("No matches found.");
            return;
        }
        for (Match match : matches) {
            System.out.println(match);
        }
    }

    public void addMatch(Match match) {
        this.matches.add(match);
        saveMatchesToJson();
    }

    public void editMatch(int matchId, Match updatedMatch) {
        for (int i = 0; i < matches.size(); i++) {
            if (matches.get(i).getId() == matchId) {
                matches.set(i, updatedMatch);
                saveMatchesToJson();
                return;
            }
        }
        System.out.println("Match with ID " + matchId + " not found.");
    }

    public void removeMatch(int matchId) {
        matches.removeIf(m -> m.getId() == matchId);
        saveMatchesToJson();
    }
}