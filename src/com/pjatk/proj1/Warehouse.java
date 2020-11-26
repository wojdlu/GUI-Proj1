package com.pjatk.proj1;

import com.pjatk.proj1.containers.ContainerInterface;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<ContainerInterface> warehouse = new ArrayList<>();


    public void addContainer(ContainerInterface containerInterface){
        warehouse.add(containerInterface);
    }

}
