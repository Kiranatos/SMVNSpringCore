package net.kiranatos.core.s03annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test03SpringOnlyAnnotationsWithoutXML {
    public static void main(String[] args) {
        System.out.println("\n\n III варіант конфігурації Spring приложения: "
                + "Java code + Annotations (no XML).\n"
                + "Функцию файла applicationContext.xml выполняет класс SpringConfig.");
        
        /* Использование конфигурационного файла
        аналог класса new ClassPathXmlApplicationContext("xml/applicationContext.xml"); */
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(SpringConfig.class /*, SpringConfig2.class можно передать несколько классов*/);
        /*
        context.register(SpringConfig1.class, SpringConfig2.class);
        context.scan("com.yet.spring.core.beans");
        context.refresh(); // после регистрации или сканировании нужно вызывать refresh, чтобы обновить контекст
        */
        
        
        Film film01 = context.getBean("comedyFilm", Film.class);
        System.out.println("...Playng: " + film01.getFilm());
        
        Film film02 = context.getBean("horrorFilm", Film.class);
        System.out.println("...Playng: " + film02.getFilm());
        
        Film film03 = context.getBean("mysteryFilm", Film.class);
        System.out.println("...Playng: " + film03.getFilm());
        
        Film film04 = context.getBean("crimeFilm", Film.class);
        System.out.println("...Playng: " + film04.getFilm());
        
        Film film05 = context.getBean("starWarsFilm", Film.class);
        System.out.println("...Playng: " + film05.getFilm());        

        Film prototype_VS_Singleton;
        for (int i = 0; i < 10; i++) {
            prototype_VS_Singleton = context.getBean("historicalFilm", Film.class);
            System.out.println(prototype_VS_Singleton);
        }
        for (int i = 0; i < 10; i++) {
            prototype_VS_Singleton = context.getBean("westernFilm", Film.class);
            System.out.println(prototype_VS_Singleton);
        }
        

        context.close();
    }    
}




