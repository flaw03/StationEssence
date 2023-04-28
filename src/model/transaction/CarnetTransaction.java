package model.transaction;

public class CarnetTransaction {
    private Transaction[] transactions;
    private int nbrTransacation;

    public CarnetTransaction() {
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

    public CarnetTransaction getInfoTransactionClient(String nomClient) {
        CarnetTransaction carnetTransactionClient = new CarnetTransaction();
        for (int i = 0; i<nbrTransacation ; i++){
            if (transactions[i].getNonClient().equals(nomClient)) {
                carnetTransactionClient.ajouterTransation(transactions[i]);
            }
        }
        return carnetTransactionClient;
    }
}
