package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.entities.TvShow;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.TvShowResponseRest;
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface TvShowController {

	NetflixResponse<List<TvShowResponseRest>> getTvShowsByCategory(Long categoryId) throws NetflixException;

	NetflixResponse<TvShowResponseRest> getTvShowById(Long id) throws NetflixException;

	NetflixResponse<TvShowResponseRest> createTvShow(TvShowRest tvShowRest) throws NetflixException;
}
