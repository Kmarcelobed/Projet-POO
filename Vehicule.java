package NewTp;

public abstract class Vehicule {

    String immatriculation, marque, modele;
    private int anneeMiseEnService , kilometrage;
    protected boolean statut;

    Vehicule (String immatriculation, String marque, String modele, int anneeMiseEnService, int kilometrage) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.anneeMiseEnService = anneeMiseEnService;
        this.kilometrage = kilometrage;
        this.statut = true;
    }

    boolean dispo() {
        return statut;
    }

    void louer() throws VehiculeException {
        if (!statut) {
            throw new VehiculeException("Le véhicule est déjà loué.");
        }
        statut = false;
    }

    int gtkilo(){
        return kilometrage;
    }

    void retourner() {
        statut = true;
    }

    abstract void calculerPrixLocation();


    public void afficher() {
        System.out.println( "\nVéhicule [Marque: " + marque +"" +
                " Modèle: " + modele +
                ", Immatriculation: " + immatriculation +
                ", Année: " + anneeMiseEnService +
                ", Kilométrage: " + kilometrage +" km"+
                ", Statut: " + (statut ? "Disponible" : "Loué") + "]");
    }
}










