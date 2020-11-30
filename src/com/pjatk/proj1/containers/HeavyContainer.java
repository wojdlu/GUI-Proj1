package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;

import java.util.UUID;

public class HeavyContainer extends BasicContainer implements Container {
    private double wallThickness;

//    HeavyContainer heavyContainer = new HeavyContainer(weightNetto, weightBrutto, sender, id, wallThickness);

    public HeavyContainer(double weightNetto, double weightBrutto, Sender sender, double wallThickness) {
        super(weightNetto, weightBrutto, sender);
        this.wallThickness = wallThickness;
    }

    public HeavyContainer(double weightNetto, double weightBrutto, Sender sender, UUID id, int day, double wallThickness) {
        super(weightNetto, weightBrutto, sender, id, day);
        this.wallThickness = wallThickness;
    }

    public HeavyContainer(double weightNetto, double weightBrutto, Sender sender, UUID id, int day) {
        super(weightNetto, weightBrutto, sender, id, day);
        this.wallThickness = wallThickness;
    }

    public HeavyContainer() {
    }

    public HeavyContainer(double weightNetto, double weightBrutto, Sender sender) {
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
        return "HeavyContainer{" +
                "wallThickness=" + wallThickness +
                ", weightNetto=" + weightNetto +
                ", weightBrutto=" + weightBrutto +
                ", ID=" + ID +
                ", sender=" + sender +
                ", transportDay=" + transportDay +
                '}';
    }

    public String toFile() {
        return "HeavyContainer:" +
                "," + weightNetto +
                "," + weightBrutto +
                "," + ID +
                "," + sender.toFile() +
                "," + transportDay +
                "," + wallThickness +

                '}';
    }

}
