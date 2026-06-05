package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.Employee;

public class LaunchApp {

	public static void main(String[] args) 
	{
		ApplicationContext container = 
				new ClassPathXmlApplicationContext("applicationconfig.xml");
		
		Employee em = container.getBean(Employee.class);
		System.out.println(em);
	}
}
