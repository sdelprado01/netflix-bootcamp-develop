package com.everis.d4i.tutorial.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORIES")
public class Category implements Serializable {

	private static final long serialVersionUID = 180802329613616000L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", unique = true)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	private List<TvShow> tvShows;

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

	public List<TvShow> getTvShows() {
		return tvShows;
	}

	public void setTvShows(List<TvShow> tvShows) {
		this.tvShows = tvShows;
	}

}
