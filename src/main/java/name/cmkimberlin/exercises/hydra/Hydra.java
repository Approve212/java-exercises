package name.cmkimberlin.exercises.hydra;

public class Hydra {
    private int heads;
    private int tails;

    //Constructor for making the Hydra with H heads and T tails
    public Hydra(int H, int T) {
        this.heads = H;
        this.tails = T;
    }

    //Gets the number of Hydra heads
    public int getHeads() {
        return this.heads;
    }
    //Sets the number of Hydra heads
    public void setHeads(int H) {
        this.heads = H;
    }
    //Gets the number of Hydra tails
    public int getTails() {
        return this.tails;
    }
    //Sets the number of Hydra tails
    public void setTails(int T) {
        this.tails = T;
    }

    //Calculates the minimum number of moves to defeat the Hydra
    public int minMovesCalc(Hydra hydra) {
        boolean dead = false;
        int moves = 0;
        int heads = hydra.getHeads();
        int tails = hydra.getTails();
        
        while (!dead) {
            while (heads >= 2) {
                heads -= 2;
                moves++;
            }
            if ((tails % 2) == 0 && tails > 0 && (tails > 3 || heads > 0)) {
                tails -= 2;
                heads++;
                moves++;

            } else if (tails == 0 && heads == 1) {
                moves = -1;
                dead = true;
            } else if (tails == 0 && heads == 0) {
                dead = true;
            } else {
                tails++;
                moves++;
            }
        }
        return moves;
    }
}
