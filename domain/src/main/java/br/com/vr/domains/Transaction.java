package br.com.vr.domains;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
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

    @DynamoDBAttribute(attributeName = "value")
    private Double value;

    @DynamoDBAttribute(attributeName = "cnpj")
    private String cnpj;

    @DynamoDBAttribute(attributeName = "dateTransaction")
    private DateTime dateTransaction;

    @DynamoDBAttribute(attributeName = "transactionType")
    private String transactionType;

}
