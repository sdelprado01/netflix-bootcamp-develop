package com.everis.d4i.tutorial.services.impl;

import com.everis.d4i.tutorial.repositories.AwardRepository;
import com.everis.d4i.tutorial.services.AwardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwardServiceImpl implements AwardService {

    @Autowired
    AwardRepository awardRepository;

    private ModelMapper modelMapper = new ModelMapper();
}
