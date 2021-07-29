package com.everis.d4i.tutorial.services.impl;

import com.everis.d4i.tutorial.entities.Actor;
import com.everis.d4i.tutorial.entities.Chapter;
import com.everis.d4i.tutorial.entities.Season;
import com.everis.d4i.tutorial.entities.TvShow;
import com.everis.d4i.tutorial.exceptions.InternalServerErrorException;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.request.ActorRequestRest;
import com.everis.d4i.tutorial.json.response.*;
import com.everis.d4i.tutorial.repositories.ActorRepository;
import com.everis.d4i.tutorial.repositories.ChapterRepository;
import com.everis.d4i.tutorial.repositories.SeasonRepository;
import com.everis.d4i.tutorial.repositories.TvShowRepository;
import com.everis.d4i.tutorial.services.ActorService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    ActorRepository actorRepository;
    @Autowired
    ChapterRepository chapterRepository;

    private ModelMapper modelMapper = new ModelMapper();

    private static final Logger LOGGER = LoggerFactory.getLogger(ActorServiceImpl.class);

    @Override
    public List<ActorResponseRest> getActors() throws NetflixException {

        return actorRepository.findAll().stream().map(actor -> modelMapper.map(actor, ActorResponseRest.class))
                .collect(Collectors.toList());
    }

    @Override
    public ActorResponseRest getActorById(Long id) throws NetflixException {

        Actor actor = actorRepository.getOne(id);
        List<Chapter> participatingChapters = chapterRepository.findByActorsId(Collections.singletonList(actor.getId()));
        Set<TvShow> participatingTvShows = new HashSet<>();
        for (Chapter chapter:
             participatingChapters) {
            participatingTvShows.add(chapter.getSeason().getTvShow());
        }
        //Una lista de Tv Shows en los que ha participado

        List<TvShowResponseRest> tvShowResponseRestList = participatingTvShows.stream()
                .map(tvShow -> modelMapper.map(tvShow, TvShowResponseRest.class)).collect(Collectors.toList());

        List<ChapterResponseRest> chapterResponseRests = participatingChapters.stream()
                .map(chapter -> modelMapper.map(chapter, ChapterResponseRest.class)).collect(Collectors.toList());

        for (TvShowResponseRest tvShowResponseRest:
             tvShowResponseRestList) {
            tvShowResponseRest.setChapters(chapterResponseRests);
        }

        try {
            ActorResponseRest actorResponseRest = modelMapper.map(actor, ActorResponseRest.class);
            actorResponseRest.setTvShows(tvShowResponseRestList);
            return actorResponseRest;
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new NotFoundException(entityNotFoundException.getMessage());
        }
    }

    @Override
    public ActorResponseRest createActor(ActorRequestRest actorRequestRest) throws NetflixException {
        Actor actor = modelMapper.map(actorRequestRest, Actor.class);
        actor.setChapters(chapterRepository.findByIdIn(actorRequestRest.getChapters()));
        try {
            actor = actorRepository.save(actor);
        } catch (final Exception e) {
            LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
            throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
        }
        return modelMapper.map(actor, ActorResponseRest.class);
    }

    @Override
    public ActorResponseRest updateActorNameById(Long id, String name) throws NetflixException {
        Actor actor = actorRepository.getOne(id);
        actor.setName(name);
        try {
            actor = actorRepository.save(actor);
        } catch (final Exception e) {
            LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
            throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
        }
        return modelMapper.map(actor, ActorResponseRest.class);
    }

    @Override
    public ActorResponseRest updateActorBirthYearById(Long id, Year birthYear) throws NetflixException {
        Actor actor = actorRepository.getOne(id);
        actor.setBirthYear(birthYear);
        try {
            actor = actorRepository.save(actor);
        } catch (final Exception e) {
            LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
            throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
        }
        return modelMapper.map(actor, ActorResponseRest.class);
    }

    @Override
    public ActorResponseRest updateActorChaptersById(Long id, List<Long> chaptersId) throws NetflixException {
        Actor actor = actorRepository.getOne(id);
        actor.setChapters(chapterRepository.findByIdIn(chaptersId));
        try {
            actor = actorRepository.save(actor);
        } catch (final Exception e) {
            LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
            throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
        }
        return modelMapper.map(actor, ActorResponseRest.class);
    }

    @Override
    public List<ActorResponseRest> deleteActorById(Long id) throws NetflixException {
        try {
            actorRepository.deleteById(id);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new NotFoundException(entityNotFoundException.getMessage());
        }
        return actorRepository.findAll().stream().map(actor -> modelMapper.map(actor, ActorResponseRest.class))
                .collect(Collectors.toList());
    }
}
