package vue_controleur;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.BorderLayout;
import java.awt.Color;
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
    private JPanel[][] tab;
    public Environnement env;
    JLabel label;
    

    public FenetrePrincipale(Environnement _env) {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        env = _env;
        build();
    }

    // Dans la méthode build()
    public void build() {
        setTitle("Jeu de la Vie");
        setSize(1200, 1000);

        // Panneau principal
        JPanel pan = new JPanel(new BorderLayout());

        // Panneau central
        JComponent pan1 = new JPanel(new GridLayout(env.getSizeX(), env.getSizeY()));
        hexaGrid = new HexagonalGrid(env.getSizeX(), env.getSizeY(), 10, 30, 50);

        JComponent pan3 = new JPanel (new GridLayout(env.getSizeX(),env.getSizeY()));
        tab = new JPanel[env.getSizeX()][env.getSizeY()];


        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        pan1.setBorder(blackline);
        for(int i = 0; i<env.getSizeX();i++){
            for (int j = 0; j < env.getSizeY(); j++) {
                tab[i][j] = new JPanel();

                pan1.add(tab[i][j]);
            }

        }

        
        pan1.setBorder(blackline);

        // Panneau pour les boutons
        JPanel pan2 = new JPanel();
        pan2.setLayout(new BoxLayout(pan2, BoxLayout.Y_AXIS));
        // Bouton b1
        JButton button = new JButton("<html><div style='text-align: center; color: blue; '>Pause.</div></html>"); //on peut mettre du css mdrr
        JButton moins = new JButton("<html><div style='text-align: center; color: blue; '>-</div></html>");
        JButton plus = new JButton("<html><div style='text-align: center; color: blue; '>+</div></html>");
        JButton NUKE = new JButton("<html><div style='text-align: center; color: blue; '>NUKE.</div></html>");
        JButton reset = new JButton("<html><div style='text-align: center; color: blue; '>RESET.</div></html>");

        pan2.add(Box.createVerticalStrut(50));
        pan2.add(button);
        pan2.add(Box.createVerticalStrut(10));
        pan2.add(plus);
        pan2.add(moins);
        pan2.add(Box.createVerticalStrut(10));
        pan2.add(NUKE);
        pan2.add(Box.createVerticalStrut(10));
        pan2.add(reset);
        pan2.add(Box.createVerticalStrut(10));

       
        button.addActionListener(e -> {
            env.pause();
        });

        moins.addActionListener(e -> {
            if(env.getSpeed()<=10000)env.setSpeed(100);
            else System.out.println("mec arrete????");
        });

        plus.addActionListener(e -> {
             if(env.getSpeed() -100 >0) env.setSpeed(-100);
             else System.out.println("ARRETE!!!!!!!!!");
        });

        NUKE.addActionListener(e -> {
             env.NUKE();
        });

        reset.addActionListener(e -> {
             env.rndState();
        });

        pan.add(pan1, BorderLayout.CENTER);
        pan.add(pan2, BorderLayout.WEST);

        setContentPane(pan);

        // Ajout Menu
        JMenuBar jm = new JMenuBar();
        JMenu m = new JMenu("Fichier");
        JMenuItem mi = new JMenuItem("Charger");

        m.add(mi);
        jm.add(m);
        setJMenuBar(jm);
        if(env.getType()) pan.add(hexaGrid);
        

        MouseHandler mouseHandler = new MouseHandler(env, hexaGrid, 30, 50);
        pan.addMouseListener(mouseHandler);
    }


    @Override
    public void update(Observable o, Object arg) {
        if(env.getType()){
            for(int i = 0; i<env.getSizeX();i++)
            for (int j = 0; j < env.getSizeY(); j++) {
                if (env.getState(i, j)) {
                    hexaGrid.repaintHexagon(i, j, Color.BLACK);
                } else {
                    hexaGrid.repaintHexagon(i, j,Color.WHITE);
                }
            }
        }
        else{
            for(int i = 0; i<env.getSizeX();i++)
            for (int j = 0; j < env.getSizeY(); j++) {
                if (env.getState(i, j)) {

                    tab[i][j].setBackground(Color.BLACK);
                } else {
                    tab[i][j].setBackground(Color.WHITE);
                }

                
            }

        
        }
        

        


    }
}
