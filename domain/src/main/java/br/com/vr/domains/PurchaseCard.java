package br.com.vr.domains;

import br.com.vr.domains.commands.UnlockCardCommand;
import br.com.vr.domains.events.UnlockedCardEvent;
import br.com.vr.domains.services.KenanService;
import br.com.vr.domains.shared.AggregateRoot;
import br.com.vr.domains.shared.Event;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.ArrayList;
import java.util.List;

@DynamoDBTable(tableName = "PurchaseCard")
public class PurchaseCard extends AggregateRoot {

    private PurchaseCardId purchaseCardId;
    private UnlockCard unlockCard;
    private Balance balance;
    private Cnpj cnpj;
    private PurchaseCardType purchaseCardType;
    private Category category;
    private CashBack cashBack;
    private SecurityDigit securityDigit;
    private Pat pat;
    private Expiration expiration;
    private List<Transactions> transactions;

    private List<Event> events = new ArrayList<>();

    protected PurchaseCard(
            PurchaseCardId purchaseCardId,
            UnlockCard unlockCard,
            Balance balance,
            Cnpj cnpj,
            PurchaseCardType purchaseCardType,
            Category category,
            CashBack cashBack,
            SecurityDigit securityDigit,
            Pat pat,
            Expiration expiration,
            List<Transactions> transactions
    ) {
        super(purchaseCardId);
        this.unlockCard = unlockCard;
        this.balance = balance;
        this.cnpj = cnpj;
        this.purchaseCardType = purchaseCardType;
        this.category = category;
        this.cashBack = cashBack;
        this.securityDigit = securityDigit;
        this.pat = pat;
        this.expiration = expiration;
        this.transactions = transactions;
    }

    @Override
    public PurchaseCardId getId() {
        return purchaseCardId;
    }

    protected void apply(Event event) {
        if (event instanceof UnlockedCardEvent) {
            events.add(event);
        }
    }

    private void unlockedCard(UnlockedCardEvent unlockedCardEvent){
        apply(unlockedCardEvent);
    }

    public void unlockCard(UnlockCardCommand unlockCardCommand, KenanService kenanService){
        this.unlockCard.setValue(unlockCardCommand.getUnlockValue().getValue());
        kenanService.unlockCard(unlockCardCommand.getUnlockValue().getValue());
        unlockedCard(
                new UnlockedCardEvent(
                        unlockCardCommand.getPurchaseCardId(),
                        unlockCardCommand.getUnlockValue()
                )
        );
    }

}
