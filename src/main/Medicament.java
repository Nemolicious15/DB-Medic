package main;

public class Medicament {
    private String nume;
    private int id;
    private Boala bol;

    public String getNume() {
        return nume;
    }

    public int getId() {
        return id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medicament(String nume, int id, Boala bol) {
        this.nume = nume;
        this.id = id;
        this.bol = bol;
    }

    public Boala getBol() {
        return bol;
    }

    public void setBol(Boala bol) {
        this.bol = bol;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "nume='" + nume + '\'' +
                ", id=" + id +
                ", bol=" + bol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicament)) return false;

        Medicament that = (Medicament) o;

        if (getId() != that.getId()) return false;
        if (getNume() != null ? !getNume().equals(that.getNume()) : that.getNume() != null) return false;
        return getBol() != null ? getBol().equals(that.getBol()) : that.getBol() == null;
    }

}
