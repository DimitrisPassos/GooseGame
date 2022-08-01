import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.Scanner;



public class GameEngine implements Serializable{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static ArrayList<Player> players = new ArrayList<>();

    private static Board board = new Board("My");

        static StartingSquare sq = new StartingSquare(0);


        static Player player1 = new Player("Player1",board,sq);
        static Player player2 = new Player("Player2",board,sq);
        static Player player3 = new Player("Player3",board,sq);
        static Player player4 = new Player("Player4",board,sq);
        static Player player5 = new Player("Player5",board,sq);
        static Player player6 = new Player("Player6",board,sq);

    static boolean win  = false;


    static Player[] playerArray = {player1,player2,player3,player4,player5,player6};

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws URISyntaxException, IOException, ConcurrentModificationException {



        introGame();

        for (Player s : players){
            System.out.println(s.getName());
        }
        startGame();


    }

    public static void introGame(){
        welcome();
        int numberOfPlayers;

        do {
            if(scanner.hasNextInt()){
                numberOfPlayers = scanner.nextInt();
                break;
            }else {
                scanner.nextLine();
                System.out.println("Mistakes were made");
            }
        }while(true);


        if (numberOfPlayers < 2 || numberOfPlayers > 6) {

            while (true) {
                System.out.println("Please enter a valid number of players.\n" +
                        "Do you want to see the welcome message again? Press 7");

                scanner.nextLine();

                numberOfPlayers = scanner.nextInt();

                if (numberOfPlayers == 7) {

                    welcome();
                }
                if (numberOfPlayers > 1 && numberOfPlayers < 7){
                    break;
                }
            }
        }

        for (int i = 0; i < numberOfPlayers; i++){
            addPlayer(playerArray[i]);
        }

        System.out.println("Do you want to set Player name? Y/n");

        String s = scanner.next();

        if (s.equals("Y") || s.equals("y")){

            changePlayerName();

        }else{

            s.equals("n");

        }

        String isAdvanced;
        System.out.println("Do you want to play the advanced variation" +
                " which every goose square teleports you to the next square? (Y/n)");

        isAdvanced = scanner.next();

        if (isAdvanced.equals("y") || isAdvanced.equals("Y")){
            board.setAdvanced();
            board.init();
        }

    }

    public static void welcome(){
        System.out.println("Welcome to the game of Goose:\n" +
                "Please select how many players will play: \n" +
                "Player number must be higher than two and less or equal to six");
    }

    public static void addPlayer(Player player){
        players.add(player);
    }

    public static void changePlayerName(){
        for (Player s : players){
            System.out.println("Choose Player Name:\n");
            String name = scanner.next();
            s.setName(name);
        }
    }

    public static void victoryMessage() throws URISyntaxException {
        final URI url = new URI("https://www.youtube.com/watch?v=O71fetlkCZo&ab_channel=aughrisbuzz&t=0m36s");

        playSong(url);
    }

    public static void playSong(URI uri){
        if (Desktop.isDesktopSupported()){
            try {
                Desktop.getDesktop().browse(uri);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void startGame() throws URISyntaxException, IOException, ConcurrentModificationException {
        while(win == false) {
            for (Player s : players) {
                if (s.getSquare().canPlay()) {

                    System.out.println(s.getName() + " is playing now: " +
                            "You are at square " + s.getSquare().getNumber());
                    System.out.println("Play  Load? : P/s/l");

                    String ps = scanner.next();
                    if (ps.equals("s")|| ps.equals("S")){
                        SaveGame();
                        System.out.println(ANSI_YELLOW + "Game is Saved" + ANSI_RESET);
                        System.out.println("Continue playing or exit? (P / E)");
                        ps = scanner.next();
                        if (ps.equals("e") || ps.equals("E")){
                            System.exit(1);
                        }else {
                            ps = "P";
                        }
                    }


                    if (ps.equals("P") || ps.equals("p")) {



                        int zari1 = s.rollDice1();

                        int zari2 = s.rollDice2();

                        int zaria = zari1 + zari2;

                        System.out.println(s.getName() + " has rolled a " + zaria);

                        if (s.getSquare().getNumber() == 0 && (zari1 == 6 && zari2 == 3)){

                            Square forwardSquare = s.getBoard().getTheSquare(26);
                            s.setSquare(forwardSquare);
                            System.out.println("Lucky guys. You moved to square " + s.getSquare().getNumber());
                            continue;

                        }

                        if (s.getSquare().getNumber() == 0 && (zari1 == 5 && zari2 == 4)){
                            Square forwardSquare = s.getBoard().getTheSquare(53);
                            s.setSquare(forwardSquare);
                            System.out.println("Lucky guys. You moved to square " + s.getSquare().getNumber());
                            continue;
                        }


                        int position = s.getSquare().getNumber();

                        int togo = position + zaria;

                        if(togo >= 63){
                            togo = 63 - (togo - 63);
                        }

                        togo = s.getBoard().getTheSquare(togo).action(togo);

                        if(togo > 63){
                            togo = 63 - (togo - 63);
                        }


                        System.out.println(s.getBoard().getTheSquare(togo).toString());

                        Square finals = s.getBoard().getTheSquare(togo);

                        finals.swap(s);

                        s.moveTo(finals);


                        System.out.println(ANSI_CYAN + s.getName() + " is now at square " + finals.getNumber() + ANSI_RESET);

                        board.getTheSquare(togo).setPlayer(s);

                        if (togo == 63) {

                            System.out.println(ANSI_RED + "Winner is " + s.getName() + ANSI_RESET);

                            victoryMessage();

                            win = true;

                            break;
                        }




                    }
                    if (ps.equals("l") || ps.equals("L")){

                        LoadGame();

                    }
                }else{
                    s.getSquare().superAction();
                }
            }
        }

    }



    public static void SaveGame() throws IOException {
        try {

            FileOutputStream fileStream = new FileOutputStream("data.txt");

            ObjectOutputStream objStream = new ObjectOutputStream(fileStream);

            for (Player s : players){

                objStream.writeObject(s);

            }

            objStream.close();

        } catch (FileNotFoundException | NotSerializableException e) {

            e.printStackTrace();
        }
    }

    public static void LoadGame() throws IOException, EOFException {

        ArrayList<Player> myList = new ArrayList<>();

        FileInputStream fileStream = new FileInputStream("data.txt");

        try (ObjectInputStream objStream = new ObjectInputStream(fileStream);){

                Object obj = new Object();


                boolean check = true;

                while(check) {
                    try {
                        myList.add((Player) objStream.readObject());
                    }catch (EOFException e){
                        check = false;
                    }

                }

                players.clear();

                for (int i = 0; i < myList.size(); i++) {
                    players.add(myList.get(i));
                }

                for (Player s : players) {
                    System.out.println(s.getName());
                }
            System.out.println("Loading Game..... ");
            startGame();



        } catch (FileNotFoundException | NotSerializableException | ClassNotFoundException | URISyntaxException e) {
            e.printStackTrace();
        }catch (EOFException e){
            System.out.println("Opps something went wrong");
        }
    }

}