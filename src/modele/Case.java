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

    public Case(boolean state) {
        this.state = state;
    }
    
    public Case(boolean state, int x, int y) {
        this.state = state;
        this.x = x;
        this.y = y;
    }

    public Case( int x, int y) {
        
        this.x = x;
        this.y = y;
    }

    public void rndState() {
        state = rnd.nextBoolean();
    }


    public boolean nextState(Environnement e) {
        int alive = 0;

        alive += e.getCase(this, Direction.gh).state ? 1 : 0;
        alive += e.getCase(this, Direction.hd).state ? 1 : 0;
        alive += e.getCase(this, Direction.g).state ? 1 : 0;
        alive += e.getCase(this, Direction.d).state ? 1 : 0;
        alive += e.getCase(this, Direction.bg).state ? 1 : 0;
        alive += e.getCase(this, Direction.db).state ? 1 : 0;
        
        if (state) {
            return alive == 2 || alive == 3;
        } else {    
            return alive == 3;
        }
}

    public void setState(boolean state) {
            this.state = state;
        }

    public int getX() {return x;}
    public int getY() {return y;}


}

