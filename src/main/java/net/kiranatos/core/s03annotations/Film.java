package net.kiranatos.core.s03annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

public interface Film { String getFilm(); }

class ComedyFilm implements Film {
    @Override
    public String getFilm() { return "_Film's Genre: Comedy_"; }
}

class HorrorFilm implements Film {
    @Override
    public String getFilm() { return "_Film's Genre: Horror_"; }
}

class MysteryFilm implements Film {
    private Film comedyFilm, horrorFilm;

    public MysteryFilm(Film comedyFilm, Film horrorFilm) {
        this.comedyFilm = comedyFilm;    
        this.horrorFilm = horrorFilm;
    }
    
    @Override
    public String getFilm() { return "_Film's Genres: Mystery, Comedy, Horror_"; }
}

class CrimeFilm implements Film {
    private Film mysteryFilm;

    public CrimeFilm(Film mysteryFilm) { this.mysteryFilm = mysteryFilm; }
    
    @Override
    public String getFilm() { return "_Film's Genres: Crime, Mystery, Comedy, Horror_"; }
}

class FantasyFilm implements Film {
    
    @Value("${videoFilm.name}")
    private String name;

    @Value("${videoFilm.duration}")
    private int duration;
    
    @Value("G.Lukas")
    private String producer;
    
    @Value("1977")
    private double year;
    
    @Override
    public String getFilm() { return "_Film's Genre: Fantasy_ Name:" + name + " Time:" + duration + " Director:" + producer + " Y:" + year; }
}

class HistoricalFilm implements Film {    
    @PostConstruct
    public void doMyInit() { System.out.println("\tDoing my initialization in HistoricalFilm"); }
    
    @PreDestroy
    public void doMyDestroy() { System.out.println("\tDoing my destruction in HistoricalFilm"); }
    
    @Override
    public String getFilm() { return "_Film's Genre: Historical_"; }
}

class WesternFilm implements Film {
    @PostConstruct
    public void doMyInit() { System.out.println("\tDoing my initialization in WesternFilm"); }

    // Для Prototype бинов не вызывается destroy-метод!
    @PreDestroy
    public void doMyDestroy() { System.out.println("\tDoing my destruction in WesternFilm"); }
    
    @Override
    public String getFilm() { return "_Film's Genre: Western_"; }
}

/* Action
1.3 Adventure
1.6 Drama
1.11 Magical realism
1.13 Paranoid fiction
1.14 Philosophical
1.15 Political
1.16 Romance
1.17 Saga
1.18 Satire
1.19 Science fiction
1.20 Social
1.21 Speculative
1.22 Thriller
1.23 Urban */