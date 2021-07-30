package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.request.SeasonRequestRest;
import com.everis.d4i.tutorial.json.response.SeasonResponseRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface SeasonController {

	NetflixResponse<List<SeasonResponseRest>> getSeasonsByTvShow(Long tvShowId) throws NetflixException;

	NetflixResponse<SeasonResponseRest> getSeasonByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber)
			throws NetflixException;

}
