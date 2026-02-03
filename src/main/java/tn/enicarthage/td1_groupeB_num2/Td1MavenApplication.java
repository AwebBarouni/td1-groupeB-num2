package tn.enicarthage.td1_groupeB_num2;


// org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class Td1MavenApplication {

    public static void main(String[] args) {
        //SpringApplication.run(Td1MavenApplication.class, args);
        Produit p1 = new Produit();
        p1.setCode("P01");
        p1.setLibelle("Laptop");
        p1.setPrix(2500);

        Produit p2 = new Produit();
        p2.setCode("P02");
        p2.setLibelle("Souris");
        p2.setPrix(80);
        Magasin magasin = new Magasin();
        magasin.ajouterProduit(p1);
        magasin.ajouterProduit(p2);

        System.out.println("=================================");
        System.out.println("        PRODUITS DU MAGASIN      ");
        System.out.println("=================================");
        System.out.println(magasin.getProduits());

        System.out.println("\n------------- COMPARAISON -------------");
        Produit plusCher = magasin.comparerSelonPrix(p1, p2);
        System.out.println("Produit le plus cher : " + plusCher);

        System.out.println("\n------------- PRIX TOTAL ---------------");
        double total = magasin.calculerPrixDeuxProduits(p1, p2);
        System.out.println("Prix total des deux produits : " + total + " DT");

        System.out.println("\n------------- SUPPRESSION --------------");
        magasin.supprimerProduit(p2);

        System.out.println("Liste des produits après suppression :");
        System.out.println(magasin.getProduits());

        System.out.println("=================================");

    }
}
