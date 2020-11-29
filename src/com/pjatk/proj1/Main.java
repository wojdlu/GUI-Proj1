package com.pjatk.proj1;

import com.pjatk.proj1.containers.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Port port = new Port();
        Warehouse warehouse = new Warehouse();
        while(true){
            int x = menu();
            if(x==6)
                break;
            switch (x){
                case 1:
                    port.addShip(newShip());
                    break;
                case 2:
                    warehouse.addContainer(newContainer());
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    menu();
            }


        }
    }

    static int menu(){
        System.out.println("Co chcesz zrobić:");
        System.out.println("1. Stwórz nowy statek");
        System.out.println("2. Stwórz nowy kontener");
        System.out.println("3. Przenieś kontener na statek z magazynu lub wagonu");
        System.out.println("4. Przenieś kontener ze statku do magazynu lub wagonu");
        System.out.println("6. zakończ program");
        System.out.print("Wpisz cyfrę odpowiadającą opcji: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

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

    static ContainerInterface newContainer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj imię nadawcy:");
        String name = scanner.nextLine();
        System.out.println("podaj nazwisko nadawcy:");
        String surname = scanner.nextLine();
        System.out.println("podaj adres:");
        String address = scanner.nextLine();
        System.out.println("podaj datę urodzenia:");
        String birthDate = scanner.nextLine();
        System.out.println("podaj pesel:");
        int pesel = scanner.nextInt();
        Sender sender = new Sender(name,surname,address,birthDate,pesel);
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
                        return newContainer();
                }

            default:
                return newContainer();

        }

    }
}
