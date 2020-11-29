package com.pjatk.proj1.containers;

import com.pjatk.proj1.Wagon;
import com.pjatk.proj1.Warehouse;

import java.util.Timer;
import java.util.TimerTask;

public class Calendar implements Runnable {

    private int day = 0;
    Wagon wagon;
    Warehouse warehouse;

    Calendar(Warehouse warehouse, Wagon wagon){
        this.wagon = wagon;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try{
            while(true) {
                Thread.sleep(5000);
                day++;
                if(day%5 == 0){

                }
            }
        }catch (Exception e){

        }

    }
}
