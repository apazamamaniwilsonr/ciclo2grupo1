package pe.edu.epeu.asistencia.modelo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.epeu.asistencia.enums.Carrera;
import pe.edu.epeu.asistencia.enums.TipoParticipante;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Participante {
    private StringProperty dni;
    private StringProperty nombre;
    private StringProperty apellidos;
    private Carrera carrera;
    private TipoParticipante tipoParticipante;
    private BooleanProperty estado;

}
