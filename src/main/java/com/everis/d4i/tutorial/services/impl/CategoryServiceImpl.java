package com.everis.d4i.tutorial.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.everis.d4i.tutorial.json.response.CategoryResponseRest;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.d4i.tutorial.entities.Category;
import com.everis.d4i.tutorial.exceptions.InternalServerErrorException;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.request.CategoryRequestRest;
import com.everis.d4i.tutorial.repositories.CategoryRepository;
import com.everis.d4i.tutorial.services.CategoryService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;

@Service
public class CategoryServiceImpl implements CategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryRepository categoryRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public List<CategoryResponseRest> getCategories() throws NetflixException {

		return categoryRepository.findAll().stream().map(category -> modelMapper.map(category, CategoryResponseRest.class))
				.collect(Collectors.toList());

	}

	public CategoryResponseRest createCategories(final CategoryRequestRest categoryRequestRest) throws NetflixException {
		Category category = new Category();
		category.setName(categoryRequestRest.getName());
		try {
			category = categoryRepository.save(category);
		} catch (final Exception e) {
			LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
			throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
		}
		return modelMapper.map(category, CategoryResponseRest.class);
	}

}
