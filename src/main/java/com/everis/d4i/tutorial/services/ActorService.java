package com.everis.d4i.tutorial.services;

import java.time.Year;
import java.util.List;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.request.ActorRequestRest;
import com.everis.d4i.tutorial.json.response.ActorResponseRest;



public interface ActorService {

    List<ActorResponseRest> getActors() throws NetflixException;

    ActorResponseRest getActorById(Long id) throws NetflixException;

    ActorResponseRest createActor(ActorRequestRest actorRequestRest) throws NetflixException;

    ActorResponseRest updateActorNameById(Long id, String name) throws NetflixException;

    ActorResponseRest updateActorBirthYearById(Long id, Year birthYear) throws NetflixException;

    ActorResponseRest updateActorChaptersById(Long id, List<Long> chaptersId) throws NetflixException;

}
