package br.com.vr.domains;

import br.com.vr.domains.commands.UnlockCardCommand;
import br.com.vr.domains.events.UnlockedCardEvent;
import br.com.vr.domains.services.KenanService;
import br.com.vr.domains.shared.AggregateRoot;
import br.com.vr.domains.shared.Event;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.List;

@DynamoDBTable(tableName = "PurchaseCard")
public class PurchaseCard extends AggregateRoot {

    @Id
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

    @DynamoDBHashKey(attributeName = "purchaseCardId")
    public PurchaseCardId getPurchaseCardId() {
        return purchaseCardId;
    }

    public void setPurchaseCardId(PurchaseCardId purchaseCardId) {
        this.purchaseCardId = purchaseCardId;
    }

    @DynamoDBAttribute(attributeName = "unlockCard")
    public UnlockCard getUnlockCard() {
        return unlockCard;
    }

    public void setUnlockCard(UnlockCard unlockCard) {
        this.unlockCard = unlockCard;
    }

    @DynamoDBAttribute(attributeName = "balance")
    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    @DynamoDBAttribute(attributeName = "cnpj")
    public Cnpj getCnpj() {
        return cnpj;
    }

    public void setCnpj(Cnpj cnpj) {
        this.cnpj = cnpj;
    }

    @DynamoDBAttribute(attributeName = "purchaseCardType")
    public PurchaseCardType getPurchaseCardType() {
        return purchaseCardType;
    }

    public void setPurchaseCardType(PurchaseCardType purchaseCardType) {
        this.purchaseCardType = purchaseCardType;
    }

    @DynamoDBAttribute(attributeName = "category")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @DynamoDBAttribute(attributeName = "cashBack")
    public CashBack getCashBack() {
        return cashBack;
    }

    public void setCashBack(CashBack cashBack) {
        this.cashBack = cashBack;
    }

    @DynamoDBAttribute(attributeName = "securityDigit")
    public SecurityDigit getSecurityDigit() {
        return securityDigit;
    }

    public void setSecurityDigit(SecurityDigit securityDigit) {
        this.securityDigit = securityDigit;
    }

    @DynamoDBAttribute(attributeName = "pat")
    public Pat getPat() {
        return pat;
    }

    public void setPat(Pat pat) {
        this.pat = pat;
    }

    @DynamoDBAttribute(attributeName = "expiration")
    public Expiration getExpiration() {
        return expiration;
    }

    public void setExpiration(Expiration expiration) {
        this.expiration = expiration;
    }

    @DynamoDBAttribute(attributeName = "transactions")
    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

}
