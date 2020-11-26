package com.pjatk.proj1.containers;

import java.util.UUID;

public class BasicContainer implements ContainerInterface{
    private double weightNetto;
    private double weightBrutto;
    private final UUID ID = UUID.randomUUID();

    public BasicContainer(double weightNetto, double weightBrutto) {
        this.weightNetto = weightNetto;
        this.weightBrutto = weightBrutto;
    }
}
