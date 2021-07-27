package com.everis.d4i.tutorial.controllers;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.request.ActorRequestRest;
import com.everis.d4i.tutorial.json.response.ActorResponseRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

import java.time.Year;
import java.util.List;

public interface ActorController {

    NetflixResponse<List<ActorResponseRest>> getActors() throws NetflixException;

    NetflixResponse<ActorResponseRest> getActorById(Long id) throws NetflixException;

    NetflixResponse<ActorResponseRest> createActor(ActorRequestRest actorRequestRest) throws NetflixException;

    NetflixResponse<ActorResponseRest> updateActorNameById(Long id, String name) throws NetflixException;

    NetflixResponse<ActorResponseRest> updateActorBirthYearById(Long id, Year year) throws NetflixException;

    NetflixResponse<ActorResponseRest> updateActorChaptersById(Long id, List<Long> chaptersId) throws NetflixException;

    NetflixResponse<List<ActorResponseRest>> deleteActorById(Long id) throws NetflixException;
}
