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
        if (e.getCase(this, Direction.h).state) {
            n++;
        }
        if (e.getCase(this, Direction.hd).state) {
            n++;
        }
        if (e.getCase(this, Direction.d).state) {
            n++;
        }
        if (e.getCase(this, Direction.db).state) {
            n++;
        }
        if (e.getCase(this, Direction.b).state) {
            n++;
        }
        if (e.getCase(this, Direction.bg).state) {
            n++;
        }
        if (e.getCase(this, Direction.g).state) {
            n++;
        }
        if (e.getCase(this, Direction.gh).state) {
            n++;
        }
        return n;
    }


    public void nextState(Environnement e) {
        int neighbours = getNeighbours(e); 
        System.out.println(neighbours); 
        if (state) {  
            if (neighbours < 2 || neighbours > 3) {
                state = false; 
            }
        } else {  
            if (neighbours == 3) {
                state = true;
            }  
        }
    }


    public int getX() {return x;}
    public int getY() {return y;}

}
