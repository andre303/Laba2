package com.company;

import java.util.Date;

public class TrainFactory {
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
