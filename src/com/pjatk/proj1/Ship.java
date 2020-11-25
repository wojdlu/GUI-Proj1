package com.pjatk.proj1;

import java.util.UUID;

public class Ship {

    private final int MAX_TOXIC_EXPLOSIVE_CONTAINERS;
    private final int MAX_HEAVY_CONTAINERS;
    private final int MAX_ELECTRIC_CONTAINERS;
    private final int MAX_ALL_CONTAINERS;
    private final int MAX_WEIGHT;
    private final UUID uniqueId = UUID.randomUUID();
    private final String NAME;
    private String homePort;
    private String destinationPort;
    private String startingPort;

    public Ship(int MAX_TOXIC_EXPLOSIVE_CONTAINERS, int MAX_HEAVY_CONTAINERS, int MAX_ELECTRIC_CONTAINERS, int MAX_ALL_CONTAINERS, int MAX_WEIGHT, String NAME) {
        this.MAX_TOXIC_EXPLOSIVE_CONTAINERS = MAX_TOXIC_EXPLOSIVE_CONTAINERS;
        this.MAX_HEAVY_CONTAINERS = MAX_HEAVY_CONTAINERS;
        this.MAX_ELECTRIC_CONTAINERS = MAX_ELECTRIC_CONTAINERS;
        this.MAX_ALL_CONTAINERS = MAX_ALL_CONTAINERS;
        this.MAX_WEIGHT = MAX_WEIGHT;
        this.NAME = NAME;
    }

    public int getMAX_TOXIC_EXPLOSIVE_CONTAINERS() {
        return MAX_TOXIC_EXPLOSIVE_CONTAINERS;
    }

    public int getMAX_HEAVY_CONTAINERS() {
        return MAX_HEAVY_CONTAINERS;
    }

    public int getMAX_ELECTRIC_CONTAINERS() {
        return MAX_ELECTRIC_CONTAINERS;
    }

    public int getMAX_ALL_CONTAINERS() {
        return MAX_ALL_CONTAINERS;
    }

    public int getMAX_WEIGHT() {
        return MAX_WEIGHT;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public String getNAME() {
        return NAME;
    }

    public String getHomePort() {
        return homePort;
    }

    public void setHomePort(String homePort) {
        this.homePort = homePort;
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort;
    }

    public String getStartingPort() {
        return startingPort;
    }

    public void setStartingPort(String startingPort) {
        this.startingPort = startingPort;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "MAX_TOXIC_CONTAINERS=" + MAX_TOXIC_EXPLOSIVE_CONTAINERS +
                ", MAX_HEAVY_CONTAINERS=" + MAX_HEAVY_CONTAINERS +
                ", MAX_ELECTRIC_CONTAINERS=" + MAX_ELECTRIC_CONTAINERS +
                ", MAX_ALL_CONTAINERS=" + MAX_ALL_CONTAINERS +
                ", MAX_WEIGHT=" + MAX_WEIGHT +
                ", uniqueId=" + uniqueId +
                '}';
    }
}

