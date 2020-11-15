package com.company;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class TrainFactory {
   private static final String[] CITIES = {"Lutsk", "Kiev", "Lviv", "Harkiv", "Odessa", "Dnipro", "Ivano-Frankivsk", "Ternopyl"};

    static Train Create() {
        Train train = new Train();
        Seats seats = new Seats();
        Date date = new Date();
        date.setHours((int) (Math.random() * 24) );
        date.setMinutes((int) (Math.random() * 60) );
        seats.setCommon ( (int) (Math.random() * 10) );
        seats.setCoupe( (int) (Math.random() * 50) );
        seats.setLux( (int) (Math.random() * 10) );
        seats.setReserved ( (int) (Math.random() * 60) );
        train.setSeats(seats);
        train.setTime(date);
        train.setGoal( CITIES[ (int) (Math.random() * CITIES.length) ] );
        return train;
    }
}
class Seats{
    private int common;
    private int coupe;
    private int reserved;
    private int lux;

    public int getCommon() {
        return common;
    }

    public void setCommon(int common) {
        this.common = common;
    }
    public int getCoupe(){
        return coupe;
    }
    public void setCoupe(int coupe) {
        this.coupe = coupe;
    }
    public int getReserved(){
        return reserved;
    }
    public void setReserved(int reserved) {
        this.reserved = reserved;
    }
    public int getLux(){
        return reserved;
    }
    public void setLux(int lux) {
        this.lux = lux;
    }
}
class Train{
    private String goal;
    private Date depart;
    private Seats seats;

    public void setGoal(String goal){
        this.goal = goal;
    }
    public String getGoal(){return goal;}
    public Date getTime(){return depart;}
    public void setTime(Date depart){this.depart = depart;}
    public Seats getSeats(){return seats;};
    public void setSeats(Seats seats){this.seats = seats;}
    public boolean isAfter(Date af){
        return depart.after(af);
    }
    public boolean isFree(){
        if (seats.getCommon()!=0){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Потяг прямує до " + goal + "|" + depart.getHours() + ":" + depart.getMinutes() + "|Загальні:" + seats.getCommon()+
                "|Купе:"+seats.getCoupe()+"|Плацкарт:"+seats.getReserved()+"|Люкс"+seats.getLux();
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Train> arr = new ArrayList<Train>();
        System.out.println("Введіть кількість поїздів:");
        int len = in.nextInt();
        for(int i = 0;i<len;i++){
            arr.add(TrainFactory.Create());
            System.out.println(arr.get(i).toString());
        }
        System.out.println("Введіть бажаний пункт призначення:");
        in.nextLine();
        String goal = in.nextLine();
        boolean f = false;
        for (Train a:arr) {
            if(a.getGoal().equals(goal)) {
                System.out.println(a.toString());
                f = true;
            }
        }
        if(!f)System.out.println("Не знайдено підходящих потягів.");
        int h,m;
        String numbers[];
        while(true) {
            System.out.println("Введіть час після якого повинна бути відправка(HH:MM):");
                numbers = in.nextLine().split(":");
                h = Integer.parseInt(numbers[0]);
                m = Integer.parseInt(numbers[1]);
             if(h<0||h>23||m<0||m>60) continue;
             else break;
        }
        Date dep = new Date();
        dep.setHours(h);
        dep.setMinutes(m);
        f = false;
        for (Train a:arr) {
            if(a.getGoal().equals(goal) && a.isAfter(dep)) {
                System.out.println(a.toString());
                f = true;
            }
        }
        if(!f)System.out.println("Не знайдено підходящих потягів");
        f = false;
        System.out.println("Потяги з вільними загальними місцями:");
        for (Train a:arr) {
            if(a.getGoal().equals(goal)&&a.isAfter(dep)&&a.isFree()) {
                System.out.println(a.toString());
                f = true;
            }
        }
        if(!f)System.out.println("Не знайдено.");
    }
}
