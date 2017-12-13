package sample;

import javafx.fxml.FXML;

public class Conroller_wylogowany implements HierarchicalController<Controller>{

    private Controller parentController;
@Override

    public void setParentController(Controller parentController) {
        this.parentController = parentController; }

    public Controller getParentController() {
        return parentController;
    }

public void wyloguj(){
    getParentController().wyloguj();
    getParentController().setAktualny(null);
    getParentController().logowanie(new javafx.event.ActionEvent());
}

}
