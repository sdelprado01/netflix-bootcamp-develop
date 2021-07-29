package com.everis.d4i.tutorial.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.everis.d4i.tutorial.entities.TvShow;
import com.everis.d4i.tutorial.exceptions.InternalServerErrorException;
import com.everis.d4i.tutorial.json.response.AwardResponseRest;
import com.everis.d4i.tutorial.json.response.TvShowResponseRest;
import com.everis.d4i.tutorial.repositories.AwardRepository;
import com.everis.d4i.tutorial.repositories.CategoryRepository;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.request.TvShowRequestRest;
import com.everis.d4i.tutorial.repositories.TvShowRepository;
import com.everis.d4i.tutorial.services.TvShowService;

@Service
public class TvShowServiceImpl implements TvShowService {

	@Autowired
	private TvShowRepository tvShowRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private AwardRepository awardRepository;

	private ModelMapper modelMapper = new ModelMapper();

	private static final Logger LOGGER = LoggerFactory.getLogger(TvShowServiceImpl.class);

	@Override
	public List<TvShowResponseRest> getTvShowsByCategory(Long categoryId) throws NetflixException {

		return tvShowRepository.findByCategoriesId(Collections.singletonList(categoryId)).stream()
				.map(tvShow -> modelMapper.map(tvShow, TvShowResponseRest.class)).collect(Collectors.toList());

	}

	@Override
	public TvShowResponseRest getTvShowById(Long id) throws NetflixException {

		try {
			return modelMapper.map(tvShowRepository.getOne(id), TvShowResponseRest.class);
		} catch (EntityNotFoundException entityNotFoundException) {
			throw new NotFoundException(entityNotFoundException.getMessage());
		}

	}

	@Override
	public TvShowResponseRest createTvShow(TvShowRequestRest tvShowRequestRest) throws NetflixException {
		TvShow tvShow = modelMapper.map(tvShowRequestRest, TvShow.class);
		tvShow.setCategories(categoryRepository.findByIdIn(tvShowRequestRest.getCategories()));
		try {
			tvShow = tvShowRepository.save(tvShow);
		} catch (final Exception e) {
			LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
			throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
		}
		return modelMapper.map(tvShow, TvShowResponseRest.class);
	}

	@Override
	public TvShowResponseRest updateCategoriesFromTvShow(Long id, List<Long> categoriesId) throws NetflixException {
		TvShow tvShow = tvShowRepository.getOne(id);
		tvShow.setCategories(categoryRepository.findByIdIn(categoriesId));
		try {
			tvShow = tvShowRepository.save(tvShow);
		} catch (final Exception e) {
			LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
			throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
		}
		return modelMapper.map(tvShow, TvShowResponseRest.class);
	}

	@Override
	public TvShowResponseRest updateNameFromTvShow(Long id, String name) throws NetflixException {
		TvShow tvShow = tvShowRepository.getOne(id);
		tvShow.setName(name);
		try {
			tvShow = tvShowRepository.save(tvShow);
		} catch (final Exception e) {
			LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
			throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
		}
		return modelMapper.map(tvShow, TvShowResponseRest.class);
	}

	@Override
	public List<TvShowResponseRest> deleteTvShowById(Long id) throws NetflixException {
		try {
			tvShowRepository.delete(tvShowRepository.getOne(id));
		} catch (final Exception e) {
			LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
			throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
		}
		return tvShowRepository.findAll().stream()
				.map(tvShow -> modelMapper.map(tvShow, TvShowResponseRest.class)).collect(Collectors.toList());
	}


}
