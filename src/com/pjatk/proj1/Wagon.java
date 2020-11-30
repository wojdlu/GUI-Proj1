package com.pjatk.proj1;

import com.pjatk.proj1.containers.Container;

import java.util.ArrayList;
import java.util.List;


public class Wagon {
    List<Container> wagon = new ArrayList<>();
    int maxWagonNumber = 2;
    int waitingTime = 0;


    public boolean addContainer(Container container){
        if(wagon.size() < maxWagonNumber){
            wagon.add(container);
            return true;
        }else if(wagon.size() == maxWagonNumber){
            System.out.println("Wagon jest pełen i nie można dodać kolejnych kontenerów, odczekaj 30sek na przyjazd kolejnego");
            return false;
        }else{
            return false;

        }
    }
    public void checkSpace(){
        if(wagon.size() == maxWagonNumber){
            waitingTime++;
            if(waitingTime == 6) {
                wagon.clear();
                System.out.println("Wagon jest gotowy do załadunku");
            }
        }else{
            waitingTime = 0;
        }
    }
}
