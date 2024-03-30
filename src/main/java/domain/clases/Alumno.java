package domain.clases;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String legajo;
    private List<Materia> materiasAprobadas;

    public void agregarMateriaAprobada(Materia materia) {
        this.materiasAprobadas.add(materia);
    }

    public Alumno(String nombre, String legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }

    boolean puedeCursar(Materia materia) {
        for (int i = 0; i < materia.getCorrelativas().size(); i++) {
            boolean encontrada = false;
            for (int j = 0; j < this.materiasAprobadas.size(); j++) {
                encontrada = materia.getCorrelativas().get(i).getNombre().equals(this.materiasAprobadas.get(j).getNombre());
                if (encontrada) break;
            }

            if (!encontrada) return false;
        }
        return true;
    }
}
