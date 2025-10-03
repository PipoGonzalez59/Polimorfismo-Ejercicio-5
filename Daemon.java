public class Daemon extends Proceso {

    public Daemon(int pid, String nombre) {
        super(pid, nombre);
    }

    @Override
    public String ejecutar() {
        return this.toString() + " está EJECUTÁNDOSE EN SEGUNDO PLANO (Monitoreando el sistema).";
    }
}