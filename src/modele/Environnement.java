package modele;

import java.util.Observable;

public class Environnement extends Observable implements Runnable {
    private Case[][] tab;
    private int sizeX, sizeY;
    private boolean pause;
    private int speed;
    private boolean type;
    private Rules rules;

    public Rules getRules(){return rules;}

    public void setRules(int numRules){
        switch (numRules) {
            case 0:
                rules = new StandardRules();
                break;
            case 1:
                rules = new HighLifeRules();
                break;
            case 2:
                rules = new DayAndNightRules();
                break;
            case 3:
                rules = new SeedsRules();
                break;
            case 4:
                rules = new MazeRules();
                break;
            case 5:
                rules = new TwoByTwoRules();
                break;
            default:
                throw new AssertionError();
        }
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void pause(){
        this.pause = !this.pause;
    }

    public int getSpeed(){return speed;}

    public boolean getType(){return type;}

    public void setSpeed(int moreSpeed){
        this.speed += moreSpeed;
    }

    public void setType(){
       type = !type;
    }

   

    public boolean getState(int x, int y) {
        return tab[x][y].getState();
    }

    public void setState(int x, int y, boolean state) {
        tab[x][y].setState(state);
    }

    public Case getCase(Case source, Direction d) {
        int[] offset = DirectionOffsets.getOffset(d);

        int newX = (source.getX() + offset[0])%sizeX;
        int newY = (source.getY() + offset[1])%sizeY;


        if (newX < 0) {
            newX += sizeX;
        }
        if (newY < 0) {
            newY += sizeY;
        }
        
        return tab[newX][newY];
    }



    public Environnement(int _sizeX, int _sizeY, boolean typeuh) {

        rules = new StandardRules();
        sizeX = _sizeX;
        sizeY = _sizeY;

        tab = new Case[sizeX][sizeY];
        

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                tab[i][j] = new Case(i, j);
                
                
                tab[i][j].rndState();
            }
        }

        pause = false;
        speed = 1001;
        type = typeuh;
    }

    public void rndState() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                tab[i][j].rndState();

            }
        }
    }

    public void updateState() {

        Case[][] temp = new Case[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                temp[i][j] = new Case(i, j);
                temp[i][j].setState(tab[i][j].nextState(this, type));
                
            }
        }
        tab = temp;
    }

    public void NUKE(){
        for (int i = 0; i < sizeX; i++) 
        for (int j = 0; j < sizeY; j++) {
                tab[i][j].setState(false);
            
        }
        
    }

    

    @Override
    public void run() {
       if(!pause){
            updateState();
            System.out.println(getSpeed());
       }
        
      
        // notification de l'observer
        setChanged();
        notifyObservers();
    }
}
