package com.impanfilov.bars.model;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contract implements Serializable {

    Integer id;
    String number;
    LocalDateTime date;
    LocalDateTime dateLastModified;
    Boolean relevance;

    @JsonCreator
    public Contract(@JsonProperty("id") Integer id,
                    @JsonProperty("number")  String number,
                    @JsonProperty("date") ZonedDateTime date,
                    @JsonProperty("dateLastModified")  ZonedDateTime dateLastModified) {
        this.id = id;
        this.number = number;
        this.date = date.toLocalDateTime();
        this.dateLastModified = dateLastModified.toLocalDateTime();
        this.relevance =dateLastModified.isAfter(ZonedDateTime.now().minusDays(60));
    }

}

