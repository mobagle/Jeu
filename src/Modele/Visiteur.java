package Modele;

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
public abstract class Visiteur {

    // Par défaut la méthode de visite d'un composant
    // provoque une erreur pour un visiteur. A redéfinir donc
    // si un composant doit être visité.
    // Les autres méthodes se ramènent à la visite d'un composant
    // Les visiteurs peuvent donc aussi ne spécialiser que le traitement
    // de types d'objets spécifiques en ne redéfinissant que les méthodes
    // associées à ceux qu'ils sont censés visiter
    public boolean visite(Composant c) {
        return false;
    }

    public boolean visite(Brique b) {
        return visite((Composant) b);
    }

    public boolean visite(Bonus b) {
        return visite((Composant) b);
    }
    
    public boolean visite(Niveau n) {
        return visite((Composant) n);
    }
    
    public boolean visite(Balle b) {
        return visite((Composant) b);
    }

    public boolean visite(Raquette r) {
        return visite((Composant) r);
    }
}
