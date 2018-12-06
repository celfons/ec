package br.com.vr.domains.shared;

import javax.validation.constraints.NotNull;
import java.util.Random;

public abstract class RandomUUID implements ValueObject<RandomUUID> {

    @NotNull
    public final Long id;

    public RandomUUID() {
        this.id =  Math.abs(new Random().nextLong());
    }

    public RandomUUID(Long id) {
        this.id = id;
    }

    @Override
    public boolean sameValueAs(RandomUUID other) {
        return other != null && this.id.equals(other.id);
    }

}