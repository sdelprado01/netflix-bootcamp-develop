package com.everis.d4i.tutorial.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORIES")
@Data
public class Category implements Serializable {

	private static final long serialVersionUID = 180802329613616000L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", unique = true)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	private List<TvShow> tvShows;
}
