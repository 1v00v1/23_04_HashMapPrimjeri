package zadaci.polaznikHashMap;

import java.util.*;

/*
Napiši program za evidenciju polaznika na tečaju koji osigurava jedinstvenost e-mail adresa polaznika.
 Program treba omogućiti unos polaznika i njihovih podataka te provjeriti jesu li e-mail adrese jedinstvene.

* Koristi klasu Polaznik s atributima: ime, prezime i e-mail
* Koristi HashMap<String, Polaznik> za pohranu polaznika, gdje će ključ biti e-mail adresa, a vrijednost objekt klase Polaznik.
* Napravi glavnu klasu EvidencijaPolaznika koja sadrži main metodu.
* Omogući korisniku unos novih polaznika (ime, prezime, e-mail).
* Pri dodavanju novog polaznika, provjeri je li e-mail adresa već prisutna u evidenciji polaznika.
 Ako je e-mail adresa već prisutna, ispiši odgovarajuću poruku i ne dopusti unos polaznika s istom e-mail adresom.
* Omogući ispis svih polaznika na tečaju nakon unosa.

Što bi trebalo izmijeniti u rješenju ako dodamo novi zahtjev?
* Svi polaznici moraju biti cijelo vrijeme sortirani po emailu uzlazno
 */
public class Evidencija {
    public static void main(String[] args) {

        HashMap<String,Polaznik> p = new HashMap<>();

        Scanner s = new Scanner(System.in);
        Boolean exit = false;

        do {
            printMenu();
            int izbor = Integer.parseInt(s.nextLine());
            switch (izbor) {
                case 1 -> {
                    Polaznik pol = UnosPolaznika(s,p);
                    p.put(pol.getEmail(), pol);
                }

                case 2 -> IspisPolaznika(p);

                default -> exit = true;

            }


        } while (exit == false);

    }

    private static void IspisPolaznika(HashMap<String,Polaznik> p) {

        System.out.println("Lista polaznika :");
        TreeMap<String, Polaznik> tm =new TreeMap<>();
        tm.putAll(p);
        for (Polaznik pol : tm.values()) {
            System.out.println(pol);
        }
    }



    public static Polaznik UnosPolaznika(Scanner s, HashMap<String,Polaznik> p ) {
        boolean ex = false;
        String email;
        System.out.print("Unesite Ime : ");
        String ime = s.nextLine();
        System.out.print("Unesite Prezime : ");
        String prezime = s.nextLine();

        System.out.print("Unesite Email : ");
        email = s.nextLine();
        for (String k : p.keySet()) {
            do {
                if (k.equals(email)) {
                    System.out.println("Email se koristi\nPonovite unos");
                    System.out.print("Unesite Email : ");
                    email = s.nextLine();
                } else {
                    System.out.println("polaznik uspješno unesen");
                    ex = true;
                }


            } while (!ex);
        }
        return new Polaznik(ime, prezime, email);


    }

    public static void printMenu() {
        System.out.println("-".repeat(30));
        System.out.println("1: Unos \n" +
                "2: Ispis polaznika\n" +
                "3: izlaz");
        System.out.println("-".repeat(30));
        System.out.print("Unesite izbor: ");
    }

}

