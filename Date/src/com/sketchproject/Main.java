package com.sketchproject;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws ParseException {
        String bell = "08:00:00";
        String homework = "01:00:00";
        String sleep = "08:00:00";
        String pray = "00:10:00";
        String workout = "00:15:00";
        String shower = "00:15:00";
        String breakfast = "00:15:00";
        String school = "00:30:00";

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date timeBell = dateFormat.parse(bell);
        Date timeHomework = dateFormat.parse(homework);
        Date timeSleep = dateFormat.parse(sleep);
        Date timePray = dateFormat.parse(pray);
        Date timeWorkout = dateFormat.parse(workout);
        Date timeShower = dateFormat.parse(shower);
        Date timeBreakfast = dateFormat.parse(breakfast);
        Date timeSchool = dateFormat.parse(school);

        long difference = timeBell.getTime() - timePray.getTime();

        String hms2 = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(difference),
                TimeUnit.MILLISECONDS.toMinutes(difference) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(difference) % TimeUnit.MINUTES.toSeconds(1));

        System.out.println(hms2);

        System.out.println("Alarm List:");

        DateTime bellRinging = new DateTime(2016, 8, 10, 7, 0);
        System.out.println(bellRinging.toString("HH:mm"));

        DateTime alarmSchool = bellRinging.minusHours(0).minusMinutes(30);
        System.out.println(alarmSchool.toString("HH:mm"));

        DateTime alarmBreakfast = alarmSchool.minusHours(0).minusMinutes(15);
        System.out.println(alarmBreakfast.toString("HH:mm"));

        DateTime alarmShower = alarmBreakfast.minusHours(0).minusMinutes(15);
        System.out.println(alarmShower.toString("HH:mm"));

        DateTime alarmWorkout = alarmShower.minusHours(0).minusMinutes(15);
        System.out.println(alarmWorkout.toString("HH:mm"));

        DateTime alarmPray = alarmWorkout.minusHours(0).minusMinutes(10);
        System.out.println(alarmPray.toString("HH:mm"));

        DateTime alarmSleep = alarmPray.minusHours(8).minusMinutes(0);
        System.out.println(alarmSleep.toString("HH:mm"));

        DateTime alarmHomework = alarmSleep.minusHours(1).minusMinutes(0);
        System.out.println(alarmHomework.toString("HH:mm"));
    }
}
