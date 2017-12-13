package sample;

public class Czlowieczek {

    protected String imie;
    protected String nazwisko;
    protected Integer wiek;
    protected Integer wzrost;
    protected String pesel;


    public Czlowieczek(String imie, String nazwisko, Integer wiek , Integer wzrost, String pesel) {
        this.imie = imie;
        this.nazwisko=nazwisko;
        this.wiek = wiek;
        this.wzrost=wzrost;
        this.pesel=pesel;
    }
    // set i get imie
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }
    // set i get nazwisko
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    // set i get wiek
    public Integer getWiek() {
        return wiek;
    }

    public void setWiek(Integer wiek) {
        this.wiek= wiek;
    }
    // set i get wzrost
    public Integer getWzrost() {
        return wzrost;
    }

    public void setWzrost(Integer wzrost) {
        this.wzrost = wzrost;
    }

// set i get pesel
    public String getPesel()
    {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }


}
