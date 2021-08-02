package com.everis.d4i.tutorial.json.request;

import com.everis.d4i.tutorial.entities.Chapter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.Year;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ActorRequestRest implements Serializable {

    private Long id;
    private String name;
    private Year birthYear;
    private List<Long> chapters;

}
