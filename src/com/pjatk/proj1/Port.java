package com.pjatk.proj1;

import com.pjatk.proj1.containers.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Port {
    private List<Ship> port = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        Ship ship0 = new Ship(10, 10, 10, 11, 1000, "Wojo");
        Ship ship1 = new Ship(10, 10, 10, 11, 1400, "Jaymz");
        Ship ship2 = new Ship(10, 10, 10, 11, 1200, "Greg");
        Ship ship3 = new Ship(10, 10, 10, 11, 11000, "Ola");
        Port port = new Port();
        port.addShip(ship0);
        port.addShip(ship1);
        port.addShip(ship2);
        port.addShip(ship3);

        Sender sender = new Sender("Pajak", "wojo", "sdfa", "121.12", 12312313);
        BasicContainer bs = new BasicContainer(100, 10, sender);
        ExplosivesContainer ec = new ExplosivesContainer(10, 10, sender, "II");
        ship0.addSingleContainers(bs);
        ship2.addSingleContainers(bs);
        ship2.addSingleContainers(ec);
        FileOutputStream oos = null;

        StringBuilder sb = new StringBuilder();

        printPort(port, sb);

        System.out.println(sb.toString());

        try {
            oos = new FileOutputStream("nowy.txt");
            oos.write(sb.toString().getBytes());
        } finally {
            if (oos != null)
                oos.close();
        }

        System.out.println("============================");
        Iterator<String> fileIterator = Files.lines(Paths.get("nowy.txt")).iterator();

        List<Ship> readSHIPS = readShips(fileIterator);
        Port newPort = new Port();
        readSHIPS.forEach(s -> newPort.addShip(s));

        printPort(newPort, new StringBuilder());

    }

    private static void printPort(Port port, StringBuilder sb) {
        port.getShipList().forEach(s -> {
            sb.append(s.toFile() + "\n");

            s.getContainers().forEach(c -> sb.append("\t" + c.toFile() + "\n"));
        });

        System.out.println(sb.toString());
    }

    private static List<Ship> readShips(Iterator<String> fileIterator) {
        ArrayList<Ship> ships = new ArrayList<>();

        String line = fileIterator.next();
        while (fileIterator.hasNext()) {
            if (line.contains("Statek")) {
                String shipData = line.replace("Statek:", "");
                String[] split = shipData.split(",");

//                int maxToxic = Integer.parseInt(split[0].replace("maxToxic=", ""));
                int maxToxic = Integer.parseInt(split[0].replace("maxToxic=", ""));
                int maxHeavy = Integer.parseInt(split[1]);
                int maxElectric = Integer.parseInt(split[2]);
                int maxAll = Integer.parseInt(split[3]);
                int maxWeight = Integer.parseInt(split[4]);
                String name = split[5];

                Ship fromFileShip = new Ship(maxToxic, maxHeavy, maxElectric, maxAll, maxWeight, name);

                List<Container> containers = readContainers(fileIterator);
                fromFileShip.setContainers(containers);

                ships.add(fromFileShip);
            }
        }

        return ships;
    }

    public static List<Container> readContainers(Iterator<String> fileIterator) {
        ArrayList<Container> containerList = new ArrayList<>();

        while (fileIterator.hasNext()) {
            String line = fileIterator.next();


            if (line.contains("Container")) {
                String containerData = line.substring(line.indexOf(":") + 1, line.length());
                String[] split = containerData.split(",");
                double weightNetto = Double.parseDouble(split[0]);
                double weightBrutto = Double.parseDouble(split[1]);
                UUID id = UUID.fromString(split[2]);
                Sender sender = readSender(split[3]);
                int day = Integer.parseInt(split[4]);


                Container container = null;
                if (line.contains("HeavyContainer")) {
                    int wallThickness = Integer.parseInt(split[5]);
                    container = new HeavyContainer(weightNetto, weightBrutto, sender, id, day, wallThickness);
                } else if (line.contains("ExplosivesContainer")) {
                    String securityClass = split[5];
                    container = new ExplosivesContainer(weightNetto, weightBrutto, sender, id, day, securityClass);
                } else if (line.contains("LiquidsContainer")) {
                    double diameter = Double.parseDouble(split[5]);
                    container = new LiquidsContainer(weightNetto, weightBrutto, sender, id, day, diameter);
                } else if (line.contains("RefigeratedContainer")) {
                    int watt = Integer.parseInt(split[5]);
                    container = new RefrigeratedContainer(weightNetto, weightBrutto, sender, id, day, watt);
                } else if (line.contains("ToxicLiquidsContainer")) {
                    double diameter = Double.parseDouble(split[5]);
                    container = new ToxicLiquidsContainers(weightNetto, weightBrutto, sender, id, day, diameter);
                } else if (line.contains("ToxicLooseContainer")) {
                    double grainSize = Double.parseDouble(split[5]);
                    container = new ToxicLooseContainer(weightNetto, weightBrutto, sender, id, day, grainSize);
                } else {
                    container = new BasicContainer(weightNetto, weightBrutto, sender, id, day);
                }
                containerList.add(container);
            } else {
                break;
            }
        }
        return containerList;
    }

    public static Sender readSender(String line) {
        String senderData = line.substring(line.indexOf(":"), line.length());
        String[] split = senderData.split(";");
        String name = split[0];
        String surname = split[1];
        String address = split[2];
        String birthDate = split[3];
        int pesel = Integer.parseInt(split[4]);
        int warningNumber = Integer.parseInt(split[5]);
        return new Sender(name, surname, address, birthDate, pesel, warningNumber);
    }

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

    @Override
    public String toString() {
        return "Port{" +
                "port=" + port +
                '}';
    }
}
