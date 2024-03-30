package domain.clases;

import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public boolean aprobada() {
        for (int i = 0; i < this.materias.size(); i++) {
            if (!this.alumno.puedeCursar(this.materias.get(i))) return false;
        }
        return true;
    }
}
