
import model.Produit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduitTest {

    Produit produit ;

    @BeforeEach
    void setUp() {
        produit = new Produit(5,10);
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
    void modifierPrix(){
        assertEquals(produit.getPrix(),10);
        produit.setPrix(15);
        assertEquals(produit.getPrix(),15);
        assertThrows(IllegalArgumentException.class,()->{produit.setPrix(-5);});
    }


}