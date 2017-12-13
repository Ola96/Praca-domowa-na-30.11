package sample;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Controller implements HierarchicalController<Controller>{

    public Pane glowna;

    protected DataContainer dataContainer;
    public Label login_label;
    public Label rola_label;
    public User aktualny;
   protected Statystyki statsy;


    @Override
    public Controller getParentController() {
        return this;
    }

    @Override
    public void setParentController(Controller parent) {

    }

    public User getAktualny (){
        return aktualny;
}

    public DataContainer getDataContainer() {
        return dataContainer;
    }

    public Controller() {
        dataContainer = new DataContainer();
    }


   private void load(String fxml) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        try {
            final BorderPane load = loader.load();
            glowna.getChildren().clear();
            glowna.getChildren().add(load);
            HierarchicalController<Controller> controller = loader.getController();
            controller.setParentController(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void logowanie(ActionEvent actionEvent) {
     if(aktualny==null){load("Zaloguj.fxml");
     } else{load("Wyloguj.fxml"); }
    }

    public void dane(ActionEvent actionEvent) {
        load("Wprowadzanie_danych.fxml");
    }
    public void statystyki(ActionEvent actionEvent) {
        load("Statystyki.fxml");

    }


    public void zaloguj(User aktualny) {
        this.aktualny=aktualny;
        login_label.setText(aktualny.getLogin());
        rola_label.setText(aktualny.getRola());
    }

    public void wyloguj(){
        this.aktualny=null;
        login_label.setText("");
        rola_label.setText("");
    }

      public void setStatsy(Statystyki statsy) {
        this.statsy = statsy;
    }

    public Statystyki getStatsy() {
        return statsy;
    }

    public void setAktualny(User aktualny) {
        this.aktualny = aktualny;
    }
}