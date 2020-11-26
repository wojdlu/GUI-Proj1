package com.pjatk.proj1.containers;

import java.util.UUID;

public class ToxicLooseContainer extends HeavyContainer implements ContainerInterface{
    private final UUID ID = UUID.randomUUID();

    public ToxicLooseContainer(double weightNetto, double weightBrutto) {
        super(weightNetto, weightBrutto);
    }
}
