package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;


public class ToxicLooseContainer extends HeavyContainer implements ContainerInterface{

    private double grainSize;

    public ToxicLooseContainer(double weightNetto, double weightBrutto, Sender sender, double grainSize) {
        super(weightNetto, weightBrutto, sender);
        this.grainSize = grainSize;
    }

    public ToxicLooseContainer(){}

    public ToxicLooseContainer(double weightNetto, double weightBrutto, Sender sender) {
        super(weightNetto, weightBrutto, sender);
    }

    public double getWeight() {
        return weightBrutto;
    }

    public Sender getSender(){
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
                '}';
    }

}
