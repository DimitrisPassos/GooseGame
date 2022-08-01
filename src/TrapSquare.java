import java.io.Serializable;


public class TrapSquare extends Square implements Serializable {


    private int count;

    boolean canPlay = false;

    public TrapSquare(int number,Player player) {
        super(number);
        this.squareName = "Trap Square";
        this.player = player;
    }

    public TrapSquare(int number) {
        super(number);
        this.player = null;

    }

    @Override
    public int getNumber() {
        return super.getNumber();
    }

    @Override
    boolean canPlay() {

        return false;

    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int action(int num) {
        if (this.getPlayer()!=null) {
            Player pl = this.getPlayer();
            Square sq = pl.getSquare();
            pl.setSquare(sq);
        }
        return num;

    }

    @Override
    public void setNumber(int number) {
        super.setNumber(number);
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
        return super.toString();
    }

    @Override
    public void superAction() {
        if (this.getPlayer()!=null) {
            Player pl = this.getPlayer();
            Square sq = pl.getSquare();
            pl.setSquare(sq);
        }
    }


}
