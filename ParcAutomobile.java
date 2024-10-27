package NewTp;

import java.util.ArrayList;

public class ParcAutomobile {
    ArrayList<Vehicule> VehiculeDuParc;
    ArrayList<Client> ClientDuParc;
    ParcAutomobile(){
        ClientDuParc = new ArrayList<>();
        VehiculeDuParc = new ArrayList<>();
    }

    void addVehucile(Vehicule m){
        VehiculeDuParc.add(m);
    }
    void removeVehicule(Vehicule m){
        VehiculeDuParc.remove(m);
    }

    void addClient (Client m ){
        ClientDuParc.add(m);
    }

    void removeClient (Client m ){
        ClientDuParc.remove(m);
    }

    ArrayList<Vehicule> VehiculesDispo() {
        ArrayList<Vehicule> dispo = new ArrayList<>();
        for (Vehicule v : VehiculeDuParc) {
            if (v.dispo()) {
                dispo.add(v);
            }
        }
        return dispo;
    }

    ArrayList<Vehicule> VehiculesLoué() {
        ArrayList<Vehicule> loué = new ArrayList<>();
        for (Vehicule v : VehiculeDuParc) {
            if (!v.dispo()) {
                loué.add(v);
            }
        }
        return loué;
    }

    Vehicule rechercherVehicule(String imma) {
        for (Vehicule v : VehiculeDuParc) {
            if (v.immatriculation.equals(imma)) {
                return v;
            }
        }
        return null;
    }

    Client rechercherClient(String nom) {
        for (Client client : ClientDuParc) {
            if (client.nom.equals(nom)) {
                return client;
            }
        }
        return null;
    }

    void louerVehicule(Client m, Vehicule p) throws VehiculeException {
        if (!p.statut) throw new  VehiculeException("Le vehicule est déja loué");
        m.addLocation(p);
        p.statut=false;
    }
    void retournerVehicule(Client m, Vehicule p){
        if(!p.statut) System.out.println("Le vehicule ne peut etre retourner ");
        else {
            m.removeLocation(p);
            p.statut=true;
        }
    }

}
