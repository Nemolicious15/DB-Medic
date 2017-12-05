package main;

import java.util.ArrayList;

public class RepoMedicament {

    private ArrayList<Medicament> meds;

    public ArrayList<Medicament> getMeds() {
        return meds;
    }

    public void setMeds(ArrayList<Medicament> meds) {
        this.meds = meds;
    }

    public RepoMedicament(ArrayList<Medicament> meds) {
        this.meds = meds;
    }

    public Medicament getMedicament(int i){
        return meds.get(i);
    }

    public void addMedicament(String nume, int id, String numeb){
        meds.add(new Medicament(nume,id,new Boala(numeb)));
    }

    public void removeMedicament(int i){
        meds.remove(i);
    }
    public ArrayList<Medicament> getMedsAt(ArrayList<Integer> ints){
       ArrayList<Medicament> medi= new ArrayList<Medicament>();

       for(int i=0; i<meds.size();i++){
           for(int j=0; j<ints.size();j++){
               if(i==j) medi.add(meds.get(i));
           }
       }
       return medi;
    }
}
