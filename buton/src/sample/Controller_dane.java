package sample;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class Controller_dane implements HierarchicalController<Controller> {

    public TextField name;
    public TextField surname;
    public TextField age;
    public TextField hight;
    public TextField nrpesel;
    public TableView<Czlowieczek> table;
    private Controller parentController;
    public GridPane dane;

    @Override

    public void setParentController(Controller parentController) {
        this.parentController = parentController;
        table.setItems(parentController.getDataContainer().getCzlowieczeki());
        this.zniknij();
    }

    @Override
    public Controller getParentController() {
        return parentController;
    }

    public void dodaj(ActionEvent actionEvent) {
        table.getItems().add(new Czlowieczek(name.getText(), surname.getText(), Integer.parseInt(age.getText()), Integer.parseInt(hight.getText()), nrpesel.getText()));
        parentController.getDataContainer().setCzlowieczeki(table.getItems());
    }

       public void zniknij(){
       if (parentController.getAktualny()==null ){
           dane.setVisible(Boolean.FALSE);
        }
       else if(parentController.getAktualny().getCzy_admin()==Boolean.TRUE){
            dane.setVisible(Boolean.TRUE);
       }else if(parentController.getAktualny().getCzy_admin()==Boolean.FALSE){
           dane.setVisible(Boolean.FALSE);}

           }

    public void initialize() {
        for (TableColumn<Czlowieczek, ?> column : table.getColumns()) {
            if ("imie1".equals(column.getId())) {
                TableColumn<Czlowieczek, String> textColumn = (TableColumn<Czlowieczek, String>) column;
                textColumn.setCellValueFactory(new PropertyValueFactory<>("imie"));
            } else if ("nazwisko1".equals(column.getId())) {
                TableColumn<Czlowieczek, String> textColumn = (TableColumn<Czlowieczek, String>) column;
                textColumn.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
            } else if ("wiek1".equals(column.getId())) {
                TableColumn<Czlowieczek, Integer> lengthColumn = (TableColumn<Czlowieczek, Integer>) column;
                lengthColumn.setCellValueFactory(new PropertyValueFactory<>("wiek"));
            } else if ("wzrost1".equals(column.getId())) {
                TableColumn<Czlowieczek, Integer> lengthColumn = (TableColumn<Czlowieczek, Integer>) column;
                lengthColumn.setCellValueFactory(new PropertyValueFactory<>("wzrost"));
            } else if ("pesel1".equals(column.getId())) {
                TableColumn<Czlowieczek, String> textColumn = (TableColumn<Czlowieczek, String>) column;
                textColumn.setCellValueFactory(new PropertyValueFactory<>("pesel"));
            } else if ("usun".equals(column.getId())) {
                TableColumn<Czlowieczek, Czlowieczek> delateCol = (TableColumn<Czlowieczek, Czlowieczek>) column;
                delateCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
                delateCol.setCellFactory(param -> new TableCell<Czlowieczek, Czlowieczek>() {
                    private final Button deleteButton = new Button("Usuń");

                    @Override
                    protected void updateItem(Czlowieczek osoba, boolean empty) {
                        super.updateItem(osoba, empty);

                        if (osoba == null) {
                            setGraphic(null);
                            return;
                        }

                        setGraphic(deleteButton);
                        deleteButton.setOnAction(
                                event -> getTableView().getItems().remove(osoba));

                    }
                });
            }
            ;
        }
    }

    public void wyliczStatsy(ActionEvent actionEvent){
            Integer lp=0;
            Double wiek = 0.0;
            Double wzrost = 0.0;

            for (Czlowieczek czlowieczek: table.getItems()) {
                wiek+=czlowieczek.getWiek();
                wzrost+=czlowieczek.getWzrost();
                lp+=1;
            }
            wiek/=lp;
            wzrost/=lp;

            parentController.setStatsy(new Statystyki(lp,wzrost,wiek));
            parentController.statystyki(actionEvent);
        }


}


