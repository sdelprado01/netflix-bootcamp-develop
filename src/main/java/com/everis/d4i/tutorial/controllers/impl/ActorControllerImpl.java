package com.everis.d4i.tutorial.controllers.impl;

import com.everis.d4i.tutorial.controllers.ActorController;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.request.ActorRequestRest;
import com.everis.d4i.tutorial.json.request.TvShowRequestRest;
import com.everis.d4i.tutorial.json.response.ActorResponseRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import com.everis.d4i.tutorial.services.ActorService;
import com.everis.d4i.tutorial.services.impl.ActorServiceImpl;
import com.everis.d4i.tutorial.utils.constants.CommonConstants;
import com.everis.d4i.tutorial.utils.constants.RestConstants;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Year;
import java.util.List;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_ACTORS)
public class ActorControllerImpl implements ActorController {

    @Autowired
    private ActorService actorService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public NetflixResponse<List<ActorResponseRest>> getActors() throws NetflixException {
        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                actorService.getActors()) ;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstants.RESOURCE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public NetflixResponse<ActorResponseRest> getActorById(@PathVariable Long id) throws NetflixException {
        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                actorService.getActorById(id));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public NetflixResponse<ActorResponseRest> createActor(@ApiParam(value = RestConstants.PARAMETER_ACTOR, required = true)
                                                              @RequestBody @Valid final ActorRequestRest actorRequestRest) throws NetflixException {
        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                actorService.createActor(actorRequestRest));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = RestConstants.RESOURCE_ID + RestConstants.RESOURCE_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
    public NetflixResponse<ActorResponseRest> updateActorNameById(@PathVariable Long id,
                                                                  @RequestBody @Valid final String name) throws NetflixException {
        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                actorService.updateActorNameById(id, name));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = RestConstants.RESOURCE_ID + RestConstants.RESOURCE_BIRTH_YEAR, produces = MediaType.APPLICATION_JSON_VALUE)
    public NetflixResponse<ActorResponseRest> updateActorBirthYearById(@PathVariable Long id,
                                                                       @RequestBody @Valid final Year year) throws NetflixException {
        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                actorService.updateActorBirthYearById(id, year));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = RestConstants.RESOURCE_ID + RestConstants.RESOURCE_ACTORS_CHAPTERS, produces = MediaType.APPLICATION_JSON_VALUE)
    public NetflixResponse<ActorResponseRest> updateActorChaptersById(@PathVariable Long id,
                                                                      @RequestBody @Valid final List<Long> chaptersId) throws NetflixException {
        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                actorService.updateActorChaptersById(id, chaptersId));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = RestConstants.RESOURCE_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public NetflixResponse<List<ActorResponseRest>> deleteActorById(@PathVariable Long id) throws NetflixException {
        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                actorService.deleteActorById(id));
    }


}
