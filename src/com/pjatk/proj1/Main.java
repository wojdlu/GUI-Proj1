package com.pjatk.proj1;

import com.pjatk.proj1.containers.*;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
        Port port = new Port();
        Warehouse warehouse = new Warehouse();
        Wagon wagon = new Wagon();
        SenderBase senderBase = new SenderBase();
        Calendar calendar = new Calendar(warehouse, wagon);
        calendar.start();
        Sender sender1 = new Sender("Tomasz", "Król", "Kraków, Zamkowa 11", "11.12.1991",1231231231);
        senderBase.addSender(sender1);
        ExplosivesContainer explosivesContainer = new ExplosivesContainer(100, 120, sender1, "II");
        RefrigeratedContainer refrigeratedContainer = new RefrigeratedContainer(1100, 1400, sender1,120);
        RefrigeratedContainer refrigeratedContainer1 = new RefrigeratedContainer(1100, 1400, sender1,120);
        warehouse.addContainer(explosivesContainer);
        warehouse.addContainer(refrigeratedContainer);
        warehouse.addContainer(refrigeratedContainer1);

        while(true){

                int x = menu();
                if (x == 8)
                    break;
                switch (x) {
                    case 1:
                        port.addShip(newShip());
                        break;
                    case 2:
                        warehouse.addContainer(newContainer(senderBase));
                        break;
                    case 3:
                        showShipsAndContainers(port);
                        break;
                    case 4:
                        warehouse.showContainers();
                        break;
                    case 5:
                        deleteContainer(warehouse);
                        break;
                    case 6:
                        moveContainerToShip(warehouse, port, calendar);
                        break;
                    case 7:
                        moveContainerToWagonOrWarehouse(warehouse, wagon, port);
                        break;
                    default:
                        menu();
                }



        }
    }

// Menu główne programu

    static int menu(){
        System.out.println("Co chcesz zrobić:");
        System.out.println("1. Stwórz nowy statek");
        System.out.println("2. Stwórz nowy kontener");
        System.out.println("3. Wyświetl statki i załadowane kontenery");
        System.out.println("4. Wyświetl stan magazynu");
        System.out.println("5. Usuń istniejący kontener z magazynu");
        System.out.println("6. Przenieś kontener z magazynu na statek");
        System.out.println("7. Przenieś kontener ze statku do magazynu lub wagonu");
        System.out.println("8. zakończ program");
        System.out.print("Wpisz cyfrę odpowiadającą opcji: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

// Proces tworzenia nowego statku

    static Ship newShip() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj nazwę nowego statku: ");
        String name = scanner.nextLine();
        System.out.println("podaj maksymalną ilość wszystkich kontenerów: ");
        int maxA = scanner.nextInt();
        System.out.println("podaj maksymalną wagę kontenerów (w tonach): ");
        int maxAW = scanner.nextInt();
        System.out.println("podaj maksymalną ilość kontenerów na materiały toksyczne i wybuchowe: ");
        int maxTE = scanner.nextInt();
        System.out.println("podaj maksymalną ilość kontenerów ciężkich: ");
        int maxH = scanner.nextInt();
        System.out.println("podaj maksymalną ilość kontenerów wymagających podłączenia do sieci elektrycznej: ");
        int maxE = scanner.nextInt();
        Ship ship = new Ship(maxTE, maxH, maxE, maxA, maxAW, name);
        System.out.println("stworzono i dodano do bazy statek: " + ship);
        return ship;
    }
    // Proces tworzenia nowego kontenera i jego nadawce

    static ContainerInterface newContainer(SenderBase senderBase){
        Scanner scanner = new Scanner(System.in);
        Sender sender = chooseSender(senderBase);
        System.out.println("podaj wagę netto kontenera:");
        double weightNetto = scanner.nextDouble();
        System.out.println("podaj wagę brutto kontenera:");
        double weightBrutto = scanner.nextDouble();

        System.out.println("Jaki kontener chcesz stworzyć:");
        System.out.println("1. Podstawowy");
        System.out.println("2. Ciężki");
        System.out.println("3. Chłodniczy");
        System.out.println("4. kontener na materiały ciekłe");
        System.out.println("5. kontener na materiały wybuchowe");
        System.out.println("6. kontener na materiały toksyczne");
        System.out.print("Wpisz cyfrę odpowiadającą opcji: ");

        int y = scanner.nextInt();

        switch (y){
            case 1:
                BasicContainer bc = new BasicContainer(weightNetto, weightBrutto,sender);
                System.out.println("stworzono kontener: " + bc);
                return bc;
            case 2:
                System.out.println("Podaj grubość ściany kontenera: ");
                double wallThickness = scanner.nextDouble();
                HeavyContainer hc = new HeavyContainer(weightNetto, weightBrutto, sender, wallThickness);
                System.out.println("stworzono kontener: " + hc);
                return hc;
            case 3:
                System.out.println("Podaj zużycie prądu (w watach) : ");
                int powerConsumption = scanner.nextInt();
                RefrigeratedContainer rc = new RefrigeratedContainer(weightNetto, weightBrutto, sender, powerConsumption);
                System.out.println("stworzono kontener: " + rc);
                return rc;
            case 4:
                System.out.println("Podaj średnice otworu wlewowego : ");
                double holeDiameter = scanner.nextDouble();
                LiquidsContainer lc = new LiquidsContainer(weightNetto, weightBrutto, sender, holeDiameter);
                System.out.println("stworzono kontener: " + lc);
                return lc;
            case 5:
                System.out.println("Podaj klasę zabezpieczeń ( I, II, lub III) : ");
                String securityClass = scanner.nextLine();
                ExplosivesContainer ec = new ExplosivesContainer(weightNetto, weightBrutto, sender, securityClass);
                System.out.println("stworzono kontener: " + ec);
                return ec;
            case 6:
                System.out.println("Doprecyzuj rodzaj kontenera:");
                System.out.println("1. kontener na materiały ciekłe toksyczne");
                System.out.println("2. kontener na materiały sypkie toksyczne");
                System.out.println("Wpisz cyfrę odpowiadającą opcji: ");
                int z = scanner.nextInt();
                switch (z){
                    case 1:
                        System.out.println("Podaj średnice otworu wlewowego : ");
                        double holeDiameter1 = scanner.nextDouble();
                        ToxicLiquidsContainers tlc = new ToxicLiquidsContainers(weightNetto, weightBrutto, sender, holeDiameter1);
                        System.out.println("stworzono kontener: " + tlc);
                        return tlc;
                    case 2:
                        System.out.println("Podaj średnice ziaren materiału : ");
                        double grainDiameter = scanner.nextDouble();
                        ToxicLooseContainer tloc = new ToxicLooseContainer(weightNetto, weightBrutto, sender, grainDiameter);
                        System.out.println("stworzono kontener: " + tloc);
                        return tloc;
                    default:
                        System.out.println("Wpisałeś nieprawidłową wartosć");
                        return newContainer(senderBase);
                }

            default:
                return newContainer(senderBase);

        }

    }

    static void showShipsAndContainers(Port port){
        if(port.getShipList().isEmpty()){
            System.out.println("Nie ma jeszcze żadnych statków w porcie, które można by wyświetlić");
        }else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Istniejące statki: ");
            port.showShips();
            System.out.println("Wybierz statek, którego listę kontenerów chcesz zobaczyć i wpisz odpowiadającą cyfrę:");
            int shipNumber = scanner.nextInt();
            port.getShip(shipNumber).showContainers();
        }

    }

    static void deleteContainer(Warehouse warehouse){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kontenery znajdujące się w magazynie: ");
        warehouse.showContainers();
        System.out.println("Wybierz konteren i wipisz odpowiadającą cyfrę: ");
        int containerNumber = scanner.nextInt();
        warehouse.removeContainer(containerNumber);
    }

    static Sender chooseSender(SenderBase senderBase) {
        Scanner scanner = new Scanner(System.in);
        Sender sender;
        System.out.println("1. Stwórz nowego nadawcę");
        System.out.println("2. Wybierz nadawcę z bazy");
        System.out.println("Wpisz cyfrę odpowiadającą opcji: ");
        int x = scanner.nextInt();
        System.out.println("");
        switch (x) {
            case 1:
                System.out.println("podaj imię nadawcy:");
                String x1 = scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("podaj nazwisko nadawcy:");
                String surname = scanner.nextLine();
                System.out.println("podaj adres:");
                String address = scanner.nextLine();
                System.out.println("podaj datę urodzenia:");
                String birthDate = scanner.nextLine();
                System.out.println("podaj pesel:");
                int pesel = scanner.nextInt();
                sender = new Sender(name, surname, address, birthDate, pesel);
                senderBase.addSender(sender);
                return sender;
            case 2:
                senderBase.showSenderList();
                System.out.println("wybierz odpowiedni numer");
                int index = scanner.nextInt();
                return senderBase.getSender(index);
            default:
               return chooseSender(senderBase);
        }

    }

    static void moveContainerToShip(Warehouse warehouse, Port port, Calendar calendar){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz, który kontener chcesz przenieść: ");
        warehouse.showContainers();
        System.out.println("Wpisz numer odpowiadający kontenerowi: ");
        int containerNumber = scanner.nextInt();
        ContainerInterface container = warehouse.getContainer(containerNumber);
        System.out.println("Wybierz statek: ");
        port.showShips();
        System.out.println("Wpisz numer odpowiadający statkowi: ");
        int shipNumber = scanner.nextInt();
        Ship ship = port.getShip(shipNumber);
        container.setTransportDay(calendar.getDay());
        if(ship.addContainer(container))
            warehouse.removeContainer(containerNumber);

    }

    static void moveContainerToWagonOrWarehouse(Warehouse warehouse, Wagon wagon, Port port){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz statek z listy: ");
        port.showShips();
        System.out.println("Wpisz cyfrę odpowiadającą opcji: ");
        int shipNumber = scanner.nextInt();
        Ship ship = port.getShip(shipNumber);
        System.out.println("Kontenery znajdujące się na statku: ");
        ship.showContainers();
        System.out.println("Wybierz kontener i wpisz cyfrę odpowiadającą opcji: ");
        int containerNumber = scanner.nextInt();
        ContainerInterface container = ship.getContainer(containerNumber);
        System.out.println("Gdzie chcesz umieścić kontener: ");
        System.out.println("1. W wagonie ");
        System.out.println("2. W magazynie ");
        System.out.println("Wpisz cyfrę odpowiadającą opcji: ");
        int x = scanner.nextInt();
        switch (x) {
            case 1:
                if(wagon.addContainer(container))
                    ship.removeContainer(containerNumber);
                break;
            case 2:
                if(warehouse.addContainer(container))
                    ship.removeContainer(containerNumber);
                break;
            default:
                moveContainerToWagonOrWarehouse(warehouse, wagon, port);
        }
    }
}
