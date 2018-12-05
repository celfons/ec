package br.com.vr.domains.shared;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public abstract class RandomUUID implements ValueObject<RandomUUID> {

    @NotNull
    public final Long id;

    public RandomUUID() {
        this.id = Long.valueOf(UUID.randomUUID().toString());
    }

    public RandomUUID(Long id) {
        this.id = id;
    }

    @Override
    public boolean sameValueAs(RandomUUID other) {
        return other != null && this.id.equals(other.id);
    }

    protected abstract String getPrefix();
}