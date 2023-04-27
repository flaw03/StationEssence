package model.calendrier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendrierStockTest {

    private CalendrierStock  calendrierStock;

    @BeforeEach
    void init(){
        calendrierStock = new CalendrierStock(2,27,"Chaise");
    }

    @Test
    void changer_de_jour(){
        calendrierStock.jourSuivant(10,3,0,4,4,2);
        assertEquals(calendrierStock.getDate(),"28 Février");
        calendrierStock.jourSuivant(10,3,0,4,4,2);
        assertEquals(calendrierStock.getDate(),"1 Mars");
        calendrierStock = new CalendrierStock(12,30,"Chaise");
        assertEquals(calendrierStock.getDate(),"30 Décembre");
        calendrierStock.jourSuivant(10,3,0,4,4,2);
        assertEquals(calendrierStock.getDate(),"31 Décembre");
        calendrierStock.jourSuivant(10,3,0,4,4,2);
        assertEquals(calendrierStock.getDate(),"1 Janvier");
    }
    @Test
    void init_info_stock() {
        calendrierStock.jourSuivant(15,20,5,0,15,225);
        assertEquals(calendrierStock.obtenirInfoStock(2,27).toString(), """
                Stock de Chaise du 27 Février
                prix : 15
                stock initial : 20
                stock final : 5
                réapprovisionnement : 0
                nombre de vente : 15
                prix Total : 225
                """);
        calendrierStock.jourSuivant(1,3,2,0,4,4);
        assertEquals(calendrierStock.obtenirInfoStock(2,28).toString(), """
                Stock de Chaise du 28 Février
                prix : 4
                stock initial : 3
                stock final : 2
                réapprovisionnement : 0
                nombre de vente : 1
                prix Total : 4
                """);
        calendrierStock.jourSuivant(0,3,13,10,10,0);
        assertEquals(calendrierStock.obtenirInfoStock(3,1).toString(), """
                Stock de Chaise du 1 Mars
                prix : 10
                stock initial : 3
                stock final : 13
                réapprovisionnement : 10
                nombre de vente : 0
                prix Total : 0
                """);


        assertThrows(ArrayIndexOutOfBoundsException.class,
                ()->{
                    calendrierStock.obtenirInfoStock(2,29);});
        assertThrows(IllegalArgumentException.class,
                ()->{
                    calendrierStock.obtenirInfoStock(3,2);});assertThrows(IllegalArgumentException.class,
                ()->{
                    calendrierStock.obtenirInfoStock(3,4);});

    }
}