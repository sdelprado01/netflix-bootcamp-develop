package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.SeasonRequestRest;

public interface SeasonService {

	List<SeasonRequestRest> getSeasonsByTvShow(Long tvShowId) throws NetflixException;

	SeasonRequestRest getSeasonByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber) throws NetflixException;

}
