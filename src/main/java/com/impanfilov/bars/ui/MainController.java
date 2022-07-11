package com.impanfilov.bars.ui;

import com.impanfilov.bars.model.Contract;
import com.impanfilov.bars.service.ContractService;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
@FxmlView("main.fxml")
public class MainController {

    @Autowired
    ContractService contractService;

    @FXML private TableView<Contract> table;

    private ObservableList<Contract> data;

    @FXML
    public void initialize() {

        List<Contract> contacts = contractService.findAll();
        data = FXCollections.observableArrayList(contacts);

        TableColumn<Contract, Integer> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Contract, String> numberColumn = new TableColumn<>("Номер");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<Contract, String> dateColumn = new TableColumn<>("Дата");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Contract, String> dateLastModifiedColumn = new TableColumn<>("Дата последнего изменения");
        dateLastModifiedColumn.setCellValueFactory(new PropertyValueFactory<>("dateLastModified"));

        TableColumn<Contract, Boolean> relevanceColumn = new TableColumn<>("Актуальность");
        relevanceColumn.setCellValueFactory(
                param -> new SimpleBooleanProperty(param.getValue().getRelevance()));
        relevanceColumn.setCellFactory(CheckBoxTableCell.forTableColumn(relevanceColumn));
        relevanceColumn.setEditable(false);

        table.getColumns().setAll(idColumn, numberColumn, dateColumn, dateLastModifiedColumn,relevanceColumn);

        this.table.setItems(data);
    }


}
