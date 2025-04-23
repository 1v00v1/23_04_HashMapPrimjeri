package zadaci.random;

import zadaci.polaznikHashMap.Polaznik;

import java.util.*;

/*
*
Napiši program za evidenciju polaznika na tečaju koji osigurava jedinstvenost e-mail adresa polaznika te
* nasumično mijenja redoslijed polaznika prije ispisa. Program treba omogućiti unos polaznika i njihovih podataka,
*  provjeriti jesu li e-mail adrese jedinstvene te ispisati polaznike u nasumičnom redoslijedu.

* Koristi klasu Polaznik s atributima: ime, prezime i e-mail.
* Koristi HashMap<String, Polaznik> za pohranu polaznika, gdje je ključ e-mail adresa, a vrijednost objekt klase Polaznik.
* Napravi glavnu klasu EvidencijaPolaznika koja sadrži main metodu.
* Omogući korisniku unos novih polaznika (ime, prezime, e-mail).
* Pri dodavanju novog polaznika, provjeri je li e-mail adresa već prisutna u evidenciji.
* Ako je, ispiši odgovarajuću poruku i ne dopusti unos polaznika s istom e-mail adresom.
* Nakon unosa svih polaznika, nasumično izmiješaj redoslijed polaznika prije ispisa.
* Ispiši sve polaznike na tečaju u nasumičnom redoslijedu.
* Isprobaj ispis nakon korištenja drugih metoda iz klase Collections*/
public class Evidencija {
    public static void main(String[] args) {

        HashMap<String, Polaznik> p = new HashMap<>();

        Scanner s = new Scanner(System.in);
        Boolean exit = false;

        do {
            printMenu();
            int izbor = Integer.parseInt(s.nextLine());
            switch (izbor) {
                case 1 -> {
                    Polaznik pol = UnosPolaznika(s, p);
                    p.put(pol.getEmail(), pol);
                }

                case 2 -> IspisPolaznika(p);

                default -> exit = true;

            }


        } while (exit == false);

    }

    private static void IspisPolaznika(HashMap<String, Polaznik> p) {

        System.out.println("Lista polaznika :");
        List<Polaznik> polaznici = new ArrayList<>(p.values());
        System.out.println(polaznici);
        System.out.println("-".repeat(30));

        System.out.println("Lista shuffle :");
        Collections.shuffle(polaznici);
        System.out.println(polaznici);
        System.out.println("-".repeat(30));

        System.out.println("Lista  sortirana:");
        Collections.sort(polaznici);
        System.out.println(polaznici);
        System.out.println("-".repeat(30));

    }


    public static Polaznik UnosPolaznika(Scanner s, HashMap<String, Polaznik> p) {
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
                if (k.contains(email)) {
                    System.out.println("Email se koristi Ponovite unos");
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
