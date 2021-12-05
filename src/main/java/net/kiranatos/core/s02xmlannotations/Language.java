package net.kiranatos.core.s02xmlannotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public interface Language { public String getLang(); }

// @Component - Аннотация для класса, из которого можно создать бин
@Component("englishLang") // id=englishLang
class English implements Language { // [AXML101]
    @Override
    public String getLang() {
        return this.getClass().getSimpleName();
    }
}

// если id не указан, тогда Spring, автоматически создаст id=poland по имени класса
@Component 
class Poland implements Language { // [AXML101]
    @Override
    public String getLang() {
        return this.getClass().getSimpleName();
    }
}

/*
@Autowired - аннотация для методов, конструкторов и полей. Показывает куда нужно 
внедрить подходящий по классу или интерфейсу бин (Бины ищет там где есть аннотация @Component). 
Аннотация внедрит зависимость в приватное поле даже если нет конструктора или сетера.
Делает она это с помощью Java Reflection API
Примеры:
    Конструктор:
        @Autowired
        public MusicPlayer(Music music)   { this.music = music; }
        @Autowired
        public MusicPlayer(ClassicalMusic c)   { this.c = c; }
    Поля:
        @Autowired
        private Music music;
    Методы/Setters (в отличие от XML, название метода может быть любое):
        @Autowired
        public void setMusic(Music music)   { this.music = music; } */
@Component 
class Bilingual implements Language { // [AXML102]
    private Language langOne;
    
    @Autowired
    private Poland langTwo;    
    
    @Autowired
    public Bilingual(English langOne) {        
        this.langOne = langOne;
    }
    
    @Override
    public String getLang() {
        return this.getClass().getSimpleName() + ": " + langOne.getLang() + langTwo.getLang();
    }
} // end of class Bilingual

/*
@Qualifier("beanId") - указываем Id того бина, который хотим внедрить. 
Можно установить на конструкторах, сеттерах, полях. Обратить внимание на 
специфическое расположение аннотации в конструкторах рядом с аргументами. */
@Component 
class SlavicLanguages implements Language { // [AXML103]
    @Autowired
    @Qualifier("ukrainian")
    private Language langOne;
    
    @Autowired
    @Qualifier("poland")
    private Poland langTwo;  
    
    @Override
    public String getLang() {
        return this.getClass().getSimpleName() + ": " + langOne.getLang() + langTwo.getLang();
    }
} // end of class SlavicLanguages

@Component 
class Diglossia implements Language { // [AXML103]
    private Language langOne, langTwo;
    
    @Autowired
    public Diglossia(@Qualifier("englishLang") Language langOne, @Qualifier("ukrainian") Language langTwo) {        
        this.langOne = langOne;
        this.langTwo = langTwo;
    }
    
    @Override
    public String getLang() {
        return this.getClass().getSimpleName() + ": " + langOne.getLang() + langTwo.getLang();
    }
} // end of class Diglossia

@Component
class Italian implements Language { // [AXML104]
    @Value("${langItaly.name}")
    private String word;

    @Value("${langItaly.volume}")
    private int power;
    
    @Value(" I am from Italy ")
    private String sentance;
    
    @Value("1.2")
    private double square;
    
    @Override
    public String getLang() {
        return this.getClass().getSimpleName() + ": " + word + power + sentance + square;
    }
} // end of class Italian


@Component 
@Scope("singleton") // бессмысленное указание, т.к. и так синглтон по умолчанию
class Ukrainian implements Language { // [AXML105]
    @Override
    public String getLang() {
        return this.getClass().getSimpleName();
    }
}

@Component 
@Scope("prototype")
class Spanish implements Language { // [AXML105]
    @Override
    public String getLang() {
        return this.getClass().getSimpleName();
    }
}

@Component 
class Japanese implements Language {
    @Override
    public String getLang() {
        return this.getClass().getSimpleName();
    }
    
    @PostConstruct // Mожно пометить несколько методов.
    public void doMyInit() {
        System.out.println(this.getClass().getSimpleName() + ": Doing my initialization");
    }

    @PreDestroy // Для Prototype бинов не вызывается destroy-метод! ; Mожно пометить несколько методов.
    public void doMyDestroy() {
        System.out.println(this.getClass().getSimpleName() + ": Doing my destruction");
    }
}


/*
Multilingual
polylingual
*/


/*
@Autowired - указывает, что значение свойства нужно вставить из контекста

@Autowired именно Spring аннотация. Однако Spring фреймворк поддерживает также
стандартные JSR аннотации.
Использование JSR аннотаций позволяет быть еще более независимым от Spring-а,
а также переиспользовать помеченные классы в других контейнерах, напр. JBoss Seam
Аналог @Autowired в JSR аннотациях - @Inject (JSR 330).
Разница в том, что у @Autowired есть  параметр @Autowired(required=false)
false - при отсутствии бина будет установлен null, true - выбросит Exception.

@Autowired кроме бинов можно внедрять и внутрение объекты Spring. Can be used to inject:
- BeanFactory
- ApplicationContext
- ResourceLoader
- ApplicationEventPublisher
т.е.  не нужнo будет реализовывать Aware-интерфейсы, чтобы получить эти объекты.

Аналог @Qualifier("beanId") в JSR аннотациях - @Resource(name="beanId") (JSR 250).

@Component = @Service = @Repository = @Controller
Одинаковые и служат только для логики developer-a(напр в MVC). 
*/