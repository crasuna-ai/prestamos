package finalestructura;

public class ComputadorPortatil extends EquipoElectronico {
    private String sistemaOperativo;
    private String procesador;

    public ComputadorPortatil(String serial, String marca, float tamano, float precio,
                              String sistemaOperativo, String procesador) {
        super(serial, marca, tamano, precio);
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
    }

    public String getSistemaOperativo() { return sistemaOperativo; }
    public void setSistemaOperativo(String so) { this.sistemaOperativo = so; }
    public String getProcesador() { return procesador; }
    public void setProcesador(String procesador) { this.procesador = procesador; }
    public float getTamano() { return tamano; }
    public void setTamano(float tamano) { this.tamano = tamano; }

    @Override
    public String toString() {
        return "Portátil [Serial: " + serial + ", Marca: " + marca + ", Tamaño: " + tamano +
               "\", Precio: $" + precio + ", SO: " + sistemaOperativo + ", CPU: " + procesador + "]";
    }
}