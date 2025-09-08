package pe.edu.epeu.asistencia.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
    private TextField txtDNI, txtNombres, txtApellidos;

    @FXML
    private TableView<Participante> TableRegPart;
    ObservableList<Participante> participantes;

    @Autowired
    ParticipanteServicioI ps;

    TableColumn<Participante,String> dniCol, nombreCol, apellidosCol, carreraCol, tipoParticipanteCol;

    @FXML
    public void initialize(){
        cbxCarrera.getItems().addAll(Carrera.values());
        cbxTipoParticipante.getItems().addAll(TipoParticipante.values());
        cbxCarrera.getSelectionModel().selectLast();
        Carrera carrera = cbxCarrera.getSelectionModel().getSelectedItem();
        System.out.println(carrera.name());
        definirColumnas();
        listarParticipante();
        //select(4) mostrara nutricion que esta en la posicion 4 de carrera
    }

    public void limpiarFormulario(){
        cbxCarrera.getSelectionModel().clearSelection();
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDNI.setText("");
        cbxCarrera.getSelectionModel().clearSelection();
        cbxTipoParticipante.getSelectionModel().clearSelection();
    }

    @FXML
    public void registrarParticipante(){
        Participante p = new Participante();
        p.setDni(new SimpleStringProperty(txtDNI.getText()));
        p.setNombre(new SimpleStringProperty(txtNombres.getText()));
        p.setApellidos(new SimpleStringProperty(txtApellidos.getText()));
        p.setCarrera(cbxCarrera.getSelectionModel().getSelectedItem());
        p.setTipoParticipante(cbxTipoParticipante.getSelectionModel().getSelectedItem());
        ps.save(p);
        limpiarFormulario();
        listarParticipante();

    }

    public void definirColumnas(){
        dniCol = new TableColumn<>("DNI");
        nombreCol = new TableColumn<>("Nombre");
        apellidosCol = new TableColumn<>("Apellido");
        carreraCol = new TableColumn<>("Carrera");
        tipoParticipanteCol = new TableColumn<>("Tipo Participante");

        TableRegPart.getColumns().addAll(dniCol, nombreCol, apellidosCol, carreraCol, tipoParticipanteCol);
    }

    public void listarParticipante(){
        dniCol.setCellValueFactory(cellData -> cellData.getValue().getDni());
        nombreCol.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        apellidosCol.setCellValueFactory(cellData -> cellData.getValue().getApellidos());
        carreraCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarrera().toString()));
        participantes = FXCollections.observableList(ps.findAll());
        TableRegPart.setItems(participantes);

    }
}
