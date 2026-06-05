package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import services.DevOpsCourse;
import services.Tron;

public class LaunchApp {

	public static void main(String[] args) 
	{
		//ApplicationContext container
		
		ApplicationContext container = new ClassPathXmlApplicationContext(
				"applicationconfig.xml");
		
		Tron tron = container.getBean(Tron.class);
		
		boolean status = tron.buyTheCourse(4545.54);
		if(status)
			System.out.println("Enrolled to Course");
		else
			System.out.println("Failed to enroll");
	}
}
