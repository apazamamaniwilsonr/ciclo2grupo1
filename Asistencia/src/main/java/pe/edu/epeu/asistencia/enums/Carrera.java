package pe.edu.epeu.asistencia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum Carrera {
    SISTEMAS(Facultad.FIA,"Sistemas"),
    CIVIL(Facultad.FIA,"Civil"),
    AMBIENTAL(Facultad.FIA,"Ambiental"),

    ADMINISTRACION(Facultad.FCE,"Administrador"),

    NUTRICION(Facultad.FCS,"Nutricion"),

    EDUCACION(Facultad.FACIHED,"Educacion"),

    GENERAL(Facultad.GENERAL,"General");

    private Facultad facultad;
    private String descripcion;

    @Override
    public String toString() {
        return descripcion;
    }
}