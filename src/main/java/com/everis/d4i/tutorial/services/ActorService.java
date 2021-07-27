package com.everis.d4i.tutorial.services;

import java.util.List;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.response.ActorResponseRest;



public interface ActorService {

    List<ActorResponseRest> getActors() throws NetflixException;

}
