package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.CategoryRequestRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface CategoryController {

	NetflixResponse<List<CategoryRequestRest>> getCategories() throws NetflixException;

	NetflixResponse<CategoryRequestRest> createCategory(CategoryRequestRest categoryRequestRest) throws NetflixException;

}
