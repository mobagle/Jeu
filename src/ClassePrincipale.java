
import Ensembles.*;
import java.io.*;
import java.util.*;

public class ClassePrincipale {

    public static void main(String[] args) {
        try {
            Properties p = new Properties();
            p.load(ClassLoader.getSystemClassLoader().getResourceAsStream("defaut.cfg"));
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(System.getProperty("user.home") + "/.armoroides");
            
            ChargeurNiveaux.init(new FabriqueEnsembleTableauGenerique()); //on choisi l'implémentation de stockage des composants ici
            while (ChargeurNiveaux.prochainNiveau() != null) {
            }

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }
}
