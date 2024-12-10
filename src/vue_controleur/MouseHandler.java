package vue_controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modele.Environnement;

public class MouseHandler implements MouseListener {
    
    public Environnement env;
    

    public MouseHandler(Environnement env) {
        this.env = env;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
 
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() + 30; 
        int y = e.getY() + 50; 
        
        int cellSize = 20; 

        int row = y / cellSize;
        int col = x / cellSize;

        if (row >= 0 && row < env.getSizeX() && col >= 0 && col < env.getSizeY()) {
            env.setState(row, col, !env.getState(row, col));
            System.out.println("Case cliquée : Row=" + row + ", Col=" + col);
        } else {
            System.out.println("PAS DEDANS  !!!!!!!!!!!");
        }
    }
}