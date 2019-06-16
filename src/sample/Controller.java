package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.ArrayList;

public class Controller {

    private ObservableList<User> listData;

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, String> firstColumn;

    @FXML
    private TableColumn<User, String> secondColumn;

    @FXML
    private Button addCellInTable;

    @FXML
    public void initialize(){
        table.setEditable(true);

        initCellTableColAsTextField(firstColumn, "firstColumn");
        initCellTableColAsTextField(secondColumn, "secondColumn");

        updateCell(firstColumn);
        updateCell(secondColumn);

        listData = getListData();

        table.setItems(listData);
        /*
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                table.setItems(listData);
            }
        });*/
    }

    private void initCellTableColAsTextField (TableColumn<User, String> tableColumn ,String nameFieldUser){
        tableColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));

        tableColumn.setCellFactory(TextFieldTableCell.<User> forTableColumn());
    }

    private void updateCell(TableColumn<User, String> tableColumn){
        tableColumn.setOnEditCommit((TableColumn.CellEditEvent<User, String> event) -> {
            TablePosition<User, String> pos = event.getTablePosition();

            String newCell = event.getNewValue();

            int row = pos.getRow();

            // switching on a list of columns
            switch (tableColumn.getText()){
                case "C1":{
                    User user = event.getTableView().getItems().get(row);

                    user.setFirstCell(newCell);

                    System.out.println(user.getFirstCell() + "   " + user.getSecondCell());
                }break;

                case "C2":{
                    User user = event.getTableView().getItems().get(row);

                    user.setSecondCell(newCell);

                    System.out.println(user.getFirstCell() + "   " + user.getSecondCell());
                }break;
            }
        });
    }

    private void addCell(TableColumn<User, String> tableColumn){

    }

    private ObservableList<User> getListData() {
        User user1 = new User("aaaaa", "dbbbbb");
        User user2 = new User("dshfghd", "yukfgh");
        User user3 = new User("adjdfhhnvgaaaa", "tyrutye");

        ArrayList<User> sd = new ArrayList<>();
        sd.add(user1);
        sd.add(user2);
        sd.add(user3);

        return FXCollections.observableArrayList(sd);
    }

    public void setListData(ObservableList<User> listData) {
        this.listData = listData;
    }
}
