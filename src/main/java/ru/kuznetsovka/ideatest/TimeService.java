package ru.kuznetsovka.ideatest;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class TimeService {
    public static void combineDateTime(JsonEntity ticket){
        String[] departureTimes = ticket.getDepartureTime().split(":");
        String[] arrivalTimes = ticket.getArrivalTime().split(":");
        ticket.setDepartureDateTime(
                ticket.getDepartureDate().atTime(parseInt(departureTimes[0]),parseInt(departureTimes[1])));
        ticket.setArrivalDateTime(
                ticket.getArrivalDate().atTime(parseInt(arrivalTimes[0]),parseInt(arrivalTimes[1])));
    }
    public static String convertMinuteToStringFormat(Long minute) {
        return LocalTime.MIN.plus(
                Duration.ofMinutes(minute)
        ).toString();
    }

    public static long getPercentileTime(Set<Long> minutes, double percentile){
        List<Long> list = new ArrayList<>(minutes);
        int index = (int)Math.ceil((percentile / (double) 100) * (double)list.size());
        return list.get(index - 1);
    }
}
