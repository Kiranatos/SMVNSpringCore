package net.kiranatos.core.s01xml;

import org.springframework.context.ConfigurableApplicationContext;

public class Part2 {
    public void nextPart(ConfigurableApplicationContext context) {
        System.out.println("\n[XML1000] Примеры внедрения коллекций (look also in examples -> 2)): ");
        City city_01 = context.getBean("tokyoBean", City.class);
        System.out.println("\t Walking in : " + city_01.getName());
        
        System.out.println("\n[XML1001] Расширенный вариант подключения файла *.properties: ");
        City city_02 = context.getBean("nagoyaBean", City.class);
        System.out.println("\t Walking in : " + city_02.getName());
        
        System.out.println("\n[XML1002] Schemes and Namespaces UTIL: ");
        City city_03 = context.getBean("iwakuraBean", City.class);
        System.out.println("\t Walking in : " + city_03.getName());
        
        System.out.println("\n[XML1003] Schemes and Namespaces p and c (для сокращения записи injections in c-constructor and p-properties/setters): ");
        City city_04 = context.getBean("yokoteBean", City.class);
        System.out.println("\t Walking in : " + city_04.getName());
        
        System.out.println("\n[XML1004] Автоматическое связывание in XML"
                + "\n Пример использования look in examples -> 1) \n");
        
    }    
}
