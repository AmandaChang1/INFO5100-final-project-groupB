package dto;

import java.io.Serializable;


public class Discount implements Serializable {
    //there are two kinds of discount: 1: cash back ; 2: percentage off
    private boolean isCashBack;
    private float value;

    public Discount() {
    }

    public  Discount(Discount dt) {
        this.isCashBack = dt.isCashBack;
        this.value = dt.value;
    }

    public Discount(boolean isCashBack, float value) {
        this.isCashBack = isCashBack;
        this.value = value;
    }

    public boolean getCashBack() {
        return isCashBack;
    }

    public void setCashBack(boolean cashBack) {
        this.isCashBack = cashBack;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}