package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduitTest {

    Produit produit ;

    @BeforeEach
    void setUp() {
        produit = new Produit(5);
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
}