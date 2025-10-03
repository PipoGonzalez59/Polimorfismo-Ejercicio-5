public class ProcesoCPU extends Proceso {

    public ProcesoCPU(int pid, String nombre) {
        super(pid, nombre);
    }

    @Override
    public String ejecutar() {
        return this.toString() + " está REALIZANDO CÁLCULO INTENSIVO (Compilando código).";
    }
}