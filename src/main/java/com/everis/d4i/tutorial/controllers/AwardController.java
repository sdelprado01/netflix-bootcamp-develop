package com.everis.d4i.tutorial.controllers;

import java.util.List;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.response.AwardResponseRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface AwardController {

    NetflixResponse<List<AwardResponseRest>> getAwards() throws NetflixException;

    NetflixResponse<List<AwardResponseRest>> getAwardsByTvShowId(Long id) throws NetflixException;
}
