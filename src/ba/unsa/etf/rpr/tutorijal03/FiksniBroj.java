package ba.unsa.etf.rpr.tutorijal03;

import java.util.Map;
import java.util.TreeMap;

public class FiksniBroj extends TelefonskiBroj {

    enum Grad {
        TRAVNIK, ORASJE, ZENICA, SARAJEVO, LIVNO, TUZLA, MOSTAR, BIHAC, GORAZDE, SIROKI_BRIJEG, BRCKO
    }

    private Map<Grad, String> mapa;
    private String pozivni;
    private String broj;

    {
        mapa = new TreeMap<>();
        mapa.put(Grad.TRAVNIK, "030");
        mapa.put(Grad.ORASJE, "031");
        mapa.put(Grad.ZENICA, "032");
        mapa.put(Grad.SARAJEVO, "033");
        mapa.put(Grad.LIVNO, "034");
        mapa.put(Grad.TUZLA, "035");
        mapa.put(Grad.MOSTAR, "036");
        mapa.put(Grad.BIHAC, "037");
        mapa.put(Grad.GORAZDE, "038");
        mapa.put(Grad.SIROKI_BRIJEG, "039");
        mapa.put(Grad.BRCKO, "049");
    }

    public FiksniBroj(Grad grad, String broj) {
        pozivni = mapa.get(grad);
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        return pozivni + "/" + broj;
    }

    @Override
    public int hashCode() {
        return pozivni.hashCode() + broj.hashCode();
    }
}