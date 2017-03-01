/*
 * Armoroides - casse briques à but pédagogique
 * Copyright (C) 2016 Guillaume Huard

 * Ce programme est libre, vous pouvez le redistribuer et/ou le
 * modifier selon les termes de la Licence Publique Générale GNU publiée par la
 * Free Software Foundation (version 2 ou bien toute autre version ultérieure
 * choisie par vous).

 * Ce programme est distribué car potentiellement utile, mais SANS
 * AUCUNE GARANTIE, ni explicite ni implicite, y compris les garanties de
 * commercialisation ou d'adaptation dans un but spécifique. Reportez-vous à la
 * Licence Publique Générale GNU pour plus de détails.

 * Vous devez avoir reçu une copie de la Licence Publique Générale
 * GNU en même temps que ce programme ; si ce n'est pas le cas, écrivez à la Free
 * Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307,
 * États-Unis.

 * Contact: Guillaume.Huard@imag.fr
 *          Laboratoire LIG
 *          700 avenue centrale
 *          Domaine universitaire
 *          38401 Saint Martin d'Hères
 */
package Modele;

public class Raquette extends ComposantGraphique {
    float largeur, hauteur;
    static final float LARGEUR_DEFAUT = 4;
    static final float HAUTEUR_DEFAUT = 0.5f;
    
    Raquette(float x, float y) {
        super(x, y);
        largeur = LARGEUR_DEFAUT;
        hauteur = HAUTEUR_DEFAUT;
    }

    @Override
    public float l() {
        return largeur;
    }

    @Override
    public float h() {
        return hauteur;
    }

    @Override
    boolean accepte(Visiteur v) {
        return v.visite(this);
    }

    @Override
    ComposantGraphique copieVers(float x, float y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}