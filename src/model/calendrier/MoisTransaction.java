package model.calendrier;

import model.transaction.CarnetTransaction;
import model.transaction.Transaction;

public class MoisTransaction {

    private final String nom;
    private final CarnetTransaction[] carnetTransactions;

    public MoisTransaction(String nom, int nbrJour) {
        this.nom = nom;
        carnetTransactions = new CarnetTransaction[nbrJour];
        for (int i = 0; i < nbrJour; i++) {
            carnetTransactions[i] = new CarnetTransaction();
        }
    }

    public void ajouterTransaction(int jour, Transaction transaction) throws ArrayIndexOutOfBoundsException {
        if (jour >= carnetTransactions.length) {
            throw new ArrayIndexOutOfBoundsException("jour hors du tableau");
        }
        carnetTransactions[jour].ajouterTransation(transaction);
    }

    public CarnetTransaction getInfoTransaction(int jour) throws ArrayIndexOutOfBoundsException{
        if (jour >= carnetTransactions.length){
            throw new ArrayIndexOutOfBoundsException("jour hors du tableau");
        }
        return carnetTransactions[jour];
    }


    public Transaction getTransactionNum(int jour, int numeroTransaction) {
        return carnetTransactions[jour].getTransactionNum(numeroTransaction);
    }

    public CarnetTransaction getInfoTransactionClient(int jour, String nomClient) {
        return carnetTransactions[jour].getInfoTransactionClient(nomClient);
    }
}
