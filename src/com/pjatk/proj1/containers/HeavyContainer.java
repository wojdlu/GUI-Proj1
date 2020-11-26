package com.pjatk.proj1.containers;

import java.util.UUID;

public class HeavyContainer extends BasicContainer implements ContainerInterface{

    private final UUID ID = UUID.randomUUID();

    public HeavyContainer(double weightNetto, double weightBrutto) {
        super(weightNetto, weightBrutto);
    }
}
