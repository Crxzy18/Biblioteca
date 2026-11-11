package co.edu.ucentral.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.ucentral.entities.Prestamo;
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {}
