package entites;

public class Jeu {
	private Joueur[] joueurs;
    private Plateau plateau;
    private boolean estTermine;
    private int joueurCourantIndex;

    public Jeu(Joueur joueur1, Joueur joueur2) {
        this.joueurs = new Joueur[]{joueur1, joueur2};
        this.plateau = new Plateau();
        this.estTermine = false;
        this.joueurCourantIndex = 0; // Commence avec le premier joueur
    }
    
    public boolean estTermine() {
        for (Joueur joueur : joueurs) {
            if (joueur.getPointsDeVie() <= 0) {
                estTermine = true;
                break;
            }
        }
        return estTermine;
    }


    public void tourJoueur(int totalDe) {
        Joueur joueurCourant = getJoueurCourant();
        Pion pion = joueurCourant.getPion();
        int positionActuelle = pion.getPosition().getNumCase();
        int nouvellePosition = positionActuelle + totalDe;
        Case nouvelleCase = plateau.getCase(nouvellePosition);
        Pion nouveauPion = new Pion(nouvelleCase, pion.getCouleur());
        joueurCourant.setPion(nouveauPion);
    }
    
    public void changerJoueur() {
        joueurCourantIndex = (joueurCourantIndex + 1) % joueurs.length;
    }
    
    public Joueur getJoueurAdverse() {
        return joueurs[(joueurCourantIndex + 1) % joueurs.length];
    }
    
    public Joueur getJoueurCourant() {
        return joueurs[joueurCourantIndex];
    }
    
    public void lancerPartie() {
       
    }

    public boolean estGagnant(Joueur joueur) {
        
        return false;
    }

}
