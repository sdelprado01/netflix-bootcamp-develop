package com.everis.d4i.tutorial.services.impl;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.response.ActorResponseRest;
import com.everis.d4i.tutorial.json.response.AwardResponseRest;
import com.everis.d4i.tutorial.json.response.TvShowResponseRest;
import com.everis.d4i.tutorial.repositories.AwardRepository;
import com.everis.d4i.tutorial.services.AwardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AwardServiceImpl implements AwardService {

    @Autowired
    AwardRepository awardRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<AwardResponseRest> getAwards() throws NetflixException {
        return awardRepository.findAll().stream().map(award -> modelMapper.map(award, AwardResponseRest.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AwardResponseRest> getAwardsByTvShowId(Long tvShowId) throws NetflixException {
        return awardRepository.findByTvShowsId(Collections.singletonList(tvShowId)).stream()
                .map(award -> modelMapper.map(award, AwardResponseRest.class)).collect(Collectors.toList());
    }
}
