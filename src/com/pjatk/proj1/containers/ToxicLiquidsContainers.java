package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;

import java.util.UUID;

public class ToxicLiquidsContainers extends ToxicLooseContainer implements Container {

    private double holeDiameter;

    public ToxicLiquidsContainers(double weightNetto, double weightBrutto, Sender sender, double holeDiameter) {
        super(weightNetto, weightBrutto, sender);
        this.holeDiameter = holeDiameter;
    }
    public ToxicLiquidsContainers(double weightNetto, double weightBrutto, Sender sender, UUID id, int day, double holeDiameter) {
        super(weightNetto, weightBrutto, sender, id, day);
        this.holeDiameter = holeDiameter;
    }

    public ToxicLiquidsContainers(){}

    public Sender getSender(){
        return sender;
    }

    public double getWeight() {
        return weightBrutto;
    }

    @Override
    public String toString() {
        return "ToxicLiquidsContainers{" +
                "holeDiameter=" + holeDiameter +
                ", weightNetto=" + weightNetto +
                ", weightBrutto=" + weightBrutto +
                ", ID=" + ID +
                ", sender=" + sender +
                ", transportDay=" + transportDay +
                '}';
    }

    public String toFile() {
        return "ToxicLiquidsContainers:" +
                 weightNetto +
                "," + weightBrutto +
                "," + ID +
                "," + sender.toFile() +
                "," + transportDay +
                ",=" + holeDiameter +
                '}';
    }
}
