package br.com.vr.domains;

import br.com.vr.domains.commands.UnlockCardCommand;
import br.com.vr.domains.events.CreatedPurchaseCardEvent;
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
    private Pat pat;
    private ArrayList<Transactions> transactions;

    private List<Event> events = new ArrayList<>();

    public PurchaseCard(
            PurchaseCardId purchaseCardId,
            UnlockCard unlockCard,
            Balance balance,
            Cnpj cnpj,
            PurchaseCardType purchaseCardType,
            Category category,
            CashBack cashBack,
            Pat pat,
            ArrayList<Transactions> transactions
    ) {
        super(purchaseCardId);
        this.purchaseCardId = purchaseCardId;
        this.unlockCard = unlockCard;
        this.balance = balance;
        this.cnpj = cnpj;
        this.purchaseCardType = purchaseCardType;
        this.category = category;
        this.cashBack = cashBack;
        this.pat = pat;
        this.transactions = transactions;
    }

    public PurchaseCard(){

    }

    protected void apply(Event event) {
        if(event instanceof CreatedPurchaseCardEvent){
            events.add(event);
        }
        else if (event instanceof UnlockedCardEvent) {
            events.add(event);
        }
    }

    private void createdPurchaseCard(CreatedPurchaseCardEvent createdPurchaseCardEvent) {
        apply(createdPurchaseCardEvent);
    }

    public void createPurchaseCard() {
        createdPurchaseCard(
                new CreatedPurchaseCardEvent(
                    this.purchaseCardId,
                    this.unlockCard,
                    this.balance,
                    this.cnpj,
                    this.purchaseCardType,
                    this.category,
                    this.cashBack,
                    this.pat,
                    this.transactions
                )
        );
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

   @DynamoDBHashKey
   public Long getId(){
        return this.purchaseCardId.id;
   }

    @DynamoDBAttribute(attributeName = "purchaseCardId")
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

    @DynamoDBAttribute(attributeName = "pat")
    public Pat getPat() {
        return pat;
    }

    public void setPat(Pat pat) {
        this.pat = pat;
    }

    @DynamoDBAttribute(attributeName = "transactions")
    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transactions> transactions) {
        this.transactions = transactions;
    }

}
