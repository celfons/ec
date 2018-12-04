package br.com.vr.domains;

import java.util.Date;

public class Expiration {

    private Date value;

    public Expiration(Date value) {
        this.value = value;
    }

    public Date getValue() {
        return value;
    }

    public void setValue(Date value) {
        this.value = value;
    }
}
