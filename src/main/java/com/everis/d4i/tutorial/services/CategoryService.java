package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.request.CategoryRequestRest;
import com.everis.d4i.tutorial.json.response.CategoryResponseRest;

public interface CategoryService {

	List<CategoryResponseRest> getCategories() throws NetflixException;

	CategoryResponseRest createCategories(CategoryRequestRest categoryRequestRest) throws NetflixException;
}
