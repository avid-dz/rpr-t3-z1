package ba.unsa.etf.rpr.tutorijal03;

//ovu klasu ni ne treba implementovati ovdje jer je apstraktna
//iz ove klase izvedene su jos tri klase
public abstract class TelefonskiBroj implements Comparable<TelefonskiBroj> {

    public abstract String ispisi();
    public abstract int hashCode();

    @Override
    public int compareTo(TelefonskiBroj telefonskiBroj) {
        return ispisi().compareTo(telefonskiBroj.ispisi());
    }
}
