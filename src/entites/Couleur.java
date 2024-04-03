package entites;

public enum Couleur {
    ROUGE("R"),
    BLEU("B");

    private final String symbole;

    private Couleur(String symbole) {
        this.symbole = symbole;
    }

    public String getSymbole() {
        return this.symbole;
    }
}
