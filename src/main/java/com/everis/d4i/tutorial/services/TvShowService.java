package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.response.AwardResponseRest;
import com.everis.d4i.tutorial.json.response.TvShowResponseRest;
import com.everis.d4i.tutorial.json.request.TvShowRequestRest;

public interface TvShowService {

	List<TvShowResponseRest> getTvShowsByCategory(Long categoryId) throws NetflixException;

	TvShowResponseRest getTvShowById(Long id) throws NetflixException;

	TvShowResponseRest createTvShow(TvShowRequestRest tvShowRequestRest) throws NetflixException;

	TvShowResponseRest updateCategoriesFromTvShow(Long id, List<Long> categoriesId) throws NetflixException;

	TvShowResponseRest updateNameFromTvShow(Long id, String name) throws NetflixException;

	List<TvShowResponseRest> deleteTvShowById(Long id) throws NetflixException;

}
