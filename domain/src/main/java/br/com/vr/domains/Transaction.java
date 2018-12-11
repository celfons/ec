package br.com.vr.domains;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import org.joda.time.DateTime;

@DynamoDBDocument
@Getter
@AllArgsConstructor
@Builder
public class Transaction {

    private Double value;
    private String cnpj;
    private DateTime dateTransaction;
    private String transactionType;

}
