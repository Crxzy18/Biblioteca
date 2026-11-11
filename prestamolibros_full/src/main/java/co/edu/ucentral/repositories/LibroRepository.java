package co.edu.ucentral.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.ucentral.entities.Libro;
public interface LibroRepository extends JpaRepository<Libro, String> {}
