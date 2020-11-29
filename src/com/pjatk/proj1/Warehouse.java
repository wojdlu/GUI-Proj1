package com.pjatk.proj1;

import com.pjatk.proj1.containers.*;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<ContainerInterface> containerList = new ArrayList<>();
    private ExplosivesContainer ec;
    private ToxicLiquidsContainers tc;
    private ToxicLooseContainer tlc;


    public boolean addContainer(ContainerInterface containerInterface){

        containerList.add(containerInterface);
        return true;
    }

    public void showContainers(){
        int c = 1;
        for(ContainerInterface x : containerList){
            System.out.println(c + ". " + x );
            c++;
        }
    }

    public ContainerInterface getContainer(int x){
        x = x-1;
        ContainerInterface container = containerList.get(x);
        return container;
    }

    public void removeContainer(int x){
        x = x-1;
        try {
            containerList.remove(x);
        }catch (Exception e){
            System.out.println("Wybrano niepoprawny numer");
        }
    }
}
