package com.everis.d4i.tutorial.json.response;

import com.everis.d4i.tutorial.json.request.CategoryRequestRest;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.Year;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
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
    private List<ChapterResponseRest> chapters;
    private Double rating;
}


