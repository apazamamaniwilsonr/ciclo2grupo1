package pe.edu.epeu.asistencia.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
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
    TableColumn<Participante,Void> opcCol;
    int indexEdit=-1;
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
        txtDNI.requestFocus();
    }

    @FXML
    public void registrarParticipante(){
        Participante p = new Participante();
        p.setDni(new SimpleStringProperty(txtDNI.getText()));
        p.setNombre(new SimpleStringProperty(txtNombres.getText()));
        p.setApellidos(new SimpleStringProperty(txtApellidos.getText()));
        p.setCarrera(cbxCarrera.getSelectionModel().getSelectedItem());
        p.setTipoParticipante(cbxTipoParticipante.getSelectionModel().getSelectedItem());
        if (indexEdit==-1){
            ps.save(p);
        }else {
            ps.update(p,indexEdit);
            indexEdit=-1;
        }
        limpiarFormulario();
        listarParticipante();

    }

    public void definirColumnas(){
        dniCol = new TableColumn<>("DNI");
        nombreCol = new TableColumn<>("Nombre");
        apellidosCol = new TableColumn<>("Apellido");
        carreraCol = new TableColumn<>("Carrera");
        tipoParticipanteCol = new TableColumn<>("Tipo Participante");
        opcCol = new TableColumn<>("Opciones");
        TableRegPart.getColumns().addAll(dniCol, nombreCol, apellidosCol, carreraCol, tipoParticipanteCol, opcCol);
    }

    public void listarParticipante(){
        dniCol.setCellValueFactory(cellData -> cellData.getValue().getDni());
        nombreCol.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        apellidosCol.setCellValueFactory(cellData -> cellData.getValue().getApellidos());
        carreraCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarrera().toString()));
        tipoParticipanteCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoParticipante().toString()));
        agregarAccionesButton();
        participantes = FXCollections.observableList(ps.findAll());
        TableRegPart.setItems(participantes);

    }
    public void eliminarParticipante(int index){
        ps.delete(index);
        listarParticipante();
    }
    public void editarParticipante(Participante p, int index){
        txtDNI.setText(p.getDni().getValue());
        txtApellidos.setText(p.getApellidos().getValue());
        txtNombres.setText(p.getNombre().getValue());
        cbxCarrera.getSelectionModel().select(p.getCarrera());
        cbxTipoParticipante.getSelectionModel().select(p.getTipoParticipante());
        indexEdit=index;
    }
    public void agregarAccionesButton(){
        Callback<TableColumn<Participante, Void>, TableCell<Participante, Void>> cellFactory = param -> new TableCell<>(){
            private final Button btnEdit = new Button("Editar");
            private final Button btnDelet = new Button("Eliminar");
            {
                btnEdit.setOnAction(event -> {
                    Participante p = getTableView().getItems().get(getIndex());
                    editarParticipante(p, getIndex());
                });
                btnDelet.setOnAction(event -> {
                    eliminarParticipante(getIndex());
                });
            }
            @Override
            public void updateItem(Void item, boolean empty){
                super.updateItem(item, empty);
                if(empty){setGraphic(null);
                }else {
                    HBox hBox = new HBox(btnEdit, btnDelet);
                    hBox.setSpacing(10);
                    setGraphic(hBox);
                }
            }
        };
        opcCol.setCellFactory(cellFactory);
    }
}
