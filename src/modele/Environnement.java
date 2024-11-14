package modele;

import java.util.Observable;

public class Environnement extends Observable implements Runnable {
    private Case[][] tab;
    private Case[][] tab2;
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

        return tab[newX][newY];
    }



    public Environnement(int _sizeX, int _sizeY) {

        sizeX = _sizeX;
        sizeY = _sizeY;

        tab = new Case[sizeX][sizeY];
        tab2 = new Case[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                tab[i][j] = new Case();
                tab2[i][j] = new Case();
                
                tab[i][j].rndState();
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

   public void updateState() {

    if (tab2 == null) 
    {   
        tab2 = new Case[sizeX][sizeY];
    }
 
    for (int i = 0; i < sizeX; i++) 
        for (int j = 0; j < sizeY; j++)
        {
            tab2[i][j].nextState(this);
        }

    Case[][] temp = tab;
    tab = tab2;
    tab2 = temp; 
}

    

    @Override
    public void run() {
        if(truc){
             rndState();
             truc = false;
        }
        updateState();
        
        // notification de l'observer
        setChanged();
        notifyObservers();
    }
}
