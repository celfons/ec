package br.com.vr.domains.events;

import br.com.vr.domains.Transaction;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamoDBDocument
public class CreatedPurchaseCardEvent implements PurchaseCardEvents {

    private String purchaseCardId;

    private Boolean unlockCard;

    private Double balance;

    private String cnpj;

    private String purchaseCardType;

    private String category;

    private Integer cashBack;

    private Boolean pat;

    private ArrayList<Transaction> transactions;

}
