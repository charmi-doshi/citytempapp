package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.bean.EmployeeBean;

import config.Config;

public class Client {

	public static void main(String[] args) {

		// ApplicationContext ctx =
		new FileSystemXmlApplicationContext("src\\resources\\Spring.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		EmployeeBean emp = (EmployeeBean) ctx.getBean("employee");
		EmployeeBean emp1 = (EmployeeBean) ctx.getBean("employee");
		System.out.println(emp);
		System.out.println(emp1);
		emp.display();

		ctx.close();
	}
}

