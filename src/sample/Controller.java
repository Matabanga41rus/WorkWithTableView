package sample;

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

    private String[] listNameColumn = {"C1", "C2"};

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, String> firstCell;

    @FXML
    private TableColumn<User, String> secondCell;

    @FXML
    private Button addCellInTable;

    @FXML
    private Button deleteCell;

    @FXML
    public void initialize(){
        table.setEditable(true);

        initCellTableColAsTextField(firstCell, "firstCell");
        initCellTableColAsTextField(secondCell, "secondCell");

        updateCell(firstCell);
        updateCell(secondCell);

        listData = getListData();

        table.setItems(listData);
        System.out.println(listData);
        table.refresh();

        addCellInTable.setOnAction(event -> {
            listData.add(new User("null", "null"));
        });

        deleteCell.setOnAction(event -> {

        });

        /*
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                table.setItems(listData);
            }
        });*/

    }

    private void deleteFullStringInTable(TableColumn<User, String> tableColumn){

    }

    private void initCellTableColAsTextField (TableColumn<User, String> tableColumn ,String nameFieldUser){
        tableColumn.setCellValueFactory(new PropertyValueFactory<>(nameFieldUser));

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
