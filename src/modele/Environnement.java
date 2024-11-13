package modele;

import java.util.Observable;

public class Environnement extends Observable implements Runnable {
    private Case[][] tab;
    private int sizeX, sizeY;

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
        switch (d) {
            case h:
                return tab[source.getX() % sizeX][source.getY() + 1 % sizeY];
            case hd:
                return tab[source.getX() + 1 % sizeX][source.getY() + 1 % sizeY];
            case d:
                return tab[source.getX() + 1 % sizeX][source.getY() % sizeY];
            case db:
                return tab[source.getX() + 1 % sizeX][source.getY() - 1 % sizeY];
            case b:
                return tab[source.getX() % sizeX][source.getY() - 1 % sizeY];
            case bg:
                return tab[source.getX() - 1 % sizeX][source.getY() - 1 % sizeY];
            case g:
                return tab[source.getX() - 1 % sizeX][source.getY() % sizeY];
            case gh:
                return tab[source.getX() - 1 % sizeX][source.getY() + 1 % sizeY];
            default:
                throw new IllegalArgumentException("Direction inconnue : " + d);
        }
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
        rndState();
        // notification de l'observer
        setChanged();
        notifyObservers();
    }
}
