package com.pjatk.proj1;

import java.util.*;

public class Port {
    private List<Ship> port = new ArrayList<>();

    public Port() {
    }

    public void addShip(Ship ship) {
        port.add(ship);
    }

    public void showShips() {
        Collections.sort(port, Comparator.comparing(Ship::getNAME));
        Collections.reverse(port);

        int c = 1;

        for (Ship x : port) {
            System.out.println(c + ". " + x);
            c++;
        }

    }

    public Ship getShip(int x) {
        x = x - 1;
        return port.get(x);
    }

    public void deleteShip(int x) {
        Collections.sort(port, Comparator.comparing(Ship::getNAME));
        Collections.reverse(port);
        x = x - 1;
        port.remove(x);
    }

    public List<Ship> getShipList() {
        return port;
    }

}
