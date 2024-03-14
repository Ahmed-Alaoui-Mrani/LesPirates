package entites;

public class Plateau implements Affichage {
	    private Integer taille;
	    private Case[][] cases;
	    private final int POSITION_CASE_SPECIALE = 29;
	    
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
	    
	    public boolean estCaseFauxEspoir(int position) {
	        return position == POSITION_CASE_SPECIALE;
	    }
	    
	    @Override
	    public void afficherPlateau(Joueur joueur1, Joueur joueur2) {
	        System.out.println("Plateau:");
	        for (int i = 0; i < 6; i++) {
	            for (int j = 0; j < 5; j++) {
	                int numeroCase = cases[i][j].getNumCase();
	                if (numeroCase == POSITION_CASE_SPECIALE) {
	                    System.out.print("* "); 
	                } 
	                else if (joueur1.getPion().getPosition().getNumCase() == numeroCase) {
	                    System.out.print("R "); 
	                } else if (joueur2.getPion().getPosition().getNumCase() == numeroCase) {
	                    System.out.print("B "); 
	                } else {
	                    System.out.print("- "); 
	                }
	            }
	            System.out.println(); 
	        }
	    }

	    public void deplacerPion(Pion pionADeplacer, Integer deplacement) {
	        
	    }

	    public Case getCase(int position) {
	        if (position < 1 || position > 30) {
	            throw new IllegalArgumentException("La position doit être comprise entre 1 et 30 inclusivement.");
	        }
	        // Calcul des indices de ligne et de colonne
	        int ligne = (position - 1) / 5; 
	        int colonne = (position - 1) % 5; 
	        // Retour de la case correspondante
	        return this.cases[ligne][colonne];
	    }	
}
