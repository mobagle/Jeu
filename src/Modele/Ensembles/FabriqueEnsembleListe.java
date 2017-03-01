package Modele.Ensembles;

class FabriqueEnsembleListe extends FabriqueEnsemble {
    @Override
    public <T> Ensemble<T> nouveau() {
        return new EnsembleListe<>();
    }
    
}