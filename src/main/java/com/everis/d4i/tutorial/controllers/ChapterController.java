package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.request.ChapterRequestRest;
import com.everis.d4i.tutorial.json.response.ChapterResponseRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface ChapterController {

	NetflixResponse<List<ChapterResponseRest>> getChaptersByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber)
			throws NetflixException;

	NetflixResponse<ChapterResponseRest> getChapterByTvShowIdAndSeasonNumberAndChapterNumber(Long tvShowId, short seasonNumber,
																							 short chapterNumber) throws NetflixException;

	NetflixResponse<ChapterResponseRest> updateChapterByTvShowIdAndSeasonNumberAndChapterNumber(Long tvShowId, short seasonNumber,
																							 short chapterNumber, String name) throws NetflixException;

}
