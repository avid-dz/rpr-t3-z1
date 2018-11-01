package ba.unsa.etf.rpr.tutorijal03;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import static ba.unsa.etf.rpr.tutorijal03.FiksniBroj.Grad.*;

public class Imenik {

    private HashMap<String, TelefonskiBroj> mapaOsoba;

    public Imenik() {
        mapaOsoba = new HashMap<>();
    }

    public void dodaj(String ime, TelefonskiBroj broj) {
        mapaOsoba.put(ime, broj);
    }
    public String dajBroj(String ime) {
        return mapaOsoba.get(ime).ispisi();
    }
    public String dajIme(TelefonskiBroj broj) {
        return "";
    }
    public String naSlovo(char s) {
        return "";
    }
    public Set<String> izGrada(FiksniBroj.Grad g) {
        return new TreeSet<>();
    }
    public Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g) {
        return new TreeSet<>();
    }
}