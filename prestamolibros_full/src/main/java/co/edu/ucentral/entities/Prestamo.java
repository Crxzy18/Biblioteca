package co.edu.ucentral.entities;
import jakarta.persistence.*;
@Entity
@Table(name="prestamo")
public class Prestamo {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int idPrestamo;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name="documento", referencedColumnName = "documento", nullable = false) private Estudiante estudiante;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "isbn", referencedColumnName = "isbn", nullable = false) private Libro libro;
    @Column(name="fecha", nullable = false, length=15) private String fechaPrestamo;
    public Prestamo() {}
    public int getIdPrestamo() { return idPrestamo; } public void setIdPrestamo(int idPrestamo) { this.idPrestamo = idPrestamo; }
    public Estudiante getEstudiante() { return estudiante; } public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
    public Libro getLibro() { return libro; } public void setLibro(Libro libro) { this.libro = libro; }
    public String getFechaPrestamo() { return fechaPrestamo; } public void setFechaPrestamo(String fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }
}
