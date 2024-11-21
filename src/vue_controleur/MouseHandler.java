package vue_controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modele.Environnement;
import modele.HexagonalGrid;

public class MouseHandler implements MouseListener {
    
    public Environnement env;
    private HexagonalGrid hexaGrid;
    private int offsetX;
    private int offsetY;

    public MouseHandler(Environnement env, HexagonalGrid hexaGrid, int offsetX, int offsetY) {
        this.env = env;
        this.hexaGrid = hexaGrid;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
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
        int height = (int) (Math.sqrt(3) * hexSize) + 15;
        int width = 2 * hexSize -2;
        int yOffset = height / 2;

        int row = (y - offsetY) / (height - yOffset);
        int col = (x - offsetX) / width;

        if (row % 2 != 0) {
            col = (x - offsetX - hexSize) / width;
        }

        if (row >= 0 && row < env.getSizeX() && col >= 0 && col < env.getSizeY()) {
            env.setState(row, col, true); 
            System.out.println("flute");
        } else {
            System.out.println("PAS DEDANS!!!");
        }
    }
}