package br.com.vr.domains.shared;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot<ID> {

    private ID id;

    private List<Event> events = new ArrayList<>();

    protected void apply(Event event) {
        events.add(event);
    }

    AggregateRoot() {
    }

    protected AggregateRoot(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public Iterable<Event> getEvents() {
        return events;
    }

}