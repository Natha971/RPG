import java.util.List;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {

        int menu1 = Combat.menu1();
        int menu2 = 0;
        while (menu1 != 4 && menu2 != 4) {

            if(menu1 == 2){ // Mode multijoueur
                // Ramène au menu
                menu2 = Combat.menu2();
                if(menu2 != 3){
                    // Choix du personnage pour le joueur 1
                    Heros joueur1 = Combat.askPersonnage(1);

                    // Choix du personnage pour le joueur 2
                    Heros joueur2 = Combat.askPersonnage(2);

                    // Choix de l'arme pour le joueur 1
                    joueur1.setArme(Combat.askArme(1));

                    // Choix de l'arme pour le joueur 2
                    joueur2.setArme(Combat.askArme(2));

                    // Choix du sort pour le joueur 1
                    joueur1.setSort(Combat.askSort(1));

                    // Choix du sort pour le joueur 2
                    joueur2.setSort(Combat.askSort(2));

                    Combat.modeDeJeu2(menu2, joueur1, joueur2);
                }
            }
            else if(menu1 == 1){
                System.out.println("Combattez face à un monstre");
                menu2 = Combat.menu2();
                if(menu2 != 3){
                    // Choix du personnage pour le joueur 1
                    Heros joueur1 = Combat.askPersonnage(1);

                    // Choix de l'arme pour le joueur 1
                    joueur1.setArme(Combat.askArme(1));

                    // Choix du sort pour le joueur 1
                    joueur1.setSort(Combat.askSort(1));

                    Monstre monstre = Combat.monstreAléa();

                    Combat.modeDeJeu1(menu2, joueur1, monstre);
                }
            }
            else if(menu1 == 3){
                Aide.aide();
            }
            menu1 = Combat.menu1();
        }
    }
}
