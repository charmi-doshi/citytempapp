package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.EmpBean;
import com.bean.EmployeeBean;

@Repository("dao")
public class EmpDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//methods
	public int addEmployee()
	{
		String eName = "charmi";
		System.out.println("jdbc temp" + jdbcTemplate);
		return jdbcTemplate.update("insert into employee(eid,ename) values(?,?)",20,eName );
		
	}
	
	public int delEmployee(int eId)
	{
		return jdbcTemplate.update("delete from employee where eid=",+eId +"");
		
	}
	
	private final static class Employeemapper implements RowMapper<EmpBean>
	{
		@Override
		public EmpBean mapRow(ResultSet rs,int rowNum) throws SQLException
		{
			EmpBean empbean = new EmpBean();
			empbean.seteId(rs.getInt("eid"));
			empbean.seteName(rs.getString("ename"));
			
			
			return empbean;
		}
	}

	public List<EmpBean> emplist()
	{
		return jdbcTemplate.query("select * from employee", new Employeemapper());
	}
}
