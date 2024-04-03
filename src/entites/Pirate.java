package entites;

public class Pirate {
    private String nom;
    private Integer pointsDeVie;
    private Couleur couleur;
    private Pion pion;
    private boolean reculePourProchainTour;
    private boolean bloquePourProchainTour;

    public Pirate(Pion pion, String nom, Integer pointsDeVie, Couleur couleur) {
        this.pion = pion;
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.couleur = couleur; // Assurez-vous d'initialiser la couleur correctement
    }


    public void recevoirDegats(Integer degats) {
        this.pointsDeVie -= degats;
    }

    public Case getPosition() {
        return this.pion.getPosition();
    }

    public Integer getPointsDeVie() {
        return this.pointsDeVie;
    }

    public void setPosition(int position) {
        this.pion.setPosition(position);
    }

    public String getNom() {
        return this.nom;
    }

    public Pion getPion() {
        return this.pion;
    }
    
    public void setPion(Pion pion) {
        this.pion = pion;
    }
    
    public void setReculePourProchainTour(boolean recule) {
        this.reculePourProchainTour = recule;
    }
    
    public boolean doitReculerPourProchainTour() {
        return this.reculePourProchainTour;
    }
    
    public boolean aReculePourProchainTour() {
        return this.reculePourProchainTour;
    }
    public Couleur getCouleur() {
        return this.couleur;
    }
    
    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }
    
    public boolean estDepasse(int position) {
        return this.getPion().getPosition().getNumCase() < position;
    }
    
    public void setBloquePourProchainTour(boolean bloque) {
        this.bloquePourProchainTour = bloque;
    }

    public boolean estBloquePourProchainTour() {
        return this.bloquePourProchainTour;
    }


}
