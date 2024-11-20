package vue_controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modele.Environnement;
import modele.HexagonalGrid;

public class MouseHandler implements MouseListener {
    
    public Environnement env;
    private HexagonalGrid hexaGrid;

    public MouseHandler(Environnement env, HexagonalGrid hexaGrid) {
        this.env = env;
        this.hexaGrid = hexaGrid;
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
        int x = e.getX();
        int y = e.getY();
        
        int hexSize = hexaGrid.getHexSize();
        int height = (int) (Math.sqrt(3) * hexSize) + 5;
        int width = 2 * hexSize;
        int yOffset = height / 2;

        int row = (y - 100) / (height - yOffset);
        int col = (x - 10) / width;

        if (row % 2 != 0) {
            col = (x - 10 - hexSize) / width;
        }

        if (row >= 0 && row < env.getSizeX() && col >= 0 && col < env.getSizeY()) {
            env.setState(row, col, true); 
            System.out.println("flute");
        } else {
            System.out.println("PAS DEDANS!!!");
        }
    }
}