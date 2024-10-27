package NewTp;

import java.util.Random;

public class  Camion extends Vehicule implements Louable{
    int somme;
    private int capacite, nbrEssieux;

    Camion (String immatriculation, String marque, String modele,
            int anneeMiseEnService, int kilometrage, int capacite, int nbrEssieux){
        super(immatriculation, marque, modele, anneeMiseEnService, kilometrage);
        this.capacite=capacite;
        this.nbrEssieux=nbrEssieux;
        this.somme=0;
        statut=true;
    }

    void calculerPrixLocation() {
        somme = capacite*5000+ gtkilo()*1000;
        System.out.println("Le camion coute "+somme+"$");
    }

    public void loue() throws VehiculeException {
        if (!statut) throw new  VehiculeException("La voiture est déja loué");
        statut =false;
    }

    public void retourner() {
        statut=true;
    }

    @Override
    public void afficher () {
         super.afficher();
         System.out.println("Camion{" +
                "Capacite=" + capacite +"Kg"+
                "Nombre d'essieux=" + nbrEssieux +
                 "}\nLa voiture coute "+this.somme+"$");
    }
}
