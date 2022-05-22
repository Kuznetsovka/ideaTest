package ru.kuznetsovka.ideatest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class JsonEntity {
    private String origin;
    @JsonProperty("origin_name")
    private String originName;
    private String destination;
    @JsonProperty("destination_name")
    private String destinationName;
    @JsonProperty("departure_date")
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy")
    private LocalDate departureDate;
    @JsonProperty("departure_time")
    private String departureTime;
    @JsonProperty("arrival_date")
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy")
    private LocalDate arrivalDate;
    @JsonProperty("arrival_time")
    private String arrivalTime;
    private String carrier;
    private int stops;
    private int price;
    private Duration duration;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;

    public Duration getDuration() {
        return  Duration.between(departureDateTime, arrivalDateTime);
    }
}

