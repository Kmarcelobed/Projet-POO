package NewTp;

import java.util.Random;

public class Voiture extends Vehicule implements Louable {
    private int nbrDePlace;
    private String carburant;
    Voiture (String immatriculation, String marque, String modele, int anneeMiseEnService,
             int kilometrage, int nbrDePlace, String carburant){
        super(immatriculation, marque, modele, anneeMiseEnService, kilometrage);
        this.carburant=carburant;
        this.nbrDePlace=nbrDePlace;
    }

    void calculerPrixLocation() {

    }

    @Override
    public void loue() throws VehiculeException {
            if (!this.statut) throw new  VehiculeException("La voiture est déja loué");
            this.statut =false;
    }

    @Override
    public void retourner()  {
        if (!this.statut) this.statut = true;
    }

    @Override
    public void afficher () {
        super.afficher();
        System.out.println( "Voiture{" +
                "Nombre de Place=" + nbrDePlace +
                ", carburant='" + carburant + '\'' +
                "}");
    }
}