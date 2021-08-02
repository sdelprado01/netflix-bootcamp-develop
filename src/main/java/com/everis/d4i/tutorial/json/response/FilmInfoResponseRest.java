package com.everis.d4i.tutorial.json.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class FilmInfoResponseRest implements Serializable {

    private String longDescription;
    private String name;
    private double rate;
    private String shortDescription;
}
