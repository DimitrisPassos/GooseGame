import java.io.Serializable;

public class TeleportSquare extends Square implements Serializable {

    public TeleportSquare(int number) {
        super(number);
        this.squareName = "Teleport Square";
    }

    public TeleportSquare(int number, Player player) {
        super(number, player);
    }

    @Override
    public int getNumber() {
        return super.getNumber();
    }

    @Override
    public void setNumber(int number) {
        super.setNumber(number);
    }

    @Override
    public int action(int num) {
        if (num == 6){
            return 12;
        }
        if (num == 42){
            return 30;
        }
        if (num == 58){
            return 1;
        }
        return 0;
    }

    @Override
    boolean canPlay() {
        return super.canPlay();
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
