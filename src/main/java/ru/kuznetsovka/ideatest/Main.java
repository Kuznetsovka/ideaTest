package ru.kuznetsovka.ideatest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;


import java.io.File;
import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;

import static ru.kuznetsovka.ideatest.TimeService.*;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        File file = new File("src/main/resources/tickets.json");
        Wrapper wrapper = mapper.readValue(file, Wrapper.class);
        // В данном примере не обязательно, но требуется если дата прилета и отлета отличается
        wrapper.getTickets().forEach(TimeService::combineDateTime);
        Long averageTime = wrapper.getTickets().stream()
                .map(JsonEntity::getDuration)
                .collect(Collectors.averagingLong(Duration::toMinutes)).longValue();

        System.out.println("Среднее время перелета:" + convertMinuteToStringFormat(averageTime));
        Set<Long> durationArr = wrapper.getTickets().stream().map(JsonEntity::getDuration).map(Duration::toMinutes).collect(Collectors.toSet());
        System.out.println("90 перцентиль времени перелета:" + convertMinuteToStringFormat(getPercentileTime(durationArr,90)));
    }


}
