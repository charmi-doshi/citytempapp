package com.cont;

import java.sql.Array;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.CityTempBean;
import com.dao.CityTempDao;

import config.Config;

public class CityTempCont {

	public static void main(String args[]) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

		CityTempDao tempdao = (CityTempDao) ctx.getBean("citytempdao");
		int choice;

		do {
			System.out.println("1--add city and temp");
			System.out.println("2--delete city");
			System.out.println("3--update city");
			System.out.println("4--display city temp");
			System.out.println("5--display average city temp");
			System.out.println("6--exit");
			System.out.println("Enter your choice:");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			String city, phase;
			int Temp[] = new int[3];

			switch (choice) {
			case 1:
				System.out.println("Enter the city name:");
				city = sc.next();

				for (int i = 0; i < 3; i++) {
					System.out.println("Enter the temp:");
					Temp[i] = sc.nextInt();

				}
				System.out.println(Temp);

				int res = tempdao.addCityTemp(city, Temp);

				if (res > 0) {
					System.out.println("record inserted sucessfully");
				} else {
					System.out.println("record not inserted");
				}
				break;
			case 2:
				System.out.println("Enter the city name:");
				city = sc.next();

				System.out.println(tempdao.delCity(city) + "record deleted");

				break;
			case 3:
				System.out.println("Enter the city name:");
				city = sc.next();
				System.out.println("Enter the new temp");
				for (int i = 0; i < 3; i++) {
					System.out.println("Enter the temp:");
					Temp[i] = sc.nextInt();

				}

				int r = tempdao.updateCityTemp(city, Temp);
				if (r > 0) {
					System.out.println("record updated sucessfully");
				} else {
					System.out.println("record not updated");
				}
				break;
			case 4:
				System.out.println("Enter the city name:");
				city = sc.next();
				
				CityTempBean citybean = tempdao.getCityTempbyName(city);
				
					System.out.println("city-"+citybean.getCity()+"\ttemp:"+citybean.getCityTemp());
				
				break;
			case 5:
				System.out.println("Enter the city name:");
				city = sc.next();
				
				
				
				break;
			default:
				System.out.println("Thank you for using the app");
				break; 
			}
		} while (choice != 6);

		List<CityTempBean> citylist = tempdao.cityTempList();
		
		for(CityTempBean list:citylist)
		{
			System.out.println("city-"+list.getCity()+"\ttemp:"+list.getCityTemp());
		}
	}
}
