
import Ensembles.*;
import java.io.*;
import java.util.*;

public class ClassePrincipale {

    public static void main(String[] args) {
        FabriqueEnsemble.init(Configuration.proprietes());
        //ChargeurNiveaux.init(FabriqueEnsemble.petit()); //on choisi l'implémentation de stockage des composants ici
        while (ChargeurNiveaux.prochainNiveau() != null) {
        }

    }
}
