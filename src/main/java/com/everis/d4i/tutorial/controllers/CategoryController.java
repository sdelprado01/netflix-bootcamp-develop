package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.request.CategoryRequestRest;
import com.everis.d4i.tutorial.json.response.CategoryResponseRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface CategoryController {

	NetflixResponse<List<CategoryResponseRest>> getCategories() throws NetflixException;

	NetflixResponse<CategoryResponseRest> createCategory(CategoryRequestRest categoryRequestRest) throws NetflixException;

}
