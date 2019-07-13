package com.thoughtworks.tdd;

public class Ticket {
    private boolean isUsed;
    private boolean isProvided;

    public Ticket() {
    }
    public Ticket(boolean isUsed, boolean isProvided) {
        this.isUsed = isUsed;
        this.isProvided = isProvided;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public boolean isProvided() {
        return isProvided;
    }

    public void setProvided(boolean provided) {
        isProvided = provided;
    }



}
