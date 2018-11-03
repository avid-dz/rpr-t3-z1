package ba.unsa.etf.rpr.tutorijal03;

public abstract class TelefonskiBroj implements Comparable<TelefonskiBroj> {

    public abstract String ispisi();
    public abstract int hashCode();

    @Override
    public int compareTo(TelefonskiBroj telefonskiBroj) { //zbog smjestanja u TreeSet i sortiranja po metodi ispisi()
        return ispisi().compareTo(telefonskiBroj.ispisi());
    }
}
