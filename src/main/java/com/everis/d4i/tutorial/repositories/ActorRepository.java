package com.everis.d4i.tutorial.repositories;

import com.everis.d4i.tutorial.entities.Actor;
import com.everis.d4i.tutorial.entities.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    List<Actor> findByChaptersId(List<Long> chapterIdList);
}
