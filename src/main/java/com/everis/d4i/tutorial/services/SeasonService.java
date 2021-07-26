package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.request.SeasonRequestRest;
import com.everis.d4i.tutorial.json.response.SeasonResponseRest;

public interface SeasonService {

	List<SeasonResponseRest> getSeasonsByTvShow(Long tvShowId) throws NetflixException;

	SeasonResponseRest getSeasonByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber) throws NetflixException;

}
