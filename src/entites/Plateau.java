package entites;

public class Plateau {
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
    
    public void afficherCasesSpeciales() {
        System.out.println("Cases spéciales:");
        System.out.println("3 : Si un pirate tombe sur cette case, l'adversaire perd 1 HP.");
        System.out.println("15 : Si un pirate tombe sur cette case, il gagne 1 HP.");
        System.out.println("18 : Si un pirate tombe sur cette case, il retourne à la case de départ.");
        System.out.println("21 : Si un pirate tombe sur cette case, il est bloqué pendant un tour.");
        System.out.println("29 : Si un pirate tombe sur cette case, il reculera au prochain tour.");
    }

  /*  public boolean estCaseFauxEspoir(int position) {
        return position == POSITION_CASE_SPECIALE;
    }
    */

    public void afficherPlateau(Pirate pirateCourant, Pirate pirateAdverse) {
        System.out.println("Plateau:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                int numeroCase = cases[i][j].getNumCase();
                if (numeroCase == 3 || numeroCase == 15 || numeroCase == 18 || numeroCase == 21 || numeroCase == 29) {
                    System.out.print("* ");
                } else if (pirateCourant.getPion().getPosition().getNumCase() == numeroCase) {
                    System.out.print(pirateCourant.getCouleur().getSymbole() + " ");
                } else if (pirateAdverse.getPion().getPosition().getNumCase() == numeroCase) {
                    System.out.print(pirateAdverse.getCouleur().getSymbole() + " ");
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
