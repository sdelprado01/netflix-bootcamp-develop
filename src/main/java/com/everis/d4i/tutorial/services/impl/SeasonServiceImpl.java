package com.everis.d4i.tutorial.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.d4i.tutorial.entities.Season;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.SeasonRequestRest;
import com.everis.d4i.tutorial.repositories.SeasonRepository;
import com.everis.d4i.tutorial.services.SeasonService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;

@Service
public class SeasonServiceImpl implements SeasonService {

	@Autowired
	private SeasonRepository seasonRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<SeasonRequestRest> getSeasonsByTvShow(Long tvShowId) throws NetflixException {
		return seasonRepository.findByTvShowId(tvShowId).stream()
				.map(season -> modelMapper.map(season, SeasonRequestRest.class)).collect(Collectors.toList());
	}

	@Override
	public SeasonRequestRest getSeasonByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber) throws NetflixException {
		Season season = seasonRepository.findByTvShowIdAndNumber(tvShowId, seasonNumber)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SEASON));
		return modelMapper.map(season, SeasonRequestRest.class);
	}

}
