package com.dao;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.CityTempBean;

@Repository("citytempdao")
public class CityTempDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public int addCityTemp(String city,int Temp[])
	{
		return jdbcTemplate.update("insert into weather(city,temperature)values(?,?)",city,Temp);
	}
	
	public int delCity(String city)
	{
		return jdbcTemplate.update("delete from weather where city=?",city);
	}
	
	public int updateCityTemp(String city,int Temp[])
	{
		return jdbcTemplate.update("update weather set temperature=? where city=?", Temp,city);
	}
	
	//rowmapper
	private final static class Employeemapper implements RowMapper<CityTempBean>
	{
		@Override
		public CityTempBean mapRow(ResultSet rs,int rowNum) throws SQLException
		{
			CityTempBean tempbean = new CityTempBean();
			tempbean.setCity(rs.getString("city"));
			
//			System.out.println();
			
			
//			System.out.println(temp);
			
			tempbean.setCityTemp(rs.getArray("temperature"));
			return tempbean;
		}
	}
	
	//methods using query method
	
	public List<CityTempBean> cityTempList()
	{
		return jdbcTemplate.query("select * from weather",new Employeemapper());
	}
	
	public CityTempBean getCityTempbyName(String city)
	{
		 return jdbcTemplate.queryForObject("select * from weather where city='"+city+ "'",new Employeemapper());
	}
	
	public CityTempBean getAvgTemp(CityTempBean ctb)
	{
		return jdbcTemplate.queryForObject("select temperature from weather where city '"+ctb.getCity()+"'",new Employeemapper());
	}
}
