package Modele.Ensembles;
import java.util.NoSuchElementException;
import java.util.Properties;

abstract public class FabriqueEnsemble {

    static FabriqueEnsemble grand;
    static FabriqueEnsemble petit;

    static FabriqueEnsemble creerFabriqueEnsemble(String type) {
        switch (type) {
            case "Tableau":
                return new FabriqueEnsembleTableau();
            case "Liste":
                return new FabriqueEnsembleListe();
            default:
                throw new NoSuchElementException("Ensemble de type " + type);
        }
    }

    public static void init(Properties p) {
        grand = creerFabriqueEnsemble(p.getProperty("GrandEnsemble"));
        petit = creerFabriqueEnsemble(p.getProperty("PetitEnsemble"));
        System.err.println("Grand ensemble : " + grand + ", Petit Ensemble : " + petit);
    }

    public static FabriqueEnsemble grand() {
        return grand;
        //return new FabriqueEnsembleTableau();
    }

    public static FabriqueEnsemble petit() {
        return petit;
        //return new FabriqueEnsembleListe();
    }

    public abstract <T> Ensemble<T> nouveau();
}
