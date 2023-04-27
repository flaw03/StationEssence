package model.produit;

import model.produit.Produit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduitTest {

    Produit produit ;

    @BeforeEach
    void setUp() {
        produit = new Produit("produit Miracle",5,10);
    }

    @Test
    void bonStock(){
        assertEquals(produit.getStock(),5);
        produit.gainStock(5);
        assertEquals(produit.getStock(),10);
        produit.perteStock(7);
        assertEquals(produit.getStock(),3);
        assertThrows(IllegalArgumentException.class,()->{produit.perteStock(5);});
    }


    @Test
    void calculer_Prix(){
        assertEquals(produit.calculerPrix(4),40);
        produit.setPrix(5);
        assertEquals(produit.calculerPrix(4),40);
        produit.changerDate();
        assertEquals(produit.calculerPrix(5),25);
    }


    @Test
    void perteStock(){
        assertThrows(IllegalArgumentException.class,
                ()->{
                    produit.perteStock(10);});

        produit.perteStock(3);
        assertEquals(produit.getStock(),2);
        produit.perteStock(2);
        assertEquals(produit.getStock(),0);


    }

    @Test
    void changer_prix_test(){


        assertThrows(IllegalArgumentException.class,()->{produit.setPrix(-5);});

        produit.setPrix(20);
        assertEquals(produit.getPrix(),10);
        produit.changerDate();
        assertEquals(produit.calendrierStock.obtenirInfoStock(1, 1).getPrix(), 10);
        assertEquals(produit.getPrix(),20);

        produit.changerDate();
        assertEquals(produit.calendrierStock.obtenirInfoStock(2,1).getPrix(),20);

        produit.setPrix(0);
        produit.changerDate();
        assertEquals(produit.getPrix(),0);
        assertEquals(produit.calendrierStock.obtenirInfoStock(3,1).getPrix(),20);
    }

    @Test
    void changer_Date_Test(){
        produit.perteStock(5);
        produit.gainStock(10);
        produit.changerDate();
        assertEquals(produit.calendrierStock.obtenirInfoStock(1,1).toString(), """
                Stock de produit Miracle du 1 Janvier
                prix : 10
                stock initial : 5
                stock final : 10
                réapprovisionnement : 10
                nombre de vente : 5
                prix Total : 50
                """);
        produit.changerDate();
        assertEquals(produit.calendrierStock.obtenirInfoStock(2,1).toString(), """
                Stock de produit Miracle du 2 Janvier
                prix : 10
                stock initial : 10
                stock final : 10
                réapprovisionnement : 0
                nombre de vente : 0
                prix Total : 0
                """);

    }
}