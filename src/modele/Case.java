package modele;

import java.util.Random;

public class Case {
    private static final Random rnd = new Random();
    private boolean state;
    private int x;
    private int y;

    public boolean getState() {
        return state;
    }



    public void rndState() {
        state = rnd.nextBoolean();
    }

    private int getNeighbours(Environnement e) {
        int n = 0;
        if (e.getCase(this, Direction.h) != null) {
            n++;
        }
        if (e.getCase(this, Direction.hd) != null) {
            n++;
        }
        if (e.getCase(this, Direction.d) != null) {
            n++;
        }
        if (e.getCase(this, Direction.db) != null) {
            n++;
        }
        if (e.getCase(this, Direction.b) != null) {
            n++;
        }
        if (e.getCase(this, Direction.bg) != null) {
            n++;
        }
        if (e.getCase(this, Direction.g) != null) {
            n++;
        }
        if (e.getCase(this, Direction.gh) != null) {
            n++;
        }
        return n;
    }


    public void nextState(Environnement e) {
        if (state){
            if (getNeighbours(e) < 2 || getNeighbours(e) > 3){
                state = false;
            }

            else{
                state = true;
            }
        }
        else {
            if (getNeighbours(e) == 3){
                state = true;
            }
        }

    }


    public int getX() {return x;}
    public int getY() {return y;}

}
