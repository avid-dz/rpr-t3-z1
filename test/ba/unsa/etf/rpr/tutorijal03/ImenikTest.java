package ba.unsa.etf.rpr.tutorijal03;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static ba.unsa.etf.rpr.tutorijal03.FiksniBroj.Grad.*;
import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {

    @Test
    void dodaj() {
        Imenik imenik = new Imenik();
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        imenik.dodaj("Hana Hanic", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(SARAJEVO, "123-456"));
        assertEquals("033/123-456", imenik.dajBroj("Meho Mehic"));
    }

    @Test
    void naSlovo() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Pero Peric", new FiksniBroj(SARAJEVO, "123-656"));
        imenik.dodaj("Ivo Ivic", new MobilniBroj(61, "321-645"));
        imenik.dodaj("Jozo Jozic", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        assertEquals( "1. Ivo Ivic - 061/321-645", imenik.naSlovo('I').trim());
    }

    @Test
    void izGrada() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(SARAJEVO, "123-456"));
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(SARAJEVO, "123-656"));
        imenik.dodaj("Pero Peric", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        Set<String> set = imenik.izGrada(SARAJEVO);
        String result = "";
        for (String ime: set) {
            result += ime + ",";
        }
        assertEquals("Ivo Ivic,Meho Mehic,Sara Sarac,", result);
    }

    @Test
    void izGradaBrojevi() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(SARAJEVO, "123-456"));
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(SARAJEVO, "123-656"));
        imenik.dodaj("Pero Peric", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        Set<TelefonskiBroj> set = imenik.izGradaBrojevi(SARAJEVO);
        String result = "";
        for (TelefonskiBroj broj: set) {
            result += broj.ispisi() + ",";
        }
        assertEquals("033/123-156,033/123-456,033/123-656,", result);
    }

    @Test
    void dajIme() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Neko Nekic", new FiksniBroj(SARAJEVO, "123-454"));
        imenik.dodaj("Dzavid Brdar", new MedunarodniBroj("+386", "98 44-55-66"));
        imenik.dodaj("Emir Emirovic", new MobilniBroj(61, "938-671"));
        imenik.dodaj("Murat Muratovic", new FiksniBroj(SARAJEVO, "456-654"));
        assertEquals("Emir Emirovic", imenik.dajIme(new MobilniBroj(61, "938-671")));
    }

    @Test
    void dajBroj() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Neko Nekic", new FiksniBroj(SARAJEVO, "123-454"));
        imenik.dodaj("Dzavid Brdar", new MedunarodniBroj("+386", "98 44-55-66"));
        imenik.dodaj("Murat Muratovic", new FiksniBroj(SARAJEVO, "456-654"));
        assertEquals("+38698 44-55-66", imenik.dajBroj("Dzavid Brdar"));
    }

    @Test
    void dajImeIzuzetak() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Neko Nekic", new FiksniBroj(SARAJEVO, "123-454"));
        imenik.dodaj("Dzavid Brdar", new MedunarodniBroj("+386", "98 44-55-66"));
        imenik.dodaj("Emir Emirovic", new MobilniBroj(61, "938-671"));
        imenik.dodaj("Murat Muratovic", new FiksniBroj(SARAJEVO, "456-654"));
        assertThrows(IllegalArgumentException.class, () -> {imenik.dajIme(new FiksniBroj(BIHAC, "999-888"));},
                "To ime nije ni upisano u imenik!");
    }

    @Test
    void dajBrojIzuzetak() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Neko Nekic", new FiksniBroj(SARAJEVO, "123-454"));
        imenik.dodaj("Dzavid Brdar", new MedunarodniBroj("+386", "98 44-55-66"));
        imenik.dodaj("Murat Muratovic", new FiksniBroj(SARAJEVO, "456-654"));
        assertThrows(IllegalArgumentException.class, () -> {imenik.dajBroj("Niko Nikic");},
                "Taj broj nije ni upisan u imenik!");
    }
}