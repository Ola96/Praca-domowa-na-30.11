package sample;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataContainer {

    protected ObservableList<Czlowieczek> czlowieczki;

    public ObservableList<Czlowieczek> getCzlowieczeki() {
        return czlowieczki;
    }

    public void setCzlowieczeki(List<Czlowieczek> czlowieczki) {
        this.czlowieczki = FXCollections.observableArrayList(czlowieczki);
    }

    public DataContainer() {
        czlowieczki = FXCollections.observableArrayList();
    }
}

