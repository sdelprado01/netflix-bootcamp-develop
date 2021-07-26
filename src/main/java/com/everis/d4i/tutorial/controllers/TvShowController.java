package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.TvShowResponseRest;
import com.everis.d4i.tutorial.json.TvShowRequestRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface TvShowController {

	NetflixResponse<List<TvShowResponseRest>> getTvShowsByCategory(Long categoryId) throws NetflixException;

	NetflixResponse<TvShowResponseRest> getTvShowById(Long id) throws NetflixException;

	NetflixResponse<TvShowResponseRest> createTvShow(TvShowRequestRest tvShowRequestRest) throws NetflixException;

	NetflixResponse<TvShowResponseRest> updateCategoriesFromTvShow(Long id, List<Long> categoriesId) throws  NetflixException;
}
