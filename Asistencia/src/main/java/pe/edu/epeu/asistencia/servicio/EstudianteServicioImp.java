package pe.edu.epeu.asistencia.servicio;

import pe.edu.epeu.asistencia.modelo.Estudiante;
import pe.edu.epeu.asistencia.repositorio.EstudianteRepository;

import java.util.List;

public class EstudianteServicioImp extends EstudianteRepository implements EstudianteServicioI {

    @Override
    public void save(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    @Override
    public Estudiante update(Estudiante estudiante, int index) {
        return estudiantes.set(index, estudiante);
    }

    @Override
    public void delete(int index) {
        estudiantes.remove(index);
    }

    @Override
    public Estudiante findById(int index) {
        return estudiantes.get(index);
    }
    @Override
    public List<Estudiante> findAll(){
        if (estudiantes.isEmpty()){
            return super.findAll();
        }
        return  estudiantes;
    }
}
