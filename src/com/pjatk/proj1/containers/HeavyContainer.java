package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;

import java.util.UUID;

public class HeavyContainer extends BasicContainer implements ContainerInterface{
    private double wallThickness;


    public HeavyContainer(double weightNetto, double weightBrutto, Sender sender, double wallThickness) {
        super(weightNetto, weightBrutto, sender);
        this.wallThickness = wallThickness;
    }

    public HeavyContainer(double weightNetto, double weightBrutto, Sender sender) {
        super(weightNetto, weightBrutto, sender);
    }

    public double getWeight(){
        return weightBrutto;
    }


    @Override
    public String toString() {
        return "HeavyContainer{" +
                "wallThickness=" + wallThickness +
                ", weightNetto=" + weightNetto +
                ", weightBrutto=" + weightBrutto +
                ", ID=" + ID +
                ", sender=" + sender +
                '}';
    }


}
