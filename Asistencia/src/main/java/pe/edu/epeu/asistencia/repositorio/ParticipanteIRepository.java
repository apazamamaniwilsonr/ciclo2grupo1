package pe.edu.epeu.asistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.epeu.asistencia.modelo.Participante;

@Repository
public interface ParticipanteIRepository extends JpaRepository<Participante,String> {
}
