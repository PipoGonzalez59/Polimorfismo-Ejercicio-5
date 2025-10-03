import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Planificador planificador = new Planificador();
        int nextPid = 100;
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                    case 2:
                    case 3:
                        System.out.print("\nIngrese el nombre para el nuevo proceso: ");
                        String nombre = scanner.nextLine();
                        crearProceso(opcion, planificador, nextPid, nombre);
                        nextPid++;
                        break;
                    
                    case 4:
                        ejecutarProcesos(planificador);
                        break;
                    
                    case 5:
                        mostrarProcesosRegistrados(planificador);
                        break;

                    case 6:
                        System.out.println("\nSaliendo del simulador. ¡Adiós!");
                        continuar = false;
                        break;
                        
                    default:
                        System.out.println("\nOpción no válida. Intente de nuevo.");
                        break;
                }
            } else {
                System.out.println("\nEntrada no válida. Por favor, ingrese un número.");
                scanner.nextLine();
            }
            System.out.println("--------------------------------------------------");
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Operaciones ---");
        System.out.println("1. Crear Proceso de CPU");
        System.out.println("2. Crear Proceso de E/S (I/O)");
        System.out.println("3. Crear Daemon (Segundo plano)");
        System.out.println("4. Ejecutar todos los procesos (Polimorfismo)");
        System.out.println("5. Mostrar Procesos Registrados");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearProceso(int tipo, Planificador planificador, int pid, String nombre) {
        Proceso nuevoProceso = null;
        String tipoString = "";
        
        switch (tipo) {
            case 1:
                nuevoProceso = new ProcesoCPU(pid, nombre);
                tipoString = "Proceso de CPU";
                break;
            case 2:
                nuevoProceso = new ProcesoIO(pid, nombre);
                tipoString = "Proceso de E/S (I/O)";
                break;
            case 3:
                nuevoProceso = new Daemon(pid, nombre);
                tipoString = "Daemon";
                break;
        }

        if (nuevoProceso != null) {
            planificador.agregarProceso(nuevoProceso);
            System.out.println("\n Proceso creado y registrado: " + tipoString + " " + nuevoProceso.toString());
        }
    }

    private static void ejecutarProcesos(Planificador planificador) {
        List<String> resultados = planificador.ejecutarTodos();
        
        if (resultados.isEmpty()) {
            System.out.println("\n No hay procesos registrados para ejecutar.");
            return;
        }

        System.out.println("\n--- INICIANDO EJECUCIÓN POLIMÓRFICA ---");
        System.out.println("El Planificador itera la lista y llama a .ejecutar() en cada uno.");
        System.out.println("El comportamiento real de ejecución (el output) es elegido en tiempo de ejecución.");

        for (String resultado : resultados) {
            System.out.println("> " + resultado);
        }
        System.out.println("--- EJECUCIÓN FINALIZADA ---");
    }
    
    private static void mostrarProcesosRegistrados(Planificador planificador) {
        List<String> descripciones = planificador.obtenerDescripcionProcesos();
        
        if (descripciones.isEmpty()) {
             System.out.println("\n No hay procesos registrados.");
             return;
        }
        
        System.out.println("\n--- Procesos Registrados ---");
        for (String descripcion : descripciones) {
            System.out.println(descripcion);
        }
    }
}