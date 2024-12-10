package modele;

public class Modules {

    public static int[][] generate3x3Blinker(int offsetX, int offsetY) {
        int[][] blinker = new int[3][2]; // Tableau de 3 cellules avec leurs coordonnées
        for (int i = 0; i < 3; i++) {
            blinker[i][0] = i + offsetX; // Ligne
            blinker[i][1] = 1 + offsetY; // Colonne
        }
        return blinker;
    }

    public static int[][] generate3x3SpaceShip(int offsetX, int offsetY) {
        int[][] spaceship = new int[5][2]; // Tableau de 5 cellules avec leurs coordonnées
        spaceship[0] = new int[]{0 + offsetX, 0 + offsetY};
        spaceship[1] = new int[]{1 + offsetX, 0 + offsetY};
        spaceship[2] = new int[]{2 + offsetX, 0 + offsetY};
        spaceship[3] = new int[]{2 + offsetX, 1 + offsetY};
        spaceship[4] = new int[]{1 + offsetX, 2 + offsetY};
        return spaceship;
    }

    public static int[][] generate5x4SpaceShip(int offsetX, int offsetY) {
        int[][] spaceship = new int[7][2]; // Tableau de 7 cellules avec leurs coordonnées
        spaceship[0] = new int[]{1 + offsetX, 0 + offsetY};
        spaceship[1] = new int[]{2 + offsetX, 0 + offsetY};
        spaceship[2] = new int[]{3 + offsetX, 0 + offsetY};
        spaceship[3] = new int[]{4 + offsetX, 0 + offsetY};
        spaceship[4] = new int[]{0 + offsetX, 1 + offsetY};
        spaceship[5] = new int[]{4 + offsetX, 1 + offsetY};
        spaceship[6] = new int[]{0 + offsetX, 3 + offsetY};
        return spaceship;
    }
}