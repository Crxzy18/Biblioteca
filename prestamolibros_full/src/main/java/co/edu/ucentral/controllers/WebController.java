package co.edu.ucentral.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import co.edu.ucentral.entities.*;
import co.edu.ucentral.repositories.*;

@Controller
public class WebController {
    private final EstudianteRepository estRepo;
    private final LibroRepository libRepo;
    private final PrestamoRepository preRepo;

    public WebController(EstudianteRepository e, LibroRepository l, PrestamoRepository p) {
        this.estRepo = e; this.libRepo = l; this.preRepo = p;
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("totalEstudiantes", estRepo.count());
        model.addAttribute("totalLibros", libRepo.count());
        model.addAttribute("totalPrestamos", preRepo.count());
        return "index";
    }

    // --- ESTUDIANTES ---
    @GetMapping("/estudiantes")
    public String estudiantes(Model model) {
        model.addAttribute("estudiantes", estRepo.findAll());
        model.addAttribute("estudiante", new Estudiante());
        return "estudiantes";
    }
    @GetMapping("/estudiantes/edit/{id}")
    public String editEstudiante(@PathVariable String id, Model model) {
        model.addAttribute("estudiantes", estRepo.findAll());
        model.addAttribute("estudiante", estRepo.findById(id).orElse(new Estudiante()));
        return "estudiantes";
    }
    @PostMapping("/estudiantes/save")
    public String saveEstudiante(@ModelAttribute Estudiante estudiante) {
        estRepo.save(estudiante);
        return "redirect:/estudiantes";
    }
    @GetMapping("/estudiantes/delete/{id}")
    public String deleteEstudiante(@PathVariable String id) {
        estRepo.deleteById(id);
        return "redirect:/estudiantes";
    }

    // --- LIBROS ---
    @GetMapping("/libros")
    public String libros(Model model) {
        model.addAttribute("libros", libRepo.findAll());
        model.addAttribute("libro", new Libro());
        return "libros";
    }
    @GetMapping("/libros/edit/{id}")
    public String editLibro(@PathVariable String id, Model model) {
        model.addAttribute("libros", libRepo.findAll());
        model.addAttribute("libro", libRepo.findById(id).orElse(new Libro()));
        return "libros";
    }
    @PostMapping("/libros/save")
    public String saveLibro(@ModelAttribute Libro libro) {
        libRepo.save(libro);
        return "redirect:/libros";
    }
    @GetMapping("/libros/delete/{id}")
    public String deleteLibro(@PathVariable String id) {
        libRepo.deleteById(id);
        return "redirect:/libros";
    }

    // --- PRESTAMOS ---
    @GetMapping("/prestamos")
    public String prestamos(Model model) {
        model.addAttribute("prestamos", preRepo.findAll());
        model.addAttribute("estudiantes", estRepo.findAll());
        model.addAttribute("libros", libRepo.findAll());
        model.addAttribute("prestamo", new Prestamo());
        return "prestamos";
    }
    @PostMapping("/prestamos/save")
    public String savePrestamo(@ModelAttribute Prestamo prestamo) {
        preRepo.save(prestamo);
        return "redirect:/prestamos";
    }
    @GetMapping("/prestamos/delete/{id}")
    public String deletePrestamo(@PathVariable Integer id) {
        preRepo.deleteById(id);
        return "redirect:/prestamos";
    }
}
