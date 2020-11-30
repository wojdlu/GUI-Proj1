package com.pjatk.proj1;

public class Sender {
    private String name;
    private String surname;
    private String address;
    private String birthDate;
    private int pesel;
    private int warningNumber = 0;

    public Sender(String name, String surname, String address, String birthDate, int pesel) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.birthDate = birthDate;
        this.pesel = pesel;
    }

    public Sender(String name, String surname, String address, String birthDate, int pesel, int warningNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.birthDate = birthDate;
        this.pesel = pesel;
        this.warningNumber = warningNumber;
    }

    public void warn() {
        warningNumber++;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Sender{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", pesel=" + pesel +
                ", warningNumber=" + warningNumber +
                '}';
    }

    public String toFile() {
        return "Sender:" +
                     name +
                ";" + surname +
                ";" + address +
                ";" + birthDate +
                ";" + pesel +
                ";" + warningNumber;
    }


}
