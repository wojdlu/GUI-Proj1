package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;

import java.util.UUID;

public class BasicContainer implements Container {

    protected double weightNetto;
    protected double weightBrutto;
    protected UUID ID = UUID.randomUUID();
    protected Sender sender;
    protected int transportDay;

    public BasicContainer(double weightNetto, double weightBrutto, Sender sender) {
        this.weightNetto = weightNetto;
        this.weightBrutto = weightBrutto;
        this.sender = sender;
    }

    public BasicContainer(double weightNetto, double weightBrutto, Sender sender, UUID ID, int day ){
        this.weightNetto = weightNetto;
        this.weightBrutto = weightBrutto;
        this.sender = sender;
        this.ID = ID;
        this.transportDay = day;
    }

    public BasicContainer() {
    }

    public double getWeight() {

        return weightBrutto;
    }

    public void setTransportDay(int transportDay) {
        this.transportDay = transportDay;
    }

    public int getTransportDay() {
        return transportDay;
    }

    public Sender getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "BasicContainer{" +
                "weightNetto=" + weightNetto +
                ", weightBrutto=" + weightBrutto +
                ", ID=" + ID +
                ", sender=" + sender +
                ", transportDay=" + transportDay +
                '}';
    }

    @Override
    public String toFile() {
        return "BasicContainer:" +
                weightNetto +
                "," + weightBrutto +
                "," + ID +
                "," + sender.toFile() +
                "," + transportDay;
    }
}
