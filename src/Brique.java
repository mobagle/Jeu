
class Brique implements ComposantGraphique {
    int resistance;
    int couleur;
    float x, y;
    
    Brique(int r, int c) {
        this(r, c, 0, 0);
    }
    
    Brique(int r, int c, float x, float y) {
        resistance = r;
        couleur = c;
        this.x = x;
        this.y = y;
    }
    
    public ComposantGraphique copieVers(float x, float y) {
        return new Brique(resistance, couleur, x, y);
    }    

    public String toString() {
        return "Brique en ("+x+", "+y+"), resistance "+resistance+", couleur "+couleur;
    }
}
