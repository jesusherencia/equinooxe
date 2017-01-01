/** Copyright (C) 2016 <mohamedboullouz@gmail.com>
  * This file is part of Equinooxe Project
  */
package com.equinooxe.module.espaces;

/**
 * @author mboullouz
 *
 */
public class EspacesConsts {

	public static final String VIEW_BASE_URL = "/espaces";
	public static final String BASE_URL = "/espaces";

	/** Batiments */
	public static final String VIEW_BATIMENT_BASE = VIEW_BASE_URL + "batiment";
	public static final String URL_BATIMENT_BASE = BASE_URL + "/batiment";
	// views
	public static final String VIEW_BATIMENT_LIST = VIEW_BATIMENT_BASE + "/list";
	public static final String VIEW_BATIMENT_NEW = VIEW_BATIMENT_BASE + "/form";
	public static final String VIEW_BATIMENT_SAVE = VIEW_BATIMENT_BASE + "/save";
	public static final String VIEW_BATIMENT_SHOW = VIEW_BATIMENT_BASE + "/show";
	// urls
	public static final String URL_BATIMENT_LIST = URL_BATIMENT_BASE + "/list";
	public static final String URL_BATIMENT_NEW = URL_BATIMENT_BASE + "/new";
	public static final String URL_BATIMENT_SAVE = URL_BATIMENT_BASE + "/save";
	public static final String URL_BATIMENT_SHOW_ID = URL_BATIMENT_BASE + "/show/{id}";
	public static final String URL_BATIMENT_SHOW = URL_BATIMENT_BASE + "/show/";
	public static final String URL_BATIMENT_EDIT_ID = URL_BATIMENT_BASE + "/edit/{id}";
}
