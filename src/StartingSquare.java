import java.io.Serializable;

public class StartingSquare extends Square implements Serializable {

    public StartingSquare(int number) {
        super(number);
        this.squareName = "Zero square";
    }

    @Override
    public int action(int num) {
        return super.action(num);
    }

    @Override
    boolean canPlay() {
        return super.canPlay();
    }

    @Override
    public boolean anotherPlayer() {
        return super.anotherPlayer();
    }
}
