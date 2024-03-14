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
        
        if (nouvellePosition == 30) {
            System.out.println("Vous êtes arrivé à la case 30, félicitations ! Vous avez gagné !");
            estTermine = true;
            return;
        }
        
        if (nouvellePosition < 1 || nouvellePosition > 30) {
            System.out.println("La position doit être comprise entre 1 et 30 inclusivement. Vous devez rejouer !");
            return;
        }
        
        if (plateau.estCaseFauxEspoir(nouvellePosition) && !joueurCourant.aReculePourProchainTour()) {
            joueurCourant.setReculePourProchainTour(true);
            return;
        }
        
        Joueur joueurAdverse = getJoueurAdverse(joueurCourant); // Obtenez le joueur adverse
        
        if (joueurCourant.doitReculerPourProchainTour()) {
            nouvellePosition -= totalDe;
            joueurCourant.setReculePourProchainTour(false); // Réinitialiser le recul pour le prochain tour
        }
        
        if (nouvellePosition > joueurAdverse.getPion().getPosition().getNumCase()) {
            joueurAdverse.recevoirDegats(1); // Le joueur dépassé perd 1 point de vie
            System.out.println(joueurCourant.getNom() + " a dépassé " + joueurAdverse.getNom() + ". " +
                    joueurAdverse.getNom() + " perd 1 point de vie.");
        }
       
        Case nouvelleCase = plateau.getCase(nouvellePosition);
        Pion nouveauPion = new Pion(nouvelleCase, pion.getCouleur());
        joueurCourant.setPion(nouveauPion);
        
        
        if (plateau.estCaseFauxEspoir(nouvellePosition)) {
            joueurCourant.setReculePourProchainTour(true);
            return; 
        }
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
    
    public Joueur getJoueurAdverse(Joueur joueurCourant) {
        // Si le joueur courant est le premier joueur dans le tableau
        if (joueurCourant == joueurs[0]) {
            return joueurs[1];
        } else {
            return joueurs[0];
        }
    }

}
