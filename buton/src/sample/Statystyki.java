package sample;

public class Statystyki {

    public Integer losob;
    public Double srwzrost;
    public Double srwiek;

public Statystyki (Integer losob, Double srwzost, Double srwiek){
   this.losob=losob;
   this.srwiek=srwiek;
   this.srwzrost=srwzost;
}

    public Double getSrwzrost() {
        return srwzrost;
    }

    public Integer getLosob() {
        return losob;
    }

    public Double getSrwiek() {
        return srwiek;
    }

    public void setLosob(Integer losob) {
        this.losob = losob;
    }

    public void setSrwzrost(Double srwzrost) {
        this.srwzrost = srwzrost;
    }

    public void setSrwiek(Double srwiek) {
        this.srwiek = srwiek;
    }
}
