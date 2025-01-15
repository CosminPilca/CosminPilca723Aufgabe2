package view;

import Model.Club;
import Model.Match;
import Model.Player;
import Service.ClubService;
import Service.MatchService;
import Service.PlayerService;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;
    private MatchService matchService;
    private PlayerService playerService;
    private ClubService clubService;

    public ConsoleView() {
        scanner = new Scanner(System.in);
        matchService = new MatchService();
        playerService = new PlayerService();
        clubService = new ClubService();
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("============== Main Menu ==============");
            System.out.println("1. EURO 2024 Spiele verwalten");
            System.out.println("2. Fussballvereinsmanagement");
            System.out.println("0. Exit");
            System.out.print("Bitte Auswahl treffen: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    euro2024Menu();
                    break;
                case "2":
                    clubManagementMenu();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Ungultige Auswahl.");
            }
        }
    }

    // ========== Aufgabe 1 Menüs ==========
    private void euro2024Menu() {
        boolean back = false;
        while (!back) {
            System.out.println("----- EURO 2024 Spielorte -----");
            System.out.println("1. Alle Matches anzeigen");
            System.out.println("2. Neues Match hinzufügen");
            System.out.println("3. Match bearbeiten");
            System.out.println("4. Match löschen");
            System.out.println("0. Zuruck");
            System.out.print("Auswahl: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    matchService.listAllMatches();
                    break;
                case "2":
                    addMatch();
                    break;
                case "3":
                    editMatch();
                    break;
                case "4":
                    removeMatch();
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Ungultige Auswahl.");
            }
        }
    }

    private void addMatch() {
        System.out.println("Neues Match hinzufugen:");

        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Team 1: ");
        String team1 = scanner.nextLine();

        System.out.print("Team 2: ");
        String team2 = scanner.nextLine();

        System.out.print("Datum (YYYY-MM-DD): ");
        String datum = scanner.nextLine();

        System.out.print("Spielort (Stadt): ");
        String spielort = scanner.nextLine();

        System.out.print("Kapazitat: ");
        String kapazitaet = scanner.nextLine();

        Match match = new Match(id, team1, team2, datum, spielort, kapazitaet);
        matchService.addMatch(match);
    }

    private void editMatch() {
        System.out.print("Gib die ID des zu bearbeitenden Matches ein: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Neue Matchdaten eingeben:");

        System.out.print("Team 1: ");
        String team1 = scanner.nextLine();

        System.out.print("Team 2: ");
        String team2 = scanner.nextLine();

        System.out.print("Datum (YYYY-MM-DD): ");
        String datum = scanner.nextLine();

        System.out.print("Spielort (Stadt): ");
        String spielort = scanner.nextLine();

        System.out.print("Kapazitat: ");
        String kapazitaet = scanner.nextLine();

        Match updated = new Match(id, team1, team2, datum, spielort, kapazitaet);
        matchService.editMatch(id, updated);
    }

    private void removeMatch() {
        System.out.print("Gib die ID des zu löschenden Matches ein: ");
        int id = Integer.parseInt(scanner.nextLine());
        matchService.removeMatch(id);
    }

    // ========== Aufgabe 2 Menüs ==========
    private void clubManagementMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("----- Fußballvereinsmanagement -----");
            System.out.println("1. Spieler verwalten");
            System.out.println("2. Vereine verwalten");
            System.out.println("3. Vereine nach Stadt filtern");
            System.out.println("4. Alle Spieler eines Vereins anzeigen (nach Vereinsname)");
            System.out.println("5. Alle Spieler eines Vereins sortiert nach Marktwert anzeigen");
            System.out.println("0. Zurück");
            System.out.print("Auswahl: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    playerManagementMenu();
                    break;
                case "2":
                    clubCrudMenu();
                    break;
                case "3":
                    filterClubsByCity();
                    break;
                case "4":
                    listPlayersInClub();
                    break;
                case "5":
                    listPlayersInClubSorted();
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Ungültige Auswahl.");
            }
        }
    }

    // --- Spieler-Verwaltung (a) ---
    private void playerManagementMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("----- Spieler-Verwaltung -----");
            System.out.println("1. Spieler hinzufügen");
            System.out.println("2. Spieler bearbeiten");
            System.out.println("3. Spieler löschen");
            System.out.println("4. Alle Spieler anzeigen");
            System.out.println("0. Zurück");
            System.out.print("Auswahl: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addPlayer();
                    break;
                case "2":
                    editPlayer();
                    break;
                case "3":
                    removePlayer();
                    break;
                case "4":
                    playerService.listAllPlayers();
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Ungültige Auswahl.");
            }
        }
    }

    private void addPlayer() {
        System.out.println("Neuen Spieler hinzufügen:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Alter: ");
        int alter = Integer.parseInt(scanner.nextLine());
        System.out.print("Position: ");
        String position = scanner.nextLine();
        System.out.print("Marktwert: ");
        double marktwert = Double.parseDouble(scanner.nextLine());

        Player player = new Player(name, alter, position, marktwert);
        playerService.addPlayer(player);

        // Optionally, we could also attach this new player to an existing club:
        System.out.print("Soll der Spieler einem Club hinzugefügt werden? (j/n): ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("j")) {
            System.out.print("Club-ID eingeben: ");
            int clubId = Integer.parseInt(scanner.nextLine());
            clubService.addPlayerToClub(clubId, player);
        }
    }

    private void editPlayer() {
        System.out.print("Name des Spielers, der bearbeitet werden soll: ");
        String oldName = scanner.nextLine();

        System.out.println("Neue Daten für den Spieler eingeben:");
        System.out.print("Neuer Name: ");
        String name = scanner.nextLine();
        System.out.print("Neues Alter: ");
        int alter = Integer.parseInt(scanner.nextLine());
        System.out.print("Neue Position: ");
        String position = scanner.nextLine();
        System.out.print("Neuer Marktwert: ");
        double marktwert = Double.parseDouble(scanner.nextLine());

        Player updated = new Player(name, alter, position, marktwert);
        playerService.editPlayer(oldName, updated);
    }

    private void removePlayer() {
        System.out.print("Name des zu löschenden Spielers: ");
        String name = scanner.nextLine();
        playerService.removePlayer(name);
    }

    // --- Vereins-Verwaltung (b) ---
    private void clubCrudMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("----- Vereins-Verwaltung -----");
            System.out.println("1. Verein hinzufügen");
            System.out.println("2. Verein bearbeiten");
            System.out.println("3. Verein löschen");
            System.out.println("4. Alle Vereine anzeigen");
            System.out.println("0. Zurück");
            System.out.print("Auswahl: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addClub();
                    break;
                case "2":
                    editClub();
                    break;
                case "3":
                    removeClub();
                    break;
                case "4":
                    clubService.listAllClubs();
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Ungültige Auswahl.");
            }
        }
    }

    private void addClub() {
        System.out.println("Neuen Verein hinzufügen:");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Stadt: ");
        String stadt = scanner.nextLine();

        Club newClub = new Club(id, name, stadt);
        clubService.addClub(newClub);
    }

    private void editClub() {
        System.out.print("ID des Vereins, der bearbeitet werden soll: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Neue Vereinsdaten:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Stadt: ");
        String stadt = scanner.nextLine();

        Club updated = new Club(id, name, stadt);
        clubService.editClub(id, updated);
    }

    private void removeClub() {
        System.out.print("ID des zu löschenden Vereins: ");
        int id = Integer.parseInt(scanner.nextLine());
        clubService.removeClub(id);
    }

    // --- (c) ---
    private void filterClubsByCity() {
        System.out.print("Stadt eingeben: ");
        String city = scanner.nextLine();
        clubService.listClubsByCity(city);
    }

    // --- (d) ---
    private void listPlayersInClub() {
        System.out.print("Name des Vereins: ");
        String clubName = scanner.nextLine();
        clubService.listPlayersInClub(clubName);
    }

    // --- (e) ---
    private void listPlayersInClubSorted() {
        System.out.print("Name des Vereins: ");
        String clubName = scanner.nextLine();
        System.out.print("Sortierung: Aufsteigend (a) oder Absteigend (d)? ");
        String sortChoice = scanner.nextLine();
        boolean ascending = sortChoice.equalsIgnoreCase("a");
        clubService.listPlayersInClubSortedByMarketValue(clubName, ascending);
    }
}