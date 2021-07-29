package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.response.ActorResponseRest;
import com.everis.d4i.tutorial.json.response.AwardResponseRest;

import java.util.List;

public interface AwardService {

    List<AwardResponseRest> getAwards() throws NetflixException;

    List<AwardResponseRest> getAwardsByTvShowId(Long tvShowId) throws NetflixException;
}
