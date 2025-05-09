package zadaci.polaznikHashMap;

public class Polaznik implements Comparable<Polaznik>{
    private String ime;
    private  String prezime;
    private  String email;

    public Polaznik(String ime, String prezime, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return
                "ime= " + ime +
                ", prezime= " + prezime +
                ", email= " + email +"\n";
    }

    @Override
    public int compareTo(Polaznik o) {
        return this.email.compareTo(o.email);
    }
}

