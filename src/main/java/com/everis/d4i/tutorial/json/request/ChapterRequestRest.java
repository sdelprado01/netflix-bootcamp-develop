package com.everis.d4i.tutorial.json.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ChapterRequestRest implements Serializable {

	private static final long serialVersionUID = 8725949484031409482L;

	private Long id;
	private short number;
	private String name;
	private short duration;
	private List<Long> actors;
}
