import java.util.Objects;

public abstract class Proceso {
    private final int pid;
    private final String nombre;

    public Proceso(int pid, String nombre) {
        this.pid = pid;
        this.nombre = nombre;
    }

    public abstract String ejecutar();

    public int getPid() {
        return pid;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() + " - PID: " + pid + "] " + nombre;
    }
}