package com.pjatk.proj1.containers;

import java.util.UUID;

public class RefrigeratedContainer extends HeavyContainer implements ContainerInterface {
     private int powerConsumption;
    private final UUID ID = UUID.randomUUID();

    public RefrigeratedContainer(double weightNetto, double weightBrutto) {
        super(weightNetto, weightBrutto);
    }
}
