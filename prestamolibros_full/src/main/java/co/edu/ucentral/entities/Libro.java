package co.edu.ucentral.entities;
import jakarta.persistence.*;
@Entity
@Table(name="libro")
public class Libro {
    @Id @Column(name="isbn", nullable = false, length=30) private String isbn;
    @Column(name="titulo", nullable = false, length=30) private String titulo;
    @Column(name="editorial", nullable = false, length=30) private String editorial;
    @Column(name="autor", nullable = false, length=30) private String autor;
    @Column(name="num_pag", nullable = false) private int numPag;
    public Libro() {}
    public String getIsbn() { return isbn; } public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitulo() { return titulo; } public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getEditorial() { return editorial; } public void setEditorial(String editorial) { this.editorial = editorial; }
    public String getAutor() { return autor; } public void setAutor(String autor) { this.autor = autor; }
    public int getNumPag() { return numPag; } public void setNumPag(int numPag) { this.numPag = numPag; }
}
