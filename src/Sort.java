public class Sort {
    //Créez une nouvelle classe Sort qui ont comme variables un nom, un cout en mana et une puissance.
    // Vous pouvez tous les donner à votre Héros directement et il ne sera alors limité que par son mana,
    // soit ajouter la propriété niveauMinimum à la classe Sort pour que le Héros ne puisse utiliser que
    // les sorts les plus puissants qu’à partir d’un certain niveau. Vous pouvez aussi faire en sorte que les
    // Monstres donnent à la fin des combats une chance au Héros de découvrir un nouveau sort.
    //En combat, le héros aura donc le choix entre attaquer, fuir et tous les sorts dont il dispose.

    private String nom;
    private int coutMana;
    private int puissance;

    public Sort(String nom, int coutMana, int puissance) {
        this.nom = nom;
        this.coutMana = coutMana;
        this.puissance = puissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCoutMana() {
        return coutMana;
    }

    public void setCoutMana(int coutMana) {
        this.coutMana = coutMana;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }
}
