package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;

import java.util.UUID;

public class ToxicLiquidsContainers extends ToxicLooseContainer implements ContainerInterface {

    private double holeDiameter;

    public ToxicLiquidsContainers(double weightNetto, double weightBrutto, Sender sender, double holeDiameter) {
        super(weightNetto, weightBrutto, sender);
        this.holeDiameter = holeDiameter;
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
                '}';
    }
}
