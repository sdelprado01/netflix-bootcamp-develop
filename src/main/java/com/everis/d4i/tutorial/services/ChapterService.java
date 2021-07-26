package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ChapterRequestRest;

public interface ChapterService {

	List<ChapterRequestRest> getChaptersByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber) throws NetflixException;

	ChapterRequestRest getChapterByTvShowIdAndSeasonNumberAndChapterNumber(Long tvShowId, short seasonNumber,
                                                                           short chapterNumber) throws NetflixException;

}
