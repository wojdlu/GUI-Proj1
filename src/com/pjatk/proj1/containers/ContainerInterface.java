package com.pjatk.proj1.containers;

import com.pjatk.proj1.Sender;

public interface ContainerInterface {

    double getWeight();

    void setTransportDay(int x);

    int getTransportDay();

    Sender getSender();
}
