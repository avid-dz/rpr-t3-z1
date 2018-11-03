package ba.unsa.etf.rpr.tutorijal03;

import java.util.HashMap;
import java.util.Map;
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
        if(!mapaOsoba.containsKey(ime)) throw new IllegalArgumentException("To ime nije ni upisano u imenik!");
        return mapaOsoba.get(ime).ispisi();
    }
    public String dajIme(TelefonskiBroj broj) {
        if(!mapaOsoba.containsValue(broj)) throw new IllegalArgumentException("Taj broj nije ni upisan u imenik!");
        return "";
    }
    public String naSlovo(char s) {
        int brojOsobaNaSlovo = 0;
        String ispis = "";
        for (Map.Entry<String, TelefonskiBroj> par : mapaOsoba.entrySet()) {
            if (par.getKey().charAt(0) == s) {
                brojOsobaNaSlovo++;
                ispis += brojOsobaNaSlovo;
                ispis += ". ";
                ispis += par.getKey();
                ispis += " - ";
                ispis += par.getValue().ispisi();
                ispis += "\n";
            }
        }
        return ispis;
    }
    public Set<String> izGrada(FiksniBroj.Grad g) {
        return new TreeSet<>();
    }
    public Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g) {
        return new TreeSet<>();
    }
}