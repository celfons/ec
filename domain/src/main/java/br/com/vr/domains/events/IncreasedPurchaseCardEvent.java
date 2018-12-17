package br.com.vr.domains.events;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamoDBDocument
public class IncreasedPurchaseCardEvent implements PurchaseCardEvents {

    private String purchaseCardId;

    private Double value;

    private String cnpj;

    private DateTime dateTransaction;

    private String transactionType;

}
