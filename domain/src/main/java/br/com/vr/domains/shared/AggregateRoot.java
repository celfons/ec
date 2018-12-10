package br.com.vr.domains.shared;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot<Long> {

    protected Long id;

    private List<Event> events = new ArrayList<>();

    protected void apply(Event event) {
        events.add(event);
    }

    protected AggregateRoot() {
    }

    protected AggregateRoot(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Iterable<Event> getEvents() {
        return events;
    }

}