package finalestructura;

import javax.swing.*;
import java.util.ArrayList;

public class ServicioPrestamoIngenieria {
    public static ArrayList<EstudianteIngenieria> vector_ingenieros = new ArrayList<>();
    public static ArrayList<ComputadorPortatil> vector_portatil = new ArrayList<>();

    public static void menu() {
        String[] opciones = {"Registrar préstamo", "Modificar préstamo", "Devolver equipo", "Buscar equipo", "Volver"};
        int op = JOptionPane.showOptionDialog(null, "Menú Ingeniería", "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
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
        if (Utilidades.buscarEstudianteIngenieria(cedula) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un préstamo registrado para esta cédula.");
            return;
        }
        String nombre = Utilidades.pedirNombreOpcional("Ingrese nombre:");
        String apellido = Utilidades.pedirNombreOpcional("Ingrese apellido:");
        String telefono = Utilidades.pedirTelefonoOpcional("Ingrese teléfono:");
        int semestre = Utilidades.leerSemestreOpcional("Ingrese semestre (1-10):");
        float promedio = Utilidades.leerPromedioOpcional("Ingrese promedio acumulado:");

        String serial = Utilidades.pedirSerialObligatorio("Ingrese serial del portátil:");
        if (Utilidades.buscarPortatil(serial) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un préstamo con ese serial.");
            return;
        }
        String marca = Utilidades.pedirNombreOpcional("Ingrese marca del portátil:");
        float tamano = Utilidades.leerFloatOpcional("Ingrese tamaño en pulgadas:");
        float precio = Utilidades.leerFloatObligatorio("Ingrese precio:");
        String sistemaOperativo = Utilidades.seleccionarSO();
        String procesador = Utilidades.seleccionarProcesador();

        ComputadorPortatil portatil = new ComputadorPortatil(serial, marca, tamano, precio, sistemaOperativo, procesador);
        vector_portatil.add(portatil);

        EstudianteIngenieria estudiante = new EstudianteIngenieria(cedula, nombre, apellido, telefono, semestre, promedio, serial);
        vector_ingenieros.add(estudiante);

        JOptionPane.showMessageDialog(null, "Préstamo registrado exitosamente.");
    }

    public static void modificarPrestamo() {
        EstudianteIngenieria est = Utilidades.buscarEstudianteIngenieriaPorMenu();
        if (est == null) {
            JOptionPane.showMessageDialog(null, "No existe registro para la búsqueda.");
            return;
        }
        est.setNombre(Utilidades.pedirNombreOpcional("Nuevo nombre (" + est.getNombre() + "):"));
        est.setApellido(Utilidades.pedirNombreOpcional("Nuevo apellido (" + est.getApellido() + "):"));
        est.setTelefono(Utilidades.pedirTelefonoOpcional("Nuevo teléfono (" + est.getTelefono() + "):"));
        est.setSemestre(Utilidades.leerSemestreOpcional("Nuevo semestre (" + est.getSemestre() + "):"));
        est.setPromedio(Utilidades.leerPromedioOpcional("Nuevo promedio (" + est.getPromedio() + "):"));

        ComputadorPortatil portatil = Utilidades.buscarPortatil(est.getSerialEquipo());
        if (portatil != null) {
            portatil.setMarca(Utilidades.pedirNombreOpcional("Nueva marca (" + portatil.getMarca() + "):"));
            portatil.setTamano(Utilidades.leerFloatOpcional("Nuevo tamaño (" + portatil.getTamanio() + "):"));
            portatil.setPrecio(Utilidades.leerFloatOpcional("Nuevo precio (" + portatil.getPrecio() + "):"));
            portatil.setSistemaOperativo(Utilidades.seleccionarSO());
            portatil.setProcesador(Utilidades.seleccionarProcesador());
        }
        JOptionPane.showMessageDialog(null, "Registro modificado.");
    }

    public static void devolucionEquipo() {
        EstudianteIngenieria est = Utilidades.buscarEstudianteIngenieriaPorMenu();
        if (est == null) {
            JOptionPane.showMessageDialog(null, "No existe registro para la búsqueda.");
            return;
        }
        ComputadorPortatil portatil = Utilidades.buscarPortatil(est.getSerialEquipo());
        vector_ingenieros.remove(est);
        if (portatil != null) vector_portatil.remove(portatil);
        JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente.");
    }

    public static void buscarEquipo() {
        EstudianteIngenieria est = Utilidades.buscarEstudianteIngenieriaPorMenu();
        if (est != null) {
            ComputadorPortatil portatil = Utilidades.buscarPortatil(est.getSerialEquipo());
            JOptionPane.showMessageDialog(null, est.toString() + (portatil != null ? "\n" + portatil.toString() : ""));
        } else {
            JOptionPane.showMessageDialog(null, "No existe registro para la búsqueda.");
        }
    }
}
