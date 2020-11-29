package com.pjatk.proj1;

import com.pjatk.proj1.containers.*;

import java.util.ArrayList;
import java.util.List;
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
    private int weight;

    List<ContainerInterface> containers = new ArrayList<>();


    public Ship(int MAX_TOXIC_EXPLOSIVE_CONTAINERS, int MAX_HEAVY_CONTAINERS, int MAX_ELECTRIC_CONTAINERS, int MAX_ALL_CONTAINERS, int MAX_WEIGHT, String NAME) {
        this.MAX_TOXIC_EXPLOSIVE_CONTAINERS = MAX_TOXIC_EXPLOSIVE_CONTAINERS;
        this.MAX_HEAVY_CONTAINERS = MAX_HEAVY_CONTAINERS;
        this.MAX_ELECTRIC_CONTAINERS = MAX_ELECTRIC_CONTAINERS;
        this.MAX_ALL_CONTAINERS = MAX_ALL_CONTAINERS;
        this.MAX_WEIGHT = MAX_WEIGHT;
        this.NAME = NAME;
    }

    private int heavyConunter = 0;
    private int toxicCounter = 0;
    private int electricCounter = 0;

    public void addContainer(ContainerInterface container){
        for(ContainerInterface x : containers){
            weight += x.getWeight();
        }
        weight += container.getWeight();

        if(containers.size() < MAX_ALL_CONTAINERS && weight < MAX_WEIGHT) {
            if (container instanceof ExplosivesContainer || container instanceof ToxicLooseContainer || container instanceof ToxicLiquidsContainers) {
                if(toxicCounter < MAX_TOXIC_EXPLOSIVE_CONTAINERS){
                    containers.add(container);
                    toxicCounter++;
                }else {
                    System.out.println("Statek nie pomieści więcej kontenerów z materiałami toksycznymi lub wybuchowymi ");
                }
            } else if(container instanceof RefrigeratedContainer){
                if(electricCounter < MAX_ELECTRIC_CONTAINERS){
                    containers.add(container);
                    electricCounter++;
                }else {
                    System.out.println("Statek nie pomieści więcej kontenerów, które muszą być podłączone do sieci elektrycznej");
                }
            }else if (container instanceof HeavyContainer) {
                if (heavyConunter < MAX_HEAVY_CONTAINERS) {
                    containers.add(container);
                    heavyConunter++;
                } else {
                    System.out.println("Statek nie pomieści więcej ciężkich kontenerów");
                }
            }
        }else{
            System.out.println("Statek nie udźwignie więcej ciężaru, lub nie ma na nim już miejsca");
        }

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

