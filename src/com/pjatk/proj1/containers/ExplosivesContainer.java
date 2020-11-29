package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;

import java.util.UUID;

public class ExplosivesContainer extends HeavyContainer implements ContainerInterface {

    protected String securityClass;

    public ExplosivesContainer(double weightNetto, double weightBrutto, Sender sender, String securityClass) {
        super(weightNetto, weightBrutto, sender);
        this.securityClass = securityClass;
    }
    public double getWeight() {
        return weightBrutto;
    }

    @Override
    public String toString() {
        return "ExplosivesContainer{" +
                "securityClass='" + securityClass + '\'' +
                ", weightNetto=" + weightNetto +
                ", weightBrutto=" + weightBrutto +
                ", ID=" + ID +
                ", sender=" + sender +
                '}';
    }
}



