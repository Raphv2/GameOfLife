package modele;

import java.util.Observable;

public class Environnement extends Observable implements Runnable {
    private Case[][] tab;

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    private int sizeX, sizeY;

    public boolean getState(int x, int y) {
        return tab[x][y].getState();
    }

    public Case getCase(Case source, Direction d) {
        switch (d) {
            case h:
                return tab[source.getX() % sizeX][source.getY() + 1 % sizeY];
                break;
            case hd:
                return tab[source.getX() + 1 % sizeX][source.getY() + 1 % sizeY];
                break;
            case d:
                return tab[source.getX() + 1 % sizeX][source.getY() % sizeY];
                break;
            case db:
                return tab[source.getX() + 1 % sizeX][source.getY() - 1 % sizeY];
                break;
            case b:
                return tab[source.getX() % sizeX][source.getY() - 1 % sizeY];
                break;
            case bg:
                return tab[source.getX() - 1 % sizeX][source.getY() - 1 % sizeY];
                break;
            case g:
                return tab[source.getX() - 1 % sizeX][source.getY() % sizeY];
                break;
            case gh:
                return tab[source.getX() - 1 % sizeX][source.getY() + 1 % sizeY];
                break;
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
                tab[i][j].rndState;

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
