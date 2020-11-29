package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;

import java.util.UUID;

public class BasicContainer implements ContainerInterface{
    protected double weightNetto;
    protected double weightBrutto;
    protected final UUID ID = UUID.randomUUID();
    protected Sender sender;

    public BasicContainer(double weightNetto, double weightBrutto, Sender sender) {
        this.weightNetto = weightNetto;
        this.weightBrutto = weightBrutto;
        this.sender = sender;
    }

    public BasicContainer(){}

    public double getWeight() {
        return weightBrutto;
    }

    @Override
    public String toString() {
        return "BasicContainer{" +
                "weightNetto=" + weightNetto +
                ", weightBrutto=" + weightBrutto +
                ", ID=" + ID +
                ", sender=" + sender +
                '}';
    }
}
