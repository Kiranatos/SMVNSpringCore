package net.kiranatos.examples.e02collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
Source:
Spring Collections (List, Set, Map, and Properties) example
https://mkyong.com/spring/spring-collections-list-set-map-and-properties-example/
*/

public class App {
    public static void main(String[] args) {
        System.out.println("\n\n Пример [XML1000] внедрения коллекций: ");
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "examples/e02/SpringBeans.xml");
        Customer cust = (Customer) context.getBean("CustomerBean");
        System.out.println(cust);
    }
}