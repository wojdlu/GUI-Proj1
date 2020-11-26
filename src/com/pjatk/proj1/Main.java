package com.pjatk.proj1;

import com.pjatk.proj1.containers.BasicContainer;
import com.pjatk.proj1.containers.ContainerInterface;

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
        return ship;
    }
    static ContainerInterface newContainer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj wagę netto kontenera:");
        double weightNetto = scanner.nextDouble();
        System.out.println("podaj wagę brutto kontenera:");
        double weightBrutto = scanner.nextDouble();
        System.out.println("Jaki kontener chcesz stworzyć:");
        System.out.println("1. Podstawowy");
        System.out.println("2. Ciężki");
        System.out.println("3. Chłodniczy");
        System.out.println("4. kontener na materiały ciekłe");
        System.out.println("6. kontener na materiały wybuchowe");
        System.out.println("6. kontener na materiały toksyczne");
        System.out.print("Wpisz cyfrę odpowiadającą opcji: ");
        int y = scanner.nextInt();
        switch (y){
            case 1:
                BasicContainer bc = new BasicContainer(weightNetto, weightBrutto);
                return bc;
            default:
                BasicContainer bs = new BasicContainer(weightNetto, weightBrutto);
                return bs;
        }

    }
}
