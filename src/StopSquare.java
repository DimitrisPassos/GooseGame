import java.io.Serializable;

public class StopSquare extends Square implements Serializable {

    int count;

    public StopSquare(int number) {
        super(number);
        this.squareName = "Stop Square";
        this.count = 2;
    }

    public StopSquare(int number, Player player) {
        super(number, player);
        this.count = 2;
    }

    @Override
    public void setNumber(int number) {
        super.setNumber(number);
    }

    @Override
    public int getNumber() {
        return super.getNumber();
    }

    @Override
    boolean canPlay() {
        if (this.getCount() == 0){
            return true;
        }
        decreaseTurn();
        return false;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int action(int num) {
        if (canPlay()){

            return num;
        }
        return num;
    }

    @Override
    public boolean anotherPlayer() {
        return super.anotherPlayer();
    }

    @Override
    public void setPlayer(Player player) {
        super.setPlayer(player);
    }

    @Override
    public Player getPlayer() {
        return super.getPlayer();
    }

    @Override
    public String toString() {
        return super.toString() + " turns left to play : " + this.getCount();
    }
    @Override
    public void decreaseTurn(){
        int nextValue = this.getCount() - 1;
        this.setCount(nextValue);
    }


}
