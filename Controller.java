package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class Controller {

    @FXML
    private TextField fieldID;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldSurname;
    @FXML
    private TextField fieldPayment;
    @FXML
    private TextField fieldSuccess;
    @FXML
    private TextField fieldRemove;
    @FXML
    private Label lblRemove;
    @FXML
    private TableView<Worker> tblView;
    @FXML
    private TableColumn<Worker, Integer> idColumn;
    @FXML
    private TableColumn<Worker, String> nameColumn;
    @FXML
    private TableColumn<Worker, String> surnameColumn;
    @FXML
    private TableColumn<Worker, Double> paymentColumn;

    private ObservableList<Worker> workers = FXCollections.observableArrayList();
    @FXML
    private void initialise(){
        idColumn.setCellValueFactory(new PropertyValueFactory<Worker, Integer>("ID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Worker, String>("surname"));
        paymentColumn.setCellValueFactory(new PropertyValueFactory<Worker, Double>("payment"));
    }
    public Controller(){
    }

    public void onAdd(){
        initialise();
        if (!fieldID.getText().isEmpty() && !fieldName.getText().isEmpty() && !fieldSurname.getText().isEmpty() && !fieldPayment.getText().isEmpty()){
            try{
            workers.add(new Worker(Integer.parseInt(fieldID.getText()), fieldName.getText(), fieldSurname.getText(), Double.parseDouble(fieldPayment.getText())));}
            catch (NumberFormatException e){}
            tblView.setItems(workers);
            fieldSuccess.setText("Successful add");
        } else fieldSuccess.setText("Failure");
        fieldID.setText("");
        fieldName.setText("");
        fieldSurname.setText("");
        fieldPayment.setText("");
    }
    public void onMouseEnterRemove(){
        lblRemove.setVisible(true);
        fieldRemove.setVisible(true);
    }
    public void onRemove(){
        for (Worker wrk: workers) {
            if(wrk.getID() == Integer.parseInt(fieldRemove.getText()))
                workers.remove(wrk);
        }
        tblView.setItems(workers);
        lblRemove.setVisible(false);
        fieldRemove.setVisible(false);
        fieldRemove.setText("");
    }



}
