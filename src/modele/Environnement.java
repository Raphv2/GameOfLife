package modele;

import java.util.Observable;

public class Environnement extends Observable implements Runnable {
    private Case[][] tab;
    private int sizeX, sizeY;
    private boolean truc = true;

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

   

    public boolean getState(int x, int y) {
        return tab[x][y].getState();
    }

    public Case getCase(Case source, Direction d) {

        int[] offset = DirectionOffsets.getOffset(d);

        int newX = (source.getX() + offset[0]) % sizeX;
        int newY = (source.getY() + offset[1]) % sizeY;

        if (newX < 0) {
            newX += sizeX;
        }
        if (newY < 0) {
            newY += sizeY;
        }

        // Retourner la case à ces coordonnées
        return tab[newX][newY];
}



    public Environnement(int _sizeX, int _sizeY) {

        sizeX = _sizeX;
        sizeY = _sizeY;

        tab = new Case[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                tab[i][j] = new Case();
            }
        }
    }

    public void rndState() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                tab[i][j].rndState();

            }
        }
        

    }

    

    @Override
    public void run() {
        if(truc){
            rndState();
            truc = false;
        }

        for (int i = 0; i < sizeX; i++) 
            for (int j = 0; j < sizeY; j++) {
            tab[i][j].nextState( this);
        }

        // notification de l'observer
        setChanged();
        notifyObservers();
    }
}
