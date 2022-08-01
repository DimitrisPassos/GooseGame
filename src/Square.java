import java.io.Serializable;

public class Square implements Serializable {

    protected String squareName;
    protected int number;
    protected Player player;

    public Square(int number) {
        this.number = number;
        this.player = null;
    }

    public Square(int number,Player player) {
        this.number = number;
        this.player = player;
    }

    public int action(int num){
        return num;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    boolean canPlay(){
        return true;
    }

    public boolean anotherPlayer(){
        if (this.player == null){
            return false;
        }
        return true;
    }

    public Player getPlayer(){
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void swap(Player player) {
        if (anotherPlayer()) {
            System.out.println("There is already a player in this square. Swapping");
            Player incomingPlayer = this.getPlayer();

            Square toMove = player.getSquare();

            incomingPlayer.setSquare(toMove);

            System.out.println(incomingPlayer.getName() + " has swapped squares with " + player.getName());
            System.out.println(incomingPlayer.getName() + " is now at square  " + incomingPlayer.getSquare().getNumber());
        }
    }

    @Override
    public String toString() {
        return "You are now in a " + this.squareName ;
    }

    public void decreaseTurn(){

    }

    public void superAction(){}
}







