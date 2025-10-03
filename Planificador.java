import java.util.ArrayList;
import java.util.List;

public class Planificador {
    private final List<Proceso> listaProcesos;

    public Planificador() {
        this.listaProcesos = new ArrayList<>();
    }

    public void agregarProceso(Proceso p) {
        listaProcesos.add(p);
    }

    public List<String> ejecutarTodos() {
        List<String> resultados = new ArrayList<>();
        
        for (Proceso p : listaProcesos) {
            resultados.add(p.ejecutar()); 
        }
        return resultados;
    }

    public List<String> obtenerDescripcionProcesos() {
        List<String> descripciones = new ArrayList<>();
        for (Proceso p : listaProcesos) {
            descripciones.add(p.toString());
        }
        return descripciones;
    }
}