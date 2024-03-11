package entites;

public class Plateau {
	    private Integer taille;
	    private Case[][] cases;
	    
	    public Plateau() {
	        this.cases = new Case[6][5];
	        int numeroCase = 1;
	        for (int i = 0; i < 6; i++) {
	        	for (int j = 0; j < 5; j++) {
	        		this.cases[i][j] = new Case(numeroCase++);
	        	}
	        }
	    }
	    
	    public int getNbCases() {
	        return cases.length;
	    }
	    
	    public void afficherPlateau(Joueur joueur1, Joueur joueur2) {
	        System.out.println("Plateau:");
	        for (int i = 0; i < 6; i++) {
	            for (int j = 0; j < 5; j++) {
	                int numeroCase = cases[i][j].getNumCase();
	                if (joueur1.getPion().getPosition().getNumCase() == numeroCase) {
	                    System.out.print("R "); // Marquer la position du pion du joueur 1
	                } else if (joueur2.getPion().getPosition().getNumCase() == numeroCase) {
	                    System.out.print("B "); // Marquer la position du pion du joueur 2
	                } else {
	                    System.out.print("* "); // Marquer les cases vides
	                }
	            }
	            System.out.println(); // Nouvelle ligne après chaque ligne de cases
	        }
	    }

	    public void deplacerPion(Pion pionADeplacer, Integer deplacement) {
	        // Logique pour déplacer le pion sur le plateau
	    }

	   public Case getCase(int position) {
		   if (position < 1 || position > 30) {
		        throw new IllegalArgumentException("La position doit être comprise entre 1 et 30 inclusivement.");
		    }
		    int ligne = (position - 1) / 5; // Calcul de l'indice de ligne
		    int colonne = (position - 1) % 5; // Calcul de l'indice de colonne
		    return this.cases[ligne][colonne];
	    }	
}
