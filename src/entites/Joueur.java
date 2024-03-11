package entites;

public class Joueur {
    private String nom;
    private Integer pointsDeVie;
    private Couleur couleur;
    private Pion pion;

    public Joueur(Pion pion, String nom, Integer pointsDeVie) {
        this.pion = pion;
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
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

}
