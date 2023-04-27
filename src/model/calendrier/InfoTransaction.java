package model.calendrier;

import model.transaction.Transaction;

public class InfoTransaction {
    private Transaction[] transactions;
    private int nbrTransacation;

    public InfoTransaction() {
        transactions = new Transaction[20];
        nbrTransacation = 0;
    }


    public void ajouterTransation (Transaction transaction){
        if (nbrTransacation >= transactions.length){
            return;
        }
        transactions[nbrTransacation] = transaction;
        nbrTransacation ++;
    }

    public int getNbrTransacation() {
        return nbrTransacation;
    }


    public Transaction getTransactionNum(int numeroTransaction) {
        for (int i = 0 ; i < nbrTransacation ; i++){
            if (transactions[i].getNumTransaction() == numeroTransaction) {
                return transactions[i];
            }
        }
        return null;
    }

    public InfoTransaction getInfoTransactionClient(String nomClient) {
        InfoTransaction infoTransactionClient = new InfoTransaction();
        for (int i = 0; i<nbrTransacation ; i++){
            if (transactions[i].getNonClient().equals(nomClient)) {
                infoTransactionClient.ajouterTransation(transactions[i]);
            }
        }
        return infoTransactionClient;
    }
}
