package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;

public interface Container {

    double getWeight();

    void setTransportDay(int x);

    int getTransportDay();

    Sender getSender();

    String toFile();
}
