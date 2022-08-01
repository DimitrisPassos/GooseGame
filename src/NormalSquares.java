import java.io.Serializable;

public class NormalSquares extends Square implements Serializable {

    public NormalSquares(int number) {
        super(number);
        this.squareName = "Normal Square";
    }

    public NormalSquares(int number, Player player) {
        super(number, player);
    }

    @Override
    public int getNumber() {
        return super.getNumber();
    }

    @Override
    public int action(int num) {
        return num;
    }

    @Override
    public void setNumber(int number) {
        super.setNumber(number);
    }

    @Override
    boolean canPlay() {
        return true;
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
    public void swap(Player player) {
        super.swap(player);
    }


}
