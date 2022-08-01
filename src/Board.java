import java.io.Serializable;
import java.util.ArrayList;

public class Board implements Serializable {

    private ArrayList<Square> allSquares = new ArrayList<>();
    private String boardName;
    private boolean advanced = false;

    public Board(String boardName) {
        this.boardName = boardName;
        init();
    }
    public Board(String boardName,boolean advanced) {
        this.boardName = boardName;
        this.advanced = advanced;
        init();
    }

    public void init(){
        for (int i = 0; i < 64; i++){
            allSquares.add(new NormalSquares(i));
        }

        int[] specialS = {5,9,14,18,23,27,32,36,41,45,50,54,59};
        if (!advanced){
            for (int i: specialS){
                allSquares.set(i,new PlayAgainSquare(i));
            }
        }else if (advanced){
            for (int i: specialS){
                allSquares.set(i,new PlayAgainSquare(i,true));
            }
        }



        int[] specialT = {6,42,58};

        for (int i : specialT){
            allSquares.set(i,new TeleportSquare(i));
        }

        allSquares.set(19,new StopSquare(19));

        allSquares.set(31,new TrapSquare(31));

        allSquares.set(52,new TrapSquare(52));

        allSquares.set(0,new StartingSquare(0));

    }

    public ArrayList<Square> getAllSquares() {
        return allSquares;
    }

    public Square getTheSquare(int num){
        return allSquares.get(num);
    }

    public void setAdvanced(){
        this.advanced = true;
    }


}
