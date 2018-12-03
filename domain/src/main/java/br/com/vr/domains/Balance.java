package br.com.vr.domains;

public class Balance {

    private Double value;

    public Balance(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
