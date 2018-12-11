package br.com.vr.domains;

import br.com.vr.domains.commands.UnlockCardCommand;
import br.com.vr.domains.events.CreatedPurchaseCardEvent;
import br.com.vr.domains.events.PurchaseCardEvents;
import br.com.vr.domains.events.UnlockedCardEvent;
import br.com.vr.domains.services.KenanService;
import br.com.vr.domains.shared.AggregateRoot;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@DynamoDBTable(tableName = "PurchaseCard")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseCard extends AggregateRoot {

    @Id
    @Setter
    @DynamoDBHashKey(attributeName = "purchaseCardId")
    @JsonProperty(value = "purchaseCardId")
    @DynamoDBAutoGeneratedKey
    @NotNull
    private String purchaseCardId;

    @Setter
    @DynamoDBAttribute(attributeName = "unlockCard")
    private Boolean unlockCard;

    @Setter
    @DynamoDBAttribute(attributeName = "balance")
    private Double balance;

    @Setter
    @DynamoDBAttribute(attributeName = "cnpj")
    private String cnpj;

    @Setter
    @DynamoDBAttribute(attributeName = "purchaseCardType")
    private String purchaseCardType;

    @Setter
    @DynamoDBAttribute(attributeName = "category")
    private String category;

    @Setter
    @DynamoDBAttribute(attributeName = "cashBack")
    private Integer cashBack;

    @Setter
    @DynamoDBAttribute(attributeName = "pat")
    private Boolean pat;

    @Setter
    @DynamoDBAttribute(attributeName = "transactions")
    private ArrayList<Transaction> transactions;

    @DynamoDBAttribute(attributeName = "events")
    @Setter
    @Builder.Default
    private List<PurchaseCardEvents> events = new ArrayList<>();

    protected void apply(PurchaseCardEvents event) {
        events.add(event);
    }

    private void createdPurchaseCard(CreatedPurchaseCardEvent createdPurchaseCardEvent) {
        apply(createdPurchaseCardEvent);
    }

    public void createPurchaseCard() {
        createdPurchaseCard(
                CreatedPurchaseCardEvent.builder()
                .purchaseCardId(this.purchaseCardId)
                .unlockCard(this.unlockCard)
                .balance(this.balance)
                .cnpj(this.cnpj)
                .purchaseCardType(this.purchaseCardType)
                .category(this.category)
                .cashBack(this.cashBack)
                .pat(this.pat)
                .transactions(this.transactions)
                .build()
        );
    }

    private void unlockedCard(UnlockedCardEvent unlockedCardEvent){
        apply(unlockedCardEvent);
    }

    public void unlockCard(UnlockCardCommand unlockCardCommand, KenanService kenanService){
        this.unlockCard = unlockCardCommand.getUnlockValue();
        kenanService.unlockCard(unlockCardCommand.getUnlockValue());
        unlockedCard(
                UnlockedCardEvent
                        .builder()
                        .purchaseCardId(unlockCardCommand.getPurchaseCardId())
                        .unlockCard(unlockCardCommand.getUnlockValue()).build()
        );
    }

}
