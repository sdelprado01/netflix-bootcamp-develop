package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.SeasonRequestRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface SeasonController {

	NetflixResponse<List<SeasonRequestRest>> getSeasonsByTvShow(Long tvShowId) throws NetflixException;

	NetflixResponse<SeasonRequestRest> getSeasonByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber)
			throws NetflixException;

}
