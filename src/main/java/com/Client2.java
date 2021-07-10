package com;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.bean.xmlBean;

public class Client2 {

	public static void main(String args[])
	{
		
		//singleton design pattern
		//lazy loading or lazy binding
		//cuz cotainer ahs to go to find the file 
		FileSystemResource resource = new FileSystemResource("src/resources/Spring.xml");
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		
									//cast the obj
		xmlBean x1 = factory.getBean("student",xmlBean.class);
		xmlBean x2 = factory.getBean("student", xmlBean.class);
		
		//set the application context
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/resources/Spring.xml");
		
		//second way to cast the obj 
		xmlBean x3 = (xmlBean) ctx.getBean("student");
		
		
		System.out.println(x1.hashCode());
		System.out.println(x2.hashCode());
		System.out.println(x3.hashCode());
		x3.display();
		
		
	}
}
