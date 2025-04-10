

import javax.swing.SwingUtilities;
import modele.Environnement;
import modele.Ordonnanceur;
import vue_controleur.FenetrePrincipale;

/**
 *
 * @author frederic
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable(){
			public void run(){

				Environnement e = new Environnement(50, 50, !true);
				FenetrePrincipale fenetre = new FenetrePrincipale(e);
				fenetre.setVisible(true);

				e.addObserver(fenetre);
				
				Ordonnanceur o = new Ordonnanceur(e.getSpeed(), e, e);
				o.start();

			}
		});

    }

}
