package com.healthtrack.model;

/**
 * Clase Usuario para la plataforma HealthTrack
 * Gestiona la información del usuario y actualización de peso
 */
public class Usuario {
    private String nombre;
    private double peso;

    public Usuario(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    /**
     * Actualiza el peso del usuario
     * CORREGIDO: Ahora asigna correctamente el nuevo peso
     * @param nuevoPeso el nuevo peso a registrar
     */
    public void actualizarPeso(double nuevoPeso) {
        // CORRECCIÓN: Asignar el nuevo peso en lugar de restar 1kg
        this.peso = nuevoPeso;
    }

    public void mostrarInformacion() {
        System.out.println("Usuario: " + nombre + ", Peso Actual: " + peso + " kg");
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                '}';
    }
}
