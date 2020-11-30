package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;

import java.util.UUID;

public class LiquidsContainer extends BasicContainer implements ContainerInterface {

    protected double holeDiameter;

    public LiquidsContainer(double weightNetto, double weightBrutto, Sender sender, double holeDiameter) {
        super(weightNetto, weightBrutto, sender);
        this.holeDiameter = holeDiameter;
    }
    public double getWeight() {
        return weightBrutto;
    }

    public Sender getSender(){
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
                '}';
    }
}
