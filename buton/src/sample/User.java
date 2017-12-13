package sample;

import javafx.fxml.FXML;

import java.awt.*;

public class User {

        @FXML
        private String login;
        private String haslo;
        private String rola;
        private Boolean czy_admin;


    public User ( String login, String haslo, String rola){
            this.login=login;
            this.haslo=haslo;
            this.rola=rola;
        }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login =login;
    }


    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }



    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }


    public Boolean getCzy_admin() {
        return czy_admin;
    }

    public void setCzy_admin(Boolean czy_admin) {
        this.czy_admin = czy_admin;
    }
}
