package net.kiranatos.core.s02xmlannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02SpringAnnotationsAndXML {
    public static void main(String[] args) {
        System.out.println("Check files: applicationContext02.xml, pom.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "core/s02/xml/applicationContext02.xml"                
        );
        
        System.out.println("\n\t[AXML101] Получение бина через аннотацию @Component");
        Language lang_01 = context.getBean("englishLang", Language.class);
        System.out.println("...translating from " + lang_01.getLang());
        lang_01 = context.getBean("poland", Language.class);
        System.out.println("...translating from " + lang_01.getLang());
        
        System.out.println("\n\t[AXML102] Получение бинов через аннотацию @Autowired");
        lang_01 = context.getBean("bilingual", Language.class);
        System.out.println("...translating from " + lang_01.getLang());
        
        System.out.println("\n\t[AXML103] Получение бинов через аннотацию @Qualifier");        
        System.out.println("Пример внедрения в приватные поля:");
        lang_01 = context.getBean("slavicLanguages", Language.class);
        System.out.println("...translating from " + lang_01.getLang());
        System.out.println("Пример внедрения в конструктор:");
        lang_01 = context.getBean("diglossia", Language.class);
        System.out.println("...translating from " + lang_01.getLang());
        
        System.out.println("\n\t[AXML104] Внедрение значений из внешнего файла (в XML добавляется строка)"
                + " c аннотацией @Value(\"${langItaly.name}\")");
        lang_01 = context.getBean("italian", Language.class);
        System.out.println("...translating from " + lang_01.getLang());
        
        System.out.println("\n\t[AXML105] Получение бинов с аннотацией @Scope");
        System.out.println("\t Singleton:");
        for (int i = 0; i < 10; i++) {
            lang_01 = context.getBean("ukrainian", Language.class);            
            System.out.println(lang_01);
        }
        System.out.println("\t Prototype:");
        for (int i = 0; i < 10; i++) {
            lang_01 = context.getBean("spanish", Language.class);            
            System.out.println(lang_01);
        }
                
        System.out.println("\n\t[AXML106] Бины с аннотациями @PostConstruct и @PreDestroy для методов");
        System.out.println("Все те же правила, что и для XML варианта. Для данных аннотаций необходим доп.dependency in pom.xml ");
        lang_01 = context.getBean("japanese", Language.class);            
        System.out.println("...translating from " + lang_01.getLang());
        
        context.close();
    }    
}
