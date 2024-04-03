package entites;

public interface Affichage {
    void afficherAvancement(Pirate pirate);
    void afficherResultatDe(Integer de1, Integer de2);
    void afficherDepassement(Pirate pirate1, Pirate pirate2);
    void afficherEffetEspoir(Pirate pirate);
    void afficherEffetHopital(Pirate pirate);
    void afficherBloquagePion(Pirate pirate);
    void afficherPirateGagnant(Pirate pirateGagnant);
    void afficherRetourDepart(Pirate pirate);
    void afficherEchangePions(Pirate pirate1, Pirate pirate2);
    void afficherCoupDeFeu(Pirate pirate1, Pirate pirate2);
}
