package com.everis.d4i.tutorial.json.response;

import com.everis.d4i.tutorial.entities.Chapter;
import com.everis.d4i.tutorial.json.request.ChapterRequestRest;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.Year;
import java.util.List;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ActorResponseRest implements Serializable {


    private Long id;
    private String name;
    private Year birthYear;
    private List<TvShowResponseRest> tvShows;
}
