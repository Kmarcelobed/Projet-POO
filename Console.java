package NewTp;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) throws VehiculeException {
        Scanner sc = new Scanner(System.in);
        ParcAutomobile Parc = new ParcAutomobile();
        int choix=0;

        while (choix!=7){
            System.out.println("\n1. Ajouter un véhicule\n2. Ajouter un nouveau client \n3. Louer un véhicule à un client\n4. Retourner un véhicule\n5. Lister les véhicules disponibles\n6. Lister les véhicules loués\n7. Quitter");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix){
                case 1:
                    System.out.print("1. Ajouter une Voiture  \n2. Ajouter un camion \nChoix :");
                    int mp = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Entrez l'immatriculation: ");
                    String immatriculation = sc.nextLine();
                    System.out.print("Entrez la marque: ");
                    String marque = sc.nextLine();
                    System.out.print("Entrez le modèle: ");
                    String modele = sc.nextLine();
                    System.out.print("Entrez l'année de mise en service: ");
                    int anneeService = sc.nextInt();
                    System.out.print("Entrez le Kilométrage: ");
                    int kilometrage = sc.nextInt();

                    if (mp == 1) {
                        System.out.print("Entrez le nombre de places: ");
                        int places = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Entrez le nom du carburant: ");
                        String carburant = sc.nextLine();
                        Vehicule m = new Voiture(immatriculation, marque, modele, anneeService, kilometrage, places, carburant);
                        Parc.addVehucile(m);
                    } else {
                        System.out.print("Entrez la capacité: ");
                        int capacite = sc.nextInt();
                        System.out.print("Entrez le nombre d'essieux: ");
                        int essieux = sc.nextInt();
                        Vehicule m = new Camion(immatriculation, marque, modele, anneeService, kilometrage, capacite, essieux);
                        Parc.addVehucile(m);
                    }

                    System.out.println("Véhicule ajouté avec succès !");

                    break;
                case 2 :
                    System.out.print("Entrez le nom: ");
                    String nom = sc.nextLine();
                    System.out.print("Entrez le prénom: ");
                    String prenom = sc.nextLine();
                    System.out.print("Entrez le numéro de permis: ");
                    int permis = sc.nextInt();
                    System.out.print("Entrez son contact: ");
                    int telephone = sc.nextInt();
                    Client p = new Client(nom, prenom, permis, telephone);
                    Parc.addClient(p);
                    System.out.println("Client ajouté avec succès !");
                    break;
                case 3:
                    System.out.print("Entrez l'immatriculation du véhicule à louer: ");
                    immatriculation = sc.nextLine();
                    Vehicule vehicule = Parc.rechercherVehicule(immatriculation);
                    if (vehicule == null || !vehicule.dispo()) {
                        System.out.println("Ce véhicule n'est pas disponible.");
                        return;
                    }

                    System.out.print("Nom de  du client: ");
                    nom = sc.nextLine();
                    Client client = Parc.rechercherClient(nom);
                    if (client == null) {
                        System.out.println("Client non trouvé.");
                        return;
                    }

                    try {
                        vehicule.louer();
                        client.addLocation(vehicule);
                        System.out.println("Véhicule loué avec succès !");
                    } catch (VehiculeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Entrez l'immatriculation du véhicule à retourner: ");
                     immatriculation = sc.nextLine();
                    Vehicule m = Parc.rechercherVehicule(immatriculation);
                    if (m == null || m.dispo()) {
                        System.out.println("Le véhicule n'a pas été trouvé ou est déjà disponible.");
                        return;
                    }

                    System.out.print("Entrez le nom du client: ");
                     nom = sc.nextLine();
                    Client cliente = Parc.rechercherClient(nom);
                    if (cliente == null) {
                        System.out.println("Ce client n'existe pas'");
                        return;
                    }

                    m.retourner();
                    cliente.removeLocation(m);
                    System.out.println("Le véhicule a été retourné avec succès !");
                    break;
                case 5:
                    listerVehicules(Parc.VehiculesDispo(),"Disponibles");
                    break;
                case 6:
                    listerVehicules(Parc.VehiculesLoué(),"Loués");
                    break;
                case 7:
                    System.out.println("\nMerci, au revoir.\nSee you soon");
                    break;

                default:
                    System.out.println("\nERREUR, veuillez entrer un nombre entre 1 et 6 ");

            }
        }

    }

    private static void listerVehicules(ArrayList<Vehicule> vehicules, String statut) {
        System.out.println("\nVéhicules " + statut + " :");
        for (Vehicule v : vehicules) {
            v.afficher();
        }
    }
}

