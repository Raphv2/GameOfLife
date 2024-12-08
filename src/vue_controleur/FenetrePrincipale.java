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
import modele.Case;
import modele.Environnement;
import modele.HexagonalGrid;
import modele.RuleType;

/**
 *
 * @author frederic
 */
public class FenetrePrincipale extends JFrame implements Observer {

    private HexagonalGrid hexaGrid;
    private JPanel[][] tab;
    public Environnement env;
    JLabel label;

    public Color colorLife(Case c) {
        int life = c.getLife();
        int maxLife = c.getLife2();
        Color color;
        color = Color.GREEN;
        if (life < (2 * maxLife) / 3 && life > maxLife / 3) {
            color = Color.ORANGE;
        } else if (life <= maxLife / 3 && life > 0) {
            color = Color.RED;
        } 

        return color;
    }
        

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
        JButton button = createButton("Pause");
        JButton moins = createButton("-");
        JButton plus = createButton("+");
        JButton NUKE = createButton("NUKE");
        JButton reset = createButton("RESET");

        pan2.add(Box.createVerticalStrut(40));
        pan2.add(button);
        pan2.add(Box.createVerticalStrut(5));
        pan2.add(plus);
        pan2.add(moins);
        pan2.add(Box.createVerticalStrut(5));
        pan2.add(NUKE);
        pan2.add(Box.createVerticalStrut(5));
        pan2.add(reset);
        pan2.add(Box.createVerticalStrut(5));


        for (RuleType ruleType : RuleType.values()) {
            JButton ruleButton = createButton(ruleType.getRulesName());
            int index = ruleType.ordinal(); 
            ruleButton.addActionListener(e -> env.setRules(index)); 
            pan2.add(Box.createVerticalStrut(5));
            pan2.add(ruleButton); 
        }
       
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
        pan.add(pan2, BorderLayout.EAST);

        setContentPane(pan);

        // Ajout Menu
        JMenuBar jm = new JMenuBar();
        JMenu m = new JMenu("Fichier");
        JMenuItem mi = new JMenuItem("Charger");

        m.add(mi);
        jm.add(m);
        setJMenuBar(jm);
        if(env.getType()) pan.add(hexaGrid);
        

        MouseHandler mouseHandler = new MouseHandler(env, hexaGrid);
        pan.addMouseListener(mouseHandler);
    }

    private JButton createButton(String text) {
        JButton button = new JButton("<html><div style='text-align: center; color: blue; '>" + text + "</div></html>");
        return button;
    }


    @Override
    public void update(Observable o, Object arg) {
        if(env.getType()){
            for(int i = 0; i<env.getSizeX();i++)
            for (int j = 0; j < env.getSizeY(); j++) {
                if (env.getState(i, j)) {
                    hexaGrid.repaintHexagon(i, j, colorLife(env.getCase(i,j)));
                } else {
                    hexaGrid.repaintHexagon(i, j,Color.WHITE);
                }
            }
        }
        else{
            for(int i = 0; i<env.getSizeX();i++)
            for (int j = 0; j < env.getSizeY(); j++) {
                if (env.getState(i, j)) {

                    tab[i][j].setBackground(colorLife(env.getCase(i,j)));
                } else {
                    tab[i][j].setBackground(Color.WHITE);
                }

                
            }

        
        }
    }

 
}
