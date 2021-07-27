package com.everis.d4i.tutorial.controllers;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.response.ActorResponseRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import java.util.List;

public interface ActorController {

    NetflixResponse<List<ActorResponseRest>> getActors() throws NetflixException;
}
