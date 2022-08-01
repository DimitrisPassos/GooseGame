import java.io.Serializable;
import java.util.Random;

public class Player implements Serializable {

    private String name;
    private Board board;
    private Square square;


    public Player(String name,Board board,Square square) {
        this.name = name;
        this.board = board;
        this.square = square;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Square getSquare() {
        return this.square;
    }

    public void moveTo(Square square1) {
        this.square = square1;
    }

    public void setSquare(Square square) {
        this.square = square;
    }



    int roll1 = 0;
    public int rollDice1(){
        Random r = new Random();
        roll1++;
        int result = r.nextInt(6);
        result+=1;

        return  result;

    }
    int roll2 = 0;
    public int rollDice2(){
        Random r = new Random();
        roll2++;
        int result = r.nextInt(6);
        result+=1;

        return  result;
    }





}
