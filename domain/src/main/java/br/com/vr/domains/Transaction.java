package br.com.vr.domains;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import org.joda.time.DateTime;

@DynamoDBDocument
public class Transaction {

    private Balance value;
    private Cnpj cnpj;
    private DateTime dateTransaction;
    private TransactionType transactionType;

    public Transaction(Balance value, Cnpj cnpj, DateTime dateTransaction, TransactionType transactionType) {
        this.value = value;
        this.cnpj = cnpj;
        this.dateTransaction = dateTransaction;
        this.transactionType = transactionType;
    }

    public Balance getValue() {
        return value;
    }

    public void setValue(Balance value) {
        this.value = value;
    }

    public Cnpj getCnpj() {
        return cnpj;
    }

    public void setCnpj(Cnpj cnpj) {
        this.cnpj = cnpj;
    }

    public DateTime getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(DateTime dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
