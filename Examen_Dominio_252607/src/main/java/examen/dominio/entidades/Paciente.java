/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.dominio.entidades;

/**
 *
 * @author lagar
 */
public class Paciente {
    private String nss;
    private String nombre;
    private String apellidos;
    private boolean activo;

    public Paciente(String nss, String nombre, String apellidos, boolean activo) {
        this.nss = nss;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.activo = activo;
    }

    public boolean validarNss() {
        return nss != null && nss.matches("\\d{10,11}") && activo;
    }

    public String obtenerNombreCompleto() {
        return nombre + " " + apellidos;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
