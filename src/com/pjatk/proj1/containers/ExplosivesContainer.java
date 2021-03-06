package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;

import java.util.UUID;

public class ExplosivesContainer extends HeavyContainer implements ContainerInterface {

    protected String securityClass;

    public ExplosivesContainer(double weightNetto, double weightBrutto, Sender sender, String securityClass) {
        super(weightNetto, weightBrutto, sender);
        this.securityClass = securityClass;
    }

    public ExplosivesContainer(){}

    public double getWeight() {
        return weightBrutto;
    }

    public Sender getSender(){
        return sender;
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



