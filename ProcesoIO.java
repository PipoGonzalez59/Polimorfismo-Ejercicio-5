public class ProcesoIO extends Proceso {

    public ProcesoIO(int pid, String nombre) {
        super(pid, nombre);
    }

    @Override
    public String ejecutar() {
        return this.toString() + " está BLOQUEADO esperando respuesta de E/S (Leyendo desde disco).";
    }
}