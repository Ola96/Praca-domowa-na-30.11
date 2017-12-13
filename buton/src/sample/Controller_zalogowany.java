package sample;


import javafx.scene.control.TextField;
import javafx.scene.control.Label;


public class Controller_zalogowany implements HierarchicalController<Controller> {

    private Controller parentController;
    public TextField wprowadz_login;
    public TextField wprowadz_haslo;
    public Label error;


    @Override
    public void setParentController(Controller parentController) {
        this.parentController = parentController;
    }

    public Controller getParentController() {
        return parentController;
    }


    public void zaloguj() {

        String user_haslo = new String(wprowadz_haslo.getText());
        String user_login = new String(wprowadz_login.getText());

        if ("admin".equals(user_haslo) && !user_login.equals("")) {
            User uzytkownik = new User(user_login, user_haslo, "administrator");
            uzytkownik.setCzy_admin(Boolean.TRUE);
            getParentController().zaloguj(uzytkownik);
            getParentController().setAktualny(uzytkownik);
            getParentController().logowanie(new javafx.event.ActionEvent());

        } else if ("user".equals(user_haslo) && !user_login.equals("")) {
            User uzytkownik = new User(user_login, user_haslo, "użytkownik");
            uzytkownik.setCzy_admin(Boolean.FALSE);
            getParentController().zaloguj(uzytkownik);
            getParentController().setAktualny(uzytkownik);
            getParentController().logowanie(new javafx.event.ActionEvent());
        } else {
            error.setText("Nieprawidłowe hasło lub login");
        }


    }
}