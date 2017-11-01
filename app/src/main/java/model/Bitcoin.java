package model;

/**
 * Created by rahulbhaya on 10/15/17.
 */

public class Bitcoin {


    private float price15m;

    public float getPrice15m() {
        return price15m;
    }

    public void setPrice15m(float price15m) {
        this.price15m = price15m;
    }

    public float getLast() {
        return last;
    }

    public void setLast(float last) {
        this.last = last;
    }

    public float getBuy() {
        return buy;
    }

    public void setBuy(float buy) {
        this.buy = buy;
    }

    public float getSell() {
        return sell;
    }

    public void setSell(float sell) {
        this.sell = sell;
    }

    private float last;
    private float buy;
    private float sell;

}
