package br.com.vr.domains.events;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamoDBDocument
public class UnlockedCardEvent implements PurchaseCardEvents {

    @DynamoDBAttribute(attributeName = "purchaseCardId")
    private String purchaseCardId;

    @DynamoDBAttribute(attributeName = "unlockPurchaseCard")
    private Boolean unlockCard;

}
