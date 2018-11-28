package br.com.vr.domains;

import br.com.vr.domains.shared.AggregateRoot;
import br.com.vr.domains.shared.Event;

import java.util.ArrayList;
import java.util.List;

public class CommercialStore extends AggregateRoot {

    private List<Event> events = new ArrayList<>();

    protected CommercialStore(Object T) {
        super(T);
    }

    protected void register(Event event) {
        events.add(event);
    }

}
