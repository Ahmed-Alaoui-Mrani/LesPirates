package entites;

public class CaseEffetHP extends Case {
    private Jeu jeu;

    public CaseEffetHP(Jeu jeu) {
        this.jeu = jeu;
    }
    
	 public void hopital(Pirate pirate) {
	        if (pirate.getPion().getPosition().getNumCase() == 15) {
	            // Augmentez les points de vie du pirate de 1
	            pirate.setPointsDeVie(pirate.getPointsDeVie() + 1);
	            System.out.println("Le pirate a gagné 1 point de vie en atterrissant sur la case 15 !");
	        }
	    }

	 public void coupDeFeu(Pirate pirate) {
	        Pirate pirateAdverse = jeu.getPirateAdverse(pirate);
	        if (pirateAdverse != null) {
	            pirateAdverse.recevoirDegats(1); // Le pirate adverse perd 1 point de vie
	            System.out.println(pirateAdverse.getNom() + " a été touché par un coup de feu et perd 1 HP !");
	        } else {
	            System.out.println("Aucun pirate adverse n'a été trouvé.");
	        }
	    }
}



