package com.edubridge.mini_project_myCarapp.dao;

import java.util.List;

import com.edubridge.mini_project_myCarapp.model.car;

public interface carDao {
	int addcar(car c);
	List<car> findcars();
	car findcarByName(String name);
	int updatecar(car c);
	int deletecarByName(String name);
	void deleteAllcars();

}