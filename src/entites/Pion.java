package entites;

public class Pion {
    private Case position;
    private Couleur couleur;

    public Pion(Case position, Couleur couleur) {
        this.position = position;
        this.couleur = couleur;
    }

    public Case getPosition() {
        return this.position;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }

    public void setPosition(int position) {
    	    this.position = new Case (position);
    }

}
