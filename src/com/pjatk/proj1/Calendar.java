package com.pjatk.proj1;

import com.pjatk.proj1.Wagon;
import com.pjatk.proj1.Warehouse;

import java.util.Timer;
import java.util.TimerTask;

public class Calendar extends Thread {

    public static int day;
    private static String monitor = new String();
    private Wagon wagon;
    private Warehouse warehouse;

    Calendar(Warehouse warehouse, Wagon wagon){
        this.warehouse = warehouse;
        this.wagon = wagon;
    }

    @Override
    public void run() {
        try{
            while(true) {
                Thread.sleep(5000);
                    day++;
                    warehouse.checkDays(day);
                    wagon.checkSpace();

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public int getDay(){
        return day;
    }
}

