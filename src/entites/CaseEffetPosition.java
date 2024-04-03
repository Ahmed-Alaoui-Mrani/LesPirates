package entites;

public class CaseEffetPosition extends Case{
	public void retourCaseDepart(Pirate pirate) {
		if (pirate.getPion().getPosition().getNumCase() == 18) {
	        // Retourner à la case de départ (case 1)
	        pirate.getPion().setPosition(1);
	        System.out.println(pirate.getNom() + " est retourné à la case de départ !");
	    }    }

    public void echangerPositions(Case pirate1, Case pirate2) {
    	
    }

    public void bloquerPion(Pirate pirate) {
    	if (pirate.getPion().getPosition().getNumCase() == 21) {
            // Bloquer le pion du pirate pour un tour
            pirate.setBloquePourProchainTour(true);
            System.out.println(pirate.getNom() + " est bloqué sur la case 21 pour un tour !");
        }
    }

    public void espererLiberation(Pirate pirate) {
    	
    }
    public static void FauxEspoir(Pirate pirate) {
        // Vérifiez si le pirate est sur la case 29
        if (pirate.getPion().getPosition().getNumCase() == 29) {
            System.out.println("Le pirate est tombé dans la case 29 et reculera au prochain tour !");
            pirate.setReculePourProchainTour(true);
        }
    }
}
