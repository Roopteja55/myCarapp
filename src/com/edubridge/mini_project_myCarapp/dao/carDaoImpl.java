package com.edubridge.mini_project_myCarapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.mini_project_myCarapp.model.car;
import com.edubridge.mini_project_myCarapp.util.DBUtil;

public class carDaoImpl implements carDao {
	Connection con = DBUtil.getConnection();

	@Override
	public int addcar(car c) {

		String INSERT_QUERY = "insert into car(companyname,price,colour,mileage) values(?,?,?,?)";
		int status = 0;

		try {
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1, c.getCompanyname());
			ps.setDouble(2, c.getPrice());
			ps.setString(3, c.getColour());
			ps.setFloat(4, c.getMileage());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public List<car> findcars() {
		String SELECT_QUERY = "select * from car";
		List<car> carList = new ArrayList<>();

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(SELECT_QUERY);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				car c = new car();
				c.setId(rs.getInt("id"));
				c.setCompanyname(rs.getString("companyname"));
				c.setPrice(rs.getDouble("price"));
				c.setColour(rs.getString("colour"));
				c.setMileage(rs.getInt("mileage"));
				carList.add(c);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return carList;
	}

	@Override
	public car findcarByName(String companyname) {
		String SELECT_QUERY = "select  * from car where companyname=?";
		int status = 0;
		// PreparedStatement;
		car c = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(SELECT_QUERY);
			ps.setString(1, companyname);
			ResultSet rs = ps.executeQuery();
			c = new car();
			if (rs.next()) {
				c.setId(rs.getInt("id"));
				c.setCompanyname(rs.getString("companyname"));
				c.setPrice(rs.getDouble("price"));
				c.setColour(rs.getString("colour"));
				c.setMileage(rs.getInt("mileage"));

			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public int updatecar(car c) {

		String UPDATE_QUERY = "UPDATE car SET companyname= ?,price=?,colour=?,mileage=? where id=?";
		int status = 0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(UPDATE_QUERY);
			ps.setString(1, c.getCompanyname());
			ps.setDouble(2,c.getPrice());
			ps.setString(3, c.getColour());
			ps.setInt(4, c.getMileage());
			ps.setInt(5, c.getId());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public int deletecarByName(String companyname) {

		String DELETE_QUERY = "delete from car where companyname=?";
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.setString(1, companyname);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public void deleteAllcars() {
		String DELETE_QUERY = "delete from car";
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			 ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}