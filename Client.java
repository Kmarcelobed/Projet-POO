package NewTp;

import java.util.ArrayList;

class Client {
    String nom, prenom;
    private int numeroPermisConduire, contact;
    ArrayList<Vehicule> location;

    public Client(String nom, String prenom, int numeroPermisConduire, int contact) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroPermisConduire = numeroPermisConduire;
        this.contact = contact;
        location= new ArrayList<>();
    }

    void addLocation (Vehicule m) {location.add(m);}
    void removeLocation (Vehicule m){location.remove(m);}

    void afficher (){
        System.out.println("Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numeroPermisConduire=" + numeroPermisConduire +
                ", contact=" + contact +'}');
        for (Vehicule p : location){
            p.afficher();
        }
    }
}

