package com.company;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
