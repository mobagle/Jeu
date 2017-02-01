package Ensembles;


import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bochatom
 */
public class EnsembleTableau<T> implements Ensemble<T> {

    private T[] tab;
    int size;
    int content_size;

    EnsembleTableau() {
        this.size = 1;
        this.content_size = 0;
        this.tab = (T[]) new Object[size];
    }

    public void modif_taille() {
        size = size * 2;
        T[] newtab = (T[]) new Object[size];
        for (int i = 0; i < content_size; i++) {
            newtab[i] = this.tab[i];
        }
        this.tab = (T[]) new Object[size];
        this.tab = newtab;

    }

    @Override
    public void ajoute(T c) {
        if (content_size == size) {
            modif_taille();
        }
        tab[content_size] = c;
        content_size++;
    }

    @Override
    public void supprime(T c) {
        int i;
        for (i = 0; i < content_size && tab[i] != c; i++);
        if (i < content_size) {
            tab[i] = tab[content_size - 1];
            content_size--;

        }
        else {
            throw new NoSuchElementException();
        }
    }

}
