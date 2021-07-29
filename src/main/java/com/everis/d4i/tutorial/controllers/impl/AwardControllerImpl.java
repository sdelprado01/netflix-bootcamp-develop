package com.everis.d4i.tutorial.controllers.impl;

import com.everis.d4i.tutorial.controllers.AwardController;
import com.everis.d4i.tutorial.services.ActorService;
import com.everis.d4i.tutorial.services.AwardService;
import com.everis.d4i.tutorial.utils.constants.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_AWARDS)
public class AwardControllerImpl implements AwardController {

    @Autowired
    private AwardService awardService;
}
