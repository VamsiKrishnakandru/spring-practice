package main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import util.Employee;

public class LaunchLazyInit 
{
	public static void main(String[] args) 
	{
		//BeanFactory
		//Deprecated
		//BeanFactory beanFactory = new XmlBeanFactory("");
		
		DefaultListableBeanFactory container = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(container);
		
		reader.loadBeanDefinitions("applicationconfig.xml");
		
		Employee emp = container.getBean("emp1",Employee.class);
		System.out.println(emp);
	}
}
