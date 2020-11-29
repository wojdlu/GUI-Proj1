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

    private List<ContainerInterface> containers = new ArrayList<>();


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

    private ExplosivesContainer ex = new ExplosivesContainer();
    private ToxicLooseContainer tlc = new ToxicLooseContainer();
    private ToxicLiquidsContainers tlic = new ToxicLiquidsContainers();
    private RefrigeratedContainer rc = new RefrigeratedContainer();
    private HeavyContainer hc = new HeavyContainer();


    public boolean addContainer(ContainerInterface container){
        for(ContainerInterface x : containers){
            weight += x.getWeight();
        }
        weight += container.getWeight();

        if(containers.size() < MAX_ALL_CONTAINERS && weight < MAX_WEIGHT) {
            if (container.getClass() == ex.getClass() || container.getClass() == tlc.getClass() || container.getClass() == tlic.getClass()) {
                if(toxicCounter < MAX_TOXIC_EXPLOSIVE_CONTAINERS){
                    containers.add(container);
                    toxicCounter++;
                    return true;
                }else {
                    System.out.println("Statek nie pomieści więcej kontenerów z materiałami toksycznymi lub wybuchowymi ");
                    return false;
                }
            } else if(container.getClass() == rc.getClass()){
                if(electricCounter < MAX_ELECTRIC_CONTAINERS){
                    containers.add(container);
                    electricCounter++;
                    return true;
                }else {
                    System.out.println("Statek nie pomieści więcej kontenerów, które muszą być podłączone do sieci elektrycznej");
                    return false;
                }
            }else if (container.getClass() == hc.getClass()) {
                if (heavyConunter < MAX_HEAVY_CONTAINERS) {
                    containers.add(container);
                    heavyConunter++;
                    return true;
                } else {
                    System.out.println("Statek nie pomieści więcej ciężkich kontenerów");
                    return false;
                }
            }
        }else{
            System.out.println("Statek nie udźwignie więcej ciężaru, lub nie ma na nim już miejsca");
            return false;
        }
        return false;
    }

    public void showContainers(){
        int c = 1;
        for(ContainerInterface x: containers){
            System.out.println(c + ". " + x);
        }
    }

    public ContainerInterface getContainer(int x){
        x = x -1;
        return containers.get(x);
    }

    public void removeContainer(int x){
        x = x -1;
        containers.remove(x);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "Nazwa statku=" + NAME +
                "MAX_TOXIC_CONTAINERS=" + MAX_TOXIC_EXPLOSIVE_CONTAINERS +
                ", MAX_HEAVY_CONTAINERS=" + MAX_HEAVY_CONTAINERS +
                ", MAX_ELECTRIC_CONTAINERS=" + MAX_ELECTRIC_CONTAINERS +
                ", MAX_ALL_CONTAINERS=" + MAX_ALL_CONTAINERS +
                ", MAX_WEIGHT=" + MAX_WEIGHT +
                ", uniqueId=" + uniqueId +
                '}';
    }
}

