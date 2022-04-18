public class Objet {
    private String potion;
    private int nombre;
    private int prix;

    public Objet(String potion, int nombre, int prix) {
        this.potion = potion;
        this.nombre = nombre;
        this.prix = prix;
    }

    public String getPotion() {
        return potion;
    }

    public void setPotion(String potion) {
        this.potion = potion;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
}
