package com.pjatk.proj1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Port {
    private List<Ship> port = new ArrayList<>();

    public Port (){}

    public void addShip(Ship ship){
        port.add(ship);
    }

    public void showShips(){
        int c = 1;
        for(Ship x: port){
            System.out.println(c + ". " + x);
            c++;
        }
    }

    public Ship getShip(int x){
        x = x-1;
        return port.get(x);
    }


}
