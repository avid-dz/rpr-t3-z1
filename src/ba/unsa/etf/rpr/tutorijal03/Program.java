package ba.unsa.etf.rpr.tutorijal03;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import static ba.unsa.etf.rpr.tutorijal03.FiksniBroj.Grad.*;

public class Program {

    public static void main(String[] args) {
        Map<String, FiksniBroj.Grad> mapa = new TreeMap<>();
        mapa.put("Travnik", FiksniBroj.Grad.TRAVNIK);
        mapa.put("Orasje", FiksniBroj.Grad.ORASJE);
        mapa.put("Zenica", FiksniBroj.Grad.ZENICA);
        mapa.put("Sarajevo", FiksniBroj.Grad.SARAJEVO);
        mapa.put("Livno", FiksniBroj.Grad.LIVNO);
        mapa.put("Tuzla", FiksniBroj.Grad.TUZLA);
        mapa.put("Mostar", FiksniBroj.Grad.MOSTAR);
        mapa.put("Bihac", FiksniBroj.Grad.BIHAC);
        mapa.put("Gorazde", FiksniBroj.Grad.GORAZDE);
        mapa.put("SirokiBrijeg", FiksniBroj.Grad.SIROKI_BRIJEG);
        mapa.put("Brcko", FiksniBroj.Grad.BRCKO);
        int opcija;
        Scanner scan = new Scanner(System.in);
        Imenik imenik = null;
        String imeGrada;
        String fiksniBezPozivnog;
        String mobilniBezPozivnog;
        String medunarodniBezPozivnog;
        FiksniBroj fiksni = null;
        MedunarodniBroj medunarodni = null;
        MobilniBroj mobilni = null;
        String imePrezime;
        String ime;
        String prezime;
        int mreza;
        String drzava;
        String unos;
        while (true) {
            System.out.println("Izaberite opciju (0 za kraj): ");
            System.out.println("1 - Kreiranje praznog imenika");
            System.out.println("2 - Ispis fiksnog broja");
            System.out.println("3 - Ispis mobilnog broja");
            System.out.println("4 - Ispis medunarodnog broja");
            System.out.println("5 - Dodavanje nove osobe u imenik");
            System.out.println("6 - Pretrazivanje po imenu i prezimenu");
            System.out.println("7 - Pretrazivanje po broju");
            System.out.println("8 - Pretrazivanje po pocetnom slovu imena");
            System.out.println("9 - Ispis osoba iz unesenog grada");
            System.out.println("10 - Ispis brojeva iz unesenog grada");
            opcija = scan.nextInt();
            if (opcija == 0) break;
            switch (opcija) {
                case 1:
                    imenik = new Imenik();
                    System.out.println("Imenik kreiran.");
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Unesite ime grada (za Siroki Brijeg kucajte SirokiBrijeg): ");
                    imeGrada = scan.next();
                    System.out.print("Unesite fiksni broj bez pozivnog: ");
                    fiksniBezPozivnog = scan.next();
                    fiksni = new FiksniBroj(mapa.get(imeGrada), fiksniBezPozivnog);
                    System.out.println(fiksni.ispisi());
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Unesite mobilnu mrezu: ");
                    mreza = scan.nextInt();
                    System.out.print("Unesite mobilni broj bez pozivnog: ");
                    mobilniBezPozivnog = scan.next();
                    mobilni = new MobilniBroj(mreza, mobilniBezPozivnog);
                    System.out.println(mobilni.ispisi());
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Unesite pozivni za drzavu: ");
                    drzava = scan.next();
                    System.out.print("Unesite medunarodni broj bez pozivnog: ");
                    medunarodniBezPozivnog = scan.next();
                    medunarodni = new MedunarodniBroj(drzava, medunarodniBezPozivnog);
                    System.out.println(medunarodni.ispisi());
                    System.out.println();
                    break;
                case 5:
                    imePrezime = "";
                    System.out.print("Unesite ime osobe: ");
                    ime = scan.next();
                    imePrezime += ime;
                    imePrezime += " ";
                    System.out.print("Unesite prezime osobe: ");
                    prezime = scan.next();
                    imePrezime += prezime;
                    System.out.println("Da li osoba ima fiksni, medunarodni ili mobilni broj?");
                    System.out.println("(Unesite FIX, MED, ili MOB u zavisnosti od toga.)");
                    unos = scan.next();
                    if (unos.trim().equals("FIX")) {
                        System.out.print("Unesite ime grada (za Siroki Brijeg kucajte SirokiBrijeg): ");
                        imeGrada = scan.next();
                        System.out.print("Unesite fiksni broj bez pozivnog: ");
                        fiksniBezPozivnog = scan.next();
                        imenik.dodaj(imePrezime, new FiksniBroj(mapa.get(imeGrada), fiksniBezPozivnog));
                    }
                    else if (unos.trim().equals("MED")) {
                        System.out.print("Unesite pozivni za drzavu: ");
                        drzava = scan.next();
                        System.out.print("Unesite medunarodni broj bez pozivnog: ");
                        medunarodniBezPozivnog = scan.next();
                        imenik.dodaj(imePrezime, new MedunarodniBroj(drzava, medunarodniBezPozivnog));
                    }
                    else if (unos.trim().equals("MOB")) {
                        System.out.print("Unesite mobilnu mrezu: ");
                        mreza = scan.nextInt();
                        System.out.print("Unesite mobilni broj bez pozivnog: ");
                        mobilniBezPozivnog = scan.next();
                        imenik.dodaj(imePrezime, new MobilniBroj(mreza, mobilniBezPozivnog));
                    }
                    else {
                        System.out.println("Neispravan unos!");
                        System.out.println();
                        break;
                    }
                    System.out.println("Osoba uspjesno dodana u imenik.");
                    System.out.println();
                    break;
                case 6:
                    imePrezime = "";
                    System.out.print("Unesite ime osobe: ");
                    ime = scan.next();
                    imePrezime += ime;
                    imePrezime += " ";
                    System.out.print("Unesite prezime osobe: ");
                    prezime = scan.next();
                    imePrezime += prezime;
                    try {
                        System.out.println(imenik.dajBroj(imePrezime));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Da li osoba ima fiksni, medunarodni ili mobilni broj?");
                    System.out.println("(Unesite FIX, MED, ili MOB u zavisnosti od toga.)");
                    unos = scan.next();
                    if (unos.trim().equals("FIX")) {
                        System.out.print("Unesite ime grada (za Siroki Brijeg kucajte SirokiBrijeg): ");
                        imeGrada = scan.next();
                        System.out.print("Unesite fiksni broj bez pozivnog: ");
                        fiksniBezPozivnog = scan.next();
                        try {
                            System.out.println(imenik.dajIme(new FiksniBroj(mapa.get(imeGrada), fiksniBezPozivnog)));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else if (unos.trim().equals("MED")) {
                        System.out.print("Unesite pozivni za drzavu: ");
                        drzava = scan.next();
                        System.out.print("Unesite medunarodni broj bez pozivnog: ");
                        medunarodniBezPozivnog = scan.next();
                        try {
                            System.out.println(imenik.dajIme(new MedunarodniBroj(drzava, medunarodniBezPozivnog)));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else if (unos.trim().equals("MOB")) {
                        System.out.print("Unesite mobilnu mrezu: ");
                        mreza = scan.nextInt();
                        System.out.print("Unesite mobilni broj bez pozivnog: ");
                        mobilniBezPozivnog = scan.next();
                        try {
                            System.out.println(imenik.dajIme(new MobilniBroj(mreza, mobilniBezPozivnog)));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else {
                        System.out.println("Neispravan unos!");
                        System.out.println();
                        break;
                    }
                    System.out.println();
                    break;
            }
        }
    }
}
