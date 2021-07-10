package com.cont;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.EmpBean;
import com.dao.EmpDao;

import config.Config;

public class Empcont {
 

	public static void main(String args[])
	{
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		EmpDao empdao = (EmpDao) ctx.getBean("dao");
		int res = empdao.addEmployee();
		
		if(res>0)
		{
			System.out.println("record inserted");
		}
		
		List<EmpBean> emplist = empdao.emplist();
		for(EmpBean emp :emplist) {
			
			System.out.println(emp.geteId() + " -" + emp.geteName()+ " -");
		}
	}
}
