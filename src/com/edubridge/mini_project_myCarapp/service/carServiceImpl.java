package com.edubridge.mini_project_myCarapp.service;

import java.util.List;

import com.edubridge.mini_project_myCarapp.dao.carDao;
import com.edubridge.mini_project_myCarapp.dao.carDaoImpl;
import com.edubridge.mini_project_myCarapp.model.car;

public class carServiceImpl implements carService {

	private carDao dao = new carDaoImpl();
	@Override
	public int addcar(car c) {
		
		return dao.addcar(c);
	}

	@Override
	public List<car> findcars() {
		
		return dao.findcars();
	}

	@Override
	public car findcarByName(String companyname) {
		
		return dao.findcarByName(companyname);
	}

	@Override
	public int updatecar(car c) {
		
		return dao.updatecar(c);
	}

	@Override
	public int deletecarByName(String companyname) {
		
		return dao.deletecarByName(companyname);
	}

	@Override
	public void deleteAllcars() {
		
	      dao.deleteAllcars();
		
		
	}

}