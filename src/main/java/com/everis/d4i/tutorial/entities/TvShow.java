package com.everis.d4i.tutorial.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.io.Serializable;
import java.time.Year;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TV_SHOWS")
@Data
public class TvShow implements Serializable {

	private static final long serialVersionUID = 4916713904971425156L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", unique = true)
	private String name;

	@Column(name = "SHORT_DESC", nullable = true)
	private String shortDescription;

	@Column(name = "LONG_DESC", nullable = true)
	private String longDescription;

	@Column(name = "YEAR")
	private Year year;

	@Column(name = "RECOMMENDED_AGE")
	private byte recommendedAge;

	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "CATEGORIES_TV_SHOWS",
			joinColumns = {@JoinColumn(name = "TV_SHOW_ID")},
			inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID")}
	)
	private List<Category> categories;

	@Column(name = "ADVERTISING", nullable = true)
	private String advertising;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tvShow", orphanRemoval = true)
	private List<Season> seasons;

	@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "TV_SHOWS_AWARDS",
			joinColumns = {@JoinColumn(name = "TV_SHOW_ID")},
			inverseJoinColumns = {@JoinColumn(name = "AWARD_ID")}
	)
	private List<Award> awards;
}
