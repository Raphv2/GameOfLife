

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

				Environnement e = new Environnement(100, 100);
				FenetrePrincipale fenetre = new FenetrePrincipale(e);
				fenetre.setVisible(true);

				e.addObserver(fenetre);
        
				Ordonnanceur o = new Ordonnanceur(100, e);
				o.start();

			}
		});

    }

}
