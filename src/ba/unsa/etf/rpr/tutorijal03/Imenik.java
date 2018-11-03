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
        boolean pronadjenBroj = false;
        for (Map.Entry<String, TelefonskiBroj> par : mapaOsoba.entrySet()) {
            if (par.getValue().compareTo(broj) == 0) pronadjenBroj = true;
        }
        if (!pronadjenBroj) throw new IllegalArgumentException("Taj broj nije ni upisan u imenik!");
        String trazeno = "";
        for (Map.Entry<String, TelefonskiBroj> par : mapaOsoba.entrySet()) {
            if (par.getValue().compareTo(broj) == 0) trazeno = par.getKey();
        }
        return trazeno;
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
        TreeSet<String> skup = new TreeSet<>();
        for (Map.Entry<String, TelefonskiBroj> par : mapaOsoba.entrySet()) {
            if (par.getValue() instanceof FiksniBroj) {
                FiksniBroj fiksni = (FiksniBroj) par.getValue();
                if (fiksni.getGrad() == g) skup.add(par.getKey());
            }
        }
        return skup;
    }
    public Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g) {
        TreeSet<TelefonskiBroj> skup = new TreeSet<>();
        for (TelefonskiBroj broj : mapaOsoba.values()) {
            if (broj instanceof FiksniBroj) {
                if (((FiksniBroj) broj).getGrad() == g) skup.add(broj);
            }
        }
        return skup;
    }
}