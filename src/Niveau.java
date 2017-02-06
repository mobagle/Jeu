
import Ensembles.*;

public class Niveau {
    int coucheEnCours;
    Ensemble<ComposantGraphique> ensemble;   
    
    Niveau(String n, int nbCouches, FabriqueEnsemble f) {
        System.out.println("Niveau : "+n+", composé de "+nbCouches+" couches");
        coucheEnCours = -1;
        ensemble = f.nouveau();
    }
    
    void ajouteComposant(int couche, ComposantGraphique composant) {
        if (couche != coucheEnCours) {
            System.out.println("Je remplis la couche "+couche+"...");
            coucheEnCours = couche;
        }
        ensemble.ajoute(composant);
    }
    
    void fixerDimensionsMax(int i, int j) {
        System.out.println("Le niveau a une largeur de "+i+" et une hauteur de "+j);
    }
    
    void fixeCouleurs(String [] t, int nb) {
        System.out.println("Les couleurs utilisées dans ce niveau sont :");
        for (int i=0; i<nb; i++) {
            System.out.println(i+" - "+t[i]);
        }
    }
    
    void nouvelleBalle() {
        System.out.println("Terminé, voici les composants que j'ai stocké :");
        System.out.println("- dans l'ensemble implémenté dans un ...");
        System.out.println(ensemble.toString());
        System.out.println("Prêt à jouer, en attente de balle !");
    }
}
