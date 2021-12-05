Summary of Spring (core) framework with Maven


Sources of Breviary (теория из sources, которая незаконспектированна в данном коде): 
################################################################################ 
YouTube channel:  alishev
https://www.youtube.com/channel/UCK5d3n3kfkzlArMccS0TTXA
https://www.udemy.com/javarussia/?couponCode=ADVANCED_JAVARUSSIA 
alishev.neil@gmail.com
https://github.com/NeilAlishev/SpringCourse
***
Бин - похоже на объект. Бины создает Спринг из переданных ему классов.

################################################################################ 
Spring Framework - The Basics
https://www.youtube.com/playlist?list=PL6jg6AGdCNaWF-sUH2QDudBRXo54zuN1t
YouTube channel: Онлайн уроки по Java
https://www.youtube.com/channel/UCdXqgQdGW5go6nkkBbUVSMA
teacher: Yuriy Tkach
***
Dependency Injection (Inversion of Control) - Objects get their dependencies and do not create them.
AOP (Aspect Oriented Programming) - Separation of cross-cutting concerns into separate modules.
***
Modules of Spring:
1) Core container: Beans, Core, Context, Expression
    Beans and Core managing beans and realize DI
    Contex управляет контекстом, где хранятся бины и обеспечивает доступ к ним
    Expression - специальный язык виражений, который может использоваться для поиска и модификации графа бинов во время выполнения программы.
2) AOP: AOP and Aspects(поддержка библиотеки AspectJ)
3) Instrumentation - необходим, когда используем Spring в сервере приложений(Tomcat, WildFly), обеспечивает загрузку классов в контейнер и позволяет управлять контекстом и бинами.
4) Data access and integration: JDBC, JMS, ORM, Transaction, JPA
5) Web & Remoting: Web, Servlet, Struts - компоненты для роботы с web-приложениями. Базовые вещи, например - загрузка файла на сервер, паттерн MVC, web-сервисы, безопасность, интеграция с др. web-технологиями 
6) Testing
***
Главные Dependencies <artifactId>spring-context and <artifactId>spring-context-support, которые подтянут все остальные модули. Зависимость spring-tx для поддержки транзакций.
***
bean scope or lifecycle of the objects in the container
***
Классы по которым создаем бины нечего не знают про Спринг. 
Реализация Aware Interfaces позволяет узнать в каком контексте находится класс, имя бина, ссылка на контекст, сервлет-контекст веб-приложения.
Это нужно редко, например в коде тестирования.
Aware Interfaces:
public class Aaa implements ApplicationContextAware {
    public void setApplicationContext(ApplicationContext ctx){...}
}
- ApplicationContextAware
- ApplicationEventPublisherAware
- BeanFactoryAware
- BeanNameAware
- ResourceLoaderAware
- ServletContextAware
- ...
***
[утилитарная функция] Реагировать на события контекста such as creation, completion, updating
Container Events:
public class Monitor implements ApplicationListener {
    public void onApplicationEvent(ApplicationEvent event){...}
}
- ContextStartedEvent
- ContextStoppedEvent
- ContextRefreshedEvent
- ContextClosedEvent
***

################################################################################