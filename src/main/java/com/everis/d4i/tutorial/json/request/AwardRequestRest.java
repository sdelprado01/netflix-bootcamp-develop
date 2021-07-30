package com.everis.d4i.tutorial.json.request;

import com.everis.d4i.tutorial.entities.TvShow;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AwardRequestRest implements Serializable {

    private Long id;
    private String name;
    private List<Long> tvShows;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getTvShows() {
        return tvShows;
    }

    public void setTvShows(List<Long> tvShows) {
        this.tvShows = tvShows;
    }
}
