package ru.kuznetsovka.ideatest;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

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

    public static long getPercentileTime(List<Long> minutes, double percentile){
        minutes.sort(Comparator.naturalOrder());
        int index = (int)Math.ceil((percentile / (double) 100) * (double)minutes.size());
        return minutes.get(index - 1);
    }
}
