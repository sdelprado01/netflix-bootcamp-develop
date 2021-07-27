package com.everis.d4i.tutorial.json.response;

import com.everis.d4i.tutorial.entities.Chapter;
import com.everis.d4i.tutorial.json.request.ChapterRequestRest;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.Year;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorResponseRest implements Serializable {


    private Long id;
    private String name;
    private Year birthYear;
    private List<ChapterRequestRest> chapters;

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

    public Year getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Year birthYear) {
        this.birthYear = birthYear;
    }

    public List<ChapterRequestRest> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterRequestRest> chapters) {
        this.chapters = chapters;
    }
}
