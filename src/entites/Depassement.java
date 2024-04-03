package entites;

public class Depassement { 
    
	    private String anciennePositionJoueur1;
	    private String anciennePositionJoueur2;
	    
	    public boolean appliquerEffetDepassement(Pirate pirate1, Pirate pirate2) {
	        int positionPirate1 = pirate1.getPion().getPosition().getNumCase();
	        int positionPirate2 = pirate2.getPion().getPosition().getNumCase();

	        // Vérifier si le pirate 1 dépasse le pirate 2
	        if (positionPirate1 > positionPirate2 && positionPirate1 - positionPirate2 > 1) {
	            pirate2.recevoirDegats(1); // Le pirate 2 perd 1 point de vie
	            return true; // Indique qu'un dépassement a eu lieu
	        }

	        // Vérifier si le pirate 2 dépasse le pirate 1
	        if (positionPirate2 > positionPirate1 && positionPirate2 - positionPirate1 > 1) {
	            pirate1.recevoirDegats(1); // Le pirate 1 perd 1 point de vie
	            return true; // Indique qu'un dépassement a eu lieu
	        }

	        // Aucun dépassement n'a eu lieu
	        return false;
	    }


	    public String getAnciennePositionJoueur1() {
	        return this.anciennePositionJoueur1;
	    }

	    public String getAnciennePositionJoueur2() {
	        return this.anciennePositionJoueur2;
	    }

	    public void setAnciennePositionJoueur1(String anciennePositionJoueur1) {
	        this.anciennePositionJoueur1 = anciennePositionJoueur1;
	    }

	    public void setAnciennePositionJoueur2(String anciennePositionJoueur2) {
	        this.anciennePositionJoueur2 = anciennePositionJoueur2;
	    }

	}

