package main;

import java.util.ArrayList;

public class Boala {
    private String nume;


    public String getNume() {
        return nume;
    }


    public void setNume(String nume) {
        this.nume = nume;
    }


    public Boala(String nume) {
        this.nume = nume;

    }

    @Override
    public String toString() {
        return "Boala{" +
                "nume='" + nume + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boala)) return false;

        Boala boala = (Boala) o;

        return getNume() != null ? getNume().equals(boala.getNume()) : boala.getNume() == null;
    }


}
