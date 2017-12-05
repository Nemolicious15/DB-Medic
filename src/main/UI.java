package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UI {
    private Controller con;

    public Controller getCon() {
        return con;
    }

    public void setCon(Controller con) {
        this.con = con;
    }

    public UI(Controller con) {
        this.con = con;
    }

   public int citireNumar(){
        int n;
        try{
            Scanner as = new Scanner(System.in);
            n= as.nextInt();
        }
        catch (Exception e){
            System.out.println("Input incorect!");
            n= citireNumar();
        }
        return n;
   }

   public String citireString(){
       String n;
       try{
           Scanner as = new Scanner(System.in);
           n= as.next();
       }
       catch (Exception e){
           System.out.println("Input incorect!");
           n= citireString();
       }
       return n;

   }

   public Date citireData(){
       Date date= new Date();
       String n =citireString();

       try{
           DateFormat form = new SimpleDateFormat("dd mm yyyy");

           date = form.parse(n);
       }
       catch(ParseException e){
           System.out.println("Input incorect!");
           date= citireData();
       }


       return date;
   }

   public void addPacient(){
       System.out.println("Se citeste numele pacientului:");
       String nume= citireString();
       System.out.println("Se citeste prenumele pacientului:");
       String prenume= citireString();
       System.out.println("Se citeste adresa pacientului:");
       String adresa = citireString();
       System.out.println("Se citeste data consultatiei pacientului:");
       Date date= citireData();
       int n=citireNumar();
       System.out.println("Se citesc medicamentele pacientului:");
       ArrayList<Integer> meds = new ArrayList<Integer>();

       int x;
       for(int i=0;i<n;i++){
           while(true){
               x= citireNumar();
               if(x>0 & x<con.getRm().getMeds().size() & !meds.contains(x)) break;
               else System.out.println("Input incorect!");
           }
           meds.add(x);
       }
       System.out.println("Se citeste varsta pacientului:");
       int age;
       while(true){
           age= citireNumar();
           if(age>0) break;
           else System.out.println("Input incorect!");
       }
       con.addPac(nume,prenume,adresa,date,meds,age);
   }

   public void addMedicament(){
       System.out.println("Se citeste numele medicamentului:");
       String nume= citireString();
       System.out.println("Se citeste ID-ul medicamentului:");
       int id;
       while(true){
           id= citireNumar();
           if(id>0) break;
           else System.out.println("Input incorect!");
       }
       System.out.println("Se citeste boala pentru care se prescrie medicamentul:");
       String numeb= citireString();

       con.addMed(nume,id,numeb);
   }
   public void ModificaNume(){
       int i;
       System.out.println("Se citeste numarul pacientului:");
       while(true){
           i= citireNumar();
           if(i>0 & i<con.getRp().getPacienti().size()) break;
           else System.out.println("Input incorect!");
       }
       System.out.println("Se introduce noul nume:");
       String nume = citireString();
       con.updateNume(i,nume);

   }
   public void ModificaLista(){
       System.out.println("Se cisteste nr pacientului:");
       int j=citireNumar();
       System.out.println("Se citeste noul nr de medicamente al persoanei:");
       int n= citireNumar();
       System.out.println("Se citesc ID-urile medicamentelor din noua lista:");
       ArrayList<Integer> meds = new ArrayList<Integer>();

       int x;
       for(int i=0;i<n;i++){
           while(true){
               x= citireNumar();
               if(x>0 & x<con.getRm().getMeds().size() & !meds.contains(x)) break;
               else System.out.println("Input incorect!");
           }
           meds.add(x);
       }
       con.updateMedList(j,meds);
   }
   public void ModificaPrenume(){
       int i;
       System.out.println("Se citeste numarul pacientului:");
       while(true){
           i= citireNumar();
           if(i>0 & i<con.getRp().getPacienti().size()) break;
           else System.out.println("Input incorect!");
       }
       System.out.println("Se introduce noul prenume:");
       String prenume = citireString();
       con.updatePrenume(i,prenume);

   }
    public void ModificaAdresa(){
        int i;
        System.out.println("Se citeste numarul pacientului:");
        while(true){
            i= citireNumar();
            if(i>0 & i<con.getRp().getPacienti().size()) break;
            else System.out.println("Input incorect!");
        }
        System.out.println("Se introduce noua adresa:");
        String adresa = citireString();
        con.updateAdresa(i,adresa);

    }
    public void ModificaVarsta(){
        int i;
        System.out.println("Se citeste numarul pacientului:");
        while(true){
            i= citireNumar();
            if(i>0 & i<con.getRp().getPacienti().size()) break;
            else System.out.println("Input incorect!");
        }
        System.out.println("Se introduce noua varsta:");
        int age = citireNumar();
        con.updateAge(i,age);

    }


    public void AlfabeticP(){
       con.getRp().sortPacientiNume();
       for(int i=0;i<con.getRp().getPacienti().size();i++){
           System.out.printf("%-10s%-10s%%-10s%%-10s%%-10s",con.getRp().getPacient(i).getNume(),
                   con.getRp().getPacient(i).getPrenume(),
                   con.getRp().getPacient(i).getAdresa(),
                   con.getRp().getPacient(i).getData(),
                   con.getRp().getPacient(i).getAge()
                   );
       }
    }
    public void UltimaLuna(){
        Date d= con.getRp().maxLuna();
        for(int i=0;i<con.getRp().getPacienti().size();i++){
            if(con.getRp().getPacient(i).getData().getMonth()==d.getMonth())
            System.out.printf("%-10s%-10s%%-10s%%-10s%%-10s",con.getRp().getPacient(i).getNume(),
                    con.getRp().getPacient(i).getPrenume(),
                    con.getRp().getPacient(i).getAdresa(),
                    con.getRp().getPacient(i).getData(),
                    con.getRp().getPacient(i).getAge()
            );
        }
    }
    public void totPacient(){
        System.out.println("Introduceti nr persoanei dorite:");
        int i;
        while(true){
            i= citireNumar();
            if(i>0 & i<con.getRp().getPacienti().size()) break;
            else System.out.println("Input incorect!");
        }
        System.out.printf(con.getRp().getPacient(i).toString());
    }

    public void lunaAnume(){
        System.out.println("Introduceti data:");
        Date d= citireData();
        for(int i=0;i<con.getRp().getPacienti().size();i++){
            if(con.getRp().getPacient(i).getData().getMonth()!=d.getMonth())
                System.out.printf("%-10s%-10s%%-10s%%-10s%%-10s",con.getRp().getPacient(i).getNume(),
                        con.getRp().getPacient(i).getPrenume(),
                        con.getRp().getPacient(i).getAdresa(),
                        con.getRp().getPacient(i).getData(),
                        con.getRp().getPacient(i).getAge()
                );
        }
    }
    public long AfisMeniu(){
        System.out.println();
        System.out.println("1.Tabela cu pacientii, ordonata alfabetic dupa nume");
        System.out.println("2.Tabelă cu pacienţii ce au fost consultaţi în ultima lună");
        System.out.println("3.Tabelă pentru un pacient dat, cu toate bolile şi medicamentele prescrise (rezultate din consultaţii)");
        System.out.println("4.Tabelă cu pacienţii ce nu au fost consultaţi în luna respectivă");
        System.out.println("5.Tabelă cu toţi pacienţii clasificaţi pe categorii de vârstă (0-1, 2-4, 5-10, 11-18, 19-59 şi peste 60),");
        System.out.println("0.terminare program");
        System.out.println("Optiunea dvs:");
        long Opt= citireNumar();
        return Opt;
    }
    public  void main(String args[]){
        long Op= AfisMeniu();
        while(Op!=0){
            switch((int)Op) {
                case 1: AlfabeticP();
                    break;
                case 2: UltimaLuna();
                    break;
                case 3: //totPacient();
                    break;
                case 4: lunaAnume();
                    break;
                case 5: //
                    break;

                default:
                    System.out.println("Ai gresit optiunea, mai incearca");
            }
            Op=AfisMeniu();
        }
        System.out.println("Program terminat");
    }
}
