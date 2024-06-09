package com.edubridge.mini_project_myCarapp.service;

import java.util.List;

import com.edubridge.mini_project_myCarapp.model.car;

public interface carService {
	int addcar(car c);
	List<car> findcars();
	car findcarByName(String companyname);
	int updatecar(car c);
	int deletecarByName(String companyname);
	void deleteAllcars();

}