package com.pjatk.proj1;

public class Sender {
    private String name;
    private String surname;
    private String address;
    private String birthDate;
    private int pesel;

    public Sender(String name, String surname, String address, String birthDate, int pesel) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.birthDate = birthDate;
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Sender{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", pesel=" + pesel +
                '}';
    }
}
