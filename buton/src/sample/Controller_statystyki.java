package sample;



import javafx.scene.control.Label;


public class Controller_statystyki implements HierarchicalController<Controller>{

    private Controller parentController;
    public Label sredni_wiek;
    public Label sredni_wzrost;
    public Label liczba_osob;


    @Override
    public void setParentController(Controller parentController) {
        this.parentController = parentController;
        this.wypiszStatsy();
    }

    public Controller getParentController() {
        return parentController;
    }


public void wypiszStatsy(){
if (parentController.getStatsy()!=null) {
    sredni_wiek.setText(parentController.getStatsy().getSrwiek().toString());
    sredni_wzrost.setText(parentController.getStatsy().getSrwzrost().toString());
    liczba_osob.setText(parentController.getStatsy().getLosob().toString());
    }else{
    sredni_wiek.setText("Brak ststystyk");
    sredni_wzrost.setText("Brak ststystyk");
    liczba_osob.setText("Brak ststystyk");
   }
    }

}
