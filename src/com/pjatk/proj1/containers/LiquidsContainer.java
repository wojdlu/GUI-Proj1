package com.pjatk.proj1.containers;

import java.util.UUID;

public class LiquidsContainer extends BasicContainer implements ContainerInterface {

    private final UUID ID = UUID.randomUUID();

    public LiquidsContainer(double weightNetto, double weightBrutto) {
        super(weightNetto, weightBrutto);
    }
}
