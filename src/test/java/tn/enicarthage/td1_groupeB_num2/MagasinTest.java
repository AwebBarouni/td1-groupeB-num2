package tn.enicarthage.td1_groupeB_num2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MagasinTest {

    private Magasin magasin;
    private Produit p1;
    private Produit p2;

    @BeforeEach
    public void setUp() {
        magasin = new Magasin();

        p1 = new Produit();
        p1.setCode("P01");
        p1.setLibelle("Laptop");
        p1.setPrix(2500);

        p2 = new Produit();
        p2.setCode("P02");
        p2.setLibelle("Souris");
        p2.setPrix(80);
    }

    // ─── Ajout ───────────────────────────────────────────────

    @Test
    public void testAjouterUnProduit() {
        magasin.ajouterProduit(p1);
        assertEquals(1, magasin.getProduits().size());
    }

    @Test
    public void testAjouterPlusieurs() {
        magasin.ajouterProduit(p1);
        magasin.ajouterProduit(p2);
        assertEquals(2, magasin.getProduits().size());
    }

    // ─── Suppression ─────────────────────────────────────────

    @Test
    public void testSupprimerProduit() {
        magasin.ajouterProduit(p1);
        magasin.ajouterProduit(p2);
        magasin.supprimerProduit(p2);
        assertEquals(1, magasin.getProduits().size());
    }

    @Test
    public void testSupprimerProduitVerifieContenu() {
        magasin.ajouterProduit(p1);
        magasin.ajouterProduit(p2);
        magasin.supprimerProduit(p2);
        assertFalse(magasin.getProduits().contains(p2));
    }

    // ─── Comparaison selon prix ───────────────────────────────

    @Test
    public void testComparerSelonPrix_p1PlusCher() {
        Produit plusCher = magasin.comparerSelonPrix(p1, p2);
        assertEquals(p1, plusCher);
    }

    @Test
    public void testComparerSelonPrix_p2PlusCher() {
        Produit plusCher = magasin.comparerSelonPrix(p2, p1);
        assertEquals(p1, plusCher); // p1 is still more expensive
    }

    @Test
    public void testComparerSelonPrix_prixEgaux() {
        Produit pA = new Produit();
        pA.setCode("PA");
        pA.setLibelle("ProduitA");
        pA.setPrix(100);

        Produit pB = new Produit();
        pB.setCode("PB");
        pB.setLibelle("ProduitB");
        pB.setPrix(100);

        Produit result = magasin.comparerSelonPrix(pA, pB);
        assertNotNull(result);
    }

    // ─── Calcul prix deux produits ────────────────────────────

    @Test
    public void testCalculerPrixDeuxProduits() {
        double total = magasin.calculerPrixDeuxProduits(p1, p2);
        assertEquals(2580.0, total, 0.01);
    }

    @Test
    public void testCalculerPrixDeuxProduits_avecZero() {
        Produit gratuit = new Produit();
        gratuit.setCode("P00");
        gratuit.setLibelle("Gratuit");
        gratuit.setPrix(0);

        double total = magasin.calculerPrixDeuxProduits(p1, gratuit);
        assertEquals(2500.0, total, 0.01);
    }

    // ─── Liste produits ───────────────────────────────────────

    @Test
    public void testGetProduitsVide() {
        assertTrue(magasin.getProduits().isEmpty());
    }

    @Test
    public void testGetProduitsContientProduitAjoute() {
        magasin.ajouterProduit(p1);
        assertTrue(magasin.getProduits().contains(p1));
    }
}

