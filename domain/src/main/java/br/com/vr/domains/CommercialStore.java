package br.com.vr.domains;

import br.com.vr.domains.commands.UnlockCardCommand;
import br.com.vr.domains.events.UnlockedCardEvent;
import br.com.vr.domains.shared.AggregateRoot;
import br.com.vr.domains.shared.Event;
import java.util.ArrayList;
import java.util.List;

public class CommercialStore extends AggregateRoot {

    private CommercialStoreId commercialStoreId;
    private Card card;

    private List<Event> events = new ArrayList<>();

    protected CommercialStore(CommercialStoreId commercialStoreId, Card card) {
        super(commercialStoreId);
        this.card = card;
    }

    @Override
    public CommercialStoreId getId() {
        return commercialStoreId;
    }

    protected void apply(Event event) {
        if (event instanceof UnlockedCardEvent) {
            events.add(event);
        }
    }

    private void unlockedCard(UnlockedCardEvent unlockedCardEvent){
        apply(unlockedCardEvent);
    }

    public void unlockCard(UnlockCardCommand unlockCardCommand){
        this.card.setUnlocked(true);
        unlockedCard(
                new UnlockedCardEvent(
                        unlockCardCommand.getCommercialStoreId()
                )
        );
    }

}
