package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.request.ChapterRequestRest;
import com.everis.d4i.tutorial.json.response.ChapterResponseRest;

public interface ChapterService {

	List<ChapterResponseRest> getChaptersByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber) throws NetflixException;

	ChapterResponseRest getChapterByTvShowIdAndSeasonNumberAndChapterNumber(Long tvShowId, short seasonNumber,
																			short chapterNumber) throws NetflixException;

	ChapterResponseRest updateChapterByTvShowIdAndSeasonNumberAndChapterNumber(Long tvShowId, short seasonNumber,
																			short chapterNumber, String name) throws NetflixException;


}
