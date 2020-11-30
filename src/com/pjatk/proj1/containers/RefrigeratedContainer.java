package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;

import java.util.UUID;

public class RefrigeratedContainer extends HeavyContainer implements Container {
    protected int powerConsumption;

    public RefrigeratedContainer(double weightNetto, double weightBrutto, Sender sender, int powerConsumption) {
        super(weightNetto, weightBrutto, sender);
        this.powerConsumption = powerConsumption;
    }
    public RefrigeratedContainer(double weightNetto, double weightBrutto, Sender sender, UUID id, int day, int powerConsumption) {
        super(weightNetto, weightBrutto, sender, id, day);
        this.powerConsumption = powerConsumption;
    }

    public RefrigeratedContainer() {
    }

    public Sender getSender() {
        return sender;
    }

    public double getWeight() {
        return weightBrutto;
    }

    @Override
    public String toString() {
        return "RefrigeratedContainer{" +
                "powerConsumption=" + powerConsumption +
                ", weightNetto=" + weightNetto +
                ", weightBrutto=" + weightBrutto +
                ", ID=" + ID +
                ", sender=" + sender +
                ", transportDay=" + transportDay +
                '}';
    }

    public String toFile() {
        return "RefrigeratedContainer:" +
                "," + weightNetto +
                "," + weightBrutto +
                "," + ID +
                "," + sender.toFile() +
                "," + transportDay +
                "," + powerConsumption +
                '}';
    }
}
