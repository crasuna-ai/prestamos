package finalestructura;

import java.util.ArrayList;
import javax.swing.*;

public class ServicioPrestamoDiseno {
    public static ArrayList<EstudianteDiseno> vector_disenadores = new ArrayList<>();
    public static ArrayList<TabletaGrafica> vector_tableta = new ArrayList<>();

    public static void menu() {
        String[] opciones = {"Registrar préstamo", "Modificar préstamo", "Devolver equipo", "Buscar equipo", "Volver"};
        int op = JOptionPane.showOptionDialog(null, "Menú Diseño", "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        switch(op) {
            case 0: registrarPrestamo(); break;
            case 1: modificarPrestamo(); break;
            case 2: devolverPrestamo(); break;
            case 3: buscarEquipo(); break;
            default: break;
        }
    }

    public static void registrarPrestamo() {
        String cedula = Utilidades.pedirCedulaObligatoria("Ingrese cédula:");
        if (Utilidades.buscarEstudianteDiseno(cedula) != null) {
            JOptionPane.showMessageDialog(null, "Este estudiante ya tiene un préstamo registrado.");
            return;
        }
        if (vector_tableta.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay tabletas disponibles.");
            return;
        }

        String nombre = Utilidades.pedirNombreObligatorio("Ingrese nombre:");
        String apellido = Utilidades.pedirNombreObligatorio("Ingrese apellido:");
        String telefono = Utilidades.pedirTelefonoObligatorio("Ingrese teléfono:");
        String modalidad = Utilidades.seleccionarModalidad();
        int cantAsignaturas = Utilidades.pedirCantidadAsignaturasObligatorio("Ingrese cantidad de asignaturas:");

        // Se asigna la primera tableta disponible
        TabletaGrafica equipo = vector_tableta.remove(0);

        EstudianteDiseno estudiante = new EstudianteDiseno(
            cedula, nombre, apellido, telefono, modalidad, cantAsignaturas, equipo
        );
        vector_disenadores.add(estudiante);

        JOptionPane.showMessageDialog(null, "Préstamo registrado exitosamente.\nTableta asignada: " + equipo);
    }

    public static void modificarPrestamo() {
        EstudianteDiseno estudiante = Utilidades.buscarEstudianteDisenoPorMenu();
        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el estudiante.");
            return;
        }
        String[] opciones = {"Nombre", "Apellido", "Teléfono", "Modalidad", "Asignaturas", "Cancelar"};
        int op = JOptionPane.showOptionDialog(null, "¿Qué desea modificar?", "Modificar", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        switch(op) {
            case 0:
                String nuevoNombre = Utilidades.pedirNombreObligatorio("Nuevo nombre:");
                estudiante.setNombre(nuevoNombre);
                break;
            case 1:
                String nuevoApellido = Utilidades.pedirNombreObligatorio("Nuevo apellido:");
                estudiante.setApellido(nuevoApellido);
                break;
            case 2:
                String nuevoTelefono = Utilidades.pedirTelefonoObligatorio("Nuevo teléfono:");
                estudiante.setTelefono(nuevoTelefono);
                break;
            case 3:
                String nuevaModalidad = Utilidades.seleccionarModalidad();
                estudiante.setModalidad(nuevaModalidad);
                break;
            case 4:
                int nuevasAsignaturas = Utilidades.pedirCantidadAsignaturasObligatorio("Cantidad de asignaturas:");
                estudiante.setCantAsignaturas(nuevasAsignaturas);
                break;
            default: return;
        }
        JOptionPane.showMessageDialog(null, "Modificación exitosa.\n" + estudiante);
    }

    public static void devolverPrestamo() {
        EstudianteDiseno estudiante = Utilidades.buscarEstudianteDisenoPorMenu();
        if (estudiante == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el estudiante.");
            return;
        }
        // Se devuelve la tableta exacta que tenía asignada
        vector_tableta.add(estudiante.getEquipoPrestado());
        vector_disenadores.remove(estudiante);
        JOptionPane.showMessageDialog(null, "Devolución exitosa. Tableta devuelta: " + estudiante.getEquipoPrestado());
    }

    public static void buscarEquipo() {
        EstudianteDiseno estudiante = Utilidades.buscarEstudianteDisenoPorMenu();
        if (estudiante != null) {
            JOptionPane.showMessageDialog(null, estudiante.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Registro no encontrado.");
        }
    }

    // Para agregar nuevas tabletas al inventario (por ejemplo, desde un menú de administración)
    public static void agregarTabletaAlInventario(TabletaGrafica nuevaTableta) {
        for (TabletaGrafica t : vector_tableta) {
            if (t.getSerial().equalsIgnoreCase(nuevaTableta.getSerial())) {
                JOptionPane.showMessageDialog(null, "Ya existe una tableta con ese serial.");
                return;
            }
        }
        vector_tableta.add(nuevaTableta);
        JOptionPane.showMessageDialog(null, "Tableta agregada al inventario: " + nuevaTableta);
    }
}
