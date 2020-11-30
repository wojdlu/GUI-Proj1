package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;

import java.util.UUID;


public class ToxicLooseContainer extends HeavyContainer implements Container {

    private double grainSize;

    public ToxicLooseContainer(double weightNetto, double weightBrutto, Sender sender, double grainSize) {
        super(weightNetto, weightBrutto, sender);
        this.grainSize = grainSize;
    }

    public ToxicLooseContainer(double weightNetto, double weightBrutto, Sender sender, UUID id, int day, double grainSize) {
        super(weightNetto, weightBrutto, sender, id, day);
        this.grainSize = grainSize;
    }

    public ToxicLooseContainer(double weightNetto, double weightBrutto, Sender sender, UUID id, int day) {
        super(weightNetto, weightBrutto, sender, id, day);
    }

    public ToxicLooseContainer() {
    }

    public ToxicLooseContainer(double weightNetto, double weightBrutto, Sender sender) {
        super(weightNetto, weightBrutto, sender);
    }

    public double getWeight() {
        return weightBrutto;
    }

    public Sender getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "ToxicLooseContainer{" +
                "grainSize=" + grainSize +
                ", weightNetto=" + weightNetto +
                ", weightBrutto=" + weightBrutto +
                ", ID=" + ID +
                ", sender=" + sender +
                ", transportDay=" + transportDay +
                '}';
    }

    public String toFile() {
        return "ToxicLooseContainer:" +
                weightNetto +
                "," + weightBrutto +
                "," + ID +
                "," + sender.toFile() +
                "," + transportDay +
                "," + grainSize +
                '}';
    }


}
