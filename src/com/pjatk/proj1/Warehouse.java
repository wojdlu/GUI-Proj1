package com.pjatk.proj1;

import com.pjatk.proj1.containers.*;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<ContainerInterface> warehouse = new ArrayList<>();
    private ExplosivesContainer ec;
    private ToxicLiquidsContainers tc;
    private ToxicLooseContainer tlc;


    public void addContainer(ContainerInterface containerInterface){

        warehouse.add(containerInterface);
    }

    public void checkExplosives(int day){
        while()
    }

}
