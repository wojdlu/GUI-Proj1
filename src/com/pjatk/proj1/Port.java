package com.pjatk.proj1;

import java.util.ArrayList;
import java.util.List;

public class Port {
    List<Ship> port = new ArrayList<>();

    public Port (){}

    public void addShip(Ship ship){
        port.add(ship);
    }
}
