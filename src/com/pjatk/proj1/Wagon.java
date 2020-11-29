package com.pjatk.proj1;

import com.pjatk.proj1.containers.ContainerInterface;

import java.util.ArrayList;
import java.util.List;

public class Wagon {
    List<ContainerInterface> wagon = new ArrayList<>();
    int maxWagonNumber = 10;

    public void addContainer(ContainerInterface container){
        if(wagon.size() < maxWagonNumber){
            wagon.add(container);
        }else{
            System.out.println("Wagon jest pełen");
        }
    }
}
