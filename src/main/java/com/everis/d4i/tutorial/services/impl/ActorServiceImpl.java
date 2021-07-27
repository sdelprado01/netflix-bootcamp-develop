package com.everis.d4i.tutorial.services.impl;

import com.everis.d4i.tutorial.entities.Actor;
import com.everis.d4i.tutorial.exceptions.InternalServerErrorException;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.request.ActorRequestRest;
import com.everis.d4i.tutorial.json.response.ActorResponseRest;
import com.everis.d4i.tutorial.json.response.CategoryResponseRest;
import com.everis.d4i.tutorial.json.response.TvShowResponseRest;
import com.everis.d4i.tutorial.repositories.ActorRepository;
import com.everis.d4i.tutorial.repositories.ChapterRepository;
import com.everis.d4i.tutorial.services.ActorService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
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
        try {
            return modelMapper.map(actorRepository.getOne(id), ActorResponseRest.class);
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
}
