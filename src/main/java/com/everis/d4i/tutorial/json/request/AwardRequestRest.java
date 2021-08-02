package com.everis.d4i.tutorial.json.request;

import com.everis.d4i.tutorial.entities.TvShow;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AwardRequestRest implements Serializable {

    private Long id;
    private String name;
    private List<Long> tvShows;
}
