package com.everis.d4i.tutorial.json.response;

import com.everis.d4i.tutorial.json.request.CategoryRequestRest;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.Year;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TvShowResponseRest implements Serializable {

    private static final long serialVersionUID = 4916713904971425156L;

    private Long id;
    private String name;
    private String shortDescription;
    private String longDescription;
    private Year year;
    private byte recommendedAge;
    private List<CategoryResponseRest> categories;
    private String advertising;
    //private List<AwardResponseRest> awards;
    private List<ChapterResponseRest> chapters;

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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public byte getRecommendedAge() {
        return recommendedAge;
    }

    public void setRecommendedAge(byte recommendedAge) {
        this.recommendedAge = recommendedAge;
    }

    public List<CategoryResponseRest> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryResponseRest> categories) {
        this.categories = categories;
    }

    public String getAdvertising() {
        return advertising;
    }

    public void setAdvertising(String advertising) {
        this.advertising = advertising;
    }

    /*
    public List<AwardResponseRest> getAwards() {
        return awards;
    }

    public void setAwards(List<AwardResponseRest> awards) {
        this.awards = awards;
    }

     */

    public List<ChapterResponseRest> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterResponseRest> chapters) {
        this.chapters = chapters;
    }
}


