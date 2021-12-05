package net.kiranatos.core.s01xml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface Waifu {
    public String getName();    
}

class YandereWaifu implements Waifu { // [XML0101]
    @Override
    public String getName() {
        return "Mikasa Ackerman – Attack on Titan [" + getClass().getSimpleName() + "]";
    }
} // *********************************** end of class YandereWaifu

class UndereWaifu implements Waifu { // [XML0102]
    @Override
    public String getName() {
        return "Misa Amane from Death Note [" + getClass().getSimpleName() + "]";
    }
} // *********************************** end of class UndereWaifu

class TsundereWaifu implements Waifu { // [XML0201]
    private Waifu imouto;
    private TsundereWaifu(Waifu imouto) { this.imouto = imouto; }
    public String getSister()           { return imouto.getName(); }
    @Override
    public String getName()             { return "Aisaka Taiga from Toradora [" + getClass().getSimpleName() + "]"; }    
} // *********************************** end of class TsundereWaifu

class KuudereWaifu implements Waifu { // [XML0301]
    private String phrase;
    private int years;
    private Waifu imouto;
    private List<Waifu> garem = new ArrayList<>();

    public void setGarem(List<Waifu> garem) { this.garem = garem; }
    public void setYears(int years)         { this.years = years; }
    public void setImouto(Waifu imouto)     { this.imouto = imouto; }
    private KuudereWaifu(String phrase)     { this.phrase = phrase; }
    public String getFamily() {
        String str = " She is " + years + ", she say: " + phrase + ", her lovely sister: " + imouto.getName() + ". All family: ";
        for (Waifu a: garem) str = str + a.getName() + " ";
        return str;
    }
    @Override
    public String getName()                 { return "Shiro from No Game No Life [" + getClass().getSimpleName() + "]"; }
} // *********************************** end of class KuudereWaifu

class DandereWaifu implements Waifu { // [XML0401]
    private String phrase;
    private int years;
    private double size;
    private Waifu imouto;

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setImouto(Waifu imouto) {
        this.imouto = imouto;
    }
    public String getInfo() {        
        return " She is " + years + ", her size: " + size + ", she say: " + phrase + ", her lovely sister: " + imouto.getName();
    }
    @Override
    public String getName() {
        return "Mio Akiyama from K-on! [" + getClass().getSimpleName() + "]";
    }
} // *********************************** end of class DandereWaifu

class Himedere implements Waifu { //[XML0501]
    @Override
    public String getName() {
        return "Lilith Bristol from Absolute Duo [" + getClass().getSimpleName() + "]";
    }
} // *********************************** end of class Himedere

class Deredere implements Waifu { // [XML0601]
    public void doMyInit()          { System.out.println("*** Doing my initialization DEREDERE ***"); }
    public void doMyDestroy()       { System.out.println("*** Doing my destruction DEREDERE ***"); }
    @Override
    public String getName() {
        return "Ako Tamaki from Netoge no Yome wa Onnanoko ja Nai to Omotta? [" + getClass().getSimpleName() + "]";
    }
} // *********************************** end of class Deredere

class Kamidere implements Waifu { // [XML0701]
    private Kamidere() { }
    public static Kamidere getLovelyKamidereWaifu() {
        System.out.println("Fabric of Kamidere: creating waifu");
        return new Kamidere();
    }
    @Override
    public String getName() {
        return "Mio Isurugi from MM! [" + getClass().getSimpleName() + "]";
    }
} // *********************************** end of class Kamidere

class MayadereWaifu implements Waifu { // [XML0202]
    private int years = 0;
    private String name = "NoName";
    private String anime = "NoName";
    private boolean isFree = false;
    private Waifu imouto1 = new YandereWaifu();
    private Waifu imouto2 = new YandereWaifu();
    private Date today = new Date(1251303594910L);

    public MayadereWaifu(int years, String name, String anime, boolean isFree) { // 1) 2)
        this.years = years;
        this.anime = anime;
        this.name = name;
        this.isFree = isFree;
    }
    
    public MayadereWaifu(int years, String name, boolean isFree) { // 3) 5)
        this.years = years;        
        this.name = name;
        this.isFree = isFree;
    }
    
    public MayadereWaifu(Integer years, String name, StringBuilder anime, Boolean isFree) { // 4)
        this.years = years;
        this.anime = anime.toString();
        this.name = name;
        this.isFree = isFree;
    }
    
    public MayadereWaifu(Kamidere imouto1, UndereWaifu imouto2) { // 6)
        this.imouto1 = imouto1;        
        this.imouto2 = imouto2;        
    }    
    
    public MayadereWaifu(Date today) { // 7)
        this.today = today;               
    }    
    
    @Override
    public String getName() {        
        return name + " from " + anime + " [" + getClass().getSimpleName() + "] years:" +
                years + isFree + " sisters: " + imouto1.getName() + " & " + imouto2.getName() + " DATE:" + today;
    }
} // *********************************** end of class MayadereWaifu

class BodereWaifu implements Waifu { // [XML0800]
    private String words = "хрусь-хрусь ";
    private int t = 106;
    public BodereWaifu(String words, int t) { this.words = words; this.t = t; }
    @Override
    public String getName() {
        return "Mio Akiyama - K-ON! [" + getClass().getSimpleName() + "] saying: " + words + t + " times.";
    }
} // *********************************** end of class BodereWaifu

class HinedereWaifu implements Waifu { // [XML0800]    
    private String words = "кусь-кусь ";
    private int t = 105;
    private boolean b = false;
    public HinedereWaifu(String words, int t, boolean b) { this.words = words; this.t = t; this.b = b; }
    @Override
    public String getName() {
        return "Yuuko Ichihara – xxxHOLiC [" + getClass().getSimpleName() + "] saying: " + words + t + " times. " + b;
    }
} // *********************************** end of class HinedereWaifu

class CoodereWaifu implements Waifu { // [XML0800]
    private String words = "мяю-мяю ";
    private int t = 111;
    public CoodereWaifu(String words, int t) { this.words = words; this.t = t; }
    @Override
    public String getName() {
        return "Rei Ayanami - Neon Genesis Evangelion [" + getClass().getSimpleName() + "] saying: " + words + t + " times.";
    }
} // *********************************** end of class CoodereWaifu



class UtsudereWaifu implements Waifu { // [XML0801]
    @Override
    public String getName() {
        return "Miranda Lotto - D.Gray-man [" + getClass().getSimpleName() + "]";
    }
} // *********************************** end of class UtsudereWaifu

class ShundereWaifu implements Waifu { // [XML0802]
    @Override
    public String getName() {
        return "Mei Misaki - Another [" + getClass().getSimpleName() + "]";
    }
} // *********************************** end of class ShundereWaifu

/*  
Byoukidere
Hajidere
Lolita
Bakadere
Tsunshun
Darudere
Yangire
Yandegire
Giseidere
Kuugire
Gundere
Dorodere
https://www.hxchector.com/all-dere-types-anime-manga/
https://the-dere-types.fandom.com/wiki/Category:Violent
 */