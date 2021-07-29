package com.everis.d4i.tutorial.json.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SeasonResponseRest implements Serializable {

    private static final long serialVersionUID = 180802329613616000L;

    private Long id;
    private short number;
    private String name;
}
