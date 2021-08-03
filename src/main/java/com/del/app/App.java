package com.del.app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.del.app.bean.Employee;

/**
 * Hello world!
 *
 */
public class App {
	
    public static void main( String[] args ){
        
    	// Tightly coupled class
//    	Employee employee = new Employee();
//    	employee.setEmpId(100001);
//    	employee.setName("John SMith");
//    	employee.setSalary(98544.334);
//    	employee.setDept("Dev");
//    	
//    	System.out.println(employee);
    	
    	// IOC : Inversion of control => DI  dependency Injection.
    	// 1. Application Context container type
    	ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
    	
    	System.out.println("----- Application context based bean object ------");
    	Employee employeeOne = (Employee)context.getBean("employeeOne");
    	System.out.println(employeeOne);
    	
    	Employee employeeTwo = context.getBean("employeeTwo", Employee.class);
    	System.out.println(employeeTwo);
    	
    	Employee employeeThree = context.getBean("employeeThree", Employee.class);
    	System.out.println(employeeThree);
    	
    	System.out.println("-----  Bean Factory based bean object ------");
    	
    	// 2. Bean Factory Container
    	Resource resource = new ClassPathResource("appContext.xml");
    	BeanFactory factory = new XmlBeanFactory(resource);
    	
    	Employee employee1 = (Employee) factory.getBean("employeeOne");
    	System.out.println(employee1);    	

    	Employee employee2 = factory.getBean("employeeTwo",Employee.class);
    	System.out.println(employee2);
    }
}
