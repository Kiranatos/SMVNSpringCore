package net.kiranatos.core.s03annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

/* Annotation shows that we want use this file for Spring config (класс-аналог XML-config-file) */
@Configuration

/* Сообщает Спрингу, классы какого пакета нужно сканировать в поиске бинов:
аналог тега <context:component-scan base-package="net.kiranatos.annotations"/> в xml */
@ComponentScan("net.kiranatos.core.s03annotations")

/* аналог тега <context:property-placeholder location="classpath:musicPlayer.properties"/> в xml */
@PropertySource("classpath:core/s03/videoPlayer.properties")

/*@Import(SpringConfig.class) импортировать другой контекст*/
public class SpringConfig {
    
    /*
    @Autowired
    private ClassBean cb; */
    
    /* Создание бина. По умолчанию scope=singleton
    аналог тега <bean id="musicBeanRock" class="net.kiranatos.RockMusic"></bean> в xml */
    @Bean
    public ComedyFilm comedyFilm() { return new ComedyFilm(); } // bean id = comedyFilm
    
    @Bean
    public HorrorFilm horrorFilm() { return new HorrorFilm(); }
    
    /* Создание бина с использованием конструктора со ссылкой на другой объект
    Ручное внедрение зависимостей (без @Autowired)
    аналог тега <bean id="musicPlayer" class="net.kiranatos.MusicPlayer"> 
                    <constructor-arg ref="musicBeanRock"/> </bean> в xml */
    @Bean
    public MysteryFilm mysteryFilm() { return new MysteryFilm(comedyFilm(), horrorFilm()); }
    
    @Bean
    public CrimeFilm crimeFilm() { return new CrimeFilm(mysteryFilm()); }
    
    @Bean
    public FantasyFilm starWarsFilm() { return new FantasyFilm(); } // bean id = starWarsFilm
    
    @Bean
    //@Scope("singleton") по умолчанию
    public HistoricalFilm historicalFilm() { return new HistoricalFilm(); }
    
    @Bean
    @Scope("prototype")
    public WesternFilm westernFilm() { return new WesternFilm(); }
}


/*
@Value("${events.file:target/events_log.txt}")
private String filename;
"events.file" - это имя переменной окружения, откуда мы возьмем имя файла.
"target/events_log.txt" - это значение по-умолчанию, если переменная окружения events.file не будет установлена.
Запись ${имя_переменной:по-умолчанию} позволяет вам получить значение из переменной окружения, либо использовать что-то по-умолчанию.
*/
