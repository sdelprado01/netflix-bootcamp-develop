package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ChapterRequestRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface ChapterController {

	NetflixResponse<List<ChapterRequestRest>> getChaptersByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber)
			throws NetflixException;

	NetflixResponse<ChapterRequestRest> getChapterByTvShowIdAndSeasonNumberAndChapterNumber(Long tvShowId, short seasonNumber,
                                                                                            short chapterNumber) throws NetflixException;

}
