package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagasinTest {


    private Magasin magasin;
    private Lubrifiant lubrifiant1;
    private Lubrifiant lubrifiant2;
    private Lubrifiant lubrifiant3;
    private Lubrifiant lubrifiant4;

    @BeforeEach
    void setUp() {
        magasin = new Magasin(3);
        lubrifiant1 = new Lubrifiant("Lubrifiant 1" ,5,10);
        lubrifiant2 = new Lubrifiant("Lubrifiant 2" ,4,0);
        lubrifiant3 = new Lubrifiant("Lubrifiant 3" ,0,54);
        lubrifiant4 = new Lubrifiant("Lubrifiant 4" ,40,4);
        magasin.ajouterLubrifiant(lubrifiant1);
        magasin.ajouterLubrifiant(lubrifiant2);
        magasin.ajouterLubrifiant(lubrifiant3);

    }


    @Test
    void ajouter_lubrifiant(){
        assertThrows(ArrayIndexOutOfBoundsException.class,
                ()->{
                    magasin.ajouterLubrifiant(lubrifiant4);});
    }


    @Test
    void produit_disponible(){
        assertEquals(magasin.produitDisponible("Lubrifiant 1"),0);
        assertEquals(magasin.produitDisponible("Lubrifiant 4"),-1);
    }

}