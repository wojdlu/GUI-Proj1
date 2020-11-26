package com.pjatk.proj1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Port port = new Port();
        while(true){
            int x = menu();
            if(x==6)
                break;
            switch (x){
                case 1:
                    port.addShip(newShip());
                    break;
                case 2:
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
}
