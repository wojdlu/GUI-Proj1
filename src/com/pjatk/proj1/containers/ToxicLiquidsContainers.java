package com.pjatk.proj1.containers;

import java.util.UUID;

public class ToxicLiquidsContainers extends ToxicLooseContainer implements ContainerInterface {
    private final UUID ID = UUID.randomUUID();

    public ToxicLiquidsContainers(double weightNetto, double weightBrutto) {
        super(weightNetto, weightBrutto);
    }
}
