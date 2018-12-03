package br.com.vr.domains;

import org.joda.time.DateTime;

public class Transactions {

    private Double value;
    private Cnpj cnpj;
    private DateTime dateTransaction;
    private TransactionType transactionType;

    public Transactions(Double value, Cnpj cnpj, DateTime dateTransaction, TransactionType transactionType) {
        this.value = value;
        this.cnpj = cnpj;
        this.dateTransaction = dateTransaction;
        this.transactionType = transactionType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
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
