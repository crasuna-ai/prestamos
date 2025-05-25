
package finalestructura;

import javax.swing.*;

public class Utilidades {

    // ======== MÉTODOS DE INGRESO OBLIGATORIO (NO PERMITE CANCELAR) ========

    public static String pedirCedulaObligatoria(String mensaje) {
        while (true) {
            String cedula = JOptionPane.showInputDialog(mensaje);
            if (cedula == null || cedula.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar una cédula.");
                continue;
            }
            if (!cedula.trim().matches("^[0-9]+$")) {
                JOptionPane.showMessageDialog(null, "Solo números permitidos para la cédula. Intente de nuevo.");
                continue;
            }
            return cedula.trim();
        }
    }

    public static String pedirNombreObligatorio(String mensaje) {
        while (true) {
            String nombre = JOptionPane.showInputDialog(mensaje);
            if (nombre == null || nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre.");
                continue;
            }
            if (!nombre.trim().matches("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$")) {
                JOptionPane.showMessageDialog(null, "Solo letras permitidas. Intente de nuevo.");
                continue;
            }
            return nombre.trim();
        }
    }

    public static String pedirTelefonoObligatorio(String mensaje) {
        while (true) {
            String tel = JOptionPane.showInputDialog(mensaje);
            if (tel == null || tel.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número de teléfono.");
                continue;
            }
            if (!tel.trim().matches("^[0-9]+$")) {
                JOptionPane.showMessageDialog(null, "Solo números permitidos para el teléfono. Intente de nuevo.");
                continue;
            }
            return tel.trim();
        }
    }
    public static int pedirCantidadAsignaturasObligatorio(String mensaje) {
    while (true) {
        String valor = JOptionPane.showInputDialog(mensaje);
        if (valor == null || valor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad de asignaturas.");
            continue;
        }
        try {
            int cantidad = Integer.parseInt(valor.trim());
            if (cantidad < 1) {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor o igual a 1.");
                continue;
            }
            return cantidad;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido. Ingrese un número entero.");
        }
    }
}

    public static String pedirSerialObligatorio(String mensaje) {
        while (true) {
            String serial = JOptionPane.showInputDialog(mensaje);
            if (serial == null || serial.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un serial.");
                continue;
            }
            if (!serial.trim().matches("^[a-zA-Z0-9]+$")) {
                JOptionPane.showMessageDialog(null, "Solo letras y números permitidos para el serial. Intente de nuevo.");
                continue;
            }
            return serial.trim();
        }
    }

    public static float leerPromedioObligatorio(String mensaje) {
        while (true) {
            String valor = JOptionPane.showInputDialog(mensaje);
            if (valor == null || valor.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un promedio.");
                continue;
            }
            try {
                float promedio = Float.parseFloat(valor.trim());
                if (promedio <= 0 || promedio > 5) {
                    JOptionPane.showMessageDialog(null, "El promedio debe ser mayor que 0 y máximo 5.0.");
                    continue;
                }
                return promedio;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Ingrese un número válido.");
            }
        }
    }

    public static int leerSemestreObligatorio(String mensaje) {
        while (true) {
            String valor = JOptionPane.showInputDialog(mensaje);
            if (valor == null || valor.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el semestre.");
                continue;
            }
            try {
                int semestre = Integer.parseInt(valor.trim());
                if (semestre < 1) {
                    JOptionPane.showMessageDialog(null, "El semestre debe ser mínimo 1.");
                    continue;
                }
                return semestre;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Ingrese un número entero.");
            }
        }
    }
    public static float leerFloatObligatorio(String mensaje) {
    while (true) {
        String valor = JOptionPane.showInputDialog(mensaje);
        if (valor == null || valor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número decimal.");
            continue;
        }
        try {
            return Float.parseFloat(valor.trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido. Ingrese un número decimal (ejemplo: 4.5).");
        }
    }
}

    // ======== MÉTODOS DE INGRESO OPCIONAL (PERMITE CANCELAR) ========

    public static String pedirCedulaOpcional(String mensaje) {
        while (true) {
            String cedula = JOptionPane.showInputDialog(mensaje);
            if (cedula == null || cedula.trim().isEmpty()) return null;
            if (!cedula.trim().matches("^[0-9]+$")) {
                JOptionPane.showMessageDialog(null, "Solo números permitidos para la cédula. Intente de nuevo.");
                continue;
            }
            return cedula.trim();
        }
    }

    public static String pedirNombreOpcional(String mensaje) {
        while (true) {
            String nombre = JOptionPane.showInputDialog(mensaje);
            if (nombre == null || nombre.trim().isEmpty()) return null;
            if (!nombre.trim().matches("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$")) {
                JOptionPane.showMessageDialog(null, "Solo letras permitidas. Intente de nuevo.");
                continue;
            }
            return nombre.trim();
        }
    }

    public static String pedirTelefonoOpcional(String mensaje) {
        while (true) {
            String tel = JOptionPane.showInputDialog(mensaje);
            if (tel == null || tel.trim().isEmpty()) return null;
            if (!tel.trim().matches("^[0-9]+$")) {
                JOptionPane.showMessageDialog(null, "Solo números permitidos para el teléfono. Intente de nuevo.");
                continue;
            }
            return tel.trim();
        }
    }
    public static int pedirCantidadAsignaturasOpcional(String mensaje) {
    while (true) {
        String valor = JOptionPane.showInputDialog(mensaje);
        if (valor == null || valor.trim().isEmpty()) return -1;
        try {
            int cantidad = Integer.parseInt(valor.trim());
            if (cantidad < 1) {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor o igual a 1.");
                continue;
            }
            return cantidad;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido. Ingrese un número entero.");
        }
    }
}

    public static String pedirSerialOpcional(String mensaje) {
        while (true) {
            String serial = JOptionPane.showInputDialog(mensaje);
            if (serial == null || serial.trim().isEmpty()) return null;
            if (!serial.trim().matches("^[a-zA-Z0-9]+$")) {
                JOptionPane.showMessageDialog(null, "Solo letras y números permitidos para el serial. Intente de nuevo.");
                continue;
            }
            return serial.trim();
        }
    }

    public static float leerPromedioOpcional(String mensaje) {
        while (true) {
            String valor = JOptionPane.showInputDialog(mensaje);
            if (valor == null || valor.trim().isEmpty()) return -1;
            try {
                float promedio = Float.parseFloat(valor.trim());
                if (promedio <= 0 || promedio > 5) {
                    JOptionPane.showMessageDialog(null, "El promedio debe ser mayor que 0 y máximo 5.0.");
                    continue;
                }
                return promedio;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Ingrese un número válido.");
            }
        }
    }

    public static int leerSemestreOpcional(String mensaje) {
        while (true) {
            String valor = JOptionPane.showInputDialog(mensaje);
            if (valor == null || valor.trim().isEmpty()) return -1;
            try {
                int semestre = Integer.parseInt(valor.trim());
                if (semestre < 1) {
                    JOptionPane.showMessageDialog(null, "El semestre debe ser mínimo 1.");
                    continue;
                }
                return semestre;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Ingrese un número entero.");
            }
        }
    }
public static float leerFloatOpcional(String mensaje) {
    while (true) {
        String valor = JOptionPane.showInputDialog(mensaje);
        if (valor == null || valor.trim().isEmpty()) return -1;
        try {
            return Float.parseFloat(valor.trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor inválido. Ingrese un número decimal (ejemplo: 4.5).");
        }
    }
}
    // ======== MÉTODOS DE SELECCIÓN (EJEMPLO, PUEDES MODIFICAR SEGÚN TU PROYECTO) ========

    public static String seleccionarSO() {
        Object[] opciones = {"Windows 7", "Windows 10", "Windows 11"};
        int op = JOptionPane.showOptionDialog(null, "Seleccione Sistema Operativo:", "Sistema Operativo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (op < 0) return seleccionarSO();
        return opciones[op].toString();
    }

    public static String seleccionarProcesador() {
        Object[] opciones = {"AMD Ryzen", "Intel® Core™ i5"};
        int op = JOptionPane.showOptionDialog(null, "Seleccione Procesador:", "Procesador", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (op < 0) return seleccionarProcesador();
        return opciones[op].toString();
    }

    public static String seleccionarAlmacenamiento() {
        Object[] opciones = {"256 GB", "512 GB", "1 TB"};
        int op = JOptionPane.showOptionDialog(null, "Seleccione Almacenamiento:", "Almacenamiento", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (op < 0) return seleccionarAlmacenamiento();
        return opciones[op].toString();
    }

    // ======== MÉTODOS DE BÚSQUEDA (MODIFICAR SEGÚN TU PROYECTO) ========

    public static EstudianteIngenieria buscarEstudianteIngenieria(String cedula) {
        for (EstudianteIngenieria est : ServicioPrestamoIngenieria.vector_ingenieros)
            if (est.getCedula().equalsIgnoreCase(cedula)) return est;
        return null;
    }

    public static ComputadorPortatil buscarPortatil(String serial) {
        for (ComputadorPortatil portatil : ServicioPrestamoIngenieria.vector_portatil)
            if (portatil.getSerial().equalsIgnoreCase(serial)) return portatil;
        return null;
    }

    public static EstudianteIngenieria buscarEstudianteIngenieriaPorMenu() {
        Object[] opciones = {"Cédula", "Serial"};
        int op = JOptionPane.showOptionDialog(null, "Buscar por:", "Buscar Ingeniería", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (op == 0) {
            String cedula = pedirCedulaOpcional("Ingrese cédula:");
            if (cedula == null) return null;
            return buscarEstudianteIngenieria(cedula);
        } else if (op == 1) {
            String serial = pedirSerialOpcional("Ingrese serial:");
            if (serial == null) return null;
            for (EstudianteIngenieria est : ServicioPrestamoIngenieria.vector_ingenieros)
                if (est.getSerialEquipo().equalsIgnoreCase(serial)) return est;
        }
        return null;
    }

    public static EstudianteDiseno buscarEstudianteDiseno(String cedula) {
        for (EstudianteDiseno est : ServicioPrestamoDiseno.vector_disenadores)
            if (est.getCedula().equalsIgnoreCase(cedula)) return est;
        return null;
    }

    public static TabletaGrafica buscarTableta(String serial) {
        for (TabletaGrafica tab : ServicioPrestamoDiseno.vector_tableta)
            if (tab.getSerial().equalsIgnoreCase(serial)) return tab;
        return null;
    }

    public static TabletaGrafica buscarTabletaPorSerialInt(int serialInt) {
        for (TabletaGrafica tab : ServicioPrestamoDiseno.vector_tableta)
            if (tab.getSerial().hashCode() == serialInt)
                return tab;
        return null;
    }

    public static EstudianteDiseno buscarEstudianteDisenoPorMenu() {
        Object[] opciones = {"Cédula", "Serial"};
        int op = JOptionPane.showOptionDialog(null, "Buscar por:", "Buscar Diseño", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (op == 0) {
            String cedula = pedirCedulaOpcional("Ingrese cédula:");
            if (cedula == null) return null;
            return buscarEstudianteDiseno(cedula);
        } else if (op == 1) {
            String serial = pedirSerialOpcional("Ingrese serial:");
            if (serial == null) return null;
            int serialInt = serial.hashCode();
            for (EstudianteDiseno est : ServicioPrestamoDiseno.vector_disenadores)
                if (est.getSerialEquipo() == serialInt) return est;
        }
        return null;
    }

    // ======== EJEMPLO DE USO EN DEVOLUCIÓN ========
    public static void devolucionEquipo() {
        String cedula = pedirCedulaOpcional("Ingrese cédula para devolución:");
        if (cedula == null) return; // El usuario canceló, salir
        // Aquí pondrías la lógica para buscar y procesar la devolución
        JOptionPane.showMessageDialog(null, "Lógica de devolución aquí (solo ejemplo).");
    }

}