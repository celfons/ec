package br.com.vr.domains.events;

import br.com.vr.domains.*;
import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@Builder
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
