package domain;

import domain.clases.Alumno;
import domain.clases.Materia;
import domain.clases.Inscripcion;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InscripcionTest {

    @Test
    public void inscripcionAprobada() {
        Materia dds = new Materia("DDS");
        Materia pdp = new Materia("Paradigmas de Programacion");
        Materia aed = new Materia("Algoritmos y Estructuras de Datos");

        pdp.agregarCorrelativa(aed);
        dds.agregarCorrelativa(aed);
        dds.agregarCorrelativa(pdp);

        Alumno gary = new Alumno("Gary Berkman", "2043104");
        gary.agregarMateriaAprobada(aed);
        gary.agregarMateriaAprobada(pdp);

        List<Materia> materiasInscripcionGary = new ArrayList<>();
        materiasInscripcionGary.add(dds);

        Inscripcion inscripcionGary = new Inscripcion(gary, materiasInscripcionGary);

        Assert.assertTrue(inscripcionGary.aprobada());
    }

    @Test
    public void inscripcionNoAprobada() {
        Materia dds = new Materia("DDS");
        Materia pdp = new Materia("Paradigmas de Programacion");
        Materia aed = new Materia("Algoritmos y Estructuras de Datos");

        pdp.agregarCorrelativa(aed);
        dds.agregarCorrelativa(aed);
        dds.agregarCorrelativa(pdp);

        Alumno gary = new Alumno("Gary Berkman", "2043104");
        gary.agregarMateriaAprobada(aed);

        List<Materia> materiasInscripcionGary = new ArrayList<>();
        materiasInscripcionGary.add(dds);

        Inscripcion inscripcionGary = new Inscripcion(gary, materiasInscripcionGary);

        Assert.assertFalse(inscripcionGary.aprobada());
    }

}
