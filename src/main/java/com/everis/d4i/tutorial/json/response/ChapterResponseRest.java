package com.everis.d4i.tutorial.json.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChapterResponseRest implements Serializable {

    private static final long serialVersionUID = 8725949484031409482L;

    private Long id;
    private short number;
    private String name;
    private short duration;
    private List<ActorResponseRest> actors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public List<ActorResponseRest> getActors() {
        return actors;
    }

    public void setActors(List<ActorResponseRest> actors) {
        this.actors = actors;
    }
}
