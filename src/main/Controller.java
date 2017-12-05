package main;

import java.util.ArrayList;
import java.util.Date;

public class Controller {
    private RepoMedicament rm;
    private RepoPacient rp;

    public RepoMedicament getRm() {
        return rm;
    }

    public void setRm(RepoMedicament rm) {
        this.rm = rm;
    }

    public RepoPacient getRp() {
        return rp;
    }

    public void setRp(RepoPacient rp) {
        this.rp = rp;
    }

    public Controller(RepoMedicament rm, RepoPacient rp) {

        this.rm = rm;
        this.rp = rp;
    }
    public void addMed(String nume, int id, String boala){
        rm.addMedicament(nume,id,boala);
    }
    public void removeMed(int i){
        rm.removeMedicament(i);
    }
    public void addPac(String nume, String prenume, String adresa, Date data, ArrayList<Integer> ints,int age){
        rp.addPacient(nume,prenume,adresa,data,rm.getMedsAt(ints),age);
    }
    public void removePac(int i){
        rp.removePacient(i);
    }

    public void updateNume(int i, String nume){
        rp.getPacienti().get(i).setNume(nume);
    }
    public void updatePrenume(int i, String prenume){
        rp.getPacienti().get(i).setPrenume(prenume);
    }
    public void updateAdresa(int i,String adresa){
        rp.getPacienti().get(i).setAdresa(adresa);
    }
    public void updateData(int i, Date data){
        rp.getPacienti().get(i).setData(data);
    }
    public void updateMedList(int i,ArrayList<Integer> ints){
        rp.getPacienti().get(i).setMeds(rm.getMedsAt(ints));
    }
    public void updateAge(int i,int age){
        rp.getPacienti().get(i).setAge(age);
    }
}
