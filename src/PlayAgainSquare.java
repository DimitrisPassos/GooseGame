import java.io.Serializable;

public class PlayAgainSquare extends Square implements Serializable {
    private boolean isTrue = false;

    public PlayAgainSquare(int number) {
        super(number);
        this.squareName = "Play Again Square";
    }
    public PlayAgainSquare(int number,boolean isTrue) {
        super(number);
        this.squareName = "Teleport to Next Square";
        this.isTrue = isTrue;
    }



    public PlayAgainSquare(int number, Player player) {
        super(number, player);
    }

    @Override
    public int getNumber() {
        return super.getNumber();
    }

    @Override
    public int action(int num) {
        if (isTrue == false) {
            if (num == 5 || num == 9 || num == 14 || num == 18 || num == 23 || num == 27 ||
                    num == 32 || num == 36 || num == 41 || num == 45 || num == 50 || num == 54 ||
                    num == 59) {
                int first = ((int) (Math.random() * 10000) % 6) + 1;
                int second = ((int) (Math.random() * 10000) % 6) + 1;
                System.out.println("You have rolled " + (first + second));
                return num + first + second;

            }

            return 0;
        }
        if (isTrue == true) {
            switch (num) {
                case 5:
                    return 9;
                case 9:
                    return 14;

                case 14:
                    return 18;

                case 18:
                    return 23;

                case 23:
                    return 27;

                case 27:
                    return 32;

                case 32:
                    return 36;
                case 36:
                    return 41;

                case 41:
                    return 45;

                case 45:
                    return 50;

                case 50:
                    return 54;

                case 54:
                    return 59;

                default:
                    break;
            }
            return 0;
        }
        return 0;
    }

    @Override
    public void setNumber(int number) {
        super.setNumber(number);
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

    @Override
    public String toString() {
        return super.toString();
    }
}
