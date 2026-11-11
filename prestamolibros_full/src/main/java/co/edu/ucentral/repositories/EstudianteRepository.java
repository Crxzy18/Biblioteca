package co.edu.ucentral.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.ucentral.entities.Estudiante;
public interface EstudianteRepository extends JpaRepository<Estudiante, String> {}
