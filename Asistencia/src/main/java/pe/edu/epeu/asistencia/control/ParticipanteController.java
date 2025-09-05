package pe.edu.epeu.asistencia.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.epeu.asistencia.enums.Carrera;
import pe.edu.epeu.asistencia.enums.TipoParticipante;
import pe.edu.epeu.asistencia.modelo.Participante;
import pe.edu.epeu.asistencia.servicio.ParticipanteServicioI;
import pe.edu.epeu.asistencia.servicio.ParticipanteServicioImp;

@Controller
public class ParticipanteController {

    @FXML
    private ComboBox<Carrera> cbxCarrera;
    @FXML
    private ComboBox<TipoParticipante> cbxTipoParticipante;

    @FXML
    private TableView<Participante> TableRegPart;
    ObservableList<Participante> participantes;

    @Autowired
    ParticipanteServicioI ps;

    @FXML
    public void initialize(){
        cbxCarrera.getItems().addAll(Carrera.values());
        cbxTipoParticipante.getItems().addAll(TipoParticipante.values());

        cbxCarrera.getSelectionModel().selectLast();
        Carrera carrera = cbxCarrera.getSelectionModel().getSelectedItem();
        System.out.println(carrera);
        //select(4) mostrara nutricion que esta en la posicion 4 de carrera
    }

    public void listarParticipante(){
        TableColumn<Participante,String> dniCol = new TableColumn<>("DNI");
        dniCol.setCellValueFactory(cellData -> cellData.getValue().getDni());

        TableColumn<Participante,String> nombreCol = new TableColumn<>("Nombre");
        nombreCol.setCellValueFactory(cellData -> cellData.getValue().getDni());

        participantes = FXCollections.observableList(ps.findAll());
        TableRegPart.getColumns().addAll(dniCol,nombreCol);
        TableRegPart.setItems(participantes);

    }
}
