package modele;

import java.util.Random;

public class Case {
    private static final Random rnd = new Random();
    private boolean state;
    
    private int x;
    private int y;
    private int life;
    private int life2;    

    public boolean getState() {return state;}

    public int getLife(){return life;}
    public int getLife2(){return life2;}
    public void setLife(int life2){life = life2;}
    public void loseLife(int amount) {
        this.life -= amount;
        if (this.life < 0) {
            this.life = 0; // Empêche d'avoir une vie négative
        }
    }

    public void gainLife(int amount) {this.life += amount;}

    public boolean isAlive() {return life > 0;}


    public Case(boolean state) {
        this.state = state;
    }
    
    public Case(boolean state, int x, int y) { 
        this.state = state;
        this.x = x;
        this.y = y;
    }

    public Case( int x, int y, int life) {
        
        this.x = x;
        this.y = y;
        this.life = life;
        
    }

     public Case( int x, int y, int life, int life2) {
        
        this.x = x;
        this.y = y;
        this.life = life;
        this.life2 = life2;
    }

    public Case( int x, int y) {
        
        this.x = x;
        this.y = y;
    }

    public void rndState() {
        state = rnd.nextBoolean();
    }

    public int getNeighboreHexa(Environnement e){
        int alive = 0;

        alive += e.getCase(this, Direction.gh).state ? 1 : 0;
        alive += e.getCase(this, Direction.hd).state ? 1 : 0;
        alive += e.getCase(this, Direction.g).state ? 1 : 0;
        alive += e.getCase(this, Direction.d).state ? 1 : 0;
        alive += e.getCase(this, Direction.bg).state ? 1 : 0;
        alive += e.getCase(this, Direction.db).state ? 1 : 0;

        return alive;
    }

    public int getNeighbore(Environnement e){
        int alive = 0;

        alive += e.getCase(this, Direction.gh).state ? 1 : 0;
        alive += e.getCase(this, Direction.hd).state ? 1 : 0;
        alive += e.getCase(this, Direction.g).state ? 1 : 0;
        alive += e.getCase(this, Direction.d).state ? 1 : 0;
        alive += e.getCase(this, Direction.bg).state ? 1 : 0;
        alive += e.getCase(this, Direction.db).state ? 1 : 0;
        alive += e.getCase(this, Direction.h).state ? 1 : 0;
        alive += e.getCase(this, Direction.b).state ? 1 : 0;

        return alive;
    }

    public boolean nextState(Environnement e, boolean  type) {
        int alive = 0;

        if(type) alive = getNeighboreHexa(e);
        else alive = getNeighbore(e);      
        if(life <= 0) return false;
        else {
            return e.getRules().applyRule(state, alive, this);
        }
    }

    public void setState(boolean state) {
            this.state = state;
    }

    public int getX() {return x;}
    public int getY() {return y;}


}

