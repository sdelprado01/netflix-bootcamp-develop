package com.everis.d4i.tutorial.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;
import java.util.List;

@Entity
@Table(name = "ACTORS")
@Data
public class Actor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTH_YEAR")
    private Year birthYear;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "CHAPTERS_ACTORS",
            joinColumns = {@JoinColumn(name = "ACTOR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CHAPTER_ID")}
    )
    private List<Chapter> chapters;
}
