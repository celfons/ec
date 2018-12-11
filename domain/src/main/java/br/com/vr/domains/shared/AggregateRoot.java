package br.com.vr.domains.shared;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot<String> {

    protected String id;

    private List<Event> events = new ArrayList<>();

    protected void apply(Event event) {
        events.add(event);
    }

    protected AggregateRoot() {
    }

    protected AggregateRoot(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Iterable<Event> getEvents() {
        return events;
    }

}