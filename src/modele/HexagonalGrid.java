package modele;

import java.awt.*;
import javax.swing.*;

public class HexagonalGrid extends JPanel {

    private int rows;
    private int cols; 
    private int hexSize;
    private int offsetX;
    private int offsetY;

    public int getHexSize(){return hexSize;}

    public HexagonalGrid(int rows, int cols, int hexSize, int offsetX, int offsetY) {
        this.rows = rows;
        this.cols = cols;
        this.hexSize = hexSize;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        setPreferredSize(new Dimension(cols * hexSize * 2, rows * hexSize * 2));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int height = (int) (Math.sqrt(3) * hexSize) + 15; 
        int width = 2 * hexSize -2; 
        int yOffset = height / 2; 

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * width + (row % 2 == 0 ? 0 : hexSize) + offsetX; // Décalage colonnes
                int y = row * (height - yOffset) + offsetY;
                drawHexagon(g2d, x, y, hexSize, Color.WHITE);
            }
        }
    }

    private void drawHexagon(Graphics2D g2d, int x, int y, int size, Color color) {
        Polygon hex = new Polygon();
        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(i * 60) + Math.toRadians(90.); 
            int xOffset = (int) (x + size * Math.cos(angle));
            int yOffset = (int) (y + size * Math.sin(angle));
            hex.addPoint(xOffset, yOffset);
        }
        g2d.setColor(color); // Couleur fond
        g2d.fillPolygon(hex);
        g2d.setColor(Color.BLACK); // Couleur bordure
        g2d.drawPolygon(hex);
    }

        public void repaintHexagon(int row, int col, Color color) {
        int height = (int) (Math.sqrt(3) * hexSize) + 15;
        int width = 2 * hexSize -2;
        int yOffset = height / 2;

        int x = col * width + (row % 2 == 0 ? 0 : hexSize) + offsetX;
        int y = row * (height - yOffset) + offsetY;

        Graphics g = getGraphics(); 
        if (g != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            drawHexagon(g2d, x, y, hexSize, color); 
        }
    }

}