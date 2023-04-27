package model.calendrier;

import model.transaction.Transaction;

public class MoisTransaction {

    private String nom;
    private InfoTransaction[] infoTransactions;

    public MoisTransaction(String nom, int nbrJour) {
        this.nom = nom;
        infoTransactions = new InfoTransaction[nbrJour];
        for (int i = 0; i < nbrJour; i++) {
            infoTransactions[i] = new InfoTransaction();
        }
    }

    public void ajouterTransaction(int jour, Transaction transaction) throws ArrayIndexOutOfBoundsException {
        if (jour >= infoTransactions.length) {
            throw new ArrayIndexOutOfBoundsException("jour hors du tableau");
        }
        infoTransactions[jour].ajouterTransation(transaction);
    }

    public InfoTransaction getInfoTransaction(int jour) throws ArrayIndexOutOfBoundsException{
        if (jour >= infoTransactions.length){
            throw new ArrayIndexOutOfBoundsException("jour hors du tableau");
        }
        return infoTransactions[jour];
    }


    public Transaction getTransactionNum(int jour, int numeroTransaction) {
        return infoTransactions[jour].getTransactionNum(numeroTransaction);
    }

    public InfoTransaction getInfoTransactionClient(int jour, String nomClient) {
        return infoTransactions[jour].getInfoTransactionClient(nomClient);
    }
}
