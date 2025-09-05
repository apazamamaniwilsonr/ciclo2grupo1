package pe.edu.epeu.asistencia.control;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.springframework.stereotype.Controller;
import pe.edu.epeu.asistencia.enums.Carrera;
import pe.edu.epeu.asistencia.enums.TipoParticipante;

@Controller
public class ParticipanteController {

    @FXML
    private ComboBox<Carrera> cbxCarrera;
    @FXML
    private ComboBox<TipoParticipante> cbxTipoParticipante;

    @FXML
    public void initialize(){
        cbxCarrera.getItems().addAll(Carrera.values());
        cbxTipoParticipante.getItems().addAll(TipoParticipante.values());

        cbxCarrera.getSelectionModel().selectLast();
        Carrera carrera = cbxCarrera.getSelectionModel().getSelectedItem();
        System.out.println(carrera);
        //select(4) mostrara nutricion que esta en la posicion 4 de carrera
    }
}
