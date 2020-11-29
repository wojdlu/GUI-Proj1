package com.pjatk.proj1;

import com.pjatk.proj1.containers.*;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    List<ContainerInterface> containerList = new ArrayList<>();
    private ExplosivesContainer ec = new ExplosivesContainer();
    private ToxicLiquidsContainers tc = new ToxicLiquidsContainers();
    private ToxicLooseContainer tlc = new ToxicLooseContainer();



    public boolean addContainer(ContainerInterface containerInterface){

        containerList.add(containerInterface);
        return true;
    }

    public void showContainers(){
        if(containerList.isEmpty()){
            System.out.println("Magazyn jest pusty");
        }else{
            int c = 1;
            for(ContainerInterface x : containerList) {
                System.out.println("Aktualny stan magazynu: ");
                System.out.println(c + ". " + x);
                c++;
            }
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

    public void checkDays(int day){
        for(ContainerInterface x: containerList){
            if(x.getClass() == ec.getClass()){
                if(day - x.getTransportDay() > 5) {
                    System.out.println("Z powodu zbyt długiego magazynowania Kontenera z materiałami wybuchowymi (powyżej 5 dni) został on wywieziony");
                    containerList.remove(x);
                    }
            }else if(x.getClass() == tc.getClass()){
                    if(day - x.getTransportDay() > 10) {
                        System.out.println("Z powodu zbyt długiego magazynowania Kontenera z materiałami płynnymi toksycznymi (powyżej 10 dni) został on wywieziony");
                        containerList.remove(x);
                    }
            }else if(x.getClass() == tlc.getClass()){
                    if(day - x.getTransportDay() > 14) {
                        System.out.println("Z powodu zbyt długiego magazynowania Kontenera z materiałami sypkimi toksycznymi (powyżej 14 dni) został on wywieziony");
                        containerList.remove(x);
                    }
            }
        }
    }
}
