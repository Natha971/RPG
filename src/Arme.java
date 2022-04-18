public class Arme {
    private String nom;
    private int coup;

    public Arme(String nom, int coup) {
        this.nom = nom;
        this.coup = coup;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCoup() {
        return coup;
    }

    public void setCoup(int coup) {
        this.coup = coup;
    }
}
