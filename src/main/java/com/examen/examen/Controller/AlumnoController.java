package com.examen.examen.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RelationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.examen.examen.Model.Alumno;

@RestController
@RequestMapping("/api")
public class AlumnoController {

    private List<Alumno> alumnos = new ArrayList<>();

    public AlumnoController() {
        Alumno alumno1 = new Alumno(1, "Jose", "SI");
        Alumno alumno2 = new Alumno(2, "Alex", "NO");
        Alumno alumno3 = new Alumno(3, "Dani", "SI");

        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
    }

    // 2
    @PostMapping(path = "/ALUMNOS/INSERT")
    public ResponseEntity<Alumno> insertarAlumno(@RequestBody Alumno alumno) {
        alumnos.add(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumno);
    }

    @GetMapping(path = "/ALUMNOS/DELETE/")
    public Alumno eliminarAlumno(@RequestParam int id) {
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getId() == id) {
                Alumno alumnoEliminado = alumnos.remove(i);
                return alumnoEliminado;
            }
        }
        return null;
    }

    @GetMapping(path = "/ALUMNOS/UPDATE/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> getAlumno(@PathVariable(value = "id") int alumnoId) throws RelationNotFoundException {
        // Simulamos una consulta a la base de datos o a una fuente de datos externa
        Alumno alumno = null;
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getId() == alumnoId) {
                alumno = alumnos.get(i);
                break;
            }
        }

        // Comprobamos si el alumno existe
        if (alumno == null) {
            throw new RelationNotFoundException("Alumno no encontrado con el id: " + alumnoId);
        }

        alumno.setFct("yes");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(alumno);
    }

    @GetMapping(path = "/ALUMNOS/UPDATE/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Alumno> getAlumno2(@PathVariable(value = "id") int alumnoId)
            throws RelationNotFoundException {
        // Simulamos una consulta a la base de datos o a una fuente de datos externa
        Alumno alumno = null;
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getId() == alumnoId) {
                alumno = alumnos.get(i);
                break;
            }
        }

        // Comprobamos si el alumno existe
        if (alumno == null) {
            throw new RelationNotFoundException("Alumno no encontrado con el id: " + alumnoId);
        }

        // Actualizamos el valor de "fct" a "yes" para el alumno con id=1
        if (alumnoId == 1) {
            alumno.setFct("yes");
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(alumno);
    }

}
