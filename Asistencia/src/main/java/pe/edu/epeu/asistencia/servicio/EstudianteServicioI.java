package pe.edu.epeu.asistencia.servicio;

import pe.edu.epeu.asistencia.modelo.Estudiante;

import java.util.List;

public interface EstudianteServicioI {
    void save(Estudiante estudiante);
    List<Estudiante> findAll();
    Estudiante update(Estudiante estudiante, int index);
    void delete(int index);

    Estudiante findById(int index);


}
