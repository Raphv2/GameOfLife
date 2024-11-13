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

    public void getX() {
        this.x = x;
    }

    public void getY() {
        this.y = y;
    }

    public void rndState() {
        state = rnd.nextBoolean();
    }

    private int getNeighbours(Environnement e) {
        int n = 0
        if (e.getCase(this, h)){
            n++;
        }
        if (e.getCase(this, hd)){
            n++;
        }
        if (e.getCase(this, d)){
            n++;
        }
        if (e.getCase(this, db)){
            n++;
        }
        if (e.getCase(this, b)){
            n++;
        }
        if (e.getCase(this, bg)){
            n++;
        }
        if (e.getCase(this, g)){
            n++;
        }
        if (e.getCase(this, gh)){
            n++;
        }
        retunr n;
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
            if (getNeighbours(e) = 3){
                state = true;
            }
        }

    }


}
