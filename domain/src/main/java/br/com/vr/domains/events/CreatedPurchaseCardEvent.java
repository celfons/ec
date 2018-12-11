package br.com.vr.domains.events;

import br.com.vr.domains.*;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamoDBDocument
public class CreatedPurchaseCardEvent implements PurchaseCardEvents {

    @DynamoDBAttribute(attributeName = "purchaseCardId")
    private String purchaseCardId;

    @DynamoDBAttribute(attributeName = "unlockCard")
    private Boolean unlockCard;

    @DynamoDBAttribute(attributeName = "balance")
    private Double balance;

    @DynamoDBAttribute(attributeName = "cnpj")
    private String cnpj;

    @DynamoDBAttribute(attributeName = "purchaseCardType")
    private String purchaseCardType;

    @DynamoDBAttribute(attributeName = "category")
    private String category;

    @DynamoDBAttribute(attributeName = "cashBack")
    private Integer cashBack;

    @DynamoDBAttribute(attributeName = "pat")
    private Boolean pat;

    @DynamoDBAttribute(attributeName = "transactions")
    private ArrayList<Transaction> transactions;

}
