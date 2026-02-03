package tn.enicarthage.td1_groupeB_num2;

import java.util.ArrayList;
import lombok.Data;

@Data
public class Magasin {
    private ArrayList<Produit> produits;
    public Magasin() {
        produits = new ArrayList<Produit>();
    }
    public Produit comparerSelonPrix(Produit p1, Produit p2) {
        if (p1.getPrix() > p2.getPrix()) {
            return p1;
        } else {
            return p2;
        }
    }

    public void ajouterProduit(Produit p) {
        produits.add(p);
    }

    public void supprimerProduit(Produit p) {
        produits.remove(p);
    }

    public double calculerPrixDeuxProduits(Produit p1, Produit p2) {
        return p1.getPrix() + p2.getPrix();
    }
}