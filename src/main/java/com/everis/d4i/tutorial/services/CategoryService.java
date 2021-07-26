package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.CategoryRequestRest;

public interface CategoryService {

	List<CategoryRequestRest> getCategories() throws NetflixException;

	CategoryRequestRest createCategories(CategoryRequestRest categoryRequestRest) throws NetflixException;
}
