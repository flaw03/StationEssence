package model.calendrier;

import model.transaction.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendrierTransactionTest {

    private CalendrierTransaction calendrierTransaction;
    private Transaction transaction1;
    private Transaction transaction2;
    private Transaction transaction3;
    private Transaction transaction4;
    private Transaction transaction5;
    @BeforeEach
    void setUp() {
        calendrierTransaction = new CalendrierTransaction();
        Transaction.setNbrTransation(0);
        Calendrier.setDate(1,1);
        transaction1 = new Transaction(10, 2, "Pomme", "Assane");
        transaction2 = new Transaction(25,  1, "Poire", "Theo");
        transaction3 = new Transaction(25, 3, "Poire", "Assane");
        transaction4 = new Transaction(1, 30, "Eau", "Axel");
        transaction5 = new Transaction(3, 27, "Pomme", "Axel");
    }

    @Test
    void jourSuivant() {

        Calendrier.jourSuivant();
        assertEquals(calendrierTransaction.getDate(),"2 Janvier");
        Calendrier.jourSuivant();
        assertEquals(calendrierTransaction.getDate(),"3 Janvier");

    }

    @Test
    void ajouterTransaction() {
        calendrierTransaction.ajouterTransaction(transaction1);
        assertEquals(calendrierTransaction.getInfoTransaction(1,1).getNbrTransacation(),1);
        calendrierTransaction.ajouterTransaction(transaction2);
        assertEquals(calendrierTransaction.getInfoTransaction(1,1).getNbrTransacation(),2);
        calendrierTransaction.ajouterTransaction(transaction3);
        assertEquals(calendrierTransaction.getInfoTransaction(1,1).getNbrTransacation(),3);

    }

    @Test
    void getTransactionNum() {
        calendrierTransaction.ajouterTransaction(transaction1);
        calendrierTransaction.ajouterTransaction(transaction2);
        calendrierTransaction.ajouterTransaction(transaction3);
        assertEquals(calendrierTransaction.getTransactionNum(1, 1, 1), transaction1);
        assertEquals(calendrierTransaction.getTransactionNum(1, 1, 2), transaction2);
        assertEquals(calendrierTransaction.getTransactionNum(1, 1, 3), transaction3);
        assertNull(calendrierTransaction.getTransactionNum(1,1,5));
        assertNull(calendrierTransaction.getTransactionNum(1,1,0));
        assertNull(calendrierTransaction.getTransactionNum(1,1,4));
    }

    @Test
    void getInfoTransactionClient() {
        calendrierTransaction.ajouterTransaction(transaction1);
        calendrierTransaction.ajouterTransaction(transaction2);
        calendrierTransaction.ajouterTransaction(transaction3);
        assertEquals(calendrierTransaction.getInfoTransactionClient(1,1,"Assane").getNbrTransacation(),2);
        assertEquals(calendrierTransaction.getInfoTransactionClient(1,1,"Theo").getNbrTransacation(),1);
        assertEquals(calendrierTransaction.getInfoTransactionClient(1,1,"Axelle").getNbrTransacation(),0);
    }

    @Test
    void getInfoTransaction() {
        calendrierTransaction.ajouterTransaction(transaction1);
        calendrierTransaction.ajouterTransaction(transaction2);
        calendrierTransaction.ajouterTransaction(transaction3);
        assertEquals(calendrierTransaction.getInfoTransaction(1,1).getNbrTransacation(),3);

        Calendrier.jourSuivant();

        calendrierTransaction.ajouterTransaction(transaction4);
        calendrierTransaction.ajouterTransaction(transaction5);
        assertEquals(calendrierTransaction.getInfoTransaction(2,1).getNbrTransacation(),2);
    }
}