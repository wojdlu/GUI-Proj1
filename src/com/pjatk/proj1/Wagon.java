package com.pjatk.proj1;

import com.pjatk.proj1.containers.ContainerInterface;

import java.util.ArrayList;
import java.util.List;

public class Wagon {
    List<ContainerInterface> wagon = new ArrayList<>();
    int maxWagonNumber = 10;

    public boolean addContainer(ContainerInterface container){
        if(wagon.size() < maxWagonNumber){
            wagon.add(container);
            return true;
        }else{
            System.out.println("Wagon jest pełen i nie można dodać kolejnych kontenerów");
            return false;
        }
    }
}
