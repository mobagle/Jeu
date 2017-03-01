/*
 * Armoroides - casse briques à but pédagogique
 * Copyright (C) 2016 Guillaume Huard
 * 
 * Ce programme est libre, vous pouvez le redistribuer et/ou le
 * modifier selon les termes de la Licence Publique Générale GNU publiée par la
 * Free Software Foundation (version 2 ou bien toute autre version ultérieure
 * choisie par vous).
 * 
 * Ce programme est distribué car potentiellement utile, mais SANS
 * AUCUNE GARANTIE, ni explicite ni implicite, y compris les garanties de
 * commercialisation ou d'adaptation dans un but spécifique. Reportez-vous à la
 * Licence Publique Générale GNU pour plus de détails.
 * 
 * Vous devez avoir reçu une copie de la Licence Publique Générale
 * GNU en même temps que ce programme ; si ce n'est pas le cas, écrivez à la Free
 * Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307,
 * États-Unis.
 * 
 * Contact: Guillaume.Huard@imag.fr
 *          Laboratoire LIG
 *          700 avenue centrale
 *          Domaine universitaire
 *          38401 Saint Martin d'Hères
 */
package Modele;

// Class mise à disposition du dessinateur pour redimensionner les composants
// à la taille de son dessin
public class Etendeur {

    float x, y, l, h;
    float factX, factY;

    public void fixeEchelle(float fx, float fy) {
        factX = fx;
        factY = fy;
    }

    // Ici on triche un peu :
    // Comme on sait que les dimensions du composant ne varient pas
    // durant toute la vie de l'étendeur, on stocke directement le
    // résultat à l'échelle.
    public void fixeComposant(ComposantGraphique c) {
        x = c.posX() * factX;
        y = c.posY() * factY;
        l = c.l() * factX;
        h = c.h() * factY;
    }

    public float posX() {
        return x;
    }

    public float posY() {
        return y;
    }

    public float l() {
        return l;
    }

    public float h() {
        return h;
    }

    public float factX() {
        return factX;
    }

    public float factY() {
        return factY;
    }
}
