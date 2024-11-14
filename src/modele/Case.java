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
        int neighbours = getNeighbours(e);  // Compte les voisins vivants
        System.out.println(neighbours); 
        // Règles du jeu de la vie appliquées à la cellule
        if (state) {  // Si la cellule est vivante
            if (neighbours < 2 || neighbours > 3) {
                state = false;  // La cellule meurt par sous-population ou surpopulation
            }
            // Sinon, la cellule reste vivante (si elle a 2 ou 3 voisins vivants)
        } else {  // Si la cellule est morte
            if (neighbours == 3) {
                state = true;  // La cellule devient vivante par reproduction
            }
        }
    }


    public int getX() {return x;}
    public int getY() {return y;}

}
