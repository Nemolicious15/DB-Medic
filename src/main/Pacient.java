package main;

import java.util.ArrayList;
import java.util.Date;

public class Pacient {
    private String nume;
    private String prenume;
    private String adresa;
    private Date data;
    private ArrayList<Medicament> meds;
    private int age;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<Medicament> getMeds() {
        return meds;
    }

    public void setMeds(ArrayList<Medicament> meds) {
        this.meds = meds;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Pacient(String nume, String prenume, String adresa, Date data, ArrayList<Medicament> meds, int age) {
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.data = data;
        this.meds = meds;
        this.age=age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pacient)) return false;

        Pacient pacient = (Pacient) o;

        if (getNume() != null ? !getNume().equals(pacient.getNume()) : pacient.getNume() != null) return false;
        if (getPrenume() != null ? !getPrenume().equals(pacient.getPrenume()) : pacient.getPrenume() != null)
            return false;
        if (getAdresa() != null ? !getAdresa().equals(pacient.getAdresa()) : pacient.getAdresa() != null) return false;
        if (getData() != null ? !getData().equals(pacient.getData()) : pacient.getData() != null) return false;
        return getMeds() != null ? getMeds().equals(pacient.getMeds()) : pacient.getMeds() == null;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", data=" + data +
                ", meds=" + meds +
                ", age=" + age +
                '}';
    }
}
