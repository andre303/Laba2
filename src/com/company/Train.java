package com.company;

import java.util.Date;

public class Train {
    private String goal;
    private Date depart;
    private Seats seats;

    public void setGoal(String goal){
        this.goal = goal;
    }
    public String getGoal(){return goal;}
    public Date getTime(){return depart;}
    public void setTime(Date depart){this.depart = depart;}
    public Seats getSeats(){return seats;}
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
