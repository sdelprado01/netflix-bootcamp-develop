package com.everis.d4i.tutorial.json.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AwardResponseRest implements Serializable {

    private Long id;
    private String name;
}
