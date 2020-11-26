package com.pjatk.proj1.containers;

import java.util.UUID;

public class ExplosivesContainer extends HeavyContainer implements ContainerInterface {
    private final UUID ID = UUID.randomUUID();

    public ExplosivesContainer(double weightNetto, double weightBrutto) {
        super(weightNetto, weightBrutto);
    }
}
