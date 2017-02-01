/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ensembles;

/**
 *
 * @author bochatom
 */
public abstract class FabriqueEnsembleGenerique {

    public abstract <T> Ensemble<T> nouvelle();
    private static FabriqueEnsembleListeGenerique petit;
    private static FabriqueEnsembleTableauGenerique grand;

    public static void init() {
        petit = new FabriqueEnsembleListeGenerique();
        grand = new FabriqueEnsembleTableauGenerique();
    }

    public FabriqueEnsembleListeGenerique getPetit() {
        return petit;
    }

    public FabriqueEnsembleTableauGenerique getGrand() {
        return grand;
    }
}
