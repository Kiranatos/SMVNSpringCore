package net.kiranatos.examples.e01xmlautowiring;

import net.kiranatos.examples.e01xmlautowiring.domain.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
source: Spring Beans Auto-wiring Example using XML Configuration
http://websystique.com/spring/spring-beans-auto-wiring-example-using-xml-configuration/
*/

public class AppMain {
    public static void main(String args[]){
        System.out.println("\n\n\n Пример [XML1004] демонстрирующий Автоматическое связывание in XML. Теорию смотреть в разделе Core->XML. \n");
        
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("examples/e01/app-config.xml");
        
        //autowire=byName 
        Application application = (Application)context.getBean("application");
        System.out.println("Application Details : " + application);
        
        //autowire=byType
        Employee employee = (Employee)context.getBean("employee");
        System.out.println("Employee Details : "+employee);
        
        //autowire=constructor
        Performer performer = (Performer)context.getBean("performer");
        System.out.println("Performer Details : "+performer);
        
        //autowire=default
        Driver driver = (Driver)context.getBean("driver");
        System.out.println("Driver Details : "+driver);
    }
}
