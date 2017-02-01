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
public class FabriqueEnsembleListeGenerique extends FabriqueEnsembleGenerique {

    @Override
    public <T> Ensemble<T> nouvelle() {
// type de liste inféré grâce au type de retour
        return new EnsembleListe<>();
    }
}
