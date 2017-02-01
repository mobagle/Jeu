package Ensembles;


import java.util.NoSuchElementException;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class EnsembleListe<T> implements Ensemble<T> {
    
    T element;
    EnsembleListe suivant;
    
    EnsembleListe() {
        element = null;
        suivant = null;
    }

    @Override
    public void ajoute(T c) {      
        EnsembleListe e = new EnsembleListe();
        e.element = this.element;
        e.suivant = this.suivant;
        this.element = c;
        this.suivant = e;
    }

    @Override
    public void supprime(T c) {
        EnsembleListe dernier = null;
        EnsembleListe e = this;
        while(e.suivant != null && e.element != c) {
            dernier = e;
            e  = e.suivant;
        }
        if(e.element == c) {
            dernier.suivant = e.suivant;
        }
        else if(e.suivant == null) {
            throw new NoSuchElementException();
        }
    }
    
    
}
