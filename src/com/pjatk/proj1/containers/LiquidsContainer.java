package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;

import java.util.UUID;

public class LiquidsContainer extends BasicContainer implements Container {

    protected double holeDiameter;

    public LiquidsContainer(double weightNetto, double weightBrutto, Sender sender, double holeDiameter) {
        super(weightNetto, weightBrutto, sender);
        this.holeDiameter = holeDiameter;
    }

    public LiquidsContainer(double weightNetto, double weightBrutto, Sender sender, UUID id, int day, double holeDiameter) {
        super(weightNetto, weightBrutto, sender, id, day);
        this.holeDiameter = holeDiameter;
    }

    public double getWeight() {
        return weightBrutto;
    }

    public Sender getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "LiquidsContainer{" +
                "holeDiameter=" + holeDiameter +
                ", weightNetto=" + weightNetto +
                ", weightBrutto=" + weightBrutto +
                ", ID=" + ID +
                ", sender=" + sender +
                ", transportDay=" + transportDay +
                '}';
    }

    public String toFile() {
        return "LiquidsContainer:" +
                "," + weightNetto +
                "," + weightBrutto +
                "," + ID +
                "," + sender.toFile() +
                "," + transportDay +
                ",=" + holeDiameter +
                '}';
    }
}
