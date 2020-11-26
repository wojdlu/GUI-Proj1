package com.pjatk.proj1;

import com.pjatk.proj1.containers.ContainerInterface;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<String> list = new ArrayList<>();


    public void AddContainer(String s){
        list.add(s);
    }


}
