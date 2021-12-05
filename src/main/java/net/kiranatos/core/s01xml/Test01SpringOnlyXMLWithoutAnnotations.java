package net.kiranatos.core.s01xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01SpringOnlyXMLWithoutAnnotations {
    public static void main(String[] args) {
        System.out.println("\n\n\nCheck files: applicationContext.xml, pom.xml");
        /* используем ConfigurableApplicationContext, который наследуется от интерфейса 
        ApplicationContext т.к. там нету метода close + тут содержится метод для регистрации(shutdown hook) 
        - это позволит Java вызвать автоматически этот hook при нормальном(не System.exit) завершении программы. A hook уже вызовет context.close */
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                "core/s01/xml/applicationContext.xml"
        );
        
        /* родительский и дочерний контекст:
        ApplicationContext parent = new ClassPathXmlApplicationContext("text.xml");
        ApplicationContext child = new ClassPathXmlApplicationContext(new String[]{"text.xml"}, parent); 
        Родитель нечего не знает о дочерних объектах - это часто используется в Web-приложениях */
        
        System.out.println("\n[XML0101] Простое получение бина через поле id и пустой конструктор в XML");
        Waifu waifu_01 = context.getBean("yandereBean", Waifu.class);
        System.out.println("\t My Waifu: " + waifu_01.getName());
                
        System.out.println("\n[XML0102] Пример получение бина через поле name и пустой конструктор в XML");
        Waifu waifu_01_01 = context.getBean("undereWaifuBeanViaName", Waifu.class);
        System.out.println("\t My Waifu: " + waifu_01_01.getName());
        
        
        
        System.out.println("\n[XML0201] Внедряем объект, получив бин через конструктор со ссылкой на другой объект TsundereWaifu(Waifu imouto) и XML");
        Waifu waifu_02 = context.getBean("tsundereBean", Waifu.class);
        System.out.println("\t My Waifu: " + waifu_02.getName() + " & her little sister: " + ((TsundereWaifu)waifu_02).getSister());
        
        System.out.println("\n[XML0301] Внедряем объект, получив бин через конструктор with String and Setter methods и XML");
        Waifu waifu_03 = context.getBean("kuudereBean", Waifu.class);
        System.out.println("\t My Waifu: " + waifu_03.getName() + ((KuudereWaifu)waifu_03).getFamily());
                
        System.out.println("\n[XML0401] Внедряем объект, using file waifu.properties");
        Waifu waifu_04 = context.getBean("dandereBean", Waifu.class);
        System.out.println("\t My Waifu: " + waifu_04.getName() + ((DandereWaifu)waifu_04).getInfo());
        
        System.out.println("\n[XML0501] По умолчанию все бины - синглтоны, для того чтобы создавались разные объекты, нужно указать: scope=\"prototype\" ");
        for (int i = 0; i < 10; i++) {
            Waifu clone = context.getBean("himedereBean", Waifu.class);
            System.out.println("\t try to make clone of " + clone.getName() + " № " + clone + "[prototype]");
            clone = context.getBean("yandereBean", Waifu.class);
            System.out.println("\t try to make clone of " + clone.getName() + " № " + clone + "[singleton]");            
        }
        
        System.out.println("\n[XML0601] Пример init-method, destroy-method, factory-method");
        Waifu waifu_06 = context.getBean("deredereBean", Waifu.class);
        System.out.println("\t My Waifu: " + waifu_06.getName());
                
        System.out.println("\n[XML0701] Пример factory-method");
        Waifu waifu_07 = context.getBean("kamidereBean", Waifu.class);
        System.out.println("\t My Waifu: " + waifu_07.getName());     
        
        System.out.println("\n@@@ 2 способа сделать DI: via constructor or via setters @@@ \n Игры с конструтором:");
        
        Waifu waifu_01_02 = context.getBean("mayadereBean01", Waifu.class);
        System.out.println("\t [constructor] My Waifu: " + waifu_01_02.getName());
        waifu_01_02 = context.getBean("mayadereBean02", Waifu.class);
        System.out.println("\t [constructor] My Waifu: " + waifu_01_02.getName());
        //waifu_01_02 = context.getBean("mayadereBean03", Waifu.class); [НЕ СРАБОТАЛО] 3)
        //System.out.println("\t [constructor] My Waifu: " + waifu_01_02.getName());
        waifu_01_02 = context.getBean("mayadereBean04", Waifu.class);
        System.out.println("\t [constructor] My Waifu: " + waifu_01_02.getName());
        waifu_01_02 = context.getBean("mayadereBean05", Waifu.class);
        System.out.println("\t [constructor] My Waifu: " + waifu_01_02.getName());
        waifu_01_02 = context.getBean("mayadereBean06", Waifu.class);
        System.out.println("\t [constructor] My Waifu: " + waifu_01_02.getName());
        waifu_01_02 = context.getBean("mayadereBean07", Waifu.class);
        System.out.println("\t [constructor] My Waifu: " + waifu_01_02.getName());
        
        System.out.println("\n[XML0800] Пример наследование определений бинов");        
        Waifu waifu_08_03 = context.getBean("bodereBean", Waifu.class);        
        System.out.println("\t My Waifu: " + waifu_08_03.getName());
        Waifu waifu_08_01 = context.getBean("hinedereBean", Waifu.class);        
        System.out.println("\t My Waifu: " + waifu_08_01.getName());
        Waifu waifu_08_02 = context.getBean("coodereBean", Waifu.class);        
        System.out.println("\t My Waifu: " + waifu_08_02.getName());
        
        System.out.println("\n[XML0801] Пример Зависимости бинов");        
        waifu_08_01 = context.getBean("utsudereBean", Waifu.class);                
        System.out.println("\t My Waifu: " + waifu_08_01.getName());
        
        System.out.println("\n[XML0802] Пример Lazy Initialization");
        waifu_08_02 = context.getBean("shundereBean", Waifu.class);        
        System.out.println("\t My Waifu: " + waifu_08_02.getName());
        
        System.out.println("\n\n ************** SECOND PART OF Breviary (Lazy Init Mode) **************** ");
        new Part2().nextPart(context);
        
        System.out.println("\n\n\n"
                + "@@@ 2 type of container in Spring: BeanFactory and ApplicationContext @@@"
                + "\n@@@ BeanFactory - simple container that create beans and support DI (базовий интерфейс, по умолчанию имеет ЛЕНИВУЮ ИНИЦИАЛИЗАЦИЮ); @@@"
                + "\n@@@ ApplicationContext - same as above + framework services for controlling the beans @@@"
                + "\n@@@  - ClassPathXmlApplicationContext @@@"
                + "\n@@@  - FileSystemXmlApplicationContext @@@"
                + "\n@@@  - AnnotationConfigApplicationContext @@@"
                + "\n@@@  - XmlWebApplicationContext @@@"
                + "\n@@@  - StaticApplicationContext @@@");
        context.close();        
        
    }    
}
