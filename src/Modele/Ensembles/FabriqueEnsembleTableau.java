package Modele.Ensembles;

class FabriqueEnsembleTableau extends FabriqueEnsemble {
    @Override
    public <T> Ensemble<T> nouveau() {
        return new EnsembleTableau<>();
    }
    
}