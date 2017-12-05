package main;

import java.util.ArrayList;
import java.util.Date;

public class RepoPacient {
    private ArrayList<Pacient> pacienti;

    public ArrayList<Pacient> getPacienti() {
        return pacienti;
    }

    public void setPacient(ArrayList<Pacient> pacienti) {
        this.pacienti = pacienti;
    }

    public RepoPacient(ArrayList<Pacient> pacienti) {
        this.pacienti = pacienti;
    }

    public Pacient getPacient(int i){
        return pacienti.get(i);
    }

    public void addPacient(String nume, String prenume, String adresa, Date data, ArrayList<Medicament> meds, int age){
        pacienti.add(new Pacient(nume,prenume,adresa,data,meds,age));
    }
    public void removePacient(int i){
        pacienti.remove(i);
    }

    public void sortPacientiNume(){
        Pacient aux;
        for(int i=0; i<pacienti.size();i++)
            for(int j=i+1; j<pacienti.size();j++){
                if (pacienti.get(i).getNume().compareTo(pacienti.get(j).getNume())>0) {
                    aux= pacienti.get(i);
                    pacienti.set(i,pacienti.get(j));
                    pacienti.set(j,aux);
                }
            }
    }
    public Date maxLuna(){
        int n=0;
        for(int i=1;i<pacienti.size();i++){
            if(pacienti.get(n).getData().compareTo(pacienti.get(i).getData())<0) {
                n=i;
            }
        }
        return pacienti.get(n).getData();

    }

}
