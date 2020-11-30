package com.pjatk.proj1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SenderBase {

    List<Sender> senderList = new ArrayList<>();


    public Sender getSender(int x){
        x = x-1;
        return senderList.get(x);
    }

    public void showSenderList(){
        int c = 1;
        for (Sender x: senderList){
            System.out.println(c + ". " + x);
            c++;
        }
    }

    public void addSender(Sender sender){
        senderList.add(sender);
    }
}
