package ru.kuznetsovka.ideatest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
@Getter
@Setter
public class Wrapper {

   @JsonProperty("tickets")
   private Collection<JsonEntity> tickets;
}