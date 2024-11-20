package vue_controleur;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.Border;
import modele.Environnement;
import modele.HexagonalGrid;
/**
 *
 * @author frederic
 */
public class FenetrePrincipale extends JFrame implements Observer {

    private HexagonalGrid hexaGrid;
    public Environnement env;
    JLabel label;
    

    public FenetrePrincipale(Environnement _env) {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        env = _env;
        build();
    }

    public void build() {
        
        setTitle("Jeu de la Vie");
        setSize(1200, 1000);
        
        // Panneau principal
        JPanel pan = new JPanel(new BorderLayout());
        
        
        // Panneau central
        JComponent pan1 = new JPanel (new GridLayout(env.getSizeX(),env.getSizeY()));
        hexaGrid = new HexagonalGrid(env.getSizeX(),env.getSizeY(), 5);


        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        pan1.setBorder(blackline);
        
        
        // Panneau pour les boutons
        JPanel pan2 = new JPanel(new FlowLayout());
        pan2.add(new JButton("b1"));
        pan2.add(new JTextField("jt1"));
        
        
        
        pan.add(pan1, BorderLayout.CENTER);
        pan.add(pan2, BorderLayout.EAST);
        
        setContentPane(pan);

        // Ajout Menu
        JMenuBar jm = new JMenuBar();
        JMenu m = new JMenu("Fichier");
        JMenuItem mi = new JMenuItem("Charger");

        m.add(mi);
        jm.add(m);
        setJMenuBar(jm);
        pan.add(hexaGrid);

        MouseHandler mouseHandler = new MouseHandler(env, hexaGrid);
        pan.addMouseListener(mouseHandler);


        
    }


    @Override
    public void update(Observable o, Object arg) {
        // raffraîchissement de la vue
         for(int i = 0; i<env.getSizeX();i++){
            for (int j = 0; j < env.getSizeY(); j++) {
                if (env.getState(i, j)) {
                    hexaGrid.repaintHexagon(i, j, Color.BLACK);
                } else {
                    hexaGrid.repaintHexagon(i, j,Color.WHITE);
                }
            }

        }


    }
}
