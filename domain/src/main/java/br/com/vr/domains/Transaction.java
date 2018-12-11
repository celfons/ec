package br.com.vr.domains;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@DynamoDBDocument
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    private Double value;
    private String cnpj;
    private DateTime dateTransaction;
    private String transactionType;

}
