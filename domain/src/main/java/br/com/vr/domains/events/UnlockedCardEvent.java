package br.com.vr.domains.events;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamoDBDocument
public class UnlockedCardEvent implements PurchaseCardEvents {

    private String purchaseCardId;

    private Boolean unlockCard;

}
